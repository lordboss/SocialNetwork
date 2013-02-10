package ua.bionichill.socialnetwork.factory;

import java.sql.Connection;

import ua.bionichill.socialnetwork.dao.InviteResDao;
import ua.bionichill.socialnetwork.daoimpl.InviteResDaoImpl;

public class InviteResDaoFactory {
    /**
     * Method 'create'
     * 
     * @return InviteResDao
     */
    public static InviteResDao create() {
	return new InviteResDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return InviteResDao
     */
    public static InviteResDao create(Connection conn) {
	return new InviteResDaoImpl(conn);
    }

}
