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
        allDataSources = dataSourceRepository.getAll(new DataSourceEntity());
    }

    public Pager<DataSourceEntity> page(Integer page, Integer size, DataSourceEntity condition) {
        if (condition == null) {
            return new Pager<>(allDataSources).separatePager(page, size);
        }
        return new Pager<>(dataSourceRepository.getAll(condition)).separatePager(page, size);
    }

    public DataSourceEntity getById(String id) {
        DataSourceEntity dataSourceEntity = new DataSourceEntity();
        dataSourceEntity.setId(id);
        return dataSourceRepository.get(dataSourceEntity);
    }

    public boolean insert(DataSourceEntity dataSourceEntity) {
        return dataSourceRepository.insert(dataSourceEntity);
    }

    public boolean update(DataSourceEntity dataSourceEntity) {
        return dataSourceRepository.update(dataSourceEntity);
    }

    public boolean delete(String id) {
        return dataSourceRepository.deleteById(id);
    }

}
