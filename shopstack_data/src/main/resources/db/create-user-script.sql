DROP USER 'shopstack_admin'@'localhost'

CREATE USER 'shopstack_admin'@'localhost' IDENTIFIED BY 'shopStack1.0';

GRANT ALL PRIVILEGES ON shopstack.* TO 'shopstack_admin'@'localhost';

GRANT ALL PRIVILEGES ON shopstack.* TO 'shopstack_admin'@'localhost';

FLUSH PRIVILEGES;