package psn.austus.maple.tree;


import cn.hutool.core.net.NetUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages={"psn.austus.maple.tree.dao"})
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(Application.class,args);
        Environment env = application.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t太棒了！！！应用 '{}' 运行成功，访问端口: {}，API文档访问地址：http://{}:{}/doc.html\n----------------------------------------------------------", env.getProperty("spring.application.name"), env.getProperty("server.port"), NetUtil.getLocalhostStr(), env.getProperty("server.port"));
    }
}
