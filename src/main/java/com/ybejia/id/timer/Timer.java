package com.ybejia.id.timer;

import com.ybejia.id.bean.IdMeta;
import com.ybejia.id.bean.IdType;

import java.util.Date;

public interface Timer {
    long EPOCH = 1514736000000L;

    void init(IdMeta idMeta, IdType idType);

    Date transTime(long time);

    void validateTimestamp(long lastTimestamp, long timestamp);

    long tillNextTimeUnit(long lastTimestamp);

    long genTime();

}
