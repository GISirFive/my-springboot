package com.qianxin.cassandra.service;


import com.datastax.driver.core.utils.Bytes;
import com.qianxin.cassandra.entity.CassDataInfo;
import com.qianxin.cassandra.intface.CassDataInfoService;
import com.qianxin.cassandra.repository.CassDataInfoRepository;
import com.qianxin.cassandra.util.DataFormatUtil;
import com.qianxin.cassandra.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.UUID;

@Service
public class CassDataInfoServiceImpl implements CassDataInfoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CassDataInfoRepository cassDataInfoRepository;

    @Override
    public CassDataInfo createDataInfo(CassDataInfo cassDataInfo){

        String ss = "123";
        byte[] bytes = ss.getBytes();

        byte[] dataBytes = bytes;


        //数据转换转换
        ByteBuffer dataDetail = Bytes.fromHexString("0x" + DataFormatUtil.bytes2Hex(dataBytes));
        logger.debug("DataInfo -> dataDetail >>>" + dataDetail.toString());

        long timeMillis = System.currentTimeMillis();
        //获取时间类型的时间戳
        UUID dataTime = UUIDUtil.getTimeUUID(timeMillis);
        logger.debug("DataInfo -> dataTime >>>" + dataTime.toString());

        CassDataInfo dataInfo = new CassDataInfo();
        dataInfo.setDeviceId("284642040106");
        dataInfo.setDeviceType(111);
        dataInfo.setDataTime(dataTime);
        dataInfo.setDataType(111);
        dataInfo.setSubDevice("111");
        dataInfo.setDataDetail(dataDetail);

        logger.debug("保存信息到Cassandra数据库, DataInfo>>>" + dataInfo.toString());
        return cassDataInfoRepository.save(dataInfo);
    }
}
