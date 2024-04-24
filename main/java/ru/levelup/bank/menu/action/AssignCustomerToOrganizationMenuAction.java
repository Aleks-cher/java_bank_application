package ru.levelup.bank.menu.action;

import ru.levelup.bank.configuration.HibernateConfiguration;
import ru.levelup.bank.menu.Action;
import ru.levelup.bank.menu.ConsoleMenu;
import ru.levelup.bank.repository.OrganizationRepository;
import ru.levelup.bank.repository.hbm.HibernateOrganizationRepository;

public class AssignCustomerToOrganizationMenuAction implements Action {

    private final OrganizationRepository organizationRepository;

    public AssignCustomerToOrganizationMenuAction() {
        this.organizationRepository = new HibernateOrganizationRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        int organizationId = ConsoleMenu.readInt("Введите ID организации");
        int customerId = ConsoleMenu.readInt("Введите ID кастомера");

        organizationRepository.assignCustomerOrganization(organizationId, customerId);
    }
}
