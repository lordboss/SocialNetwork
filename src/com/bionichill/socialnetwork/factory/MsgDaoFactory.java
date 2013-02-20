package com.bionichill.socialnetwork.factory;

import java.sql.Connection;

import com.bionichill.socialnetwork.dao.IMsgDao;
import com.bionichill.socialnetwork.daoimpl.MsgDaoImpl;


public class MsgDaoFactory {
    /**
     * Method 'create'
     * 
     * @return MsgDao
     */
    public static IMsgDao create() {
	return new MsgDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return MsgDao
     */
    public static IMsgDao create(Connection conn) {
	return new MsgDaoImpl(conn);
    }

}
