package com.qianxin.cassandra.util;

import com.datastax.driver.core.utils.UUIDs;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UUIDUtil {

    public static UUID getTimeUUID(Date date){
        return getTimeUUID(date.getTime());
    }

    public static UUID getTimeUUID(long time){
        return new UUID(UUIDs.startOf(time).getMostSignificantBits(), new Random().nextLong());
    }
}
