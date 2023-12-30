package cn.codebro.server.datasource;

import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;

@Service
public class DataSourceService {

    private final DataSourceRepository dataSourceRepository;

    public DataSourceService(DataSourceRepository dataSourceRepository) {
        this.dataSourceRepository = dataSourceRepository;
    }

    public Page<DataSourceEntity> page(Integer page, Integer size, DataSourceEntity condition) {
        return null;
    }

    public DataSourceEntity getById(String id) {

        return null;
    }

    public boolean insert(DataSourceEntity dataSourceEntity) {

        return false;
    }

    public boolean update(DataSourceEntity dataSourceEntity) {

        return false;
    }

    public boolean delete(String id) {

        return false;
    }

}
