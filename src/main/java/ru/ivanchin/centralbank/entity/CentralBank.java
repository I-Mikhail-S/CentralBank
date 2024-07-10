package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "central_bank_entity")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CentralBank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private static final List<Bank> listBanks = new ArrayList<>();

}
