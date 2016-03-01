package com.epam.jmp.tabayeu.facade.extraComplexPackage.hardcoreIndianPool;

import java.sql.SQLException;

public class DataSource {

 static JdbcConnectionPool pool = new JdbcConnectionPool();

 public static Connection getConnection() throws ClassNotFoundException, SQLException{
  Connection connection = pool.getConnectionFromPool();
  return connection;
 }

 public static void returnConnection(Connection connection) {
  pool.returnConnectionToPool(connection);
 }
}