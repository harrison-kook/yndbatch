package kr.co.yanadoo.batch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@Table(name = "ADDITION")
@NoArgsConstructor
public class Addition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int additionSeq;

    @NotNull
    private String additionName;

    @NotNull
    private String additionBrandCode;

    @NotNull
    private String additionDeliveryCode;

    @NotNull
    private String additionCategoryCode;

    @NotNull
    private String additionType;

    @NotNull
    private String logisticsCode;

    @Column(columnDefinition = "char(1)")
    @NotNull
    private String refundYn = "N";

    @Min(value = 0)
    private Integer basePrice;

    @Min(value = 0)
    private Integer price;

    @Min(value = 0)
    private Integer standardSalePrice;

    private String saleUsableStatus;

    @Column(columnDefinition = "char(1)")
    @NotNull
    private String saleQuantityLimitedYn;

    private Integer saleQuantity;

    private String taxType;

    @Column(columnDefinition = "char(1)")
    @NotNull
    private String useYn = "Y";

    private String publisher;

    private String isbnCode;

    private String additionImagePath;

    private String additionContent;

    private String versionCode;
}
