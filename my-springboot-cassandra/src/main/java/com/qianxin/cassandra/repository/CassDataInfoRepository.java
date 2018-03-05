package com.qianxin.cassandra.repository;

import com.qianxin.cassandra.entity.CassDataInfo;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * DataInfo存储接口
 */
public interface CassDataInfoRepository extends CassandraRepository<CassDataInfo> {

}
