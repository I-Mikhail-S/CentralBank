package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
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
@XmlAccessorType(XmlAccessType.FIELD)
public class ReservationList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Тип резервирования */
    @XmlAttribute(name = "Rstr")
    private String rstr;

    /** Дата резервирования */
    @XmlAttribute(name = "RstrDste")
    private LocalDate rstrDste;

}
