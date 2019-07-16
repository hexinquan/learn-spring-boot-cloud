package com.learn.config;

import com.learn.config.properties.DataSourceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
/**
 *  springBootApplicatiob 等同于 @EnableAutoConfiguration+@ComponentScan+@Configuration
 * 1.@Component 装配对象，是由对象名称小写为key进行装配
 * 2.@Bean 装配是根据方法名称进行装配
 * 3.@ComponentScan 装配当前工程指定的目录以及子目录下对应的类
 *  spring 实现单例都是根据key来实现的
 * 4.通过Environment 获取环境配置
 *
 */
@EnableConfigServer
public class ConfigApplication {

    /**
     * 创建过程在启动类之前，方便调试
     * @return
     */

//    @Bean
//    @ConfigurationProperties(prefix = "hexinquan.datasource")
//    public DataSourceProperties buildDataConfig(){
//        return new DataSourceProperties();
//    }

    public static void main(String[] args) {



        //ConfigurableApplicationContext context = SpringApplication.run(ConfigApplication.class,args);
        SpringApplication.run(ConfigApplication.class, args);

        //加载多个源
       /* SpringApplication application = new SpringApplication();
        application.addPrimarySources(Arrays.asList(ConfigApplication.class)); //集合源，端口不一样
        application.run(args);
       */
        /** AnnotationConfigApplicationContext annotationConfigApplicationContext =
         new AnnotationConfigApplicationContext("com.learn.config");
         System.out.println(annotationConfigApplicationContext.getBean("user")); // 使用@Component 默认小写类名为key
         System.out.println(annotationConfigApplicationContext.getBean("buildUser")); //使用@Bean  默认为方法的方法名称为key
         **/
       // ConfigurableApplicationContext context = SpringApplication.run(ConfigApplication.class, args);
      //  Environment environment = context.getEnvironment(); // 环境应用环境的配置
        /**  1.首先会从根目录名为config包下读取对应的application.properties->
          *  2.如果没有再读取名为application.yml->
          *  3.读取根目录非config包以外读取application.properties->
          *  4.读取根目录非config包以外读取application.yml
         *   5.如果读取的key不存在(例如local.host在application.yml下而其它文件则没有)则会合并
         *   6.要是名称不是appliction.properties 则需要通过spring.config.name (例如:spring.name.config.name=app 直接前缀app就行) 来指定
         *   7.要是名称不是appliction.properties 则需要多个文件或者引用外部文件 则spring.config.location  例如 spring.config.location = classpath:config/app.properties,classpath:config/app1.properties
         **/
      //  System.out.println(environment.getProperty("local.ip"));
      //  System.out.println(environment.getProperty("local.host"));

     //   DataSourceProperties dataSourceConfig = context.getBean(DataSourceProperties.class);
      //  System.out.println(dataSourceConfig);



    }
}
