package kr.co.yanadoo.batch.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.boot.autoconfigure.batch.BatchDataSourceScriptDatabaseInitializer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "kr.co.yanadoo.batch.mapper.yanadooMaster",
        annotationClass = YanadooMasterMapper.class,
        sqlSessionFactoryRef = "yanadooMasterSqlSessionFactory")
@EnableConfigurationProperties(BatchProperties.class)
public class BatchConfig extends DatabaseConfig{
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "spring.batch.job.name", havingValue = "true", matchIfMissing = true)
    public JobLauncherApplicationRunner jobLauncherApplicationRunner(JobLauncher jobLauncher, JobExplorer jobExplorer, JobRepository jobRepository, BatchProperties properties) {
        JobLauncherApplicationRunner runner = new JobLauncherApplicationRunner(jobLauncher, jobExplorer, jobRepository);
        String jobNames = properties.getJob().getName();
        if(StringUtils.hasText(jobNames)){
            runner.setJobName(jobNames);
        }
        return runner;
    }

    @Bean
    @ConditionalOnMissingBean(BatchDataSourceScriptDatabaseInitializer.class)
    BatchDataSourceScriptDatabaseInitializer batchDataSourceScriptDatabaseInitializer(DataSource dataSource, @BatchDataSource ObjectProvider<DataSource> batchDataSource, BatchProperties properties) {
        return new BatchDataSourceScriptDatabaseInitializer(batchDataSource.getIfAvailable(() -> dataSource), properties.getJdbc());
    }

    @BatchDataSource
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    @Bean("batchDataSource")
    public DataSource batchDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public PlatformTransactionManager batchTransactionManager(@Qualifier("batchDataSource") DataSource batchDataSource) {
        return new DataSourceTransactionManager(batchDataSource);
    }

    @Bean(name = "yanadooMasterDataSource")
    @Primary
    public DataSource yanadooMasterDataSource() {
        return new LazyConnectionDataSourceProxy(new HikariDataSource(this));
    }

    @Bean(name = "yanadooMasterSqlSessionFactory")
    @Primary
    public SqlSessionFactory yanadooMasterSqlSessionFactory(@Qualifier("yanadooMasterDataSource") DataSource dataSource,
                                                            ApplicationContext applicationContext) throws Exception {
        return getSqlSessionFactory(dataSource);
    }

    @Bean(name = "yanadooMasterSqlSession")
    @Primary
    public SqlSessionTemplate yanadooMasterSqlSessionTemplate(@Qualifier("yanadooMasterSqlSessionFactory") SqlSessionFactory dbSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(dbSqlSessionFactory);
    }
}
