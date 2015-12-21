package com.epam.jmp.tabayeu.facade;

import com.epam.jmp.tabayeu.facade.extraComplexPackage.ConnectionFacade;
import com.epam.jmp.tabayeu.facade.extraComplexPackage.IndianConnectionFacade;

/**
 * Don't needs all extra complexity of the package. It just retrieves connection and closes it.
 * @author Tsimur_Abayeu
 *
 */
public class Client {

    private ConnectionFacade facade;

    public Client() {
        super();
        facade = new IndianConnectionFacade();
    }

    public void use() {
        facade.closeConection(facade.getConnection());
    }
}
