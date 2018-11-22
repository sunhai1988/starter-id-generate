package com.ybejia.id.factory;

import com.ybejia.id.provider.IpConfigurableMachineIdProvider;
import com.ybejia.id.provider.PropertyMachineIdProvider;
import com.ybejia.id.service.IdService;
import com.ybejia.id.service.impl.IdServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;


public class IdServiceFactoryBean implements FactoryBean<IdService> {
    protected final Logger log = LoggerFactory
            .getLogger(IdServiceFactoryBean.class);

    public enum Type {
        PROPERTY, IP_CONFIGURABLE, DB
    }
    private Type providerType;

    private long machineId;

    private String ips;

    private String dbUrl;
    private String dbName;
    private String dbUser;
    private String dbPassword;

    private long genMethod = -1;
    private long type = -1;
    private long version = -1;

    private IdService idService;

    public void init() {
        if (providerType == null) {
            log.error("The type of Id service is mandatory.");
            throw new IllegalArgumentException(
                    "The type of Id service is mandatory.");
        }

        switch (providerType) {
            case PROPERTY:
                idService = constructPropertyIdService(machineId);
                break;
            case IP_CONFIGURABLE:
                idService = constructIpConfigurableIdService(ips);
                break;
            case DB:
                idService = constructDbIdService(dbUrl, dbName, dbUser, dbPassword);
                break;
        }
    }

    public IdService getObject() throws Exception {
        return idService;
    }

    private IdService constructPropertyIdService(long machineId) {
        log.info("Construct Property IdService machineId {}", machineId);

        PropertyMachineIdProvider propertyMachineIdProvider = new PropertyMachineIdProvider();
        propertyMachineIdProvider.setMachineId(machineId);

        IdServiceImpl idServiceImpl;
        if (type != -1)
            idServiceImpl = new IdServiceImpl(type);
        else
            idServiceImpl = new IdServiceImpl();

        idServiceImpl.setMachineIdProvider(propertyMachineIdProvider);
        if (genMethod != -1)
            idServiceImpl.setGenMethod(genMethod);
        if (version != -1)
            idServiceImpl.setVersion(version);
        idServiceImpl.init();

        return idServiceImpl;
    }

    private IdService constructIpConfigurableIdService(String ips) {
        log.info("Construct Ip Configurable IdService ips {}", ips);

        IpConfigurableMachineIdProvider ipConfigurableMachineIdProvider = new IpConfigurableMachineIdProvider(
                ips);

        IdServiceImpl idServiceImpl;
        if (type != -1)
            idServiceImpl = new IdServiceImpl(type);
        else
            idServiceImpl = new IdServiceImpl();

        idServiceImpl.setMachineIdProvider(ipConfigurableMachineIdProvider);
        if (genMethod != -1)
            idServiceImpl.setGenMethod(genMethod);
        if (version != -1)
            idServiceImpl.setVersion(version);
        idServiceImpl.init();

        return idServiceImpl;
    }

    private IdService constructDbIdService(String dbUrl, String dbName,
                                           String dbUser, String dbPassword) {
        // TODO: 2018/11/22

        return null;
    }

    public Class<?> getObjectType() {
        return IdService.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public Type getProviderType() {
        return providerType;
    }

    public void setProviderType(Type providerType) {
        this.providerType = providerType;
    }

    public long getMachineId() {
        return machineId;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public long getGenMethod() {
        return genMethod;
    }

    public void setGenMethod(long genMethod) {
        this.genMethod = genMethod;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}