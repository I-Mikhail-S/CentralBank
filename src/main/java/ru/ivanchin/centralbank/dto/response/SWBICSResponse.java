package ru.ivanchin.centralbank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SWBICSResponse {
    private String SWBIC;
    private Integer defaultSWBIC;
}
