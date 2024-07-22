package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;

import java.time.LocalDate;
import java.util.Objects;

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
@XmlRootElement(name = "AccRstrList")
public class AccRstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** AccRstr */
    @XmlElement(name = "AccRstr")
    private String AccRstr;

    /** Дата регистрации */
    @XmlElement(name = "AccRstrDate")
    private LocalDate AccRstrDate;

    @ManyToOne
    @JoinTable(name = "account_entity")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();
        if (oEffectiveClass != thisEffectiveClass) return false;
        AccRstrList that = (AccRstrList) o;
        return getId() != null
                && Objects.equals(getId(), that.getId())
                && Objects.equals(getAccRstr(), that.getAccRstr())
                && Objects.equals(getAccRstrDate(), that.getAccRstrDate())
                && Objects.equals(getAccount(), that.getAccount());
    }

    @Override
    public int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
