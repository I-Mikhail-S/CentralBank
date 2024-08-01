package ru.ivanchin.centralbank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ivanchin.centralbank.dto.response.CentralBankResponse;
import ru.ivanchin.centralbank.entity.CentralBank;
import ru.ivanchin.centralbank.mapper.CentralBankMapper;
import ru.ivanchin.centralbank.repository.CentralBankRepository;
import ru.ivanchin.centralbank.workWithXml.ParserXml;

@Service
@RequiredArgsConstructor
public class CentralBankService {

    private final ParserXml parserXml;
    private final CentralBankRepository centralBankRepository;



}
