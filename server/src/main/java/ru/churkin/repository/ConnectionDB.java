package ru.churkin.repository;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import ru.churkin.entity.Project;
import ru.churkin.entity.Task;
import ru.churkin.entity.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

public class ConnectionDB {

    public EntityManagerFactory getEntityManagerFactory() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TASKList");
        return entityManagerFactory;
    }

//
//    public static final String DRIVER = "com.mysql.jdbc.Driver";
//    public static final String URL = "jdbc:mysql://localhost:3306/tasklistdb";
//    public static final String DB_USER_NAME = "root";
//    public static final String DB_PASSWORD = "root";
//

//    private Connection connection = null;
//
//    public Connection getConnection() throws SQLException {
//        try {
//            Class.forName(DRIVER);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        connection = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD);
//        return connection;
//    }
//
//    public void closeConnection() throws SQLException {
//        connection.close();
//    }



}
