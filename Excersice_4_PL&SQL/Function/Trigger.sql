CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (AuditID, TransactionID, ActionDate, ActionType)
    VALUES (AuditLog_seq.NEXTVAL, :NEW.TransactionID, SYSDATE, 'INSERT');
END;
/

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_current_balance NUMBER;
BEGIN
    SELECT Balance INTO v_current_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    IF :NEW.TransactionType = 'WITHDRAW' AND :NEW.Amount > v_current_balance THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for withdrawal');
    ELSIF :NEW.TransactionType = 'DEPOSIT' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive');
    END IF;
END;
/