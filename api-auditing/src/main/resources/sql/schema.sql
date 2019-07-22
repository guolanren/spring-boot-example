CREATE TABLE IF NOT EXISTS `example_auditing_log` (
  `auditing_log_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL,
  `ip` VARCHAR(255) NOT NULL,
  `menu` VARCHAR(255) NOT NULL,
  `type` VARCHAR(255) NOT NULL,
  `status` int(11) NOT NULL,
  `description` VARCHAR(512) DEFAULT NULL,
  `operated_time` datetime NOT NULL,
  PRIMARY KEY (`auditing_log_id`)
);