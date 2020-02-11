INSERT INTO `shopstack`.`role`(`role`)
VALUES
('ROLE_USER');

INSERT INTO `shopstack`.`ss_user`(`ss_first_name`, `ss_last_name`, `ss_email`, `ss_phone_number`, `ss_password`, `ss_enabled`, `role_id`)
VALUES
('John', 'Ray', 'ray@mail.com', 070674673684,'test@123', 1, 1),
('Tolani', 'Dada', 'tolani@mail.com', 070674673684,'test@123', 1, 1),
('Lemon', 'Brown', 'lemon@mail.com', 070674673684,'test@123', 1, 1),
('Tobi', 'Tosho', 'tosho@mail.com', 070674673684,'test@123', 1, 1),
('Bisi', 'Tokunbo', 'bisi@mail.com', 070674673684,'test@123', 1, 1),
('Carl', 'Grey', 'carl@mail.com', 070674673684,'test@123', 1, 1),
('Kayode', 'Tope', 'kay@mail.com', 070674673684,'test@123', 1, 1);
