create database if not exists CV_CANDIDATES;
use CV_CANDIDATES;

create table if not exists T_CONTACTS (
            CONTACTS_ID bigint not null auto_increment,
            F_PHONE_NUMBER varchar (20) not null,
            F_SITE varchar (255) null,
            F_REPOSITORY varchar (255) null,
            F_EMAIL varchar (100) null,
            F_SKYPE varchar (50) null,
            primary key (CONTACTS_ID)
            )CHARACTER SET utf8;

create table if not exists T_GENDER (
            GENDER_ID int not null,
            F_GENDER_NAME varchar (15) not null,
            primary key (GENDER_ID)
            )CHARACTER SET utf8;

create table if not exists T_TECHNOLOGIES (
            TECHNOLOGIES_ID bigint not null auto_increment,
            F_TECHNOLOGIES_NAME varchar (50) not null,
            primary key (TECHNOLOGIES_ID)
            )CHARACTER SET utf8;

create table if not exists T_CANDIDATES(
            CANDIDATES_ID bigint not null auto_increment,
            F_FIRSTNAME varchar(20) not null,
            F_LASTNAME varchar(20) not null,
            F_PATRONYMIC varchar(40) not null, 
            F_BIRTHDATE date not null,
            F_CONTACTS_ID bigint not null,
            F_GENDER_ID int not null,
            primary key (CANDIDATES_ID),

			FOREIGN KEY (F_CONTACTS_ID) REFERENCES T_CONTACTS (CONTACTS_ID) ON DELETE CASCADE,
            FOREIGN KEY (F_GENDER_ID) REFERENCES T_GENDER (GENDER_ID) ON DELETE CASCADE
            )CHARACTER SET utf8;
            
create table T_CANDIDATES_TECHNOLOGIES_RELATIONSHIP(
			CANDIDATES_ID bigint not null,
			TECHNOLOGIES_ID bigint not null,
            
			FOREIGN KEY (CANDIDATES_ID) REFERENCES T_CANDIDATES(CANDIDATES_ID) ON DELETE CASCADE,
			FOREIGN KEY (TECHNOLOGIES_ID) REFERENCES T_TECHNOLOGIES(TECHNOLOGIES_ID) ON DELETE CASCADE,
			UNIQUE (CANDIDATES_ID, TECHNOLOGIES_ID)
			);