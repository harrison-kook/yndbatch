package kr.co.yanadoo.batch.job;

import kr.co.yanadoo.batch.step.StepConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class JobConfig {
    public static final String JOB_NAME = "EXAMPLE_JOB";
    private final Step exampleStep;

    public JobConfig(@Qualifier(StepConfig.STEP_NAME) Step exampleStep) {
        this.exampleStep = exampleStep;
    }

    @Bean(JOB_NAME)
    public Job exampleJob(JobRepository jobRepository) {
        return new JobBuilder(JOB_NAME, jobRepository) // 4.x 버전까지는 JobBuilderFactory 를 사용했지만 이후부터는 JobBuilder 객체 사용 권장
                .incrementer(new RunIdIncrementer())
                .start(exampleStep)
                .build();
    }
}
