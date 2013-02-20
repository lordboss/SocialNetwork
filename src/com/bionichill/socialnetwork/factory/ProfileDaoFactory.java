package com.bionichill.socialnetwork.factory;

import java.sql.Connection;

import com.bionichill.socialnetwork.dao.IProfileDao;
import com.bionichill.socialnetwork.daoimpl.ProfileDaoImpl;


public class ProfileDaoFactory {
    /**
     * Method 'create'
     * 
     * @return ProfileDao
     */
    public static IProfileDao create() {
	return new ProfileDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return ProfileDao
     */
    public static IProfileDao create(Connection conn) {
	return new ProfileDaoImpl(conn);
    }

}
