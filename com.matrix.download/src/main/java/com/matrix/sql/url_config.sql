CREATE TABLE IF NOT EXISTS DES_CONFIG.URL_CONFIG (
    url_id INT(20) NOT NULL AUTO_INCREMENT,
    chain_name VARCHAR(60) NOT NULL,
    uri_str VARCHAR(500) NOT NULL,
    is_active VARCHAR(1) DEFAULT 'Y',
    url_seq INT(10),
    url_type varchar(20),
    PRIMARY KEY (url_id)
) 