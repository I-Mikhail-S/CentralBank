package ru.ivanchin.centralbank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.authenticator.SavedRequest;
import ru.ivanchin.centralbank.entity.RstrList;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantInfoResponse {
    private String nameP;
    private String regN;
    private String cntrCd;
    private SavedRequest rgn;
    private Long Ind;
    private String tnp;
    private String nnp;
    private String adr;
    private String prntBIC;
    private LocalDate dateIn;
    private Integer ptType;
    private Integer srvcs;
    private Integer xchType;
    private String participantStatus;
    private RstrList rstrList;
}
