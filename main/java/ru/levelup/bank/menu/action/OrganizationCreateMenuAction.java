package ru.levelup.bank.menu.action;

import ru.levelup.bank.configuration.HibernateConfiguration;
import ru.levelup.bank.domain.Organization;
import ru.levelup.bank.menu.Action;
import ru.levelup.bank.menu.ConsoleMenu;
import ru.levelup.bank.repository.OrganizationRepository;
import ru.levelup.bank.repository.hbm.HibernateOrganizationRepository;

public class OrganizationCreateMenuAction implements Action {

    private OrganizationRepository organizationRepository;

    public OrganizationCreateMenuAction() {
        this.organizationRepository = new HibernateOrganizationRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String organizationName = ConsoleMenu.readString("Введите наименование компании");
        String organizationVatin = ConsoleMenu.readString("Введите ИНН компании");
        Organization organization = organizationRepository.create(organizationName, organizationVatin);
        System.out.println("Компания: " + organization + " добавлена");
    }
}
