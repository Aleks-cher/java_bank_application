package ru.levelup.bank.menu.action;

import ru.levelup.bank.configuration.HibernateConfiguration;
import ru.levelup.bank.domain.AccountEntity;
import ru.levelup.bank.menu.Action;
import ru.levelup.bank.repository.hbm.HibernateAccountRepository;
import ru.levelup.bank.repository.AccountEntityRepository;

import java.util.List;

public class AccountListingMenuAction implements Action {

    private final AccountEntityRepository accountEntityRepository;

    public AccountListingMenuAction() {
        this.accountEntityRepository = new HibernateAccountRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        List<AccountEntity> accountEntityList = accountEntityRepository.allAcc();
        accountEntityList.forEach(accountEntity -> System.out.println(accountEntity));
    }
}
