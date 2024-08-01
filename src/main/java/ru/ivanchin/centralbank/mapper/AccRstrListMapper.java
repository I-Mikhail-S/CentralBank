package ru.ivanchin.centralbank.mapper;

import org.mapstruct.Mapper;
import ru.ivanchin.centralbank.dto.response.AccRstrListResponse;
import ru.ivanchin.centralbank.entity.AccRstrList;

@Mapper(componentModel = "spring")
public interface AccRstrListMapper {

    AccRstrListResponse toAccRstrListResponse(AccRstrList accRstrList);
    AccRstrList toAccRstrList(AccRstrListResponse accRstrListResponse);

}
