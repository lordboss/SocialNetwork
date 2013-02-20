package com.bionichill.socialnetwork.factory;

import java.sql.Connection;

import com.bionichill.socialnetwork.dao.IUTypeDao;
import com.bionichill.socialnetwork.daoimpl.UTypeDaoImpl;


public class UTypeDaoFactory {
    /**
     * Method 'create'
     * 
     * @return UTypeDao
     */
    public static IUTypeDao create() {
	return new UTypeDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return UTypeDao
     */
    public static IUTypeDao create(Connection conn) {
	return new UTypeDaoImpl(conn);
    }

}
