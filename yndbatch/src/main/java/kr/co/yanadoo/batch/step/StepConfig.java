package kr.co.yanadoo.batch.step;

import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import kr.co.yanadoo.batch.entity.Addition;
import kr.co.yanadoo.batch.job.JobConfig;
import kr.co.yanadoo.batch.job.JobParameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.mybatis.spring.batch.builder.MyBatisPagingItemReaderBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class StepConfig {
    public static final String STEP_NAME = JobConfig.JOB_NAME + ".EXAMPLE_STEP";
    private final EntityManagerFactory entityManagerFactory; // JPA
    private final SqlSessionFactory sqlSessionFactory; //MyBatis
    private final JobParameter jobParameter;

    @Bean(STEP_NAME)
    @JobScope
    public Step exampleStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder(STEP_NAME, jobRepository)
                .<Addition, Addition>chunk(jobParameter.getChunkSize(), transactionManager)
                .reader(exampleItemReader())
                .processor(exampleProcessor())
                .writer(exampleItemWriter())
                .build();
    }

//    @Bean
//    @StepScope
//    public JpaPagingItemReader<Addition> exampleItemReader() {
//        log.info(">>>>>>>>> exampleItemReader");
//        Map<String, Object> parameterValues = new HashMap<>();
//        parameterValues.put("price", 1265500);
//        return new JpaPagingItemReaderBuilder<Addition>()
//                .pageSize(jobParameter.getChunkSize())
//                .parameterValues(parameterValues)
//                .queryString("SELECT a FROM Addition a WHERE a.price >= :price ORDER BY a.price ASC")
//                .entityManagerFactory(entityManagerFactory)
//                .name("exampleItemReader")
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public ItemProcessor<Addition, Addition> exampleProcessor() {
//        log.info(">>>>>>>>> exampleProcessor");
//        return new ItemProcessor<Addition, Addition>() {
//            @Override
//            public Addition process(Addition addition) throws Exception {
//                addition.setPrice(addition.getPrice()+1);
//                return addition;
//            }
//        };
//    }
//
//    @Bean
//    @StepScope
//    public JpaItemWriter<Addition> exampleItemWriter() {
//        log.info(">>>>>>>>> exampleItemWriter");
//        return new JpaItemWriterBuilder<Addition>()
//                .entityManagerFactory(entityManagerFactory)
//                .build();
//    }



    @Bean
    @StepScope
    public MyBatisPagingItemReader<Addition> exampleItemReader() {
        log.info(">>>>>>>>> exampleItemReader");
        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("price", 1265500);
        return new MyBatisPagingItemReaderBuilder<Addition>()
                .pageSize(jobParameter.getChunkSize())
                .parameterValues(parameterValues)
                .sqlSessionFactory(sqlSessionFactory)
                .queryId("kr.co.yanadoo.batch.mapper.yanadooMaster.JabMapper.selectAdditionList")
                .build();
    }

    @Bean
    @StepScope
    public ItemProcessor<Addition, Addition> exampleProcessor() {
        log.info(">>>>>>>>> exampleProcessor");
        return new ItemProcessor<Addition, Addition>() {
            @Override
            public Addition process(Addition addition) throws Exception {
                addition.setPrice(addition.getPrice()+1);
                return addition;
            }
        };
    }

    @Bean
    @StepScope
    public MyBatisBatchItemWriter<Addition> exampleItemWriter() {
        log.info(">>>>>>>>> exampleItemWriter");
        return new MyBatisBatchItemWriterBuilder<Addition>()
                .sqlSessionFactory(sqlSessionFactory)
                .statementId("kr.co.yanadoo.batch.mapper.yanadooMaster.JabMapper.updateAddition")
                .build();
    }
}
