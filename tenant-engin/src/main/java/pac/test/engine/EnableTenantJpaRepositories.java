package pac.test.engine;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.*;

/**
 * Annotation to enable tenant only JPA repository scanning on specified packages by "basePakcage" or base package of annotated configuration
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
public @interface EnableTenantJpaRepositories {

    /**
     * will be a Alias (override) for "value" of {@link EnableJpaRepositories}
     * @return
     */
    String[] value() default {};

    /**
     * will be a Alias (override) for "basePackages" of {@link EnableJpaRepositories}
     * @return
     */
    String[] basePackages() default {};

    /**
     * will be a Alias (override) for "entityManagerFactoryRef" of {@link EnableJpaRepositories}
     * @return
     */
    String entityManagerFactoryRef() default "tenantEntityManagerFactory";

    /**
     * will be a Alias (override) for "transactionManagerRef" of {@link EnableJpaRepositories}
     * @return
     */
    String transactionManagerRef() default "tenantTransactionManager";
}
