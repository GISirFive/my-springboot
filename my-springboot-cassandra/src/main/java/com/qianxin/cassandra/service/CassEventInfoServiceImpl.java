package com.qianxin.cassandra.service;

import com.datastax.driver.core.utils.Bytes;
import com.qianxin.cassandra.entity.CassEventInfo;
import com.qianxin.cassandra.intface.CassEventInfoService;
import com.qianxin.cassandra.repository.CassEventInfoRepository;
import com.qianxin.cassandra.util.DataFormatUtil;
import com.qianxin.cassandra.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.UUID;

@Service
public class CassEventInfoServiceImpl implements CassEventInfoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CassEventInfoRepository cassEventInfoRepository;

    @Override
    public CassEventInfo createEventInfo(CassEventInfo cassEventInfo) {

        String ss = "123";
        byte[] bytes = ss.getBytes();

        byte[] eventBytes = bytes;

        //数据转换转换
        ByteBuffer eventDetail = Bytes.fromHexString("0x" + DataFormatUtil.bytes2Hex(eventBytes));
        logger.debug("EventInfo -> eventDetail >>>" + eventDetail.toString());


        long timeMillis = System.currentTimeMillis();
        //获取时间类型的时间戳
        UUID eventTime = UUIDUtil.getTimeUUID(timeMillis);
        logger.debug("EventInfo -> eventTime >>>" + eventDetail.toString());

        CassEventInfo eventInfo = new CassEventInfo();
        eventInfo.setDeviceId("284642040106");
        eventInfo.setDeviceType(111);
        eventInfo.setEventType(111);
        eventInfo.setEventTime(eventTime);
        eventInfo.setEventDetail(eventDetail);

        logger.debug("保存信息到Cassandra数据库, EventInfo>>>" + eventInfo.toString());
        return cassEventInfoRepository.save(eventInfo);
    }
}
