package cn.codebro.server.module.authorization;

import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorizationRepository {

    private final SqlToyLazyDao sqlToyLazyDao;

    public AuthorizationRepository(SqlToyLazyDao sqlToyLazyDao) {
        this.sqlToyLazyDao = sqlToyLazyDao;
    }

    public List<AuthorizationEntity> getAll(AuthorizationEntity condition) {
        return sqlToyLazyDao.findBySql("auth_getAll", condition);
    }

    public AuthorizationEntity get(AuthorizationEntity condition) {
        return sqlToyLazyDao.load(condition);
    }

    public boolean update(AuthorizationEntity authorization) {
        return sqlToyLazyDao.update(authorization) > 0;
    }

    public boolean deleteById(String id) {
        AuthorizationEntity authorizationEntity = new AuthorizationEntity();
        authorizationEntity.setId(id);
        return sqlToyLazyDao.delete(authorizationEntity) > 0;
    }

    public boolean insert(AuthorizationEntity authorization) {
        return sqlToyLazyDao.save(authorization) != null;
    }

}
