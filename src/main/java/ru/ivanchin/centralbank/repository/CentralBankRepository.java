package ru.ivanchin.centralbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.ivanchin.centralbank.entity.CentralBank;

import java.util.Optional;

@Repository
public interface CentralBankRepository extends JpaRepository<CentralBank, Long> {

    Optional<CentralBank> findById(@NonNull Long id);

}
