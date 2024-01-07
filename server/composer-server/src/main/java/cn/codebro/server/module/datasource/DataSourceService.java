package cn.codebro.server.module.datasource;

import cn.codebro.server.core.domain.Pager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataSourceService {

    private final DataSourceRepository dataSourceRepository;
    private final List<DataSourceEntity> allDataSources;

    public DataSourceService(DataSourceRepository dataSourceRepository) {
        this.dataSourceRepository = dataSourceRepository;
        allDataSources = dataSourceRepository.getAllDataSources();
    }

    public Pager<DataSourceEntity> page(Integer page, Integer size, DataSourceEntity condition) {
        if (condition == null) {
            return new Pager<>(allDataSources).separatePager(page, size);
        }
        return null;
    }

    public DataSourceEntity getById(String id) {
        return null;
    }

    public boolean insert(DataSourceEntity dataSourceEntity) {
        return dataSourceRepository.insertDataSource(dataSourceEntity);
    }

    public boolean update(DataSourceEntity dataSourceEntity) {
        return dataSourceRepository.updateDataSource(dataSourceEntity);
    }

    public boolean delete(String id) {
        return dataSourceRepository.deleteDataSourceById(id);
    }

}
