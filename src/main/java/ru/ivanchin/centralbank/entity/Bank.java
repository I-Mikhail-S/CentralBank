package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_entity")
public class Bank {

    @Id
    private Long BICDirectoryEntry;

    @OneToOne
    @JoinTable(name = "participant_info_entity")
    private ParticipantInfo participantInfo;

    @OneToMany
    @JoinTable(name = "account_entity")
    private Set<Account> accounts;

}
