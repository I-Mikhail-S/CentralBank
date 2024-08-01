package ru.ivanchin.centralbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivanchin.centralbank.entity.BICDirectoryEntry;

import java.util.Optional;

@Repository
public interface BICDirectoryEntryRepository extends JpaRepository<BICDirectoryEntry, Long>  {

    Optional<BICDirectoryEntry> findByBIC(Long bic);

}
