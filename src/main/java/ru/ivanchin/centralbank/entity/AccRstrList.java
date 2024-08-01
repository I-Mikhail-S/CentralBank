package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import ru.ivanchin.centralbank.workWithXml.adapter.LocalDateAdapter;

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
@XmlAccessorType(XmlAccessType.FIELD)
public class AccRstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** AccRstr */
    @XmlAttribute(name = "AccRstr")
    private String AccRstr;

    /** Дата регистрации */
    @Temporal(TemporalType.DATE)
    @XmlAttribute(name = "AccRstrDate")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate AccRstrDate;

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
                && Objects.equals(getAccRstrDate(), that.getAccRstrDate());
    }

    @Override
    public int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
