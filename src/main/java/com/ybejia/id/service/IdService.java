package com.ybejia.id.service;


import com.ybejia.id.bean.Id;

import java.util.Date;

public interface IdService {

    public long genId();

    public Id expId(long id);

    public long makeId(long time, long seq);

    public long makeId(long time, long seq, long machine);

    public long makeId(long genMethod, long time, long seq, long machine);

    public long makeId(long type, long genMethod, long time,
                       long seq, long machine);

    public long makeId(long version, long type, long genMethod,
                       long time, long seq, long machine);

    public Date transTime(long time);
}
