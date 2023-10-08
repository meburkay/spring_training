package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    //@OneToOne//this annotation creates the join relationship and by this when the table payment table created spring automatically add to it the PaymentDetail foregin key.
    //@JoinColumn(name = "payment_detail_id")//with this we can change the foreign key name. In default it is payment_detail_id and generally people use the default way.
    //@OneToOne(cascade = CascadeType.ALL)//with cascade we say that what happens to Payment as a parent it happens to PaymentDetail too. For now because of that with only PaymentRepository we can do our operations.
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})//by this way we can give whatever type we wanna give.
    private PaymentDetail paymentDetail;

    //One Merchant can have many payments. Because of that we add merchant id to Payment table. By this way we can show the merchant ids at one row. Otherwise at Merchant table we have to show more than one Payment ids at Merchant table's one row. We can not do that.
    @ManyToOne
    private Merchant merchant;


    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
