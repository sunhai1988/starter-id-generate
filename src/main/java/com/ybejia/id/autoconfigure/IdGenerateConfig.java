package com.ybejia.id.autoconfigure;

import com.ybejia.id.factory.IdServiceFactoryBean;
import com.ybejia.id.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(IdGenerateConfigProperties.class)
public class IdGenerateConfig {
    @Autowired
    private  IdGenerateConfigProperties idGenerateConfigProperties;
    @Bean
    @ConditionalOnMissingBean(IdService.class)
    public  IdService idService() throws  Exception{
        IdServiceFactoryBean idServiceFactoryBean = new IdServiceFactoryBean();
        idServiceFactoryBean.setProviderType(IdServiceFactoryBean.Type.PROPERTY);
        idServiceFactoryBean.setMachineId(idGenerateConfigProperties.getMachine());
        idServiceFactoryBean.setVersion(idGenerateConfigProperties.getVersion());
        idServiceFactoryBean.setGenMethod(idGenerateConfigProperties.getGenMethod());
        idServiceFactoryBean.init();
        return idServiceFactoryBean.getObject();
    }

}
