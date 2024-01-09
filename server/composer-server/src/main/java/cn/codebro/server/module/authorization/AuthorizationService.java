package cn.codebro.server.module.authorization;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {

    private final AuthorizationRepository authorizationRepository;

    public AuthorizationService(AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }

    

    public boolean insert(AuthorizationEntity authorization) {
        return authorizationRepository.insert(authorization);
    }

    public boolean update(AuthorizationEntity authorization) {
        return authorizationRepository.update(authorization);
    }

    public boolean deleteById(String id) {
        return authorizationRepository.deleteById(id);
    }

    public List<AuthorizationEntity> getAll(AuthorizationEntity condition) {
        return authorizationRepository.getAll(condition);
    }

    public AuthorizationEntity get(AuthorizationEntity condition) {
        return authorizationRepository.get(condition);
    }

}
