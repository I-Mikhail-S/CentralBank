package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
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
public class ParticipantInfo {

    @Id
    private Long uid;

    /** Имя участника */
    private String nameP;

    /** Регистрационный номер */
    private String regN;

    /** Код страны */
    private String cntrCd;

    /** Регион */
    private SavedRequest rgn;

    /** Индекс */
    private Long Ind;

    /** Тип населённого пункта */
    private String tnp;

    /** Название населённого пункта */
    private String nnp;

    /** Адрес */
    private String adr;

    /** Родительский БИК */
    private String prntBIC;

    /** Дата включения в систему */
    private LocalDate dateIn;

    /** Тип участника */
    private Integer ptType;

    /** Предоставляемые услуги */
    private Integer srvcs;

    /** Тип обмена */
    private Integer xchType;

    /** Статус участника */
    private String participantStatus;

    /** Лист резервирования */
    @OneToOne
    @JoinTable(name = "reservation_list_entity")
    private ReservationList reservationList;

    /** Общество всемирных межбанковских финансовых каналов связи */
    @OneToOne
    @JoinTable(name = "swbics_entity")
    private SWBICS swbics;

    @OneToOne
    @JoinTable(name = "bank")
    private Bank bank;

}
