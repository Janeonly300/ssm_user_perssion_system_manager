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

SELECT * FROM t_product;

/**
	会员表
**/
DROP TABLE IF EXISTS t_member;
CREATE TABLE t_member(
	id VARCHAR(36) PRIMARY KEY , -- 主键uuid
	member_name VARCHAR(20) , -- 姓名
	member_nick_name VARCHAR(20) , -- 昵称
	member_phone VARCHAR(20) , -- 电话
	member_email VARCHAR(50)  -- 邮箱
)ENGINE=INNODB DEFAULT CHARSET utf8;

/**
	旅客表
**/
DROP TABLE IF EXISTS t_traveller;
CREATE TABLE t_traveller(
	id VARCHAR(36) PRIMARY KEY , -- 主键id
	traveller_name VARCHAR(20) , -- 姓名
	traveller_sex VARCHAR(2) , -- 性别
	traveller_phone VARCHAR(20) , -- 电话
	traveller_credentials_type INT, -- 证件类型|0身份证|1护照|2军官证|
	traveller_credentials_num VARCHAR(50) , -- 证件号码
	traveller_type INT  -- 旅客类型|0成人|1儿童
)ENGINE = INNODB DEFAULT CHARSET utf8;

/**
	订单表
**/
DROP TABLE IF EXISTS t_orders;
CREATE TABLE t_orders(
	id VARCHAR(36) PRIMARY KEY , -- 主键Id
	orders_num VARCHAR(20) NOT NULL UNIQUE , -- 订单编号
	orders_time DATETIME, -- 下单时间
	orders_people_count INT  ,  -- 出行人数，
	orders_desc VARCHAR(50) , -- 订单描述
	orders_pay_type INT , -- 支付方式 |0支付宝|1微信|2其他
	ordes_status INT , -- 支付状态，|0 已经支付|2没有支付
	product_id VARCHAR(36) , -- 产品id
	member_id VARCHAR(36) ,-- 会员id
	FOREIGN KEY (product_id) REFERENCES t_product(id),
	FOREIGN KEY (member_id) REFERENCES t_member(id)
) ENGINE=INNODB DEFAULT CHARSET utf8;

/**
	旅客和订单中间表
**/
DROP TABLE IF EXISTS t_orders_traveller;
CREATE TABLE t_orders_traveller(
	id INT PRIMARY KEY AUTO_INCREMENT, 
	orders_id VARCHAR(36) , 
	traveller_id VARCHAR(36),
	FOREIGN KEY (traveller_id) REFERENCES t_traveller(id),
	FOREIGN KEY (orders_id) REFERENCES t_orders(id)
)ENGINE=INNODB DEFAULT CHARSET utf8;
