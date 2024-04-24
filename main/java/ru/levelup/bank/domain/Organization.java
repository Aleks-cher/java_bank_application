package ru.levelup.bank.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.List;

@Setter
@Getter
@ToString(
        exclude = "customers"
)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "vatin")
    private String vatin; // ИНН

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "organizations",
            cascade = CascadeType.ALL
    )
    private List<Customer> customers;

    public Organization(Integer id, String name, String vatin) {
        this.id = id;
        this.name = name;
        this.vatin = vatin;
        this.customers = Collections.emptyList();
    }
}
