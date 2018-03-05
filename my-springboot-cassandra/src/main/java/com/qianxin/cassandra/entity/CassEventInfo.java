package com.qianxin.cassandra.entity;


import lombok.Data;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.UUID;

import static org.springframework.cassandra.core.PrimaryKeyType.PARTITIONED;

@Table("t_event_info")
@Data
public class CassEventInfo implements Serializable{

    private static final long serialVersionUID = 8529943456200644824L;

    @PrimaryKeyColumn(name = "device_type", ordinal = 0, type = PARTITIONED)
    private int deviceType;

    @PrimaryKeyColumn(name = "device_id", ordinal = 1, type = PARTITIONED)
    private String deviceId;

    @PrimaryKeyColumn(name = "event_time", ordinal = 2, type = PARTITIONED)
    private UUID eventTime;

    @Column("event_detail")
    private ByteBuffer eventDetail;

    @Column("event_type")
    private int eventType;

    @Column("sub_device")
    private String subDevice;

}
