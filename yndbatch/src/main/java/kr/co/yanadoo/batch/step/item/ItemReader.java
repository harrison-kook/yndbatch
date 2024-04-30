package kr.co.yanadoo.batch.step.item;

import kr.co.yanadoo.batch.entity.Addition;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.item.database.orm.JpaQueryProvider;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class ItemReader<A> {
//    private DataSource dataSource;
//
//    @Bean
//    public ItemReader<Addition> itemReader() throws Exception {
//        return new JdbcPagingItemReaderBuilder<Addition>()
//                .pageSize(10)
//                .dataSource(dataSource)
//                .rowMapper(new BeanPropertyRowMapper<>(Addition.class))
//                .queryProvider(getQueryProvider())
//                .name("itemReader")
//                .build();
//    }
//
//    private PagingQueryProvider getQueryProvider() throws Exception {
//        var queryProvider = new SqlPagingQueryProviderFactoryBean();
//        queryProvider.setDataSource(dataSource);
//
//        queryProvider.setSelectClause("additionSeq, additionName, price");
//        queryProvider.setFromClause("addition");
//
//        queryProvider.setSortKey("additionSeq");
//
//        return queryProvider.getObject();
//    }
}
