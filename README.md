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
