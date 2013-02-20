package com.bionichill.socialnetwork.factory;

import java.sql.Connection;

import com.bionichill.socialnetwork.dao.IMsgTypeDao;
import com.bionichill.socialnetwork.daoimpl.MsgTypeDaoImpl;


public class MsgTypeDaoFactory {
    /**
     * Method 'create'
     * 
     * @return MsgTypeDao
     */
    public static IMsgTypeDao create() {
	return new MsgTypeDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return MsgTypeDao
     */
    public static IMsgTypeDao create(Connection conn) {
	return new MsgTypeDaoImpl(conn);
    }

}
