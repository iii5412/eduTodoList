--# root password 6212
CREATE DATABASE IF NOT EXISTS tododb;
CREATE USER 'appuser'@'%' IDENTIFIED BY 'appuser';
GRANT ALL PRIVILEGES ON tododb.* TO 'appuser'@'%';
FLUSH PRIVILEGES;
