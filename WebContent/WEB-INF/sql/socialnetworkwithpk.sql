SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `socialnetwork` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE `socialnetwork`;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`user` (
  `email` VARCHAR(255) NOT NULL ,
  `passw` VARCHAR(255) NOT NULL ,
  `typeu` VARCHAR(45) NOT NULL ,
  `statusu` VARCHAR(45) NOT NULL ,
  `profileid` INT(11) NOT NULL ,
  `registrdate` TIMESTAMP NOT NULL ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,
  INDEX `fk_user_profileid_profile_idprofile_idx` (`profileid` ASC) ,
  INDEX `fk_user_statusu_ustatus_ustatus_idx` (`statusu` ASC) ,
  INDEX `fk_user_typeu_utype_utype_idx` (`typeu` ASC) ,
  PRIMARY KEY (`email`) ,
  CONSTRAINT `fk_user_profileid_profile_idprofile`
    FOREIGN KEY (`profileid` )
    REFERENCES `socialnetwork`.`profile` (`idprofile` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_statusu_ustatus_ustatus`
    FOREIGN KEY (`statusu` )
    REFERENCES `socialnetwork`.`ustatus` (`ustatus` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_typeu_utype_utype`
    FOREIGN KEY (`typeu` )
    REFERENCES `socialnetwork`.`utype` (`utype` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`friendsh` (
  `idfriendsh` INT(11) NOT NULL AUTO_INCREMENT ,
  `friendfrom` VARCHAR(255) NOT NULL ,
  `friendto` VARCHAR(255) NOT NULL ,
  `statusfriendsh` VARCHAR(45) NOT NULL ,
  `inviteid` INT(11) NOT NULL ,
  `friendshdate` TIMESTAMP NOT NULL ,
  PRIMARY KEY (`idfriendsh`) ,
  UNIQUE INDEX `friendship_id_UNIQUE` (`idfriendsh` ASC) ,
  INDEX `fk_friendship_ivite_idx` (`inviteid` ASC) ,
  INDEX `fk_friendsh_statusfriendsh_friendshstatus_friendshstatus_idx` (`statusfriendsh` ASC) ,
  INDEX `fk_friendsh_freindfrom_user_email_idx` (`friendfrom` ASC) ,
  INDEX `fk_friendsh_freindto_user_email_idx` (`friendto` ASC) ,
  CONSTRAINT `fk_friendsh_inviteid_invite_idinvite`
    FOREIGN KEY (`inviteid` )
    REFERENCES `socialnetwork`.`invite` (`idinvite` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_friendsh_statusfriendsh_friendshstatus_friendshstatus`
    FOREIGN KEY (`statusfriendsh` )
    REFERENCES `socialnetwork`.`friendshstatus` (`friendshstatus` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_friendsh_freindfrom_user_email`
    FOREIGN KEY (`friendfrom` )
    REFERENCES `socialnetwork`.`user` (`email` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_friendsh_freindto_user_email`
    FOREIGN KEY (`friendto` )
    REFERENCES `socialnetwork`.`user` (`email` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`friendshstatus` (
  `friendshstatus` VARCHAR(45) NOT NULL ,
  UNIQUE INDEX `friendshstatus_UNIQUE` (`friendshstatus` ASC) ,
  PRIMARY KEY (`friendshstatus`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`msgstatus` (
  `msgstatus` VARCHAR(45) NOT NULL ,
  UNIQUE INDEX `msgstatus_UNIQUE` (`msgstatus` ASC) ,
  PRIMARY KEY (`msgstatus`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`invite` (
  `idinvite` INT(11) NOT NULL AUTO_INCREMENT ,
  `inviter` VARCHAR(255) NOT NULL ,
  `invitee` VARCHAR(255) NOT NULL ,
  `res` VARCHAR(45) NOT NULL ,
  `invitedate` TIMESTAMP NOT NULL ,
  UNIQUE INDEX `invite_id_UNIQUE` (`idinvite` ASC) ,
  PRIMARY KEY (`idinvite`) ,
  INDEX `fk_invite_inviter_user_email_idx` (`inviter` ASC) ,
  INDEX `fk_invite_invitee_user_email_idx` (`invitee` ASC) ,
  INDEX `fk_invite_res_inviteres_inviteres_idx` (`res` ASC) ,
  CONSTRAINT `fk_invite_inviter_user_email`
    FOREIGN KEY (`inviter` )
    REFERENCES `socialnetwork`.`user` (`email` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invite_invitee_user_email`
    FOREIGN KEY (`invitee` )
    REFERENCES `socialnetwork`.`user` (`email` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invite_res_inviteres_inviteres`
    FOREIGN KEY (`res` )
    REFERENCES `socialnetwork`.`inviteres` (`inviteres` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`inviteres` (
  `inviteres` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`inviteres`) ,
  UNIQUE INDEX `inviteres_UNIQUE` (`inviteres` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`msg` (
  `idmsg` INT(11) NOT NULL AUTO_INCREMENT ,
  `mailer` VARCHAR(255) NOT NULL ,
  `recipient` VARCHAR(255) NOT NULL ,
  `headmsg` VARCHAR(255) NULL DEFAULT NULL ,
  `bodymsg` VARCHAR(1024) NULL DEFAULT NULL ,
  `statusmsg` VARCHAR(45) NOT NULL ,
  `typemsg` VARCHAR(45) NOT NULL ,
  `sendoffdate` TIMESTAMP NOT NULL ,
  PRIMARY KEY (`idmsg`) ,
  UNIQUE INDEX `message_id_UNIQUE` (`idmsg` ASC) ,
  INDEX `fk_msg_statusmsg_msgstatus_msgstatus_idx` (`statusmsg` ASC) ,
  INDEX `fk_msg_typemsg_msgtype_msgtype_idx` (`typemsg` ASC) ,
  INDEX `fk_msg_mailer_user_email_idx` (`mailer` ASC) ,
  INDEX `fk_msg_resipient_user_email_idx` (`recipient` ASC) ,
  CONSTRAINT `fk_msg_statusmsg_msgstatus_msgstatus`
    FOREIGN KEY (`statusmsg` )
    REFERENCES `socialnetwork`.`msgstatus` (`msgstatus` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_msg_typemsg_msgtype_msgtype`
    FOREIGN KEY (`typemsg` )
    REFERENCES `socialnetwork`.`msgtype` (`msgtype` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_msg_mailer_user_email`
    FOREIGN KEY (`mailer` )
    REFERENCES `socialnetwork`.`user` (`email` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_msg_resipient_user_email`
    FOREIGN KEY (`recipient` )
    REFERENCES `socialnetwork`.`user` (`email` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`utype` (
  `utype` VARCHAR(45) NOT NULL ,
  UNIQUE INDEX `utype_UNIQUE` (`utype` ASC) ,
  PRIMARY KEY (`utype`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`profile` (
  `idprofile` INT(11) NOT NULL AUTO_INCREMENT ,
  `fname` VARCHAR(45) NULL DEFAULT NULL ,
  `surname` VARCHAR(45) NULL DEFAULT NULL ,
  `sex` VARCHAR(45) NULL DEFAULT NULL ,
  `pict` BINARY NULL DEFAULT NULL ,
  `introd` VARCHAR(1024) NULL DEFAULT NULL ,
  `hobby` VARCHAR(1024) NULL DEFAULT NULL ,
  PRIMARY KEY (`idprofile`) ,
  UNIQUE INDEX `profile_id_UNIQUE` (`idprofile` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`ustatus` (
  `ustatus` VARCHAR(45) NOT NULL ,
  UNIQUE INDEX `ustatus_UNIQUE` (`ustatus` ASC) ,
  PRIMARY KEY (`ustatus`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`msgtype` (
  `msgtype` VARCHAR(45) NOT NULL ,
  UNIQUE INDEX `msgtype_UNIQUE` (`msgtype` ASC) ,
  PRIMARY KEY (`msgtype`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `friendshstatus` (`friendshstatus`) VALUES
('DELETE'),
('PRESENT');

INSERT INTO `inviteres` (`inviteres`) VALUES
('AWAIT'),
('YES'),
('NO');

INSERT INTO `msgstatus` (`msgstatus`) VALUES
('DELETE'),
('NOREAD'),
('READ'),
('SAVE');

INSERT INTO `ustatus` (`ustatus`) VALUES
('ACTIVE'),
('BLOCKED'),
('DELETE');

INSERT INTO `utype` (`utype`) VALUES
('ADMIN'),
('REGISTERED'),
('UNREGISTERED');

INSERT INTO `msgtype` (`msgtype`) VALUES
('PLAIN'),
('NEWS'),
('COMPLAINT');

INSERT INTO `profile` (`idprofile`, `fname`, `surname`, `sex`, `pict`, `introd`, `hobby`) VALUES
(1, 'Ivan', 'Ivanov', 'MALE', NULL, 'Hello everybody!', 'sport jazz'),
(2, 'Petr', 'Petrov', 'MALE', NULL, 'Yep, I am here', 'jazz'),
(3, 'Nina', 'Ninova', 'FEMALE', NULL, 'Get five', 'doll'),
(4, 'Ira', 'Irova', 'FEMALE', NULL, 'So cute', 'haircut'),
(5, 'Kira', 'Kirova', 'FEMALE', NULL, 'Meow', 'cat'),
(6, 'Lira', 'Lirova', 'FEMALE', NULL, 'I am from Canada. Where are you from?', 'tree'),
(7, 'Tima', 'Timov', 'MALE', NULL, 'cosy', 'bike'),
(8, 'Misha', 'Mishov', 'MALE', NULL, 'bossy', 'tennis'),
(9, 'Grisha', 'Grishov', 'MALE', NULL, 'artist!', 'art'),
(10, 'Tom', 'Tomov', 'MALE', NULL, 'Proud to be american', 'geography');

INSERT INTO `user` (`email`, `passw`, `typeu`, `statusu`, `profileid`, `registrdate`) VALUES
('grisha@grisha.com', 'grisha', 'REGISTERED', 'ACTIVE', 9, '2013-02-16 13:10:19'),
('ira@ira.com', 'ira', 'REGISTERED', 'ACTIVE', 4, '2013-02-16 13:10:19'),
('ivan@ivan.com', 'ivan', 'REGISTERED', 'ACTIVE', 1, '2013-02-16 13:10:19'),
('kira@kira.com', 'kira', 'REGISTERED', 'ACTIVE', 5, '2013-02-16 13:10:19'),
('lira@lira.com', 'lira', 'REGISTERED', 'ACTIVE', 6, '2013-02-16 13:10:19'),
('misha@misha.com', 'misha', 'REGISTERED', 'ACTIVE', 8, '2013-02-16 13:10:19'),
('nina@nina.com', 'nina', 'REGISTERED', 'ACTIVE', 3, '2013-02-16 13:10:19'),
('petr@petr.com', 'petr', 'REGISTERED', 'ACTIVE', 2, '2013-02-16 13:10:19'),
('tima@tima.com', 'tima', 'REGISTERED', 'ACTIVE', 7, '2013-02-16 13:10:19'),
('tom@tom.com', 'tom', 'REGISTERED', 'ACTIVE', 10, '2013-02-16 13:10:19');

INSERT INTO `invite` (`idinvite`, `inviter`, `invitee`, `res`, `invitedate`) VALUES
(1, 'ivan@ivan.com', 'nina@nina.com', 'AWAIT', '2013-02-16 13:43:07'),
(2, 'ivan@ivan.com', 'misha@misha.com', 'NO', '2013-02-16 13:43:07'),
(3, 'tom@tom.com', 'lira@lira.com', 'YES', '2013-02-16 13:43:07'),
(4, 'kira@kira.com', 'lira@lira.com', 'YES', '2013-02-16 13:43:07'),
(5, 'nina@nina.com', 'lira@lira.com', 'YES', '2013-02-16 13:43:07');

INSERT INTO `friendsh` (`idfriendsh`, `friendfrom`, `friendto`, `statusfriendsh`, `inviteid`, `friendshdate`) VALUES
(1, 'tom@tom.com', 'lira@lira.com', 'PRESENT', 3, '2013-02-16 13:49:14'),
(2, 'kira@kira.com', 'lira@lira.com', 'PRESENT', 4, '2013-02-16 13:49:14'),
(3, 'nina@nina.com', 'lira@lira.com', 'PRESENT', 5, '2013-02-16 13:49:14');