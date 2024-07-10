package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Society for Worldwide Interbank Financial Telecommunications
 * Общество всемирных межбанковских финансовых каналов связи
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "swbics_entity")
public class SWBICS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Идентификатор */
    private String SWBIC;

    /** Дефолтный идентификатор */
    private Integer defaultSWBIC;

    @OneToOne
    @JoinTable(name = "participant_info_entity")
    private ParticipantInfo participantInfo;

}
