CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acc IN (SELECT ACCOUNTID, BALANCE FROM Accounts WHERE ACCOUNTTYPE = 'Savings') LOOP
        UPDATE Accounts
        SET BALANCE = BALANCE + (acc.BALANCE * 0.04)
        WHERE ACCOUNTID = acc.ACCOUNTID;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all Savings accounts.');
END;
/