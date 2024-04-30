package kr.co.yanadoo.batch.job;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@JobScope
@Component
public class JobParameter {
    private LocalDate date;

    @Value("${chunk-size:10}")
    private int chunkSize;

    @Value("#{jobParameters[updateDate]}")
    public void SetDate(String date){
        this.date = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }
}
