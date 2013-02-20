package com.bionichill.socialnetwork.factory;

import java.sql.Connection;

import com.bionichill.socialnetwork.dao.IFriendshStatusDao;
import com.bionichill.socialnetwork.daoimpl.FriendshStatusDaoImpl;


public class FriendshStatusDaoFactory {
    /**
     * Method 'create'
     * 
     * @return FriendshStatusDao
     */
    public static IFriendshStatusDao create() {
	return new FriendshStatusDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return FriendshStatusDao
     */
    public static IFriendshStatusDao create(Connection conn) {
	return new FriendshStatusDaoImpl(conn);
    }

}
