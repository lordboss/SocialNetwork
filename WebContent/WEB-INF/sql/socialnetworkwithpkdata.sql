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