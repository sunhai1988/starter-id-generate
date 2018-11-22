package com.ybejia.id.populater;

import com.ybejia.id.bean.Id;
import com.ybejia.id.bean.IdMeta;
import com.ybejia.id.timer.Timer;

public interface IdPopulator {

    void populateId(Timer timer, Id id, IdMeta idMeta);

}
