CREATE TABLE IF NOT EXISTS `example_sys_user` (
  `id` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP SEQUENCE IF EXISTS SEQ_SYS_USER;
CREATE SEQUENCE SEQ_SYS_USER;