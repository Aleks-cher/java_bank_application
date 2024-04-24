package ru.levelup.bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Getter
@ToString(
        exclude = {"accountEntities", "organizations"}
)
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

    // customer главная таблица

    // !!! если не хочу что бы в кастомер попали аккаунты то в аннотацию ту стринг прописывасывает эхклюд и ставим LAZY
    // если ходим выводить аккаунты то в ту стринге пусто и в fetch = FetchType.EAGER

    @OneToMany(
            mappedBy = "customer",
            fetch = FetchType.LAZY
    )
    private List<AccountEntity> accountEntities;

    @ManyToMany
    @JoinTable(
            name = "customers_and_organization",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id")
    )
    private List<Organization> organizations;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<AccountEntity> accountEntities;
//
    public Customer(Integer id, long bankDocumentId, String firsName, String lastName, Date birthday, String passportSeria, String passportNumber) {

    }
}
