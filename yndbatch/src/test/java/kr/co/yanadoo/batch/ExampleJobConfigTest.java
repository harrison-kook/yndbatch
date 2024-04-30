package kr.co.yanadoo.batch;

import kr.co.yanadoo.batch.config.BatchConfig;
import kr.co.yanadoo.batch.job.JobConfig;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBatchTest
@SpringBootTest
public class ExampleJobConfigTest {
    @Autowired private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void exampleJobConfigTest(@Qualifier(JobConfig.JOB_NAME) Job job) throws Exception {
        //given
        jobLauncherTestUtils.setJob(job);
        final JobParameters jobParameters = jobLauncherTestUtils
                .getUniqueJobParametersBuilder()
                .addString("updateDate", "2024-04-23")
                .toJobParameters();

        //when
        final JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        //then
        assertEquals(BatchStatus.COMPLETED, jobExecution.getExitStatus());
    }
}
