package com.spring.houston.tenant.engine;

/**
 * @author Houston(Nayana)
 */
public class TenantDBContext {

    private static final ThreadLocal<String> context = new ThreadLocal<>();

    public static void setCurrentDb(String dbType) {
        context.set(dbType);
    }

    public static String getCurrentDb() {
        return context.get();
    }

    public static void clear() {
        context.remove();
    }
}
