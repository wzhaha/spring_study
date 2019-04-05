# spring study
所有项目使用idea开发，springboot版本为2.1.3.RELEASE jdk为11
## springboot ##
1. web组件引用
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```
2. 静态资源访问以及整合freemarker动态页面静态化
3. lombok插件使用
    ```
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.6</version>
    </dependency>
    ```
    需要先下载Lombok插件
4. 多数据源分布式事务管理
    ```
    详见：demo文件夹 
    com.example.datasource多数据源配置文件
    com.example.demo和com.example.demo1：业务代码
    ```
5. acturtor性能监控中心
    ```
    见demo中配置以及actuator_server
    ```
6. mybatis集成以及pagehelper分页
7. AOP技术应用（全局日志以及全局异常处理）
## springcloud学习记录
1. springcloud核心--服务治理
    + 注册中心
        - eureka（推荐，国内已闭源）
        - consule（推荐）
        - zookeeper
    + 服务注册
    + 服务发现
2. 服务间调用
    + RestTemplate
    + feign客户端（推荐）
3. 服务集群与负载均衡
4. Hystrix服务保护机制
    + 服务降级
    + 服务熔断
    + 服务隔离
    
实现方式：
    1. 注解  @HystrixCommand(fallbackMethod = “*****”）
