package ru.ivanchin.centralbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.ivanchin.centralbank.entity.RstrList;

import java.util.Optional;

@Repository
public interface RstrListRepository extends JpaRepository<RstrList, Long> {

    Optional<RstrList> findById(@NonNull Long id);

}
