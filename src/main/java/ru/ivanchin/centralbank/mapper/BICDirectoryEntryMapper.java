package ru.ivanchin.centralbank.mapper;

import org.mapstruct.Mapper;
import ru.ivanchin.centralbank.dto.response.BICDirectoryEntryResponse;
import ru.ivanchin.centralbank.entity.BICDirectoryEntry;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BICDirectoryEntryMapper {

    BICDirectoryEntryResponse toBICDirectoryEntryResponse(BICDirectoryEntry bicDirectoryEntry);
    BICDirectoryEntry toBICDirectoryEntry(BICDirectoryEntryResponse bicDirectoryEntryResponse);
    List<BICDirectoryEntryResponse> toListBICDirectoryEntryResponse(List<BICDirectoryEntry> bicDirectoryEntryList);

}
