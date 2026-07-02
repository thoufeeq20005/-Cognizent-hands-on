SET SERVEROUTPUT ON;

DECLARE
    age NUMBER := 20;
    marks NUMBER := 85;
    has_license CHAR(1) := 'Y';
    i NUMBER := 1;
BEGIN

    DBMS_OUTPUT.PUT_LINE('===== IF Statement =====');

    -- IF
    IF age >= 18 THEN
        DBMS_OUTPUT.PUT_LINE('Eligible to Vote');
    END IF;


    DBMS_OUTPUT.PUT_LINE(CHR(10) || '===== IF ELSE =====');

    -- IF ELSE
    IF MOD(age,2) = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Age is Even');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Age is Odd');
    END IF;


    DBMS_OUTPUT.PUT_LINE(CHR(10) || '===== IF ELSIF ELSE =====');

    -- IF ELSIF ELSE
    IF marks >= 90 THEN
        DBMS_OUTPUT.PUT_LINE('Grade A+');
    ELSIF marks >= 80 THEN
        DBMS_OUTPUT.PUT_LINE('Grade A');
    ELSIF marks >= 70 THEN
        DBMS_OUTPUT.PUT_LINE('Grade B');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Grade C');
    END IF;


    DBMS_OUTPUT.PUT_LINE(CHR(10) || '===== NESTED IF =====');

    -- Nested IF
    IF age >= 18 THEN
        IF has_license = 'Y' THEN
            DBMS_OUTPUT.PUT_LINE('Can Drive');
        END IF;
    END IF;


    DBMS_OUTPUT.PUT_LINE(CHR(10) || '===== SIMPLE LOOP =====');

    -- Simple LOOP with EXIT WHEN
    i := 1;
    LOOP
        DBMS_OUTPUT.PUT_LINE('Loop Value: ' || i);
        i := i + 1;

        EXIT WHEN i > 3;
    END LOOP;


    DBMS_OUTPUT.PUT_LINE(CHR(10) || '===== WHILE LOOP =====');

    -- WHILE LOOP
    i := 1;
    WHILE i <= 3 LOOP
        DBMS_OUTPUT.PUT_LINE('While Value: ' || i);
        i := i + 1;
    END LOOP;


    DBMS_OUTPUT.PUT_LINE(CHR(10) || '===== FOR LOOP =====');

    -- FOR LOOP
    FOR j IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE('For Value: ' || j);
    END LOOP;


    DBMS_OUTPUT.PUT_LINE(CHR(10) || '===== REVERSE FOR LOOP =====');

    -- REVERSE FOR LOOP
    FOR j IN REVERSE 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE('Reverse Value: ' || j);
    END LOOP;


    DBMS_OUTPUT.PUT_LINE(CHR(10) || '===== CONTINUE =====');

    -- CONTINUE
    FOR j IN 1..5 LOOP

        IF j = 3 THEN
            CONTINUE;
        END IF;

        DBMS_OUTPUT.PUT_LINE('Continue Value: ' || j);

    END LOOP;


    DBMS_OUTPUT.PUT_LINE(CHR(10) || '===== NULL STATEMENT =====');

    -- NULL Statement
    IF marks < 0 THEN
        DBMS_OUTPUT.PUT_LINE('Invalid Marks');
    ELSE
        NULL;
    END IF;


    DBMS_OUTPUT.PUT_LINE(CHR(10) || 'Program Completed Successfully');

END;
/