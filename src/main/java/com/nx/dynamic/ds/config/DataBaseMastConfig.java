package com.nx.dynamic.ds.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryMastDataBase", // 配置连接工厂
        transactionManagerRef = "transactionManagerMastDatabase", // 配置事物管理器
        basePackages = {"com.nx.dynamic.dict.dao"} // 设置dao所在位置

)
public class DataBaseMastConfig {

    // 配置数据源
    @Autowired
    private DataSource dataBaseMastDataSource;

    @Primary
    @Bean(name = "entityManagerFactoryMastDataBase")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMastDataBase(EntityManagerFactoryBuilder builder) {
        return builder
                // 设置数据源
                .dataSource(dataBaseMastDataSource)
                //设置实体类所在位置.扫描所有带有 @Entity 注解的类
                .packages("com.nx.dynamic.dict.model")
                // Spring会将EntityManagerFactory注入到Repository之中.有了 EntityManagerFactory之后,
                // Repository就能用它来创建 EntityManager 了,然后 EntityManager 就可以针对数据库执行操作
                .persistenceUnit("databaseMastPersistenceUnit")
                .build();

    }

    /**
     * 配置事物管理器
     *
     * @param builder
     * @return
     */
    @Bean(name = "transactionManagerMastDatabase")
    PlatformTransactionManager transactionManagerMastDatabase(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryMastDataBase(builder).getObject());
    }
}
