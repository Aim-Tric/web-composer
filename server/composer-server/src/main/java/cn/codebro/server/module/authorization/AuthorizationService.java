package cn.codebro.server.module.authorization;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限模块服务
 * 本模块包含：
 * 1.权限信息管理：权限信息的添加、删除、修改、查询功能
 * 2.访问日志：对各个应用模块的访问日志记录
 * 3.访问异常告警：对非正常访问操作进行记录，并发出预警
 */
@Service
public class AuthorizationService {

    private final AuthorizationRepository authorizationRepository;

    public AuthorizationService(AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }



    /* *************************************************
     **
     ** 下面是权限信息管理中的添加、修改、删除和查询功能
     **
     * *************************************************/

    /**
     * 新增权限信息
     * 该方法提供简单的数据插入功能
     *
     * @param authorization 待新增的权限实体类
     * @return 新增数据结果
     */
    public boolean insert(AuthorizationEntity authorization) {
        return authorizationRepository.insert(authorization);
    }

    /**
     * 更新权限信息
     * 该方法提供简单的数据更新功能
     *
     * @param authorization 待更新的权限实体类
     * @return 更新数据结果
     */
    public boolean update(AuthorizationEntity authorization) {
        return authorizationRepository.update(authorization);
    }

    /**
     * 删除权限信息
     * 该方法提供简单的数据删除功能
     *
     * @param id 待删除的权限数据ID
     * @return 删除数据结果
     */
    public boolean deleteById(String id) {
        return authorizationRepository.deleteById(id);
    }

    /**
     * 根据条件获取全部权限信息
     * 该方法提供根据条件查询数据列表
     *
     * @param condition 待查询的条件实体
     * @return 符合查询条件的结果列表
     */
    public List<AuthorizationEntity> getAll(AuthorizationEntity condition) {
        return authorizationRepository.getAll(condition);
    }

    /**
     * 根据条件获取单个权限信息
     * 该方法提供根据条件查询单挑数据
     *
     * @param condition 待查询的条件实体
     * @return 符合查询条件的单个结果
     */
    public AuthorizationEntity get(AuthorizationEntity condition) {
        return authorizationRepository.get(condition);
    }

}
