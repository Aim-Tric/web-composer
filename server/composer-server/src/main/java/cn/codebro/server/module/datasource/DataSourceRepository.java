package cn.codebro.server.module.datasource;

import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class DataSourceRepository {

    private final SqlToyLazyDao sqlToyLazyDao;

    public DataSourceRepository(SqlToyLazyDao sqlToyLazyDao) {
        this.sqlToyLazyDao = sqlToyLazyDao;
    }

    public List<DataSourceEntity> getAllDataSources() {
        sqlToyLazyDao.findBySql("ds_getAll", new DataSourceEntity());
        return Collections.emptyList();
    }

    public boolean insertDataSource(DataSourceEntity dataSourceEntity) {
        return sqlToyLazyDao.save(dataSourceEntity) != null;
    }

    public boolean updateDataSource(DataSourceEntity dataSourceEntity) {
        return sqlToyLazyDao.update(dataSourceEntity) != null;
    }

    public boolean deleteDataSourceById(String id) {
        DataSourceEntity dataSourceEntity = new DataSourceEntity();
        dataSourceEntity.setId(id);
        return sqlToyLazyDao.delete(dataSourceEntity) > 0;
    }
}
