package pac.test.engine;

import com.zaxxer.hikari.HikariDataSource;
import pac.test.engine.master.entity.MasterTenant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

/**
 * @author Houston(Nayana)
 */
public final class DataSourceUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceUtil.class);

    public static DataSource createAndConfigureDataSource(MasterTenant masterTenant) {
        HikariDataSource ds = new HikariDataSource();
        ds.setUsername(masterTenant.getUserName());
        ds.setPassword(masterTenant.getPassword());
        ds.setJdbcUrl(masterTenant.getUrl());
        ds.setDriverClassName(masterTenant.getDriverClass());
        ds.setConnectionTimeout(20000);
        ds.setMinimumIdle(3);
        ds.setMaximumPoolSize(500);
        ds.setIdleTimeout(300000);
        ds.setConnectionTimeout(20000);
        String tenantConnectionPoolName = masterTenant.getDbName() + "-connection-pool";
        ds.setPoolName(tenantConnectionPoolName);
        LOGGER.info("Hikari Data source has been configured " + masterTenant.getDbName() + ". Connection pool name:" + tenantConnectionPoolName);
        return ds;
    }
}
