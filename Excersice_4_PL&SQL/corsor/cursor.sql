SET SERVEROUTPUT ON;

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT CustomerID, TransactionDate, Amount, TransactionType
        FROM Transactions
        WHERE TO_CHAR(TransactionDate, 'MM-YYYY') = TO_CHAR(SYSDATE, 'MM-YYYY')
        ORDER BY CustomerID;

    v_cust_id Transactions.CustomerID%TYPE;
    v_trans_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_trans_type Transactions.TransactionType%TYPE;
BEGIN
    OPEN GenerateMonthlyStatements;
    LOOP
        FETCH GenerateMonthlyStatements INTO v_cust_id, v_trans_date, v_amount, v_trans_type;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_cust_id || ' Date: ' || v_trans_date || ' Amount: ' || v_amount || ' Type: ' || v_trans_type);
    END LOOP;
    CLOSE GenerateMonthlyStatements;
END;
/

DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance FROM Accounts;

    v_acc_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_fee NUMBER := 500;
BEGIN
    OPEN ApplyAnnualFee;
    LOOP
        FETCH ApplyAnnualFee INTO v_acc_id, v_balance;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;
        UPDATE Accounts
        SET Balance = v_balance - v_fee
        WHERE AccountID = v_acc_id;
    END LOOP;
    CLOSE ApplyAnnualFee;
END;
/

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate FROM Loans;

    v_loan_id Loans.LoanID%TYPE;
    v_interest Loans.InterestRate%TYPE;
BEGIN
    OPEN UpdateLoanInterestRates;
    LOOP
        FETCH UpdateLoanInterestRates INTO v_loan_id, v_interest;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;
        UPDATE Loans
        SET InterestRate = v_interest + 0.5
        WHERE LoanID = v_loan_id;
    END LOOP;
    CLOSE UpdateLoanInterestRates;
END;
/
SELECT LoanID, InterestRate FROM Loans;