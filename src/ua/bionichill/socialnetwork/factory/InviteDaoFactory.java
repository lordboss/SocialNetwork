package ua.bionichill.socialnetwork.factory;

import java.sql.Connection;

import ua.bionichill.socialnetwork.dao.InviteDao;
import ua.bionichill.socialnetwork.daoimpl.InviteDaoImpl;

public class InviteDaoFactory {
    /**
     * Method 'create'
     * 
     * @return InviteDao
     */
    public static InviteDao create() {
	return new InviteDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return InviteDao
     */
    public static InviteDao create(Connection conn) {
	return new InviteDaoImpl(conn);
    }

}
