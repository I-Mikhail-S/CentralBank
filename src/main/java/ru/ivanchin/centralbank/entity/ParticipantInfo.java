package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement(name = "ParticipantInfo")
public class ParticipantInfo {

    @Id
    @XmlElement(name = "ParticipantInfo")
    private Long uid;

    /** Имя участника */
    @XmlElement(name = "nameP")
    private String nameP;

    /** Регистрационный номер */
    @XmlElement(name = "regN")
    private String regN;

    /** Код страны */
    @XmlElement(name = "cntrCd")
    private String cntrCd;

    /** Регион */
    @XmlElement(name = "rgn")
    private SavedRequest rgn;

    /** Индекс */
    @XmlElement(name = "Ind")
    private Long Ind;

    /** Тип населённого пункта */
    @XmlElement(name = "tnp")
    private String tnp;

    /** Название населённого пункта */
    @XmlElement(name = "nnp")
    private String nnp;

    /** Адрес */
    @XmlElement(name = "adr")
    private String adr;

    /** Родительский БИК */
    @XmlElement(name = "prntBIC")
    private String prntBIC;

    /** Дата включения в систему */
    @XmlElement(name = "dateIn")
    private LocalDate dateIn;

    /** Тип участника */
    @XmlElement(name = "ptType")
    private Integer ptType;

    /** Предоставляемые услуги */
    @XmlElement(name = "srvcs")
    private Integer srvcs;

    /** Тип обмена */
    @XmlElement(name = "xchType")
    private Integer xchType;

    /** Статус участника */
    @XmlElement(name = "participantStatus")
    private String participantStatus;

    /** Лист резервирования */
    @OneToOne
    @JoinTable(name = "reservation_list_entity")
    @XmlElement(name = "participantStatus")
    private ReservationList reservationList;

    /** Общество всемирных межбанковских финансовых каналов связи */
    @OneToOne
    @JoinTable(name = "swbics_entity")
    @XmlElement(name = "SWBICS")
    private SWBICS swbics;

    @OneToOne
    @JoinTable(name = "bank_entity")
    private Bank bank;

}
