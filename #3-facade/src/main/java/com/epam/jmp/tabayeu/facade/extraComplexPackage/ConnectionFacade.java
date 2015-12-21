package com.epam.jmp.tabayeu.facade.extraComplexPackage;

import java.sql.Connection;

/**
 * Not so complex here right?
 *
 * Clients should not know every part of our complex indian connection pooling framework.
 * @author Tsimur_Abayeu
 *
 */
public interface ConnectionFacade {

    Connection getConnection();

    void closeConection(Connection connection);
}
