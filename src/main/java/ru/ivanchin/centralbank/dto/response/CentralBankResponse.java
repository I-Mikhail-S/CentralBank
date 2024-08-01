package ru.ivanchin.centralbank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ivanchin.centralbank.entity.BICDirectoryEntry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CentralBankResponse {
    private String xmlns;
    private Long EDNo;
    private LocalDate EDDate;
    private Long EDAuthor;
    private String CreationReason;
    private LocalDateTime CreationDateTime;
    private String InfoTypeCode;
    private LocalDate BusinessDay;
    private Integer DirectoryVersion;
    private Set<BICDirectoryEntry> listBICDirectoryEntries;
}
