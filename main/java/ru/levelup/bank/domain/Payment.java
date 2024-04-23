package ru.levelup.bank.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;


@Getter
@ToString(
        exclude = {"accountFrom","accountTo"}
)
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

    @ManyToOne
    @JoinColumn(
            name = "account_from",
            referencedColumnName = "id"
    )
    private AccountEntity accountFrom;

    @ManyToOne
    @JoinColumn(
            name = "account_to",
            referencedColumnName = "id"
    )
    private AccountEntity accountTo;

    @Column(name = "status",columnDefinition = "ENUM('NEW', 'CONFIRMED', 'DONE', 'FAILED')")
    @ColumnTransformer(write="?::payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;


    //@Column(name = "account_from")
    //@Column(name = "account_to")
}
