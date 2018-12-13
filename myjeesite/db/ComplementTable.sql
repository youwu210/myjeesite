-- common 公共字段
-- MySQL
alter table `表名` add (
  `create_by` varchar(64)  COMMENT '创建者',
  `create_date` datetime  COMMENT '创建时间',
  `update_by` varchar(64)  COMMENT '更新者',
  `update_date` datetime  COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记'
);

--orecle
alter table 表名 add (
	create_by varchar2(64) NOT NULL,
	create_date timestamp NOT NULL,
	update_by varchar2(64) NOT NULL,
	update_date timestamp NOT NULL,
	remarks nvarchar2(255),
	del_flag char(1) DEFAULT '0' NOT NULL
);
comment on column 表名.create_by
  is '创建者';
comment on column 表名.create_date
  is '创建时间';
comment on column 表名.update_by
  is '更新者';
comment on column 表名.update_date
  is '更新时间';
comment on column 表名.remarks
  is '备注信息';
comment on column 表名.del_flag
  is '删除标记';
  

-- 上下级 公共字段 4个
-- MySQL
alter table `表名` add (
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
);

--orecle
alter table 表名 add (
	parent_id varchar2(64) NOT NULL,
	parent_ids varchar2(2000) NOT NULL,
	name nvarchar2(100) NOT NULL,
	sort number(10,0) NOT NULL,
);

