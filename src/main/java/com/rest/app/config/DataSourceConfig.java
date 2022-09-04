package com.rest.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@Profile("prod")
@EnableJpaRepositories(
        basePackages = "com.rest.app.repository",
        entityManagerFactoryRef = "entityManagerFactoryBean"
)
@EnableTransactionManagement
public class DataSourceConfig {

    private HibernateProperties hibernateProperties;
    private Environment environment;

    @Autowired
    public DataSourceConfig(HibernateProperties hibernateProperties, Environment environment) {
        this.hibernateProperties = hibernateProperties;
        this.environment = environment;
    }

    @Bean
    public DataSource jndiDataSource() throws NamingException {
        JndiObjectFactoryBean factoryBean = new JndiObjectFactoryBean();
        factoryBean.setJndiName(Objects.requireNonNull(environment.getProperty("spring.datasource.jndi-name")));
        factoryBean.setProxyInterface(DataSource.class);
        factoryBean.setLookupOnStartup(false);
        factoryBean.afterPropertiesSet();

        return (DataSource) factoryBean.getObject();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws NamingException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(jndiDataSource());
        factoryBean.setPackagesToScan("com.rest.app.entity");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties.getHibernateProperties());
        factoryBean.afterPropertiesSet();

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws NamingException {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

        return jpaTransactionManager;
    }
}