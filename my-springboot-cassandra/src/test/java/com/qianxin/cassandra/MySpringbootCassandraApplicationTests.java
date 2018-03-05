package com.qianxin.cassandra;

import com.datastax.driver.core.utils.Bytes;
import com.qianxin.cassandra.entity.CassDataInfo;
import com.qianxin.cassandra.entity.CassEventInfo;
import com.qianxin.cassandra.repository.CassDataInfoRepository;
import com.qianxin.cassandra.repository.CassEventInfoRepository;
import com.qianxin.cassandra.util.DataFormatUtil;
import com.qianxin.cassandra.util.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.ByteBuffer;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringbootCassandraApplicationTests {

	@Autowired
	private CassDataInfoRepository cassDataInfoRepository;

	@Autowired
	private CassEventInfoRepository cassEventInfoRepository;


	@Test
	public void contextLoads() {
	}


	/**
	 * 查询语句_data
	 * select * from chargerlink_access.t_data_info where device_id = '284642040106' and device_type = 111;
	 *
	 * 删除语句_data
	 * delete from chargerlink_access.t_data_info where device_id = '284642040106' and device_type = 111;
	 */
	@Test
	public void test_CassDataInfoService(){
		String ss = "123";
		byte[] bytes = ss.getBytes();
		byte[] dataBytes = bytes;
		//数据转换转换
		ByteBuffer dataDetail = Bytes.fromHexString("0x" + DataFormatUtil.bytes2Hex(dataBytes));
		System.out.println("DataInfo -> dataDetail >>>" + dataDetail.toString());

		long timeMillis = System.currentTimeMillis();
		//获取时间类型的时间戳
		UUID dataTime = UUIDUtil.getTimeUUID(timeMillis);
		System.out.println("DataInfo -> dataTime >>>" + dataTime.toString());

		CassDataInfo dataInfo = new CassDataInfo();
		dataInfo.setDeviceId("284642040106");
		dataInfo.setDeviceType(111);
		dataInfo.setDataTime(dataTime);
		dataInfo.setDataType(111);
		dataInfo.setSubDevice("111");
		dataInfo.setDataDetail(dataDetail);

		System.out.println("保存信息到Cassandra数据库, DataInfo>>>" + dataInfo.toString());
		CassDataInfo save = cassDataInfoRepository.save(dataInfo);
		System.out.println("测试完成!!!");
	}


	/**
	 *	查询语句_event
	 * 	select * from chargerlink_access.t_event_info where device_id = '284642040106' and device_type = 111;
	 *
	 * 	删除语句_event
	 *	delete from chargerlink_access.t_event_info where device_id = '284642040106' and device_type = 111;
	 */
	@Test
	public void test_CassEventInfoService(){
		String ss = "123";
		byte[] bytes = ss.getBytes();
		byte[] eventBytes = bytes;
		//数据转换转换
		ByteBuffer eventDetail = Bytes.fromHexString("0x" + DataFormatUtil.bytes2Hex(eventBytes));
		System.out.println("EventInfo -> eventDetail >>>" + eventDetail.toString());
		long timeMillis = System.currentTimeMillis();
		//获取时间类型的时间戳
		UUID eventTime = UUIDUtil.getTimeUUID(timeMillis);
		System.out.println("EventInfo -> eventTime >>>" + eventDetail.toString());

		CassEventInfo eventInfo = new CassEventInfo();
		eventInfo.setDeviceId("284642040106");
		eventInfo.setDeviceType(111);
		eventInfo.setEventType(111);
		eventInfo.setEventTime(eventTime);
		eventInfo.setEventDetail(eventDetail);

		System.out.println("保存信息到Cassandra数据库, EventInfo>>>" + eventInfo.toString());
		CassEventInfo save = cassEventInfoRepository.save(eventInfo);
		System.out.println("测试完成!!!");
	}
}
