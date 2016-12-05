
USE Movie;

DROP TABLE IF EXISTS moviemoviedetails1;


CREATE TABLE moviedetails1(
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    m_id INTEGER REFERENCES moviedetails(id),
	moviename VARCHAR(100)NOT NULL,
    country VARCHAR(25) NOT NULL,
    language VARCHAR(25) NOT NULL,
    runtime VARCHAR(20) NOT NULL
	
	)
    

INSERT INTO moviedetails1 (m_id,moviename,country,language,runtime)
SELECT moviedetails.id,'Scouts Guide to the Zombie Apocalypse','USA','English','93 min'
FROM moviedetails 
where movieName='Scouts Guide to the Zombie Apocalypse';


INSERT INTO moviedetails1 (m_id,moviename,country,language,runtime)
SELECT moviedetails.id,movieName,'USA','English','97 min'
FROM moviedetails 
where movieName='The Hallow';

INSERT INTO moviedetails1 (m_id,moviename,country,language,runtime)
SELECT moviedetails.id,movieName,'Ireland','English','111 min'
FROM moviedetails 
where movieName='Brooklyn';


INSERT INTO moviedetails1 (m_id,moviename,country,language,runtime)
SELECT moviedetails.id,movieName,'Australia','English','96 min'
FROM moviedetails 
where movieName='The Daughter';


INSERT INTO moviedetails1 (m_id,moviename,country,language,runtime)
SELECT moviedetails.id,movieName,'USA','English,Dutch','96 min'
FROM moviedetails 
where movieName='Miracle On 34th Street';

INSERT INTO moviedetails1 (m_id,moviename,country,language,runtime)
SELECT moviedetails.id,movieName,'USA','English','120 min'
FROM moviedetails 
where movieName='Do You Believe?';

INSERT INTO moviedetails1 (m_id,moviename,country,language,runtime)
SELECT moviedetails.id,movieName,'USA','English','127 min'
FROM moviedetails 
where movieName='20.000 Leagues Under the Sea';

INSERT INTO moviedetails1 (m_id,moviename,country,language,runtime)
SELECT moviedetails.id,movieName,'USA,New Zealand','English','169 min'
FROM moviedetails 
where movieName='The Hobbit: An Unexpected Journey';


INSERT INTO moviedetails1 (m_id,moviename,country,language,runtime)
SELECT moviedetails.id,movieName,'USA','English','96 min'
FROM moviedetails 
where movieName='Secret Window';

INSERT INTO moviedetails1 (m_id,moviename,country,language,runtime)
SELECT moviedetails.id,movieName,'USA','English','89 min'
FROM moviedetails 
where movieName='Burying the Ex';


INSERT INTO moviedetails1 (m_id,moviename,country,language,runtime)
SELECT moviedetails.id,movieName,'USA','English','118 min'
FROM moviedetails 
where movieName='Jem and the Holograms';




