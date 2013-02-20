package com.bionichill.socialnetwork.factory;

import java.sql.Connection;

import com.bionichill.socialnetwork.dao.IInviteDao;
import com.bionichill.socialnetwork.daoimpl.InviteDaoImpl;


public class InviteDaoFactory {
    /**
     * Method 'create'
     * 
     * @return InviteDao
     */
    public static IInviteDao create() {
	return new InviteDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return InviteDao
     */
    public static IInviteDao create(Connection conn) {
	return new InviteDaoImpl(conn);
    }

}
