package pac.test.engine.master;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import pac.test.engine.EnableTenantMasterJpaRepositories;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Houston(Nayana)
 */
@EnableTenantMasterJpaRepositories
public abstract class MasterDatabaseConfig {

    private static final Logger LOG = LoggerFactory.getLogger(MasterDatabaseConfig.class);

    public abstract MasterDatabaseConfigProperties getMasterDatabaseConfigProperties();

    @Bean(name = "masterDataSource")
    public DataSource masterDataSource() {

        LOG.info("Testing " + getMasterDatabaseConfigProperties().getUrl());
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setUsername(getMasterDatabaseConfigProperties().getUsername());
        hikariDataSource.setPassword(getMasterDatabaseConfigProperties().getPassword());
        hikariDataSource.setJdbcUrl(getMasterDatabaseConfigProperties().getUrl());
        hikariDataSource.setDriverClassName(getMasterDatabaseConfigProperties().getDriverClassName());
        hikariDataSource.setPoolName(getMasterDatabaseConfigProperties().getPoolName());
        hikariDataSource.setMaximumPoolSize(getMasterDatabaseConfigProperties().getMaxPoolSize());
        hikariDataSource.setMinimumIdle(getMasterDatabaseConfigProperties().getMinIdle());
        hikariDataSource.setConnectionTimeout(getMasterDatabaseConfigProperties().getConnectionTimeout());
        hikariDataSource.setIdleTimeout(getMasterDatabaseConfigProperties().getIdleTimeout());
        LOG.info("Setup of masterDataSource succeeded.");
        return hikariDataSource;
    }

    @Primary
    @Bean(name = "masterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory() {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        //scan entities belongs to this persistence unit//
        em.setPackagesToScan("pac.test.engine.master.entity");
        em.setDataSource(masterDataSource());
        em.setPersistenceUnitName("masterdb-persistence-unit");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        LOG.info("Setup of masterEntityManagerFactory succeeded.");
        return em;
    }

    @Bean(name = "masterTransactionManager")
    public JpaTransactionManager masterTransactionManager(@Qualifier("masterEntityManagerFactory") EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    public abstract Properties hibernateProperties();
}
