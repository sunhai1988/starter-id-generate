package com.ybejia.id.converter;


import com.ybejia.id.bean.Id;
import com.ybejia.id.bean.IdMeta;

public interface IdConverter {

    long convert(Id id, IdMeta idMeta);

    Id convert(long id, IdMeta idMeta);

}
