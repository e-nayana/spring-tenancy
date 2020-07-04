package pac.test.engine.master.service;

import pac.test.engine.master.entity.MasterTenant;

/**
 * @author Houston(Nayana)
 */
public interface MasterTenantService {

    MasterTenant     findByClientId(Integer clientId);
}
