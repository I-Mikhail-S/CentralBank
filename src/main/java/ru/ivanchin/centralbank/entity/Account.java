package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

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
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Номер счёта */
    @XmlAttribute(name = "Account")
    private String account;

    /** Тип счёта */
    @XmlAttribute(name = "RegulationAccountType")
    private String RegistrationAccountType;

    /** Контрольный ключ */
    @XmlAttribute(name = "CK")
    private Integer ck;

    /** Условный номер Банка России */
    @XmlAttribute(name = "AccountCBRBIC")
    private Long accountCBRBIC;

    /** Дата открытия */
    @XmlAttribute(name = "DateIn")
    private LocalDate dateIn;

    /** Статус счёта */
    @XmlAttribute(name = "AccountStatus")
    private String AccountStatus;

    @OneToMany
    @JoinColumn(name = "acc_rstr_list_id")
    private Set<AccRstrList> accRstrLists;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();
        if (oEffectiveClass != thisEffectiveClass) return false;
        Account account = (Account) o;
        return getId() != null
                && Objects.equals(getId(), account.getId())
                && Objects.equals(getAccount(), account.getAccount())
                && Objects.equals(getRegistrationAccountType(), account.getRegistrationAccountType())
                && Objects.equals(getCk(), account.getCk())
                && Objects.equals(getAccountCBRBIC(), account.getAccountCBRBIC())
                && Objects.equals(getDateIn(), account.getDateIn())
                && Objects.equals(getAccountStatus(), account.getAccountStatus())
                && Objects.equals(getAccRstrLists(), account.getAccRstrLists());
    }

    @Override
    public int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
