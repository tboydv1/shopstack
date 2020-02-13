
INSERT INTO `shopstack`.`ss_user`(`ss_user_id`,`ss_first_name`, `ss_last_name`, `ss_email`, `ss_phone_number`, `ss_password`, `ss_enabled`, `ss_status`)
VALUES
(1,'John', 'Ray', 'ray@mail.com', 070674673684,'test@123', 1, 'ACTIVE'),
(2,'Tolani', 'Dada', 'tolani@mail.com', 070674673684,'test@123', 1, 'ACTIVE'),
(3,'Lemon', 'Brown', 'lemon@mail.com', 070674673684,'test@123', 1,'ACTIVE'),
(4,'Tobi', 'Tosho', 'tosho@mail.com', 070674673684,'test@123', 1,'ACTIVE'),
(5,'Bisi', 'Tokunbo', 'bisi@mail.com', 070674673684,'test@123', 1,'ACTIVE'),
(6,'Carl', 'Grey', 'carl@mail.com', 070674673684,'test@123', 1,'ACTIVE'),
(7,'Kayode', 'Tope', 'kay@mail.com', 070674673684,'test@123', 1, 'ACTIVE');

INSERT INTO `shopstack`.`role`(`role_id`,`role`, `user_email`)
VALUES
(1,'ROLE_USER' , 'ray@mail.com'),
(2,'ROLE_USER' , 'tolani@mail.com'),
(3,'ROLE_USER' ,  'lemon@mail.com'),
(4,'ROLE_USER' ,  'tosho@mail.com'),
(5,'ROLE_USER' , 'bisi@mail.com'),
(6,'ROLE_USER' , 'carl@mail.com'),
(7,'ROLE_USER' , 'kay@mail.com');

