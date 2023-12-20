package cn.codebro.server;

import cn.codebro.server.application.server.ServerFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ComposerServer {

    private static final Logger logger = LoggerFactory.getLogger(ComposerServer.class);
    private final SpringApplication springApplication;
    private ConfigurableApplicationContext context;

    public ComposerServer() {
        this.springApplication = new SpringApplication(ComposerServer.class);
    }

    public void startComposerServer(String[] args) {
        logger.info("========= 正在启动Composer Server =========");
        this.context = springApplication.run(args);
        logger.info("========= Composer Server启动成功 =========");
    }

    public void printServerBaseInfo() {
        ServerFacade serverFacade = this.context.getBean(ServerFacade.class);
        
    }

    public static void main(String[] args) {
        ComposerServer composerServer = new ComposerServer();
        composerServer.startComposerServer(args);
        composerServer.printServerBaseInfo();
    }


}
