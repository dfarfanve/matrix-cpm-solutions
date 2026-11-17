CREATE TABLE  IF NOT EXISTS des_config.url_param (
  param_id INT(20) NOT NULL AUTO_INCREMENT,
  url_id INT(20) NOT NULL,
  chain_name VARCHAR(60) DEFAULT NULL,
  param_name VARCHAR(60) DEFAULT NULL,
  param_type VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (param_id),
  KEY FK_url_param_config (url_id),
  CONSTRAINT FK_url_param_config FOREIGN KEY (url_id) REFERENCES url_config (url_id) ON DELETE CASCADE ON UPDATE CASCADE
) 