package ru.levelup.bank.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import ru.levelup.bank.domain.Organization;

import java.util.List;

public interface OrganizationRepository {

    List<Organization> all();

    void update(Organization organization);

    Organization byVatin(String vatin);

    List<Organization> byName(String name);

    Organization create(
        String name,
        String vatin
    );

    void assignCustomerOrganization(Integer organizationID, Integer customerID);

}
