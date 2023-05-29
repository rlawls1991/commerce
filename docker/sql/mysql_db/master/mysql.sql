use mysql;

CREATE USER 'repl_user'@'%' IDENTIFIED BY 'repl_password';

GRANT REPLICATION SLAVE ON *.* TO 'repl_user'@'%';

GRANT INSERT,SELECT,UPDATE,DELETE ON `product`.* TO `app_commerce`@`%` IDENTIFIED BY 'test1234';
GRANT INSERT,SELECT,UPDATE,DELETE ON `user`.* TO `app_commerce`@`%` IDENTIFIED BY 'test1234';
GRANT INSERT,SELECT,UPDATE,DELETE ON `escrow`.* TO `app_commerce`@`%` IDENTIFIED BY 'test1234';
GRANT INSERT,SELECT,UPDATE,DELETE ON `review`.* TO `app_commerce`@`%` IDENTIFIED BY 'test1234';