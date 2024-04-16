package ru.levelup.bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id  // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "bank_document_id")
    private long bankDocumentId;
    @Column(name = "first_name")
    private String firsName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "passport_seria")
    private String passportSeria;
    @Column(name = "passport_number")
    private String passportNumber;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<AccountEntity> accountEntities;
//
//    public Customer(Integer id, long bankDocumentId, String firsName, String lastName, Date birthday, String passportSeria, String passportNumber) {
//
//    }
}
