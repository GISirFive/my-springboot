package com.qianxin.cassandra.intface;

import com.qianxin.cassandra.entity.CassEventInfo;

public interface CassEventInfoService {

    /**
     * EventInfo插入cassandra接口
     *
     * @param cassEventInfo
     * @return
     */
    CassEventInfo createEventInfo(CassEventInfo cassEventInfo);
}
