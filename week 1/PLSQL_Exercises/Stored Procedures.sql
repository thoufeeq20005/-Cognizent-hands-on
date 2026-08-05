-- Enable output
SET SERVEROUTPUT ON;

--------------------------------------------------
-- Step 1: Create Employee Table
--------------------------------------------------

CREATE TABLE Employee (
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(50),
    salary NUMBER
);

--------------------------------------------------
-- Step 2: Insert Records
--------------------------------------------------

INSERT INTO Employee VALUES (101, 'John', 50000);
INSERT INTO Employee VALUES (102, 'David', 60000);
INSERT INTO Employee VALUES (103, 'Mary', 55000);

COMMIT;

--------------------------------------------------
-- Step 3: Create Stored Procedure
--------------------------------------------------

CREATE OR REPLACE PROCEDURE get_employee_details
(
    p_emp_id IN NUMBER
)
IS
    v_name Employee.emp_name%TYPE;
    v_salary Employee.salary%TYPE;
BEGIN

    -- Fetch employee details
    SELECT emp_name, salary
    INTO v_name, v_salary
    FROM Employee
    WHERE emp_id = p_emp_id;

    -- Display details
    DBMS_OUTPUT.PUT_LINE('Employee Details');
    DBMS_OUTPUT.PUT_LINE('------------------');
    DBMS_OUTPUT.PUT_LINE('Employee ID   : ' || p_emp_id);
    DBMS_OUTPUT.PUT_LINE('Employee Name : ' || v_name);
    DBMS_OUTPUT.PUT_LINE('Salary        : ' || v_salary);

EXCEPTION

    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee Not Found');

    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);

END;
/

--------------------------------------------------
-- Step 4: Execute the Procedure
--------------------------------------------------

BEGIN
    get_employee_details(101);
END;
/