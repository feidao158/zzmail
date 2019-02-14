package com.zw.config;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.io.Resources;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;


import javax.sql.DataSource;

/**
 * 数据源 存储微信 AccessToken
 */
@Configuration
@PropertySource("classpath:db.properties")
@MapperScan("com.zw.mapper")
public class DataConfig {
    @Autowired
    Environment environment;

    /**
     * 数据源
     * @return
     */
    @Bean
    public DataSource dataSource()
    {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(environment.getProperty("db.driver"));
        druidDataSource.setUrl(environment.getProperty("db.url"));
        druidDataSource.setUsername(environment.getProperty("db.username"));
        druidDataSource.setPassword(environment.getProperty("db.password"));
        return druidDataSource;
    }

    /**
     * Mybatis的SqlSessionFactory
     * @param dataSource
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource)
    {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.zw.mapper");
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return sqlSessionFactoryBean;
    }

}
