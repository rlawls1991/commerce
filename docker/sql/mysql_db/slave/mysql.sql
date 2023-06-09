use mysql;

CHANGE MASTER TO MASTER_HOST='mysql-master', MASTER_PORT=3306, MASTER_USER='repl_user', MASTER_PASSWORD='repl_password', MASTER_LOG_FILE='mysql-bin.000003', MASTER_LOG_POS=154;

GRANT INSERT,SELECT,UPDATE,DELETE ON `product`.* TO `app_commerce`@`%` IDENTIFIED BY 'test1234';
GRANT INSERT,SELECT,UPDATE,DELETE ON `user`.* TO `app_commerce`@`%` IDENTIFIED BY 'test1234';
GRANT INSERT,SELECT,UPDATE,DELETE ON `escrow`.* TO `app_commerce`@`%` IDENTIFIED BY 'test1234';
GRANT INSERT,SELECT,UPDATE,DELETE ON `review`.* TO `app_commerce`@`%` IDENTIFIED BY 'test1234';