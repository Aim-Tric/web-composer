package cn.codebro.server.module.datasource;

import cn.codebro.server.core.domain.Pager;
import cn.codebro.server.module.web.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ds")
public class DataSourceController {

    private final DataSourceService dataSourceService;

    public DataSourceController(DataSourceService dataSourceService) {
        this.dataSourceService = dataSourceService;
    }

    @PostMapping("/page")
    public Pager<DataSourceEntity> page(@RequestBody PageRequest<DataSourceEntity> pageRequest) {
        return dataSourceService.page(pageRequest.getPage(), pageRequest.getSize(), pageRequest.getCondition());
    }

    @GetMapping("/{id}")
    public DataSourceEntity getById(@PathVariable String id) {
        return dataSourceService.getById(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return dataSourceService.delete(id);
    }

    @PutMapping
    public boolean update(@RequestBody DataSourceEntity dataSourceEntity) {
        return dataSourceService.update(dataSourceEntity);
    }

    @PostMapping
    public boolean insert(@RequestBody DataSourceEntity dataSourceEntity) {
        return dataSourceService.insert(dataSourceEntity);
    }
}
