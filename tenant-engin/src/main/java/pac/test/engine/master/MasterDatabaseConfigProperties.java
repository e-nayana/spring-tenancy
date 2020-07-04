package pac.test.engine.master;

/**
 * @author Houston(Nayana)
 */

public class MasterDatabaseConfigProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private long connectionTimeout;
    private int maxPoolSize;
    private long idleTimeout;
    private int minIdle;
    private String poolName;

    public String getUrl() {
        return url;
    }

    public MasterDatabaseConfigProperties setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public MasterDatabaseConfigProperties setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MasterDatabaseConfigProperties setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public MasterDatabaseConfigProperties setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }

    public long getConnectionTimeout() {
        return connectionTimeout;
    }

    public MasterDatabaseConfigProperties setConnectionTimeout(long connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public MasterDatabaseConfigProperties setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        return this;
    }

    public long getIdleTimeout() {
        return idleTimeout;
    }

    public MasterDatabaseConfigProperties setIdleTimeout(long idleTimeout) {
        this.idleTimeout = idleTimeout;
        return this;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public MasterDatabaseConfigProperties setMinIdle(int minIdle) {
        this.minIdle = minIdle;
        return this;
    }

    public String getPoolName() {
        return poolName;
    }

    public MasterDatabaseConfigProperties setPoolName(String poolName) {
        this.poolName = poolName;
        return this;
    }

    @Override
    public String toString() {
        return "MasterDatabaseConfigProperties{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", connectionTimeout=" + connectionTimeout +
                ", maxPoolSize=" + maxPoolSize +
                ", idleTimeout=" + idleTimeout +
                ", minIdle=" + minIdle +
                ", poolName='" + poolName + '\'' +
                '}';
    }
}