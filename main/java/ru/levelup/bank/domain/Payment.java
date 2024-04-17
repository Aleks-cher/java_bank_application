package ru.levelup.bank.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
@Setter
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date")
    private java.sql.Timestamp date;
    @Column(name = "amount")
    private java.math.BigDecimal amount;
    @Column(name = "account_from")
    private int accountFrom;
    @Column(name = "account_to")
    private int accountTo;
    @Column(name = "status")
    private String paymentStatus;

}
