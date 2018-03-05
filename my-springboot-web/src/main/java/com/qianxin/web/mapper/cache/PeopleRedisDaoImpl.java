package com.qianxin.web.mapper.cache;

import com.qianxin.web.entity.dto.People;
import com.qianxin.web.config.redis.tools.RedisSupperDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class PeopleRedisDaoImpl extends RedisSupperDaoImpl<People> implements IPeopleRedisDao {

}
