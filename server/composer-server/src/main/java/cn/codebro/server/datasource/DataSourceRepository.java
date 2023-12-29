package cn.codebro.server.datasource;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class DataSourceRepository {

    public List<DataSourceEntity> getAllDataSources() {

        return Collections.emptyList();
    }

    public boolean insertDataSource(DataSourceEntity dataSourceEntity) {

        return false;
    }

    public boolean updateDataSourceById(DataSourceEntity dataSourceEntity) {

        return false;
    }

    public boolean deleteDataSourceById(String id) {

        return false;
    }
}
