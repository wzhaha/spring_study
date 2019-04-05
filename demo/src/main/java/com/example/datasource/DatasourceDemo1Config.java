package com.example.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.demo1", sqlSessionFactoryRef = "demo1SqlSessionFactory")
public class DatasourceDemo1Config {

    @Bean(name = "demo1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.demo1")
    public DataSource demo1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "demo1SqlSessionFactory")
    public SqlSessionFactory demo1SqlSessionFactory(@Qualifier("demo1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //读取mybatis小配置文件
        // bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "demo1TransactionManager")
    public DataSourceTransactionManager demo1TransactionManager(@Qualifier("demo1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "demo1SqlSessionTemplate")
    public SqlSessionTemplate demo1SqlSessionTemplate(@Qualifier("demo1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
