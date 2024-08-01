package ru.ivanchin.centralbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.ivanchin.centralbank.entity.ParticipantInfo;

import java.util.Optional;

@Repository
public interface ParticipantInfoRepository extends JpaRepository<ParticipantInfo, Long> {

    Optional<ParticipantInfo> findByUid(@NonNull Long uid);

}
