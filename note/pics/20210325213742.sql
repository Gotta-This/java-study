\c zjres channel;
set grammar = oracle;

--DDL脚本

ALTER TABLE CHANNEL.NET_CODE_INFO ADD (STORE_MANAGE_RANGE VARCHAR2(64));
ALTER TABLE CHANNEL.NET_CODE_INFO ADD (STORE_MANAGE_RANGEOTHER VARCHAR(512));
ALTER TABLE CHANNEL.NET_CODE_INFO ADD (STORE_BUSI_RANGE VARCHAR(512));
ALTER TABLE CHANNEL.NET_CODE_INFO ADD (CHNL_SPECIALIZE_YEARS VARCHAR2(2));
COMMENT ON COLUMN CHANNEL.NET_CODE_INFO.STORE_MANAGE_RANGE is '营业厅经营范围-郭鹏飞-13059839565-20210311-修改';
COMMENT ON COLUMN CHANNEL.NET_CODE_INFO.STORE_MANAGE_RANGEOTHER is '营业厅经营范围（其他补充）-郭鹏飞-13059839565-20210311-修改';
COMMENT ON COLUMN CHANNEL.NET_CODE_INFO.STORE_BUSI_RANGE is '营业厅业务范围-郭鹏飞-13059839565-20210311-修改';
COMMENT ON COLUMN CHANNEL.NET_CODE_INFO.CHNL_SPECIALIZE_YEARS is '渠道专营年限-郭鹏飞-13059839565-20210311-修改';

ALTER TABLE CHANNEL.CHANNEL_PUB_EXT_INFO ADD (STORE_MANAGE_RANGE VARCHAR2(64));
ALTER TABLE CHANNEL.CHANNEL_PUB_EXT_INFO ADD (STORE_MANAGE_RANGEOTHER VARCHAR(512));
ALTER TABLE CHANNEL.CHANNEL_PUB_EXT_INFO ADD (STORE_BUSI_RANGE VARCHAR(512));
COMMENT ON COLUMN CHANNEL.CHANNEL_PUB_EXT_INFO.STORE_MANAGE_RANGE is '营业厅经营范围-郭鹏飞-13059839565-20210311-修改';
COMMENT ON COLUMN CHANNEL.CHANNEL_PUB_EXT_INFO.STORE_MANAGE_RANGEOTHER is '营业厅经营范围（其他补充）-郭鹏飞-13059839565-20210311-修改';
COMMENT ON COLUMN CHANNEL.CHANNEL_PUB_EXT_INFO.STORE_BUSI_RANGE is '营业厅业务范围-郭鹏飞-13059839565-20210311-修改';

create table MONTH_INDICATOR_REPORT
(
  upload_mon         NUMBER(6) not null,
  net_code           VARCHAR2(38),
  create_date        DATE,
  done_date          DATE,
  file_name          VARCHAR2(200),
  row_report         NUMBER(12),
  remark             VARCHAR2(4000),
  state              NUMBER(2),
  ext_1              VARCHAR2(2000),
  ext_2              VARCHAR2(2000),
  ext_3              VARCHAR2(2000)
);
comment on table MONTH_INDICATOR_REPORT
  is '渠道统一编码月度指标文件上报表--郭鹏飞--13059839565--20210315';
-- Add comments to the columns 
alter table MONTH_INDICATOR_REPORT
  add constraint PK_MONTH_INDICATOR_REPORT primary key (upload_mon, net_code);
comment on column MONTH_INDICATOR_REPORT.upload_mon
  is '上传月份时间----202001';
comment on column MONTH_INDICATOR_REPORT.net_code
  is '全网统一编码';
comment on column MONTH_INDICATOR_REPORT.create_date
  is '创建时间';
comment on column MONTH_INDICATOR_REPORT.done_date
  is '变更时间';
comment on column MONTH_INDICATOR_REPORT.file_name
  is '文件名';
comment on column MONTH_INDICATOR_REPORT.row_report
  is '行号';
comment on column MONTH_INDICATOR_REPORT.remark
  is '失败原因';
comment on column MONTH_INDICATOR_REPORT.state
  is '状态 1正常上传，2成功 3上传时校验失败';
comment on column MONTH_INDICATOR_REPORT.ext_1
  is '拓展字段1';
comment on column MONTH_INDICATOR_REPORT.ext_2
  is '拓展字段2';
comment on column MONTH_INDICATOR_REPORT.ext_3
  is '拓展字段3';