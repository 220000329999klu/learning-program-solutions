DECLARE
    v_account_id      NUMBER := 9999;  -- Non-existent account
    v_new_balance     NUMBER := 5000;
    e_account_not_found EXCEPTION;
BEGIN
    UPDATE ACCOUNTS
    SET BALANCE = v_new_balance,
        LASTMODIFIED = SYSDATE
    WHERE ACCOUNTID = v_account_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE e_account_not_found;
    END IF;

    DBMS_OUTPUT.PUT_LINE('Balance updated successfully.');

EXCEPTION
    WHEN e_account_not_found THEN
        DBMS_OUTPUT.PUT_LINE('Error: Account not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/