package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation_list_entity")
@XmlRootElement(name = "RstrList")
public class ReservationList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Тип резервирования */
    @XmlElement(name = "rstr")
    private String rstr;

    /** Дата резервирования */
    @XmlElement(name = "rstrDste")
    private LocalDate rstrDste;

    @OneToOne
    @JoinTable(name = "participant_info_entity")
    private ParticipantInfo participantInfo;

}
