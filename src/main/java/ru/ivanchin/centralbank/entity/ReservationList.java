package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
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
public class ReservationList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Тип резервирования */
    private String rstr;

    /** Дата резервирования */
    private LocalDate rstrDste;

    @OneToOne
    @JoinTable(name = "participant_info_entity")
    private ParticipantInfo participantInfo;

}
