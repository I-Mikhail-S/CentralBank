package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

/**
 * Аккаунт банка в единой системе учёта кредитных организаций
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_entity")
public class Account {

    @Id
    private BigInteger account;

    /** Тип счёта */
    private String RegistrationAccountType;

    /** Контрольный ключ */
    private Integer ck;

    /** Условный номер Банка России */
    private Long accountCBRBIC;

    /** Дата открытия */
    private LocalDate dateIn;

    /** Статус счёта */
    private String AccountStatus;

    @OneToMany
    @JoinTable(name = "acc_rstr_list_entity")
    private List<AccRstrList> accRstrLists;

    @ManyToOne
    @JoinTable(name= "bank_entity")
    private Bank bank;

}
