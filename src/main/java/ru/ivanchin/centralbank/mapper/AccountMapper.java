package ru.ivanchin.centralbank.mapper;

import org.mapstruct.Mapper;
import ru.ivanchin.centralbank.dto.response.AccountResponse;
import ru.ivanchin.centralbank.entity.Account;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountResponse toAccountResponse(Account account);
    Account toAccount(AccountResponse accountResponse);
    List<AccountResponse> toListAccountResponse(List<Account> accountList);

}
