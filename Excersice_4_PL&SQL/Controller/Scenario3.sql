SET SERVEROUTPUT ON;

DECLARE
   CURSOR loan_cursor IS
     SELECT LoanID, CustomerID, EndDate
     FROM Loans;

   v_LoanID     Loans.LoanID%TYPE;
   v_CustomerID Loans.CustomerID%TYPE;
   v_EndDate    Loans.EndDate%TYPE;

BEGIN
   OPEN loan_cursor;
   LOOP
      FETCH loan_cursor INTO v_LoanID, v_CustomerID, v_EndDate;
      EXIT WHEN loan_cursor%NOTFOUND;

      DBMS_OUTPUT.PUT_LINE('LoanID: ' || v_LoanID || 
                           ', CustomerID: ' || v_CustomerID || 
                           ', EndDate: ' || TO_CHAR(v_EndDate, 'DD-MON-YYYY'));
   END LOOP;
   CLOSE loan_cursor;
END;