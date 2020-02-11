
INSERT INTO `shopstack`.`ss_user`(`ss_user_id`,`ss_first_name`, `ss_last_name`, `ss_email`, `ss_phone_number`, `ss_password`, `ss_enabled`)
VALUES
(1,'John', 'Ray', 'ray@mail.com', 070674673684,'test@123', 1),
(2,'Tolani', 'Dada', 'tolani@mail.com', 070674673684,'test@123', 1),
(3,'Lemon', 'Brown', 'lemon@mail.com', 070674673684,'test@123', 1),
(4,'Tobi', 'Tosho', 'tosho@mail.com', 070674673684,'test@123', 1),
(5,'Bisi', 'Tokunbo', 'bisi@mail.com', 070674673684,'test@123', 1),
(6,'Carl', 'Grey', 'carl@mail.com', 070674673684,'test@123', 1),
(7,'Kayode', 'Tope', 'kay@mail.com', 070674673684,'test@123', 1);

INSERT INTO `shopstack`.`role`(`role`, `ss_user_id`)
VALUES
('ROLE_USER' , 1),
('ROLE_USER' , 2),
('ROLE_USER' , 3),
('ROLE_USER' , 4),
('ROLE_USER' , 5),
('ROLE_USER' , 6),
('ROLE_USER' , 7);

