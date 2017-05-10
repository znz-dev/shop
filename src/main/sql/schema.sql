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

# -- 创建店铺表
# CREATE TABLE shop(
#   shop_id INT NOT NULL AUTO_INCREMENT COMMENT '店铺ID',
#   name VARCHAR(20) NOT NULL COMMENT '店铺名',
#   avatar VARCHAR(50) COMMENT '店铺头像',
#   description VARCHAR(100) NOT NULL COMMENT '店铺描述',
#   owner_id INT NOT NULL COMMENT '店主ID',
#   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
#   PRIMARY KEY (shop_id)
# )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='店铺表';
#
# INSERT into shop(shop_id, name, description, owner_id)
# VALUES
#   (1, 'CASIO手表店', '专卖 (PRO-TREAK 7000-T)', 1),
#   (2, '狗粮店', '单身狗粮大减价了', 2),
#   (3, '猫砂店', '我们不生产猫砂， 我们只是猫砂的搬运工', 3),
#   (4, 'ZNZ', '指南针买一送一啦', 4);

-- 商品分类
CREATE TABLE category(
  category_id INT NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  name VARCHAR(10) NOT NULL COMMENT '分类名称',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (category_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表';

INSERT into category(name)
VALUES
  ('手表'),
  ('宠物口粮'),
  ('户外'),
  ('计算机');

-- 创建商品表
CREATE TABLE good(
  good_id INT NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  name VARCHAR(20) NOT NULL COMMENT '商品名',
  price FLOAT NOT NULL COMMENT '商品价格',
  status INT NOT NULL DEFAULT 1 COMMENT '商品状态',
  description VARCHAR(100) COMMENT '商品描述',
#   shop_id INT NOT NULL COMMENT '店铺ID',
  sales INT NOT NULL DEFAULT 0 COMMENT '销量',
  remainder INT NOT NULL COMMENT '余量',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  category_id INT NOT NULL COMMENT '商品类别ID',
  PRIMARY KEY (good_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='商品表';

# INSERT into good(name, price, remainder)
# VALUES
#   ('PRO-TREAK 7000-T', 998.8, 100),
#   ('单身狗粮', 11.11, 1111),
#   ('金猫砂', 50, 500),
#   ('指南针', 10, 100);

-- 商品图片表
CREATE TABLE picture(
  picture_id INT NOT NULL AUTO_INCREMENT COMMENT '商品图片表',
  good_id INT NOT NULL COMMENT '商品ID',
  picture VARCHAR(50) NOT NULL COMMENT '图片路径',
  category VARCHAR(20) NOT NULL COMMENT '图片用途',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (picture_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- 商品评价表
CREATE TABLE remark(
  remark_id INT NOT NULL AUTO_INCREMENT COMMENT '评价ID',
  content VARCHAR(100) NOT NULL COMMENT '评论内容',
  score INT NOT NULL COMMENT '商品评分',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (remark_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- 商品定制表
CREATE TABLE custom(
  custom_id INT NOT NULL AUTO_INCREMENT COMMENT '商品选项ID',
  good_id INT NOT NULL COMMENT '商品ID',
  name VARCHAR(20) NOT NULL COMMENT '规格详细名称',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (custom_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品定制表';

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

-- 创建订单表
CREATE TABLE order_form(
  order_id INT NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  user_id INT NOT NULL COMMENT '用户ID',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  status INT NOT NULL DEFAULT 1 COMMENT '订单状态',
  total_price FLOAT NOT NULL COMMENT '订单总价',
  address VARCHAR(100) NOT NULL COMMENT '收货地址',
  receiver VARCHAR(20) NOT NULL COMMENT '收货人姓名',
  phone VARCHAR(20) NOT NULL COMMENT '收货人电话',
  PRIMARY KEY (order_id)
)ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- 订单子项表
CREATE TABLE order_item(
  item_id INT NOT NULL AUTO_INCREMENT COMMENT '子项ID',
  order_id INT NOT NULL COMMENT '订单ID',
  good_id INT NOT NULL COMMENT '商品ID',
  price FLOAT NOT NULL COMMENT '商品单价',
  numeber INT NOT NULL COMMENT '商品数量',
  option_id INT NOT NULL COMMENT '商品选项ID',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (item_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单子项表';

-- 商品海报表
CREATE TABLE poster(
  poster_id INT NOT NULL AUTO_INCREMENT COMMENT '海报ID',
  good_id INT NOT NULL COMMENT '商品ID',
  picture VARCHAR(50) NOT NULL COMMENT '海报照片',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (poster_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品海报表';

-- 商品收藏表
CREATE TABLE collection(
  collection_id INT NOT NULL AUTO_INCREMENT COMMENT '收藏ID',
  good_id INT NOT NULL COMMENT '商品ID',
  user_id INT NOT NULL COMMENT '用户ID',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (collection_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品收藏表';
