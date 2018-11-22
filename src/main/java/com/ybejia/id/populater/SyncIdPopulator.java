package com.ybejia.id.populater;

import com.ybejia.id.bean.Id;
import com.ybejia.id.bean.IdMeta;
import com.ybejia.id.timer.Timer;

public class SyncIdPopulator extends BasePopulator {

    public SyncIdPopulator() {
        super();
    }

    public synchronized void populateId(Timer timer, Id id, IdMeta idMeta) {
        super.populateId(timer, id, idMeta);
    }

}
