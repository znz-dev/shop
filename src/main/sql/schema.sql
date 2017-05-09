CREATE database shop;

use shop;

-- 创建用户表
CREATE TABLE user(
  user_id INT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  username VARCHAR(20) NOT NULL COMMENT '用户名',
  password VARCHAR(18) NOT NULL COMMENT '用户密码',
  phone VARCHAR(20) COMMENT '电话号码',
  email VARCHAR(30) COMMENT '邮箱地址',
  real_name VARCHAR(10) COMMENT '真实姓名',
  avatar VARCHAR(50) COMMENT '用户头像',
  description VARCHAR(100) COMMENT '用户介绍',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (user_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT into user(user_id, username, password)
VALUES
  (1, 'system', '123456'),
  (2, 'root', '123456'),
  (3, 'zhangbin', '123456'),
  (4, 'zhouxin', '123456');

-- 创建店铺表
CREATE TABLE shop(
  shop_id INT NOT NULL AUTO_INCREMENT COMMENT '店铺ID',
  name VARCHAR(20) NOT NULL COMMENT '店铺名',
  avatar VARCHAR(50) COMMENT '店铺头像',
  description VARCHAR(100) NOT NULL COMMENT '店铺描述',
  owner_id INT NOT NULL COMMENT '店主ID',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
  PRIMARY KEY (shop_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='店铺表';

INSERT into shop(shop_id, name, description, owner_id)
VALUES
  (1, 'CASIO手表店', '专卖 (PRO-TREAK 7000-T)', 1),
  (2, '狗粮店', '单身狗粮大减价了', 2),
  (3, '猫砂店', '我们不生产猫砂， 我们只是猫砂的搬运工', 3),
  (4, 'ZNZ', '指南针买一送一啦', 4);

-- 创建商品表
CREATE TABLE good(
  good_id INT NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  name VARCHAR(20) NOT NULL COMMENT '商品名',
  price FLOAT NOT NULL COMMENT '商品价格',
  status INT NOT NULL DEFAULT 1 COMMENT '商品状态',
  description VARCHAR(100) COMMENT '商品描述',
  shop_id INT NOT NULL COMMENT '店铺ID',
  sales INT NOT NULL DEFAULT 0 COMMENT '销量',
  remainder INT NOT NULL COMMENT '余量',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (good_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='商品表';

INSERT into good(name, price, shop_id, remainder)
VALUES
  ('PRO-TREAK 7000-T', 998.8, 1, 100),
  ('单身狗粮', 11.11, 2, 1111),
  ('金猫砂', 50, 3, 500),
  ('指南针', 10, 4, 100);

-- 创建消息表
CREATE TABLE message(
  message_id INT NOT NULL AUTO_INCREMENT COMMENT '消息ID',
  from_id INT NOT NULL COMMENT '发送人ID',
  to_id INT NOT NULL COMMENT '收件人ID',
  title VARCHAR(20) NOT NULL COMMENT '消息标题',
  content VARCHAR(100) NOT NULL COMMENT '消息内容',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  status INT NOT NULL DEFAULT 1 COMMENT '消息状态',
  PRIMARY KEY (message_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息表';
