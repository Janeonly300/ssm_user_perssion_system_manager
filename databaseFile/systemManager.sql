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

SELECT * FROM 
t_orders o 
JOIN t_orders_traveller ot 
ON o.`id` = ot.`orders_id` 
JOIN t_traveller t 
ON t.`id` = ot.`traveller_id`  WHERE ot.`orders_id` = '3rgbsdfghrf532424122'  ;


/**
	用户表
**/
DROP TABLE IF EXISTS t_users;
CREATE TABLE t_users(
	id VARCHAR(50) PRIMARY KEY , -- uuid
	users_name VARCHAR(20) , -- 用户名称
	user_email VARCHAR(50) NOT NULL , -- 用户邮箱
	user_pwd VARCHAR(50) NOT NULL , -- 用户密码
	user_phone_num VARCHAR(20) , -- 用户手机号码
	user_status INT -- 状态
)ENGINE=INNODB DEFAULT CHARSET utf8;

/**
	角色表
**/
DROP TABLE IF t_role;
CREATE TABLE t_role(
	id VARCHAR(50) PRIMARY KEY , -- uuid
	role_name VARCHAR(20) , -- 角色名称
	role_desc VARCHAR(50)  -- 角色描述
)ENGINE=INNODB DEFAULT CHARSET utf8;

/**
	权限表
**/
DROP TABLE IF EXISTS t_permission;
CREATE TABLE t_permission(
	id VARCHAR(50) PRIMARY KEY , -- uuid
	permission_name VARCHAR(20) , -- 权限名称
	permission_url VARCHAR(50)  -- 权限资源
)ENGINE=INNODB DEFAULT CHARSET utf8;


/**
	角色与用户中间表
**/
DROP TABLE IF EXISTS t_role_usres;
CREATE TABLE t_role_usres(
	id INT PRIMARY KEY AUTO_INCREMENT, 
	users_id VARCHAR(50)  NOT NULL ,
	role_id VARCHAR(50)  NOT NULL,
	FOREIGN KEY (users_id) REFERENCES t_users(id),
	FOREIGN KEY (role_id) REFERENCES t_role(id)
)ENGINE=INNODB DEFAULT CHARSET utf8;

/**
	权限与角色中间表
**/
DROP TABLE IF EXISTS t_role_permission;
CREATE TABLE t_role_permission(
	id INT PRIMARY KEY AUTO_INCREMENT,
	role_id VARCHAR(50)  NOT NULL,
	permission_id VARCHAR(50)  NOT NULL,
	FOREIGN KEY (role_id) REFERENCES t_role(id),
	FOREIGN KEY (permission_id) REFERENCES t_permission(id)
)ENGINE=INNODB DEFAULT CHARSET utf8;


/**
	SysLog
**/
DROP TABLE IF EXISTS t_systemlog;
CREATE TABLE t_systemlog(
	id INT PRIMARY KEY AUTO_INCREMENT,
	systemlog_visit_time DATETIME NOT NULL,  -- 访问时间
	systemlog_user_name VARCHAR(50),-- 访问的用户名
	systemlog_ip VARCHAR(50), -- IP
	systemlog_url VARCHAR(50),-- URL
	systemlog_method VARCHAR(50), -- 方法
	systemlog_execution_time LONG  -- 执行的时间
)ENGINE=INNODB DEFAULT CHARSET utf8;


SELECT * FROM t_role  WHERE id IN(SELECT role_id FROM t_role_usres WHERE users_id = '111--22');

SELECT * FROM t_role WHERE id NOT IN(SELECT role_id FROM t_role_usres WHERE users_id = '111--2');

SELECT * FROM t_role WHERE id = '23--43'
