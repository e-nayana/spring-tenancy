package com.spring.houston.tenant.engine.master;

import org.springframework.core.annotation.AliasFor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * Annotation to enable transactions on components(@Controller, @RestController, @Service) via master transaction manager
 * @author Houston(Nayana)
 **/

@Transactional
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MasterTransactional {

    /**
     * masking transactionManager to value
     * Transaction manager default set as "tenantTransactionManager"
     * @return
     */
    @AliasFor("transactionManager")
    String value() default "masterTransactionManager";

    /**
     * masking value to transactionManager
     * Transaction manager default set as "tenantTransactionManager"
     * @return
     */
    @AliasFor("value")
    String transactionManager() default "masterTransactionManager";

    Propagation propagation() default Propagation.REQUIRED;

    Isolation isolation() default Isolation.DEFAULT;

    int timeout() default -1;

    boolean readOnly() default false;

    Class<? extends Throwable>[] rollbackFor() default {};

    String[] rollbackForClassName() default {};

    Class<? extends Throwable>[] noRollbackFor() default {};

    String[] noRollbackForClassName() default {};
}
