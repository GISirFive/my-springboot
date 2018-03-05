package com.qianxin.cassandra.entity;


import lombok.Data;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.UUID;

import static org.springframework.cassandra.core.PrimaryKeyType.PARTITIONED;

@Table("t_data_info")
@Data
public class CassDataInfo implements Serializable{

    private static final long serialVersionUID = 3531754743416202851L;

    @PrimaryKeyColumn(name = "device_type", ordinal = 0, type = PARTITIONED)
    private int deviceType;

    @PrimaryKeyColumn(name = "device_id", ordinal = 1, type = PARTITIONED)
    private String deviceId;

    @PrimaryKeyColumn(name = "data_time", ordinal = 2, type = PARTITIONED)
    private UUID dataTime;

    @Column("data_detail")
    private ByteBuffer dataDetail;

    @Column("data_type")
    private int dataType;

    @Column("sub_device")
    private String subDevice;

}
