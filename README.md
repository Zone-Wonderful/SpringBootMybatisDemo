# SpringBootMybatisDemo

#### 介绍
> springboot整合mybatis-plus
>
> 该项目是springboot初始化以后直接整合的
>
> springboot版本：2.4.2
>
> mybatis-plus版本：3.4.1
>
> 开发工具：IDEA



#### 1.引入maven依赖

```xml
<!--mybatis-plus 配置-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.4.1</version>
</dependency>
<!--mybatis-plus 代码生成依赖-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.4.1</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>

<!--lombok测试需要的依赖-->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
    <!-- 参考 https://www.jianshu.com/p/e9cd54163556 -->
    <!-- IDEA 在编译项目时，无论怎么配置，都不会将xml文件编译到target中，此处是让idea编译时将xml编译进去（也有可能是我的姿势不对） -->
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
        </resource>
    </resources>
</build>
```

#### 2.配置yml文件

```yml
spring:
  # 数据库配置
  datasource:
    url: jdbc:mysql://localhost:3306/test2?characterEncoding=UTF-8&useUnicode=true&useSSL=false&serverTimezone=UTC
    username: root
    password: admin_123
    driver-class-name: com.mysql.cj.jdbc.Driver

#mybatis plus 设置
mybatis-plus:
  mapper-locations: classpath:com/zone/modular/**/mapper/xml/*.xml
  global-config:
    # 关闭MP3.0自带的banner
    banner: false
  configuration:
    # 这个配置会将执行的sql打印出来，在开发或测试的时候可以用
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

#### 3.添加mybatis-plus配置类

```java
@Configuration
@MapperScan("com.zone.modular.**.mapper*") // 说明mapper类和xml在哪个文件夹下
public class MybatisPlusConfig {
    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }
}
```

弄完以上三步，配置就OK了

测试就自己弄吧。