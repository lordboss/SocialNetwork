package com.bionichill.socialnetwork.factory;

import java.sql.Connection;

import com.bionichill.socialnetwork.dao.IMsgStatusDao;
import com.bionichill.socialnetwork.daoimpl.MsgStatusDaoImpl;


public class MsgStatusDaoFactory {
    /**
     * Method 'create'
     * 
     * @return MsgStatusDao
     */
    public static IMsgStatusDao create() {
	return new MsgStatusDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return MsgStatusDao
     */
    public static IMsgStatusDao create(Connection conn) {
	return new MsgStatusDaoImpl(conn);
    }

}
