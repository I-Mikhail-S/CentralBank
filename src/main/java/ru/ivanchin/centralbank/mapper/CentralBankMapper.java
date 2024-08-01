package ru.ivanchin.centralbank.mapper;

import org.mapstruct.Mapper;
import ru.ivanchin.centralbank.dto.response.CentralBankResponse;
import ru.ivanchin.centralbank.entity.CentralBank;

@Mapper(componentModel = "spring")
public interface CentralBankMapper {

    CentralBankResponse toCentralBankResponse(CentralBank centralBank);
    CentralBank toCentralBank(CentralBankResponse centralBankResponse);

}
