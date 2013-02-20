package com.bionichill.socialnetwork.factory;

import java.sql.Connection;

import com.bionichill.socialnetwork.dao.IUserDao;
import com.bionichill.socialnetwork.daoimpl.UserDaoImpl;


public class UserDaoFactory {
    /**
     * Method 'create'
     * 
     * @return UserDao
     */
    public static IUserDao create() {
	return new UserDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return UserDao
     */
    public static IUserDao create(Connection conn) {
	return new UserDaoImpl(conn);
    }

}
