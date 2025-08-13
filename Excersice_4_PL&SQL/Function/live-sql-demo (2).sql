SET SERVEROUTPUT ON;

DECLARE
    FUNCTION CalculateAge(p_date_of_birth DATE) RETURN NUMBER IS
        v_current_date DATE := SYSDATE;
        v_years_diff   NUMBER;
    BEGIN
        v_years_diff := TRUNC(MONTHS_BETWEEN(v_current_date, p_date_of_birth) / 12);
        RETURN v_years_diff;
    END;

    FUNCTION CalculateMonthlyInstallment(p_loan_amount NUMBER, p_interest_rate NUMBER, p_loan_years NUMBER) RETURN NUMBER IS
        v_monthly_interest NUMBER := p_interest_rate / 12 / 100;
        v_total_months     NUMBER := p_loan_years * 12;
        v_numerator        NUMBER;
        v_denominator      NUMBER;
    BEGIN
        v_numerator   := p_loan_amount * v_monthly_interest * POWER(1 + v_monthly_interest, v_total_months);
        v_denominator := POWER(1 + v_monthly_interest, v_total_months) - 1;
        RETURN v_numerator / v_denominator;
    END;

    FUNCTION HasSufficientBalance(p_account_id VARCHAR2, p_required_amount NUMBER) RETURN BOOLEAN IS
        TYPE account_table IS TABLE OF NUMBER INDEX BY VARCHAR2(20);
        v_accounts account_table;
    BEGIN
        v_accounts('ACC123') := 5000;
        v_accounts('ACC456') := 1200;
        RETURN NVL(v_accounts(p_account_id), 0) >= p_required_amount;
    END;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer Age: ' || CalculateAge(DATE '1995-08-15'));
    DBMS_OUTPUT.PUT_LINE('Monthly Installment: ' || TO_CHAR(CalculateMonthlyInstallment(250000, 7.5, 10), '999999.99'));
    IF HasSufficientBalance('ACC123', 3000) THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient Balance: TRUE');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Sufficient Balance: FALSE');
    END IF;
END;
/