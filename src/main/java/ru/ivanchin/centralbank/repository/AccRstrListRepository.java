package ru.ivanchin.centralbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.ivanchin.centralbank.entity.AccRstrList;

import java.util.Optional;

@Repository
public interface AccRstrListRepository extends JpaRepository<AccRstrList, Long>  {

    Optional<AccRstrList> findById(@NonNull Long id);

}
