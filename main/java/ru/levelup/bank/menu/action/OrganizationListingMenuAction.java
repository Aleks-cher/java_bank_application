package ru.levelup.bank.menu.action;

import ru.levelup.bank.configuration.HibernateConfiguration;
import ru.levelup.bank.domain.Organization;
import ru.levelup.bank.menu.Action;
import ru.levelup.bank.repository.OrganizationRepository;
import ru.levelup.bank.repository.hbm.HibernateCustomerRepository;
import ru.levelup.bank.repository.hbm.HibernateOrganizationRepository;

import java.util.List;

public class OrganizationListingMenuAction implements Action {

    private OrganizationRepository organizationRepository;

    public OrganizationListingMenuAction() {
        this.organizationRepository = new HibernateOrganizationRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        List<Organization> organizations = organizationRepository.all();
        organizations.forEach(organization -> System.out.println(organizations));
    }
}
