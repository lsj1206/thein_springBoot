SELECT current_database();
-- 팀 테이블
CREATE TABLE teams(
		id int PRIMARY KEY, team varchar(100) NOT NULL, city varchar(100) NOT NULL
		);
-- 선수 테이블
CREATE TABLE players(
		id int PRIMARY KEY, team_id int REFERENCES teams(id), player varchar(100) NOT NULL, ROLE varchar(100) NOT NULL
		);

INSERT INTO teams (id, team, city)
VALUES(1, 'Lions', 'Rome'),(2, 'Owls', 'Oslo'),(3, 'Bears', 'Bern'),(4, 'Sharks', 'Lima');

INSERT INTO players (id, team_id, player, ROLE)
VALUES(1, 1, 'Ava', 'Guard'),(2, 1, 'Noah', 'Wing'),(3, 2, 'Emma', 'Back'),(4, NULL, 'Liam', 'Guard'),(5, NULL, 'Mia', 'Wing');

SELECT *
FROM teams;

SELECT *
FROM players;

-- inner join
SELECT t.id, t.team, t.city, p.id, p.team_id, p.player, p.role
FROM teams t
INNER JOIN players p
	ON t.id = p.team_id;

-- left join
SELECT t.id AS team_id, team, city, p.id AS player_id, player, ROLE
FROM teams t
LEFT JOIN players p
	ON t.id = p.team_id;

-- right join
SELECT t.id AS team_id, team, city, p.id AS player_id, player, ROLE
FROM teams t
RIGHT JOIN players p
	ON
t.id = p.team_id;

-- full outer join
SELECT t.id AS team_id, team, city, p.id AS player_id, player, ROLE
FROM teams t
FULL OUTER JOIN players p
    ON t.id = p.team_id;

-- full join
SELECT t.id AS team_id, team, city, p.id AS player_id, player, ROLE
FROM teams t
FULL JOIN players p
   ON t.id = p.team_id
WHERE t.id IS NULL
OR p.id IS NULL;
