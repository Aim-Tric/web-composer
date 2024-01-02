package cn.codebro.server.module.datasource;

import org.sagacity.sqltoy.config.annotation.Column;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;

import java.io.Serializable;

@Entity(tableName = "c_data_source")
public class DataSourceEntity implements Serializable {

    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "ipaddr")
    private String ipaddr;
    @Column(name = "port")
    private String port;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "dialect")
    private String dialect;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }
}
