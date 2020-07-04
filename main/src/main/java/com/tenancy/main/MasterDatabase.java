package com.tenancy.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.spring.houston.tenant.engine.master.MasterDatabaseConfig;
import com.spring.houston.tenant.engine.master.MasterDatabaseConfigProperties;

import java.util.Properties;

/**
 * @author Houston(Nayana)
 **/
@Configuration
@EnableTransactionManagement
public class MasterDatabase extends MasterDatabaseConfig {


    @Override
    public MasterDatabaseConfigProperties getMasterDatabaseConfigProperties(){
        MasterDatabaseConfigProperties masterDatabaseConfigProperties = new MasterDatabaseConfigProperties();
        masterDatabaseConfigProperties.setUsername("root");
        masterDatabaseConfigProperties.setPassword("123456");
        masterDatabaseConfigProperties.setUrl("jdbc:mysql://localhost:8889/tenant_master?useSSL=false");
        masterDatabaseConfigProperties.setDriverClassName("com.mysql.cj.jdbc.Driver");
        masterDatabaseConfigProperties.setPoolName("masterdb-connection-pool");
        masterDatabaseConfigProperties.setMaxPoolSize(250);
        masterDatabaseConfigProperties.setMinIdle(5);
        masterDatabaseConfigProperties.setConnectionTimeout(2000);
        masterDatabaseConfigProperties.setIdleTimeout(300000);

        return masterDatabaseConfigProperties;
    }

    /**
     * Recommend to keep org.hibernate.cfg.Environment.HBM2DDL_AUTO "update" {@link org.hibernate.cfg.Environment}
     * @return
     */
    @Override
    public Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
        properties.put(org.hibernate.cfg.Environment.FORMAT_SQL, true);
        properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
        return properties;
    }




}
