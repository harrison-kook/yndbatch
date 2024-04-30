package kr.co.yanadoo.batch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

public class ChainedTxConfig {
    @Bean(name = "transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(
            PlatformTransactionManager yanadooMasterTransactionManager

    ) {
        return new ChainedTransactionManager(
                yanadooMasterTransactionManager
        );
    }
}
