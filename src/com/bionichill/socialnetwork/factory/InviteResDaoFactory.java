package com.bionichill.socialnetwork.factory;

import java.sql.Connection;

import com.bionichill.socialnetwork.dao.IInviteResDao;
import com.bionichill.socialnetwork.daoimpl.InviteResDaoImpl;


public class InviteResDaoFactory {
    /**
     * Method 'create'
     * 
     * @return InviteResDao
     */
    public static IInviteResDao create() {
	return new InviteResDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return InviteResDao
     */
    public static IInviteResDao create(Connection conn) {
	return new InviteResDaoImpl(conn);
    }

}
