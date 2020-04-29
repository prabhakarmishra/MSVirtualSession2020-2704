CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `shortDescription` varchar(45) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `mrp` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB


	CREATE TABLE `producttag` (
	  `id` int(11) NOT NULL,
	  `tag` varchar(45) NOT NULL,
	  PRIMARY KEY (`id`,`tag`)
	) ENGINE=InnoDB
