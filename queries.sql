-- List the columns and their data types from the job table.
USE techjobs;

SHOW COLUMNS FROM job;


-- Write a query to list the names of the employers in St. Louis City.
USE techjobs;

SELECT
	name
FROM employer
WHERE
	location = "Saint Louis"
;


-- Write a SQL statement to remove the job table.
USE techjobs;

DROP TABLE job;


-- Write a query to return a list of the names and descriptions of all skills that are attached to jobs in alphabetical order.
-- If a skill does not have a job listed, it should not be included in the results of this query.
USE techjobs;

SELECT
	name
    , description
FROM skill s
JOIN job_skills js
	ON s.id = js.skills_id
ORDER BY
	name ASC
;