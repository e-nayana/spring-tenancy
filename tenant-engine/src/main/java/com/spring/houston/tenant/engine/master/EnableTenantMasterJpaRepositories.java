package com.spring.houston.tenant.engine.master;

import com.spring.houston.tenant.engine.tenant.EnableTenantJpaRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.*;

/**
 * Annotation to enable tenant master only JPA repository scanning on specified packages by "basePakcage" or base package of annotated configuration
 * class (name space of annotated class by this {@link EnableTenantJpaRepositories})
 *
 * @author Houston(Nayana)
 *
 */

@EnableJpaRepositories
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EnableTenantMasterJpaRepositories {


    /**
     * will be a Alias (override) for "value" of {@link EnableJpaRepositories}
     * @return
     */
    String[] value() default {};

    /**
     * will be a Alias (override) for "basePackages" of {@link EnableJpaRepositories}
     * @return
     */
    String[] basePackages() default "com.spring.houston.tenant.engine.master.repository";

    /**
     * will be a Alias (override) for "entityManagerFactoryRef" of {@link EnableJpaRepositories}
     * @return
     */
    String entityManagerFactoryRef() default "masterEntityManagerFactory";

    /**
     * will be a Alias (override) for "transactionManagerRef" of {@link EnableJpaRepositories}
     * @return
     */
    String transactionManagerRef() default "masterTransactionManager";

}
