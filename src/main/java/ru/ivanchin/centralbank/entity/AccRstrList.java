package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Резервирование средств на счёте
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "acc_rstr_list_entity")
public class AccRstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** AccRstr */
    private String accRstr;

    /** Дата регистрации */
    private LocalDate AccRstrDate;

    @ManyToOne
    @JoinTable(name = "account_entity")
    private Account account;
}
