package ru.ivanchin.centralbank.mapper;

import org.mapstruct.Mapper;
import ru.ivanchin.centralbank.dto.response.RstrListResponse;
import ru.ivanchin.centralbank.entity.RstrList;

@Mapper(componentModel = "spring")
public interface RstrListMapper {

    RstrListResponse toRstrListResponse(RstrList rstrList);
    RstrList toRstrList(RstrListResponse rstrListResponse);

}
