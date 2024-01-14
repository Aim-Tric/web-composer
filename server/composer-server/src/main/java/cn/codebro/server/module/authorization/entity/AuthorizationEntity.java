package cn.codebro.server.module.authorization.entity;

import org.sagacity.sqltoy.config.annotation.Entity;

import java.io.Serializable;

@Entity(tableName = "c_authorization")
public class AuthorizationEntity implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
