package ru.ivanchin.centralbank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ivanchin.centralbank.dto.response.CentralBankResponse;
import ru.ivanchin.centralbank.service.CentralBankService;

@RestController
@RequestMapping("/api/centralBank")
@RequiredArgsConstructor
public class CentralBankController {

    private final CentralBankService centralBankService;



}
