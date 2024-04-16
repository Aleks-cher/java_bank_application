package ru.levelup.bank.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "accounts")
@NoArgsConstructor
@Setter
public class AccountEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "account_number")
    private String account_number;
    @Column(name = "type")
    private String type;
    @Column(name = "status")
    private String status;
    @Column(name = "open_datetime")
    private Timestamp open_datetime;
    @Column(name = "bd_id")
    private Long bd_id;


//    @ManyToOne
//    @JoinColumn(name = "bd_id", referencedColumnName = "bank_document_id")
//    private Customer customer;

}
