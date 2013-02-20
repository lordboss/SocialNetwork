package com.bionichill.socialnetwork.factory;

import java.sql.Connection;

import com.bionichill.socialnetwork.dao.IFriendshDao;
import com.bionichill.socialnetwork.daoimpl.FriendshDaoImpl;


public class FriendshDaoFactory {
    /**
     * Method 'create'
     * 
     * @return FriendshDao
     */
    public static IFriendshDao create() {
	return new FriendshDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return FriendshDao
     */
    public static IFriendshDao create(Connection conn) {
	return new FriendshDaoImpl(conn);
    }

}
