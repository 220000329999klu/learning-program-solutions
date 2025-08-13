DECLARE
    v_transaction_id  TRANSACTIONS.TRANSACTIONID%TYPE := 1001;
    v_account_id      TRANSACTIONS.ACCOUNTID%TYPE := 1001;   -- Must exist in ACCOUNTS table
    v_amount          TRANSACTIONS.AMOUNT%TYPE := 5000;
    v_trx_date        TRANSACTIONS.TRANSACTIONDATE%TYPE := SYSDATE;
    v_trx_type        TRANSACTIONS.TRANSACTIONTYPE%TYPE := 'CREDIT';  -- or 'DEBIT'
BEGIN
    INSERT INTO TRANSACTIONS (
        TRANSACTIONID, ACCOUNTID, TRANSACTIONDATE, AMOUNT, TRANSACTIONTYPE
    ) VALUES (
        v_transaction_id, v_account_id, v_trx_date, v_amount, v_trx_type
    );

    DBMS_OUTPUT.PUT_LINE('Transaction inserted successfully.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error inserting transaction: ' || SQLERRM);
END;
/