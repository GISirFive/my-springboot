package com.qianxin.cassandra.intface;

import com.qianxin.cassandra.entity.CassDataInfo;

public interface CassDataInfoService {

    /**
     * DataInfo插入cassandra接口
     *
     * @param cassDataInfo
     * @return
     */
    CassDataInfo createDataInfo(CassDataInfo cassDataInfo);
}
