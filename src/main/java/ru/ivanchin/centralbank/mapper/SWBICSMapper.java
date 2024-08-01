package ru.ivanchin.centralbank.mapper;

import org.mapstruct.Mapper;
import ru.ivanchin.centralbank.dto.response.SWBICSResponse;
import ru.ivanchin.centralbank.entity.SWBICS;

@Mapper(componentModel = "spring")
public interface SWBICSMapper {

    SWBICSResponse toSWBICSResponse(SWBICS swbics);
    SWBICS toSWBICS(SWBICSResponse swbicsResponse);

}
