package com.qianxin.cassandra.repository;

import com.qianxin.cassandra.entity.CassEventInfo;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * EventInfo存储接口
 */
public interface CassEventInfoRepository extends CassandraRepository<CassEventInfo> {
}
