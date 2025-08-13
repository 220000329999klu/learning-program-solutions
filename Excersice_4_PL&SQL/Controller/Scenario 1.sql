SET SERVEROUTPUT ON;

BEGIN
  FOR cust_rec IN (
    SELECT c.CustomerID, l.LoanID, l.InterestRate, 
           FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS Age
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
  ) LOOP
    IF cust_rec.Age > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = cust_rec.LoanID;
      
      DBMS_OUTPUT.PUT_LINE('Discount applied to LoanID: ' || cust_rec.LoanID 
        || ', CustomerID: ' || cust_rec.CustomerID 
        || ', Age: ' || cust_rec.Age);
    END IF;
  END LOOP;

  COMMIT;
END;
/