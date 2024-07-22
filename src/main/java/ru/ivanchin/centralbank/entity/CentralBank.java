package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "central_bank_entity")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@XmlRootElement(name = "ED807")
public class CentralBank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinTable(name = "bank_entity")
    @XmlElement(name = "BICDirectoryEntry")
    private Set<Bank> listBanks;


    public void addBank(Bank bank) {
        if (listBanks == null)
            listBanks = new HashSet<>() {{ add(bank); }};
        else
            listBanks.add(bank);
    }

}
