package ru.levelup.bank.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@Getter
@ToString
@Table(name = "accounts")
@Entity
@NoArgsConstructor
@Setter
public class Account {

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
    private Date open_datetime;
    @Column(name = "bd_id")
    private long bd_id;



}
