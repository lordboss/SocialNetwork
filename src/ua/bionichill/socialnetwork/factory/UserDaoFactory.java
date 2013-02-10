package ua.bionichill.socialnetwork.factory;

import java.sql.Connection;

import ua.bionichill.socialnetwork.dao.UserDao;
import ua.bionichill.socialnetwork.daoimpl.UserDaoImpl;

public class UserDaoFactory {
    /**
     * Method 'create'
     * 
     * @return UserDao
     */
    public static UserDao create() {
	return new UserDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return UserDao
     */
    public static UserDao create(Connection conn) {
	return new UserDaoImpl(conn);
    }

}
