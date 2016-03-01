package com.epam.jmp.tabayeu.facade.extraComplexPackage;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.tabayeu.facade.extraComplexPackage.hardcoreIndianPool.JdbcConnectionPool;

/**
 * A kind of hardcore processing happens here. Connection facade is responsible
 * for hiding all this Indian extra stuff under the hood.
 * @author Tsimur_Abayeu
 *
 */
public class IndianConnectionFacade implements ConnectionFacade {

    private Singer singer;

    private JdbcConnectionPool connectionPool;
    
    private List<Dancer> dancers;

    public IndianConnectionFacade() {
        super();
        singer = new Singer();
        dancers = new ArrayList<Dancer>();
        for (int index = 0; index < 50000; index++) {
            dancers.add(new Dancer());
        }
        JdbcConnectionPool connectionPool = new JdbcConnectionPool();
        // Oh no, by the way we've just broken the singleton 
        new JdbcConnectionPool();
        new JdbcConnectionPool();
    }

    // Marking it as synchronized to emphasize complexity of our framework.
    private synchronized void dance() {
        for (Dancer dancer : dancers) {
            // Calling static method here in sweet Indian style
            // dil dil dil aavaaraa dil kahe chal karein aavaaragii
            dancer.dance();
        }
    }
    
    public Connection getConnection() {
        dance();
        singer.singNiceIndianSong();
        dance();
        dance();
        return connectionPool.getConnectionFromPool();
    }

    public void closeConection(Connection connection) {
        dance();
        singer.singNiceIndianSong();
        dance();
        dance();
        dance();
        singer.singNiceIndianSong();
        dance();
        dance();
        singer.singNiceIndianSong();
        connectionPool.returnConnectionToPool(connection);
    }

}
