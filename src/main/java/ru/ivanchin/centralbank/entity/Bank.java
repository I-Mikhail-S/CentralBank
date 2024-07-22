package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_entity")
@XmlRootElement(name = "BICDirectoryEntry")
public class Bank {

    @Id
    @XmlAttribute(name = "BIC")
    private Long BIC;

    @OneToOne
    @JoinTable(name = "participant_info_entity")
    @XmlElement(name = "ParticipantInfo")
    private ParticipantInfo participantInfo;

    @OneToMany
    @JoinTable(name = "account_entity")
    @XmlElement(name = "Accounts")
    private Set<Account> accounts;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ?
                ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();
        if (oEffectiveClass != thisEffectiveClass) return false;
        Bank bank = (Bank) o;
        return getBIC() != null
                && Objects.equals(getBIC(), bank.getBIC())
                && Objects.equals(getParticipantInfo(), bank.getParticipantInfo())
                && Objects.equals(getAccounts(), bank.getAccounts());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
