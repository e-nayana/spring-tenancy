package com.spring.houston.tenant.engine.master.service;

import com.spring.houston.tenant.engine.master.entity.MasterTenant;

/**
 * @author Houston(Nayana)
 */
public interface MasterTenantService {

    MasterTenant     findByClientId(Integer clientId);
}
