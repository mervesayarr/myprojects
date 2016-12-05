CREATE DATABASE IF NOT EXISTS Movie;
USE Movie;

DROP TABLE IF EXISTS moviemoviedetails;


CREATE TABLE moviedetails(
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	movieName VARCHAR(100) NOT NULL,
	writerName VARCHAR(200) NOT NULL,
	directorName VARCHAR(200) NOT NULL,
	imdbRating DOUBLE NOT NULL,
	releaseDate DATE NOT NULL,
	genre VARCHAR(20) NOT NULL,
	cast VARCHAR(200) NOT NULL
    );
	

SELECT 'INSERTING DATA INTO DATABASE' as 'INFO';

INSERT INTO moviedetails VALUES ( null, 'Scouts Guide to the Zombie Apocalypse', ' Emi Mochizuki, Carrie Lee Wilson, Christopher Landon, Lona Williams', ' Christopher Landon', 6.2, '2015-10-30', 'Comedy', ' Tye Sheridan, Logan Miller, Joey Morgan, Sarah Dumont, David Koechner, Halston Sage, Cloris Leachman, Niki Koss, Hiram A. Murray, Lukas Gage');
INSERT INTO moviedetails VALUES ( null, 'Brooklyn', 'Nick Hornby','John Crowley',7.4 , '2015-11-4', 'Drama', ' Saoirse Ronan, Domhnall Gleeson, Michael Zegen, Emory Cohen, Mary ODriscoll, Julie Walters, Eileen OHiggins, Emily Bett Rickards, Paulino Nunes, Eve Macklin');
INSERT INTO moviedetails VALUES ( null, 'The Hallow', 'Corin Hardy, Felipe Marino','Corin Hardy',5.9 , '2015-11-6', ' Horror', ' Joseph Mawle, Bojana Novakovic, Michael McElhatton, Gary Lydon, Stuart Graham, Conor Craig Stephens, Joss Wyre, Sean Tyrell, James Meryk, Billie Traynor');
INSERT INTO moviedetails VALUES ( null, 'The Daughter', 'Simon Stone','Simon Stone', 7.6, '2015-06-04', 'Drama', ' Miranda Otto, Geoffrey Rush, Anna Torv, Sam Neill, Paul Schneider, Odessa Young, Nicholas Hope, Sara West, Ewen Leslie, Kate Box');
INSERT INTO moviedetails VALUES ( null, 'Bone Tomahawk', 'S. Craig Zahler','S. Craig Zahler', 7.3, '2015-10-03', 'Horror', ' Kurt Russell, Patrick Wilson, Sean Young, Lili Simmons, Matthew Fox, David Arquette, Kathryn Morris, Richard Jenkins, Zahn McClarnon, Michael Paré');
INSERT INTO moviedetails VALUES ( null, 'Burnt', 'Steven Knight','John Wells', 7.1, '2015-10-23', 'Comedy', ' Bradley Cooper, Alicia Vikander, Lily James, Uma Thurman, Sienna Miller, Emma Thompson, Daniel Brühl, Sarah Greene, Matthew Rhys, Omar Sy');
INSERT INTO moviedetails VALUES ( null, 'I Smile Back', 'Paige Dylan, Amy Koppelman','Adam Salky', 6.1, '2015-10-23', ' Drama',' Sarah Silverman, Josh Charles, Thomas Sadoski, Mia Barron, Skylar Gaertner, Shayne Coleman, Sean Reda, Billy Magnussen, Kristin Griffith, Oona Laurence');
INSERT INTO moviedetails VALUES ( null, 'Jem and the Holograms', 'Ryan Landels','Jon M. Chu',3.3 , '2015-10-23', ' Adventure',' Juliette Lewis, Ryan Guzman, Molly Ringwald, Stefanie Scott, Hayley Kiyoko, Aubrey Peeples, Nicholas Braun, Samantha Newark, Aurora Perrineau, Isabella Kai Rice');
INSERT INTO moviedetails VALUES ( null, '12 Monkeys', 'David Peoples, Janet Peoples','Terry Gilliam', 8.1, '1995-12-27', 'Thriller', 'Bruce Willis, Madeleine Stowe, Brad Pitt, Christopher Plummer, David Morse, Jon Seda, Frank Gorshin, Joseph Melito');
INSERT INTO moviedetails VALUES ( null, 'The Water Diviner', 'Andrew Anastasios, Andrew Knight','Russell Crowe', 7.1, '2015-04-24', ' Drama', 'Russell Crowe, Olga Kurylenko, Jai Courtney, Yilmaz Erdogan');
INSERT INTO moviedetails VALUES ( null, 'Burying the Ex', 'Alan Trezza','Joe Dante',5.4 , '2015-06-19', 'Comedy', 'Anton Yelchin, Ashley Greene, Alexandra Daddario, Oliver Cooper');
INSERT INTO moviedetails VALUES ( null, 'A Little Chaos', 'Alison Deegan','Alan Rickman',6.4 , '2015-06-26', 'Romance', ' Kate Winslet, Helen McCrory, Stanley Tucci, Alan Rickman, Jennifer Ehle, Matthias Schoenaerts, Steven Waddington, Paulina Boneva, Danny Webb, Pauline Moran');
INSERT INTO moviedetails VALUES ( null, 'Adult Beginners', 'Jeff Cox, Liz Flahive',' Ross Katz', 5.5, '2015-04-24', 'Comedy', 'Nick Kroll, Rose Byrne, Bobby Cannavale, Joel McHale, Caleb and Matthew Paddock, Caitlin FitzGerald, Paula Garcés, Josh Charles, Jane Krakowski, Bobby Moynihan');
INSERT INTO moviedetails VALUES ( null, 'Barely Lethal', 'John DArco','Kyle Newman',5.3 , '2015-04-30', 'Adventure', ' Sophie Turner, Jaime King, Samuel L. Jackson, Hailee Steinfeld, Jessica Alba, Dan Fogler, Dove Cameron, Rachael Harris');
INSERT INTO moviedetails VALUES ( null, 'Child 44', 'Richard Price','Daniel Espinosa', 5.3, '2015-04-17', 'Drama', 'Tom Hardy, Noomi Rapace, Gary Oldman, Joel Kinnaman, Charles Dance, Jason Clarke, Vincent Cassel, Sam Spruell, Paddy Considine, Tara Fitzgerald');
INSERT INTO moviedetails VALUES ( null, 'The Divergent Series: Insurgent', 'Brian Duffield, Akiva Goldsman, Mark Bomback','Robert Schwentke',6.4 , '2015-03-20', 'Action', 'Shailene Woodley, Theo James, Octavia Spencer, Jai Courtney, Ray Stevenson, Zoë Kravitz, Miles Teller, Ansel Elgort, Maggie Q, Mekhi Phifer, Daniel Dae Kim, Naomi Watts, Kate Winslet');
INSERT INTO moviedetails VALUES ( null, 'Do You Believe?', 'Chuck Konzelman, Cary Solomon','Jonathan M. Gunn', 5.7, '2015-03-20', 'Drama', ' Ted McGinley, Mira Sorvino, Andrea Logan White, Lee Majors, Alexa PenaVega, Sean Astin, Madison Pettis, Cybill Shepherd, Brian Bosworth, Joseph Julian Soria');
INSERT INTO moviedetails VALUES ( null, 'Sindirella', 'Aline Brosh McKenna, Chris Weitz','Kenneth Branagh', 7.1, '2015-03-13', 'Adventure', 'Lily James, Richard Madden, Cate Blanchett, Helena Bonham Carter, Holliday Grainger, Sophie McShera, Stellan Skarsgård, Nonso Anozie, Derek Jacobi');
INSERT INTO moviedetails VALUES ( null, 'Harry Potter and the Half-Blood Prince', 'Steve Kloves','David Yates', 7.5, '2009-07-17', 'Fantasy', ' Daniel Radcliffe, Rupert Grint, Emma Watson, Helena Bonham Carter, David Bradley, Robbie Coltrane, Warwick Davis, Tom Felton, Michael Gambon, Alan Rickman, Maggie Smith, Natalia Tena, Julie Walters, David Thewlis, Evanna Lynch, Matthew Lewis, Bonnie Wright, Jim Broadbent, Helen McCrory, Jessie Cave, Hero Fiennes Tiffin, Frank Dillane');
INSERT INTO moviedetails VALUES ( null, 'Harry Potter and the Order of the Phoenix', 'Michael Goldenberg','David Yates', 7.5, '2007-07-13', 'Fantasy', 'Daniel Radcliffe, Rupert Grint, Emma Watson, Imelda Staunton, George Harris, Helen McCrory, Natalia Tena, Kathryn Hunter, Evanna Lynch, Robbie Coltrane, Ralph Fiennes, Michael Gambon, Brendan Gleeson, Jason Isaacs, Gary Oldman');
INSERT INTO moviedetails VALUES ( null, 'Serenity', 'Joss Whedon','Joss Whedon',8.0 , '2005-09-30', 'Action', ' Nathan Fillion, Gina Torres, Alan Tudyk, Morena Baccarin, Adam Baldwin, Jewel Staite, Sean Maher, Summer Glau, Ron Glass, Chiwetel Ejiofor');
INSERT INTO moviedetails VALUES ( null, 'Secret Window', 'Stephen King, David Koepp','David Koepp', 6.6, '2004-03-12', 'Horror', 'Johnny Depp, Maria Bello, Timothy Hutton, Ving Rhames, Charles Dutton');
INSERT INTO moviedetails VALUES ( null, 'Dreamcatcher', ' Stephen King, William Goldman, Lawrence Kasdan','Lawrence Kasdan',5.5 , '2003-03-19', 'Drama', 'Morgan Freeman, Thomas Jane, Jason Lee, Damian Lewis, Timothy Olyphant, Tom Sizemore, Donnie Wahlberg');
INSERT INTO moviedetails VALUES ( null, 'On The Waterfront', 'Budd Schulberg','Elia Kazan',8.3, '1954-07-28', ' Drama', 'Marlon Brando, Karl Malden, Lee J. Cobb, Rod Steiger, Pat Henning, Leif Erickson, James Westerfield, Tony Galento, Tami Mauriello, Eva Marie Saint');
INSERT INTO moviedetails VALUES ( null, 'The Sum Of All Fears', 'Paul Attanasio, Daniel Pyne','Phil Alden Robinson', 6.4, '2002-05-31', 'Action', 'Ben Affleck, Morgan Freeman, Bridget Moynahan, Alan Bates, James Cromwell');
INSERT INTO moviedetails VALUES ( null, 'Young Frankenstein', 'Gene Wilder, Mel Brooks','Mel Brooks',8.1 , '1974-12-15', 'Comedy', 'Gene Wilder, Peter Boyle, Marty Feldman, Cloris Leachman, Teri Garr');
INSERT INTO moviedetails VALUES ( null, 'Miracle On 34th Street', 'George Seaton','George Seaton', 7.9, '1947-05-02', 'Comedy', 'Maureen O\'Hara, John Payne, Edmund Gwenn, Gene Lockhart, Natalie Wood, Porter Hall, William Frawley, Jerome Cowan');
INSERT INTO moviedetails VALUES ( null, 'Enemy at the Gates', 'Jean-Jacques Annaud, Alain Godard','Jean-Jacques Annaud',7.6 , '2001-03-16', 'Drama', 'Jude Law, Ed Harris, Rachel Weisz, Joseph Fiennes, Bob Hoskins, Ron Perlman, Eva Mattes');
INSERT INTO moviedetails VALUES ( null, 'She-Wolf of London', 'George Bricker',' Jean Yarbrough', 5.2, '1946-05-17', 'Horror', 'Don Porter, June Lockhart, Sara Haden, Jan Wiley, Lloyd Corrigan, Dennis Hoey, Martin Kosleck, Eily Malyon, Frederick Worlock');
INSERT INTO moviedetails VALUES ( null, '20.000 Leagues Under the Sea', 'Earl Felton','Richard Fleischer', 7.2, '1954-12-23', 'Adventure', 'Kirk Douglas, James Mason, Paul Lukas, Peter Lorre, Robert J. Wilke, Ted de Corsia, Carleton Young, J.M. Kerrigan, Percy Helton, Ted Cooper');
INSERT INTO moviedetails VALUES ( null, 'Titanic', 'James Cameron','James Cameron', 7.7, '1997-12-19', 'Adventure', 'Leonardo DiCaprio, Kate Winslet, Billy Zane, Kathy Bates, Bill Paxton');
INSERT INTO moviedetails VALUES ( null, 'The Raid 2', 'Gareth Evans','Gareth Evans', 8.0, '2014-03-28', 'Action', ' Iko Uwais, Arifin Putra, Tio Pakusadewo, Oka Antara, Julie Estelle, Ryuhei Matsuda, Kenichi Endo, Kazuki Kitamura');
INSERT INTO moviedetails VALUES ( null, '300: Rise of an Empire', 'Zack Snyder, Kurt Johnstad','Noam Murro', 6.3, '2014-03-07', 'Action', ' Sullivan Stapleton, Eva Green, Lena Headey, Hans Matheson, David Wenham, Rodrigo Santoro, Igal Naor, Callan Mulvey, Jack OConnell, Andrew Tiernan');
INSERT INTO moviedetails VALUES ( null, 'Riddick', 'David Twohy','David Twohy', 6.4, '2013-09-06', 'Action', ' Vin Diesel, Karl Urban, Jordi Molla, Matt Nable, Katee Sackhoff, Bokeem Woodbine, Dave Bautista, Conrad Pla, Raoul Trujillo, Nolan Funk, Keri Hilson');
INSERT INTO moviedetails VALUES ( null, 'The Internship', 'Vince Vaughn, Jared Stern','Shawn Levy', 6.3, '2013-06-07', 'Comedy', 'Vince Vaughn, Owen Wilson, Max Minghella, Rose Byrne, John Goodman, Dylan O\'Brien, JoAnna Garcia, Eric Andre, Josh Brener, Tiya Sircar, Tobit Raphael, Will Ferrell');
INSERT INTO moviedetails VALUES ( null, 'Tarzan', 'Reinhard Klooss, Jessica Postigo, Yoni Brenner','Reinhard Klooss', 4.8, '2014-05-09', 'Animation', ' Kellan Lutz, Spencer Locke');
INSERT INTO moviedetails VALUES ( null, 'The Hobbit: An Unexpected Journey', 'Peter Jackson, Fran Walsh, Philippa Boyens, Guillermo del Toro','Peter Jackson',8.0 , '2012-12-14', 'Adventure', 'Ian McKellen, Martin Freeman, Cate Blanchett, Orlando Bloom, Ian Holm, Christopher Lee, Hugo Weaving, Elijah Wood, Evangeline Lilly, Andy Serkis, Richard Armitage');
INSERT INTO moviedetails VALUES ( null, 'Passion', 'Brian De Palma','Brian De Palma', 5.3, '2013-08-30', 'Drama', ' Rachel McAdams, Noomi Rapace, Karoline Herfurth, Paul Anderson');
INSERT INTO moviedetails VALUES ( null, 'How I Live Now', 'Jeremy Brock, Tony Grisoni, Penelope Skinner, Jack Thorne','Kevin Macdonald', 6.5, '2013-11-08', 'Drama', 'Saoirse Ronan, Tom Holland, Anna Chancellor');



select * from moviedetails;

