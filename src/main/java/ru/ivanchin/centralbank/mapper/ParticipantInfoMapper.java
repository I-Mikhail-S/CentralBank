package ru.ivanchin.centralbank.mapper;

import org.mapstruct.Mapper;
import ru.ivanchin.centralbank.dto.response.ParticipantInfoResponse;
import ru.ivanchin.centralbank.entity.ParticipantInfo;

@Mapper(componentModel = "spring")
public interface ParticipantInfoMapper {

    ParticipantInfoResponse toParticipantInfoResponse(ParticipantInfo participantInfo);
    ParticipantInfo toParticipantInfo(ParticipantInfoResponse participantInfoResponse);

}
