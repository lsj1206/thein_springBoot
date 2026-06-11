SELECT current_database();

-- 테이블생성
CREATE TABLE t(
		message text);

SELECT *
FROM t;

--테이블 데이터 입력
INSERT INTO t(message)
VALUES('The rents are now 10% higher than last month'),
      ('The new film will have _ in the title');

SELECT * FROM t WHERE message LIKE '%10$%%' ESCAPE '$';

-- null: NULL과 값을 비교하면 항상 NULL이 반환
SELECT NULL = NULL AS RESULT;

-- is null
SELECT address, address2
FROM address
WHERE address2 IS NULL;

-- is not null
SELECT address, address2
FROM address
WHERE address2 IS NOT NULL;

