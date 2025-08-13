DECLARE
    v_customer_id   LOANS.CUSTOMERID%TYPE := 105;      -- Example customer ID
    v_loan_id       LOANS.LOANID%TYPE := 1005;         -- Example loan ID
    v_amount        LOANS.LOANAMOUNT%TYPE := 50000;
    v_interest      LOANS.INTERESTRATE%TYPE := 7.5;
    v_start_date    LOANS.STARTDATE%TYPE := SYSDATE;
    v_end_date      LOANS.ENDDATE%TYPE := ADD_MONTHS(SYSDATE, 12);  -- 1 year later
BEGIN
    INSERT INTO LOANS (
        LOANID, CUSTOMERID, LOANAMOUNT, INTERESTRATE, STARTDATE, ENDDATE
    ) VALUES (
        v_loan_id, v_customer_id, v_amount, v_interest, v_start_date, v_end_date
    );

    DBMS_OUTPUT.PUT_LINE('Loan inserted successfully.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error inserting loan: ' || SQLERRM);
END;
/