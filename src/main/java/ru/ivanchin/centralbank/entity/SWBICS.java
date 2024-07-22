package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement(name = "SWBICS")
public class SWBICS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Идентификатор */
    @XmlElement(name = "SWBICS")
    private String SWBIC;

    /** Дефолтный идентификатор */
    @XmlElement(name = "DefaultSWBIC")
    private Integer defaultSWBIC;

    @OneToOne
    @JoinTable(name = "participant_info_entity")
    private ParticipantInfo participantInfo;

}
