# SpringMVC20220830
SpringMVC20220830
<pre>

CREATE TABLE `adoptiongroup` (
  `AdoptionID` int(11) NOT NULL,
  `AdoptionSource` varchar(255) DEFAULT NULL,
  `ContactName` varchar(255) DEFAULT NULL,
  `ContactPhone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AdoptionID`)
);

INSERT INTO `adoptiongroup` VALUES (1,'Walk-in',NULL,NULL),(2,'Rough Dog Rescue','John Jackson','111-333-4444'),(3,'Animal Friends Forever','Sacha Szerski','111-444-2222'),(4,'Fish Friends Rescue','Frank Fuerza','111-333-5555'),(5,'Save the Animals','Allen Ackerman','111-222-6666'),(6,'Cat Friend Society','Mary Munoz','111-222-3333'),(7,'Pretty Faces','Paul Pension','111-555-2222');

CREATE TABLE `breed` (
  `Category` varchar(50) NOT NULL,
  `Breed` varchar(50) NOT NULL,
  PRIMARY KEY (`Category`,`Breed`)
);

INSERT INTO `breed` VALUES ('Bird','African Grey'),('Bird','Canary'),('Bird','Cockatiel'),('Bird','Lovebird'),('Bird','Other'),('Bird','Parakeet'),('Bird','Parrot'),('Cat','Abyssinian'),('Cat','American Shorthair'),('Cat','American Wirehair'),('Cat','Angora'),('Cat','Bombay'),('Cat','British Blue'),('Cat','Burmese'),('Cat','Canadian Hairless'),('Cat','Chartreux'),('Cat','Havana'),('Cat','Japanese Bobtail'),('Cat','Korat'),('Cat','Longhair'),('Cat','Maine Coon'),('Cat','Manx'),('Cat','Oriental Shorthair'),('Cat','Other'),('Cat','Persian'),('Cat','Russian Blue'),('Cat','Scottish Fold'),('Cat','Siamese'),('Cat','Snow-Shoe'),('Cat','Sphynx'),('Cat','Tonkinese'),('Dog','Afghan'),('Dog','Airedale'),('Dog','Akita'),('Dog','Alaskan Malamute'),('Dog','Australian Shepherd'),('Dog','Bassett Hound'),('Dog','Beagle'),('Dog','Bichon Frise'),('Dog','Bloodhound'),('Dog','Border Collie'),('Dog','Boston Terrier'),('Dog','Boxer'),('Dog','Bulldog'),('Dog','Cairn Terrier'),('Dog','Chihuahua'),('Dog','Chinese Shar Pei'),('Dog','Chow Chow'),('Dog','Cock A Poo'),('Dog','Cocker Spaniel'),('Dog','Collie'),('Dog','Coon Hound'),('Dog','Dachshund'),('Dog','Dalmation'),('Dog','Doberman'),('Dog','English Bulldog'),('Dog','German Shepherd'),('Dog','Golden Retriever'),('Dog','Great Dane'),('Dog','Great Pyrenees'),('Dog','Greyhound'),('Dog','Jack Russell Terrier'),('Dog','Keeshond'),('Dog','Labrador Retriever'),('Dog','Lhasa Apso'),('Dog','Maltese'),('Dog','Maltipoos'),('Dog','Mastiff'),('Dog','Minature Pinschers'),('Dog','Norfolk Terrier'),('Dog','Other'),('Dog','Pekingese'),('Dog','Pit Bull'),('Dog','Pointer'),('Dog','Pomeranian'),('Dog','Poodle'),('Dog','Poodle-Toy'),('Dog','Rottweiler'),('Dog','Schnauzer'),('Dog','Scottish Terrier'),('Dog','Shetland Sheepdog'),('Dog','Shihtzu'),('Dog','Siberian Huskie'),('Dog','St Bernard'),('Dog','Vizsla'),('Dog','Weimaraner'),('Dog','Wire Fox Terrier'),('Dog','Yorkshire Terrier'),('Fish','Angel'),('Fish','Guppy'),('Fish','Other'),('Fish','Shark'),('Fish','Snail'),('Fish','Starfish'),('Fish','Tetra'),('Mammal','Ferret'),('Mammal','Hamster'),('Other','Other'),('Reptile','Boa Constrictor'),('Reptile','Gila Monster'),('Reptile','Other'),('Reptile','Python'),('Spider','Other'),('Spider','Scorpion'),('Spider','Tarantula');

CREATE TABLE `category` (
  `Category` varchar(50) NOT NULL,
  `Registration` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Category`)
);

INSERT INTO `category` VALUES ('Bird',NULL),('Cat','CFA'),('Dog','AKC'),('Fish',NULL),('Mammal','Misc'),('Other','Unknown'),('Reptile',NULL),('Spider',NULL);


</pre>
