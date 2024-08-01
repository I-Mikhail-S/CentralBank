package ru.ivanchin.centralbank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ivanchin.centralbank.entity.AccRstrList;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private String account;
    private String RegistrationAccountType;
    private Integer ck;
    private Long accountCBRBIC;
    private LocalDate dateIn;
    private String AccountStatus;
    private Set<AccRstrList> accRstrLists;
}
