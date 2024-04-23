package ru.levelup.bank.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.levelup.bank.menu.action.ExitAction;
import ru.levelup.bank.menu.action.OrganizationListingMenuAction;

import static org.junit.jupiter.api.Assertions.*;

public class MenuActionsTest {
    @Test
    public void testGetActionWhenActionCodeIs0ThenReturnExitAction() {
        Action result = MenuActions.getAction(0);

        assertNotNull(result);
        assertInstanceOf(ExitAction.class, result);

    }
    // было выше
    // Assertions.assertNotNull(result);
    // Assertions.assertInstanceOf(ExitAction.class, result);

    @Test
    public void testGetActionWhenActionCodeIsNotDefinedInMapThenReturnNull() {
        Action result = MenuActions.getAction(-1);
        assertNull(result);
    }

    @Test
    public void testgetActionWhenActionCodeIs1ThenReturnOrganizationListingMenuAction() {
        Action result = MenuActions.getAction(1);
        assertNotNull(result);
        assertInstanceOf(OrganizationListingMenuAction.class, result);
    }
}