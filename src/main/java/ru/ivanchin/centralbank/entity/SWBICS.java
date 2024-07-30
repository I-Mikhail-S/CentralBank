package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
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
@XmlAccessorType(XmlAccessType.FIELD)
public class SWBICS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Идентификатор */
    @XmlAttribute(name = "SWBICS")
    private String SWBIC;

    /** Дефолтный идентификатор */
    @XmlAttribute(name = "DefaultSWBIC")
    private Integer defaultSWBIC;

}
