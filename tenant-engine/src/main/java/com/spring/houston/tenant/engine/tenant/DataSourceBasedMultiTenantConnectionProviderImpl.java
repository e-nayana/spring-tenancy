package com.spring.houston.tenant.engine.tenant;

import com.spring.houston.tenant.engine.TenantDBContext;
import com.spring.houston.tenant.engine.master.entity.MasterTenant;
import com.spring.houston.tenant.engine.master.repository.MasterTenantRepository;
import com.spring.houston.tenant.engine.DataSourceUtil;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Houston(Nayana)
 */
@Configuration
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceBasedMultiTenantConnectionProviderImpl.class);

    private static final long serialVersionUID = 1L;

    private Map<String, DataSource> dataSourcesMtApp = new TreeMap<>();

    @Autowired
    private MasterTenantRepository masterTenantRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    protected DataSource selectAnyDataSource() {

        if (dataSourcesMtApp.isEmpty()) {
            List<MasterTenant> masterTenants = masterTenantRepository.findAll();
            LOGGER.info("selectAnyDataSource() method call...Total tenants:" + masterTenants.size());

            if(masterTenants.size() == 0){
                LOGGER.info("Couldn't find any tenant");
            }
            else {
                for (MasterTenant masterTenant : masterTenants) {
                    dataSourcesMtApp.put(masterTenant.getDbName(), DataSourceUtil.createAndConfigureDataSource(masterTenant));
                }
            }
        }
        return this.dataSourcesMtApp.values().iterator().next();
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        tenantIdentifier = initializeTenantIfLost(tenantIdentifier);
        if (!this.dataSourcesMtApp.containsKey(tenantIdentifier)) {
            List<MasterTenant> masterTenants = masterTenantRepository.findAll();
            LOGGER.info("selectDataSource() method call...Tenant:" + tenantIdentifier + " Total tenants:" + masterTenants.size());
            for (MasterTenant masterTenant : masterTenants) {
                dataSourcesMtApp.put(masterTenant.getDbName(), DataSourceUtil.createAndConfigureDataSource(masterTenant));
            }
        }

        if (!this.dataSourcesMtApp.containsKey(tenantIdentifier)) {
            LOGGER.warn("Trying to get tenant:" + tenantIdentifier + " which was not found in master db after rescan");
//            throw new åUsernameNotFoundException(String.format("Tenant not found after rescan, " + " tenant=%s", tenantIdentifier));
        }
        return this.dataSourcesMtApp.get(tenantIdentifier);
    }

    private String initializeTenantIfLost(String tenantIdentifier) {
        if (tenantIdentifier != TenantDBContext.getCurrentDb()) {
            tenantIdentifier = TenantDBContext.getCurrentDb();
        }
        return tenantIdentifier;
    }
}
