package ua.bionichill.socialnetwork.factory;

import java.sql.Connection;

import ua.bionichill.socialnetwork.dao.FriendshDao;
import ua.bionichill.socialnetwork.daoimpl.FriendshDaoImpl;

public class FriendshDaoFactory {
    /**
     * Method 'create'
     * 
     * @return FriendshDao
     */
    public static FriendshDao create() {
	return new FriendshDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return FriendshDao
     */
    public static FriendshDao create(Connection conn) {
	return new FriendshDaoImpl(conn);
    }

}
