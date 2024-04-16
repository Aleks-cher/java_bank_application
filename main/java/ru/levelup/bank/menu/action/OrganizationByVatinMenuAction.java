package ru.levelup.bank.menu.action;

import ru.levelup.bank.configuration.HibernateConfiguration;
import ru.levelup.bank.domain.Organization;
import ru.levelup.bank.menu.Action;
import ru.levelup.bank.menu.ConsoleMenu;
import ru.levelup.bank.repository.OrganizationRepository;
import ru.levelup.bank.repository.hbm.HibernateOrganizationRepository;

public class OrganizationByVatinMenuAction implements Action {

    private OrganizationRepository organizationRepository;

    public OrganizationByVatinMenuAction() {
        this.organizationRepository = new HibernateOrganizationRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String organizationVatin = ConsoleMenu.readString("Введите ИНН компании");
        Organization organization = organizationRepository.byVatin(organizationVatin);
        if (organization == null) {
            System.out.println("Компания с ИНН: " + organizationVatin + " не найдена!");
        } else {
            System.out.println(organization);
        }
    }
}
