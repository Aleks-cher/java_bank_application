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
    private Date date;
    @Column(name = "amount")
    private double amount;
    @Column(name = "account_from")
    private int accountFrom;
    @Column(name = "account_to")
    private int accountTo;
    @Column(name = "status")
    private String paymentStatus;

}
