use CV_CANDIDATES;
insert into CV_CANDIDATES.T_CONTACTS (
F_PHONE_NUMBER, F_SITE, F_REPOSITORY, F_EMAIL, F_SKYPE) values 
('+375(29)123-45-67', null, 'http://github.com/petya',  'petrovich@gmail.com', null), 
('+375(29)87-65-43', null, 'http://github.com/vanya', null, 'skype:ivanko'),
('+375(29)999-99-99', 'https://www.linkedin.com/in/mariya/', null, null, null);

insert into CV_CANDIDATES.T_GENDER (
GENDER_ID, F_GENDER_NAME) values 
(1, 'мужчина'),
(2, 'женщина');

insert into CV_CANDIDATES.T_TECHNOLOGIES(
TECHNOLOGIES_ID, F_TECHNOLOGIES_NAME) values  
(1, 'Git'),
(2, 'Spring Boot'),
(3, 'HTML'),
(4, 'JavaEE'),
(5, 'Java Core'),
(6, 'Maven'),
(7, 'REST'),
(8, 'Spring');

insert into CV_CANDIDATES.T_CANDIDATES(
CANDIDATES_ID, F_FIRSTNAME, F_LASTNAME,
F_PATRONYMIC, F_BIRTHDATE, F_CONTACTS_ID, F_GENDER_ID) values 
(1,'Петр', 'Петров', 'Петрович', '1986-12-12',1,1), 
(2,'Иван', 'Иванов', 'Иванович', '1997-4-4',2,1), 
(3,'Морская', 'Мария', 'Васильевна', '1999-11-07',3,2);

insert into CV_CANDIDATES.T_CANDIDATES_TECHNOLOGIES_RELATIONSHIP(
CANDIDATES_ID, TECHNOLOGIES_ID) values
(1,1),
(1,2),
(1,3),
(2,1),
(2,4),
(1,5),
(3,6),
(3,7),
(3,8);
