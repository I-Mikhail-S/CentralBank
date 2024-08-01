package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BIC_directory_entry_entity")
@XmlAccessorType(XmlAccessType.FIELD)
public class BICDirectoryEntry {

    @Id
    @Column(name = "bic", nullable = false)
    @XmlAttribute(name = "BIC")
    private Long BIC;

    @OneToOne
    @JoinColumn(name = "participant_info_id")
    @XmlElement(name = "ParticipantInfo")
    private ParticipantInfo participantInfo;

    /** Общество всемирных межбанковских финансовых каналов связи */
    @OneToOne
    @JoinTable(name = "swbics_entity")
    @XmlElement(name = "SWBICS")
    private SWBICS swbics;

    /** Аккаунты банка в системе учёта зредитных организаций */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_account_id")
    @XmlElement(name = "Accounts")
    private Set<Account> accounts = new HashSet<>();

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
        BICDirectoryEntry BICDirectoryEntry = (BICDirectoryEntry) o;
        return getBIC() != null
                && Objects.equals(getBIC(), BICDirectoryEntry.getBIC())
                && Objects.equals(getParticipantInfo(), BICDirectoryEntry.getParticipantInfo())
                && Objects.equals(getAccounts(), BICDirectoryEntry.getAccounts());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
