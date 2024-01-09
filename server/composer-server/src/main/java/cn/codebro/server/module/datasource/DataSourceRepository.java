package cn.codebro.server.module.datasource;

import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataSourceRepository {

    private final SqlToyLazyDao sqlToyLazyDao;

    public DataSourceRepository(SqlToyLazyDao sqlToyLazyDao) {
        this.sqlToyLazyDao = sqlToyLazyDao;
    }

    public List<DataSourceEntity> getAll(DataSourceEntity dataSourceEntity) {
        return sqlToyLazyDao.findBySql("ds_getAll", dataSourceEntity);
    }

    public DataSourceEntity get(DataSourceEntity dataSourceEntity) {
        return sqlToyLazyDao.load(dataSourceEntity);
    }

    public boolean insert(DataSourceEntity dataSourceEntity) {
        return sqlToyLazyDao.save(dataSourceEntity) != null;
    }

    public boolean update(DataSourceEntity dataSourceEntity) {
        return sqlToyLazyDao.update(dataSourceEntity) != null;
    }

    public boolean deleteById(String id) {
        DataSourceEntity dataSourceEntity = new DataSourceEntity();
        dataSourceEntity.setId(id);
        return sqlToyLazyDao.delete(dataSourceEntity) > 0;
    }
}
