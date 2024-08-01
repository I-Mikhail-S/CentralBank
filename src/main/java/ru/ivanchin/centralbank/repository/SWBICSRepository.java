package ru.ivanchin.centralbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.ivanchin.centralbank.entity.SWBICS;

import java.util.Optional;

@Repository
public interface SWBICSRepository extends JpaRepository<SWBICS, Long> {

    Optional<SWBICS> findById(@NonNull Long id);

}
