/* Database creation */

CREATE DATABASE /*!32312 IF NOT EXISTS*/`filmski_arhiv_ps` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `filmski_arhiv_ps`;

/* Table structure for table `arhivator` */

DROP TABLE IF EXISTS `arhivator`;

CREATE TABLE `arhivator` (
  `ArhivatorID` int(11) NOT NULL,
  `Ime` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Prezime` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `KorisnickoIme` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `KorisnickaSifra` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ArhivatorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/* Data for the table `arhivator` */

INSERT INTO `arhivator`(`ArhivatorID`,`Ime`,`Prezime`,`KorisnickoIme`,`KorisnickaSifra`) VALUES 
(1,'Vidan','Dulanović','vidan','vidan'),
(2,'Jovan','Nikolić','joca','jocani');

/* Table structure for table `film` */

DROP TABLE IF EXISTS `film`;

CREATE TABLE `film` (
  `FilmID` int(11) NOT NULL,
  `NazivFilma` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Reziser` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Trajanje` int(11) NOT NULL,
  `ZanrID` int(11) NOT NULL,
  PRIMARY KEY (`FilmID`),
  KEY `ZanrID` (`ZanrID`),
  CONSTRAINT `film_ibfk_1` FOREIGN KEY (`ZanrID`) REFERENCES `zanr` (`ZanrID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/* Data for the table `film` */

INSERT INTO `film`(`FilmID`,`NazivFilma`,`Reziser`,`Trajanje`,`ZanrID`) VALUES 
(1,'Lorens od Arabije','Dejvid Lin',228,1),
(2,'Staze slave','Stenli Kubrik',88,1),
(3,'Apokalipsa danas','Frensis Ford Kopola',202,1),
(4,'Bitka za Alžir','Gilo Pontekorvo',121,1),
(5,'Bojevi metak','Stenli Kubrik',116,1),
(6,'Idi i gledaj','Elem Klimov',136,1),
(7,'Ivanovo detinjstvo','Andrej Tarkovski',95,1),
(8,'Andrej Rubljov','Andrej Tarkovski',205,2),
(9,'Oklopnjača Potemkin','Sergej Ajzenštajn',75,2),
(10,'Štrajk','Sergej Ajzenštajn',82,2),
(11,'Ivan Grozni','Sergej Ajzenštajn',191,2),
(12,'Stradanje Jovanke Orleanke','Karl Teodor Drejer',110,2),
(13,'Deset Božjih zapovesti','Sesil B. Demil',220,2),
(14,'Tuđin','Ridli Skot',117,3),
(15,'Paklena pomorandža','Stenli Kubrik',136,3),
(16,'2001: Odiseja u svemiru','Stenli Kubrik',149,3),
(17,'Metropolis','Fric Lang',145,3),
(18,'Istrebljivač','Ridli Skot',117,3),
(19,'Stalker','Andrej Tarkovski',163,3),
(20,'Solaris','Andrej Tarkovski',167,3),
(21,'Brazil','Teri Gilijam',142,3),
(22,'Svedok optužbe','Bili Vajlder',116,4),
(23,'Između neba i zemlje','Akira Kurosava',143,4),
(24,'Građanin Kejn','Orson Vels',119,4),
(25,'M','Fric Lang',117,4),
(26,'Vrtoglavica','Alfred Hičkok',129,4),
(27,'Treći čovek','Kerol Rid',104,3),
(28,'Kineska četvrt','Roman Polanski',130,4),
(29,'Dobar, loš, zao','Serđo Leone',179,5),
(30,'Bilo jednom na Divljem zapadu','Serđo Leone',165,5),
(31,'Za dolar više','Serđo Leone',132,5),
(32,'Za šaku dolara','Serđo Leone',99,5),
(33,'Divlja horda','Sem Pekinpo',144,5),
(34,'Tragači','Džon Ford',119,5),
(35,'Crvena reka','Hauard Hoks',133,5),
(36,'Psiho','Alfred Hičkok',109,6),
(37,'Isijavanje','Stenli Kubrik',146,6),
(38,'Zlobnici','Anri-Žorž Kluzo',116,6),
(39,'Kabinet doktora Kaligarija','Robert Vine',51,6),
(40,'Ralje','Stiven Spilberg',130,6),
(41,'Isterivač đavola','Vilijem Fridkin',132,6),
(42,'Nosferatu - Simfonija užasa','F.V. Murnau',94,6),
(43,'Bulevar sumraka','Bili Vajlder',110,7),
(44,'Dvostruka obmana','Bili Vajlder',107,7),
(45,'Kec u rukavu','Bili Vajlder',111,7),
(46,'Malteški soko','Džon Hjuston',100,7),
(47,'Dodir zla','Orson Vels',112,7),
(48,'Lora','Oto Preminger',88,7),
(49,'Iz prošlosti','Žak Turner',97,7),
(50,'Kum','Frensis Ford Kopola',175,8),
(51,'Kum 2','Frensis Ford Kopola',202,8),
(52,'Taksista','Martin Skorseze',113,8),
(53,'Žaoka','Džordž Roj Hil',129,8),
(54,'Rašomon','Akira Kurosava',88,8),
(55,'Lice sa ožiljkom','Brajan de Palma',170,8),
(56,'Dobri momci','Martin Skorseze',146,9),
(57,'Kad jaganjci utihnu','Džonatan Demi',138,9),
(58,'Leon: Profesionalac','Lik Beson',136,9),
(59,'12 gnevnih ljudi','Sidni Lamet',96,9),
(60,'Let iznad kukavičjeg gnezda','Miloš Forman',133,9),
(61,'Prozor u dvorište','Alfred Hičkok',112,10),
(62,'Sever-severozapad','Alfred Hičkok',136,10),
(63,'Konopac','Alfred Hičkok',80,10),
(64,'Persona','Ingmar Bergman',85,10),
(65,'Noć lovca','Čarls Lafton',92,10),
(66,'Ubistvo','Stenli Kubrik',85,10),
(67,'Na usamljenom mestu','Nikolas Rej',94,10),
(68,'Beri Lindon','Stenli Kubrik',184,9),
(69,'Svetla velegrada','Čarli Čaplin',87,11),
(70,'Moderna vremena','Čarli Čaplin',87,11),
(71,'Veliki diktator','Čarli Čaplin',125,11),
(72,'Zlatna groznica','Čarli Čaplin',95,11),
(74,'Šerlok mlađi','Baster Kiton',49,11),
(75,'Neki to vole vruće','Bili Vajlder',120,11),
(76,'General','Baster Kiton',67,11),
(77,'Ran','Akira Kurosava',162,9),
(78,'Sedam samuraja','Akira Kurosava',207,12),
(79,'Otimači izgubljenog kovčega','Stiven Spilberg',115,12),
(80,'Blago Sijera Madre','Džon Hjuston',126,12),
(81,'Dersu Uzala','Akira Kurosava',144,12),
(82,'Veliko bekstvo','Džon Sterdžes',172,12),
(83,'Ben-Hur','Vilijam Vajler',224,12),
(84,'Konformista','Bernardo Bertoluči',111,9),
(85,'Sanšo sudski izvršitelj','Kenđi Mizoguči',124,9),
(86,'Glava za brisanje','Dejvid Linč',80,6),
(87,'Prezir','Žan-Lik Godar',103,9),
(88,'Tokijska priča','Jasuđiro Ozu',136,9);

/* Table structure for table `film_pk` */

DROP TABLE IF EXISTS `film_pk`;

CREATE TABLE `film_pk` (
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/* Data for the table `film_pk` */

INSERT INTO `film_pk`(`ID`) VALUES 
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23),
(24),
(25),
(26),
(27),
(28),
(29),
(30),
(31),
(32),
(33),
(34),
(35),
(36),
(37),
(38),
(39),
(40),
(41),
(42),
(43),
(44),
(45),
(46),
(47),
(48),
(49),
(50),
(51),
(52),
(53),
(54),
(55),
(56),
(57),
(58),
(59),
(60),
(61),
(62),
(63),
(64),
(65),
(66),
(67),
(68),
(69),
(70),
(71),
(72),
(74),
(75),
(76),
(77),
(78),
(79),
(80),
(81),
(82),
(83),
(84),
(85),
(86),
(87),
(88),
(89),
(90);

/* Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `KorisnikID` int(11) NOT NULL,
  `NazivKorisnika` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `KontaktOsoba` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `PIB` int(11) NOT NULL,
  `EMail` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `WebSite` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Adresa` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ptt` int(11) NOT NULL,
  PRIMARY KEY (`KorisnikID`),
  KEY `Ptt` (`Ptt`),
  CONSTRAINT `korisnik_ibfk_1` FOREIGN KEY (`Ptt`) REFERENCES `mesto` (`Ptt`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/* Data for the table `korisnik` */

INSERT INTO `korisnik`(`KorisnikID`,`NazivKorisnika`,`KontaktOsoba`,`PIB`,`EMail`,`WebSite`,`Adresa`,`Ptt`) VALUES 
(1,'Jugoslovenska kinoteka','Aleksandar Erdeljanović',101513422,'kinoteka@eunet.rs','www.kinoteka.org.rs','Knez Mihailova 19',11000),
(2,'Centar za kulturu Valjevo','mr Katarina Marinković',106285454,'czkvaljevo@gmail.com','www.czk.rs','Čika Ljubina 5',14000),
(3,'Dom kulture Čačak','Milen Alempijević',101112640,'executive@animanima.org','www.domkulturecacak.org','Trg narodnog ustanka 2',32000),
(4,'Niški kulturni centar','Bojana Simovi?',100620097,'centar@nkc.org.rs','www.nkc.org.rs','Stanoja Bunuševca bb',18000),
(5,'Ustanova Dom Omladine \"Kragujevac\"','Dejan Dacović',101042230,'domomladinekg@yahoo.com','www.domomladine.com','Branka Radičevića 1',34000),
(6,'Ustanova kulture \"Vuk Karadžić\"','Svetislav Goncić',104456231,'produkcijaukvuk@gmail.com','www.ukvuk.org.rs','Bulevar Kralja Aleksandra 77a',11000),
(7,'Istorijski arhiv Zrenjanin','Nada Boroš',101164860,'arhivzrenjanin@gmail.com','www.arhivzrenjanin.org.rs','Trg Slobode 10',23000),
(8,'Novobeogradska kulturna mreža','Ana Vrbanec',105749164,'ana.vrbanec@novibeograd.rs','www.novibeograd.rs','Jurija Gagarina 221',11000),
(9,'Karlovačka gimnazija','Ivan Fink',101422302,'karlgimnazija@yahoo.com','www.sites.google.com/site/karlgimn1/','Trg Branka Radičevića 2',21205),
(10,'Fondacija za omladinsku kulturu \"Danilo Kiš\"','Milanka Kosti?',101126365,'office@danilokis.rs','www.danilokis.rs','Park Rajhla Ferenca 12/a',24000),
(11,'Dom omladine Beograda','Dragan Ambrozić',100049621,'dobinfo@domomladine.org','www.domomladine.org','Makedonska 22/IV',11000);

/* Table structure for table `korisnik_pk` */

DROP TABLE IF EXISTS `korisnik_pk`;

CREATE TABLE `korisnik_pk` (
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/* Data for the table `korisnik_pk` */

insert  into `korisnik_pk`(`ID`) values 
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11);

/* Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `Ptt` int(11) NOT NULL,
  `NazivMesta` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/* Data for the table `mesto` */

INSERT INTO `mesto`(`Ptt`,`NazivMesta`) VALUES 
(11000,'Beograd'),
(14000,'Valjevo'),
(18000,'Niš'),
(21000,'Novi Sad'),
(21205,'Sremski Karlovci'),
(23000,'Zrenjanin'),
(24000,'Subotica'),
(31000,'Užice'),
(31320,'Nova Varoš'),
(32000,'Čačak'),
(32300,'Gornji Milanovac'),
(34000,'Kragujevac');

/* Table structure for table `zaduzenje` */

DROP TABLE IF EXISTS `zaduzenje`;

CREATE TABLE `zaduzenje` (
  `KorisnikID` int(11) NOT NULL,
  `ZaduzenjeID` int(11) NOT NULL,
  `DatumZaduzenja` date NOT NULL,
  `DatumRazduzenja` date DEFAULT NULL,
  `Vraceno` tinyint(1) DEFAULT '0',
  `Uplata` double NOT NULL,
  `FilmID` int(11) NOT NULL,
  `Zaduzio` int(11) NOT NULL,
  `Razduzio` int(11) DEFAULT NULL,
  PRIMARY KEY (`KorisnikID`,`ZaduzenjeID`),
  KEY `KorisnikID` (`KorisnikID`),
  KEY `FilmID` (`FilmID`),
  KEY `Zaduzio` (`Zaduzio`),
  KEY `Razduzio` (`Razduzio`),
  CONSTRAINT `zaduzenje_ibfk_0` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `zaduzenje_ibfk_1` FOREIGN KEY (`FilmID`) REFERENCES `film` (`FilmID`) ON UPDATE CASCADE,
  CONSTRAINT `zaduzenje_ibfk_2` FOREIGN KEY (`Zaduzio`) REFERENCES `arhivator` (`ArhivatorID`) ON UPDATE CASCADE,
  CONSTRAINT `zaduzenje_ibfk_3` FOREIGN KEY (`Razduzio`) REFERENCES `arhivator` (`ArhivatorID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/* Data for the table `zaduzenje` */

INSERT INTO `zaduzenje`(`KorisnikID`,`ZaduzenjeID`,`DatumZaduzenja`,`DatumRazduzenja`,`Vraceno`,`Uplata`,`FilmID`,`Zaduzio`,`Razduzio`) VALUES 
(1,0,'2017-01-31',NULL,0,0,86,1,NULL),
(1,1,'2016-02-20','2016-02-26',1,4600,60,1,1),
(1,2,'2016-03-11','2016-03-15',1,3200,78,1,1),
(1,4,'2016-06-24','2016-06-28',1,3200,7,1,1),
(2,5,'2016-06-27','2016-07-02',1,3750,40,1,1),
(3,8,'2016-08-08','2016-08-12',1,3000,84,1,1),
(3,9,'2016-09-06',NULL,0,0,68,1,NULL),
(3,11,'2016-09-02',NULL,0,0,24,1,NULL),
(3,20,'2016-09-09',NULL,0,0,86,1,NULL),
(3,21,'2016-09-09',NULL,0,0,28,1,NULL),
(7,16,'2016-09-05','2016-09-09',1,3000,40,1,1),
(7,17,'2016-09-09',NULL,0,0,8,1,NULL),
(7,18,'2016-09-09',NULL,0,0,49,1,NULL),
(7,19,'2016-09-09',NULL,0,0,10,1,NULL),
(11,12,'2016-08-07','2016-08-12',1,3850,45,1,1),
(11,13,'2016-08-07','2016-08-14',1,5450,15,1,1),
(11,14,'2016-09-01','2016-09-07',1,4700,23,1,1),
(11,15,'2016-09-01',NULL,0,0,48,1,NULL);

/* Table structure for table `zanr` */

DROP TABLE IF EXISTS `zanr`;

CREATE TABLE `zanr` (
  `ZanrID` int(11) NOT NULL,
  `NazivZanra` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ZanrID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/* Data for the table `zanr` */

INSERT INTO `zanr`(`ZanrID`,`NazivZanra`) VALUES 
(1,'Ratni'),
(2,'Istorijski'),
(3,'Sci-fi'),
(4,'Misterija'),
(5,'Vestern'),
(6,'Horor'),
(7,'Film-noar'),
(8,'Krimić'),
(9,'Drama'),
(10,'Triler'),
(11,'Komedija'),
(12,'Avantura');
