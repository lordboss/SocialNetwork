package ua.bionichill.socialnetwork.factory;

import java.sql.Connection;

import ua.bionichill.socialnetwork.dao.FriendshStatusDao;
import ua.bionichill.socialnetwork.daoimpl.FriendshStatusDaoImpl;

public class FriendshStatusDaoFactory {
    /**
     * Method 'create'
     * 
     * @return FriendshStatusDao
     */
    public static FriendshStatusDao create() {
	return new FriendshStatusDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return FriendshStatusDao
     */
    public static FriendshStatusDao create(Connection conn) {
	return new FriendshStatusDaoImpl(conn);
    }

}
