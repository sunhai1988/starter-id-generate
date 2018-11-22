package com.ybejia.id;


import com.ybejia.id.factory.IdServiceFactoryBean;
import com.ybejia.id.service.IdService;

public class Test {
    public  static  void main(String[] args){
        try {
            IdServiceFactoryBean  idServiceFactoryBean = new IdServiceFactoryBean();
            idServiceFactoryBean.setProviderType(IdServiceFactoryBean.Type.PROPERTY);
            idServiceFactoryBean.init();
            IdService object = idServiceFactoryBean.getObject();

        }catch (Exception e){

        }



    }

}
