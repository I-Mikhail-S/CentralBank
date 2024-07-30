package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;
import org.apache.catalina.authenticator.SavedRequest;

import java.time.LocalDate;

/**
 * Информация об учатнике
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "participant_info_entity")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantInfo {

    @Id
    @Column(name = "id", nullable = false)
    @XmlAttribute(name = "ParticipantInfo")
    private Long uid;

    /** Имя участника */
    @XmlAttribute(name = "nameP")
    private String nameP;

    /** Регистрационный номер */
    @XmlAttribute(name = "regN")
    private String regN;

    /** Код страны */
    @XmlAttribute(name = "cntrCd")
    private String cntrCd;

    /** Регион */
    @XmlAttribute(name = "rgn")
    private SavedRequest rgn;

    /** Индекс */
    @XmlAttribute(name = "Ind")
    private Long Ind;

    /** Тип населённого пункта */
    @XmlAttribute(name = "tnp")
    private String tnp;

    /** Название населённого пункта */
    @XmlAttribute(name = "nnp")
    private String nnp;

    /** Адрес */
    @XmlAttribute(name = "adr")
    private String adr;

    /** Родительский БИК */
    @XmlAttribute(name = "prntBIC")
    private String prntBIC;

    /** Дата включения в систему */
    @XmlAttribute(name = "dateIn")
    private LocalDate dateIn;

    /** Тип участника */
    @XmlAttribute(name = "ptType")
    private Integer ptType;

    /** Предоставляемые услуги */
    @XmlAttribute(name = "srvcs")
    private Integer srvcs;

    /** Тип обмена */
    @XmlAttribute(name = "xchType")
    private Integer xchType;

    /** Статус участника */
    @XmlAttribute(name = "participantStatus")
    private String participantStatus;

    /** Лист резервирования */
    @OneToOne
    @JoinColumn(name = "reservation_list_entity")
    @XmlElement(name = "participantStatus")
    private ReservationList reservationList;

}
