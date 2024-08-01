package ru.ivanchin.centralbank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ivanchin.centralbank.entity.Account;
import ru.ivanchin.centralbank.entity.ParticipantInfo;
import ru.ivanchin.centralbank.entity.SWBICS;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BICDirectoryEntryResponse {
    private ParticipantInfo participantInfo;
    private SWBICS swbics;
    private Set<Account> accounts;
}
