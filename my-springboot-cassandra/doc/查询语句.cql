#设置windows编码
chcp 65001

#连接数据库
.\cqlsh.bat 120.27.4.244 9042 -u cassandra -p cassandra

#查询语句_data
select * from chargerlink_access.t_data_info where device_id = '284642040106' and device_type = 111;

#查询语句_event
select * from chargerlink_access.t_event_info where device_id = '284642040106' and device_type = 111;

#删除语句_data
delete from chargerlink_access.t_data_info where device_id = '284642040106' and device_type = 111;

#删除语句_event
delete from chargerlink_access.t_event_info where device_id = '284642040106' and device_type = 111;