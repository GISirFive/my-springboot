package com.qianxin.multdatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by shuai on 2017/5/28.
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = SecondDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDataSourceConfig {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.qianxin.multdatasource.mapper.second";
    static final String MAPPER_LOCATION = "classpath:mybatis/mapper/second/*.xml";

    @Value("${spring.datasource.second.url}")
    private String url;

    @Value("${spring.datasource.second.username}")
    private String user;

    @Value("${spring.datasource.second.password}")
    private String password;

    @Value("${spring.datasource.second.driverClassName}")
    private String driverClass;

    @Bean(name = "secondDataSource")
    public DataSource clusterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "secondSqlSessionFactory")
    public MybatisSqlSessionFactoryBean getSqlSessionFactory(@Qualifier("secondDataSource") DataSource secondDataSource) throws Exception{

        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();

        mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SecondDataSourceConfig.MAPPER_LOCATION));
        /*设置数据源*/
        mybatisSqlSessionFactoryBean.setDataSource(secondDataSource);
        /**/
        mybatisSqlSessionFactoryBean.setVfs(SpringBootVFS.class);

        return mybatisSqlSessionFactoryBean;
    }
}
