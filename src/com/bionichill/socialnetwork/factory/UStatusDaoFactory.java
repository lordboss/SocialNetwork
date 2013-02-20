package com.bionichill.socialnetwork.factory;

import java.sql.Connection;

import com.bionichill.socialnetwork.dao.IUStatusDao;
import com.bionichill.socialnetwork.daoimpl.UStatusDaoImpl;


public class UStatusDaoFactory {
    /**
     * Method 'create'
     * 
     * @return UStatusDao
     */
    public static IUStatusDao create() {
	return new UStatusDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return UStatusDao
     */
    public static IUStatusDao create(Connection conn) {
	return new UStatusDaoImpl(conn);
    }

}
