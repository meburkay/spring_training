package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paymentDetails")
@NoArgsConstructor
@Data
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal merchantPayoutAmount;
    private BigDecimal commissionAmount;

    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    //We create Payment instance here because we want to reach to Payment from PaymentDetail too like the reverse. It is two-dimensional approach. If we put only Payment it is one directional approach. And When we add the Entity we have to specify the relationship. Because of that we put the @OneToOne annotation. But if we don't add the parenthesis spring put foreign keys to both tables. We don't want that. When we add the parenthesis we say to spring that the main table is Payment put the foreign key there and do not put foreign key to PaymentDetail table. But the word between the doublequote is important. It has to be match with the PaymentDetail instance that we put into the Payment class.
    @OneToOne(mappedBy = "paymentDetail")
    private Payment payment;


    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commissionAmount, LocalDate payoutDate) {
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.commissionAmount = commissionAmount;
        this.payoutDate = payoutDate;
    }
}
