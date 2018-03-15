DROP DATABASE IF EXISTS avataardemo ;
CREATE DATABASE avataardemo;
USE avataardemo;

CREATE TABLE BAG_T(
BAGID INT NOT NULL AUTO_INCREMENT,
REFNAME VARCHAR(255) NOT NULL,
TYPE VARCHAR(255) NOT NULL,
VERSION VARCHAR(100) NOT NULL,
DB_CREATED_DATETIME DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
DB_MODIFIED_DATETIME DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (BAGID)
);

CREATE TABLE SKU_T (
SKUID INT NOT NULL AUTO_INCREMENT,
ISACTIVE BIT(1) DEFAULT 0,
PURCHASELNK VARCHAR(255) NOT NULL,
DB_CREATED_DATETIME DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
DB_MODIFIED_DATETIME DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
BAGID INT NOT NULL,
PRIMARY KEY (SKUID),
FOREIGN KEY (BAGID) REFERENCES BAG_T(BAGID) 
);



Hibernate: drop table if exists bag_t
Hibernate: drop table if exists bags_skus
Hibernate: drop table if exists shoe_t
Hibernate: drop table if exists shoes_skus
Hibernate: drop table if exists sku_t
Hibernate: create table bag_t (bagid integer not null auto_increment, refname varchar(255), type varchar(255), version varchar(255), primary key (bagid))
Hibernate: create table bags_skus (bagid integer not null, skuid integer not null, primary key (bagid, skuid))
Hibernate: create table shoe_t (shoeid integer not null auto_increment, refname varchar(255), type varchar(255), version varchar(255), primary key (shoeid))
Hibernate: create table shoes_skus (shoeid integer not null, skuid integer not null, primary key (shoeid, skuid))
Hibernate: create table sku_t (skuid integer not null auto_increment, isactive BIT not null, purchaselink varchar(255), bagid integer, shoeid integer, primary key (skuid))
Hibernate: alter table bags_skus add constraint UK_t8ou3ul2q1ou8eb5m5jy1sn0l unique (skuid)
Hibernate: alter table shoes_skus add constraint UK_46cjrqatnba9oma2lvdnuwvph unique (skuid)
Hibernate: alter table bags_skus add constraint FKcsautyida28gqg04hdi8shsvn foreign key (skuid) references sku_t (skuid)
Hibernate: alter table bags_skus add constraint FK6a1ah52fwvbo46adti3bmlek5 foreign key (bagid) references bag_t (bagid)
Hibernate: alter table shoes_skus add constraint FK7ahboub571g2rivg3hls1ohwv foreign key (skuid) references sku_t (skuid)
Hibernate: alter table shoes_skus add constraint FK47ieuv4k5d0y5e3bfihffqebn foreign key (shoeid) references shoe_t (shoeid)
Hibernate: alter table sku_t add constraint FK56mi2beajurf26gtrrusy2et5 foreign key (bagid) references bag_t (bagid)
Hibernate: alter table sku_t add constraint FKg3r8snjbbgvl4f6f4noilgl9h foreign key (shoeid) references shoe_t (shoeid)