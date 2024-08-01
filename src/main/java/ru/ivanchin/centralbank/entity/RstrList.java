package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;
import ru.ivanchin.centralbank.workWithXml.adapter.LocalDateAdapter;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rstr_list_entity")
@XmlAccessorType(XmlAccessType.FIELD)
public class RstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Тип резервирования */
    @XmlAttribute(name = "Rstr")
    private String rstr;

    /** Дата резервирования */
    @Temporal(TemporalType.DATE)
    @XmlAttribute(name = "RstrDste")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate rstrDste;

}
