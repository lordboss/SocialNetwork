package ua.bionichill.socialnetwork.factory;

import java.sql.Connection;

import ua.bionichill.socialnetwork.dao.ProfileDao;
import ua.bionichill.socialnetwork.daoimpl.ProfileDaoImpl;

public class ProfileDaoFactory {
    /**
     * Method 'create'
     * 
     * @return ProfileDao
     */
    public static ProfileDao create() {
	return new ProfileDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return ProfileDao
     */
    public static ProfileDao create(Connection conn) {
	return new ProfileDaoImpl(conn);
    }

}
