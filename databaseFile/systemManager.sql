CREATE DATABASE ssm_system_manager;

USE ssm_system_manager;

/**
	产品表
**/
DROP TABLE IF EXISTS t_product;
CREATE TABLE t_product(
	id VARCHAR(39) PRIMARY KEY  , -- 主键无意义
	product_num VARCHAR(50) UNIQUE NOT NULL ,  -- 产品编号
	product_name VARCHAR(50) NOT NULL , -- 产品名称（路线名称）
	start_city_name VARCHAR(50) , -- 触发的城市
	start_date_time DATETIME , -- 出发的时间，
	product_price DOUBLE , -- 价格
	product_desc VARCHAR(250) , -- 描述
	product_status INT  -- 状态 -0 关闭 1开启
) ENGINE=INNODB DEFAULT CHARSET utf8;