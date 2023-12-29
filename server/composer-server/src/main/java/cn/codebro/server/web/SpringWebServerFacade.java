package cn.codebro.server.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurablePropertyResolver;
import org.springframework.stereotype.Component;

@Component
public class SpringWebServerFacade {

    private static final Logger logger = LoggerFactory.getLogger(SpringWebServerFacade.class);

    public void printWebServerInfo(ConfigurablePropertyResolver resolver) {
        String httpPort = resolver.getProperty(SpringConfigKeys.HTTP_PORT);
        logger.info("当前服务器HTTP指定端口为：{}", httpPort);
        
    }
}
