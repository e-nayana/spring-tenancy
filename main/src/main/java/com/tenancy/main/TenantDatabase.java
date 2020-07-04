package com.tenancy.main;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.spring.houston.tenant.engine.EnableTenantJpaRepositories;
import com.spring.houston.tenant.engine.tenant.TenantDatabaseConfig;

import java.util.Properties;

/**
 * @author Houston(Nayana)
 **/

@Configuration
@EnableTransactionManagement
@EnableTenantJpaRepositories
public class TenantDatabase extends TenantDatabaseConfig {


    @Override
    public Properties hibernateProperties(){

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.FORMAT_SQL, true);
        properties.put(Environment.HBM2DDL_AUTO, "update");
        return properties;
    }

    @Override
    public String tenantEntityPackagesToScan(){
        return "com.tenancy.main";
    }

}
