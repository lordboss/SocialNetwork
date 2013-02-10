package ua.bionichill.socialnetwork.factory;

import java.sql.Connection;

import ua.bionichill.socialnetwork.dao.UStatusDao;
import ua.bionichill.socialnetwork.daoimpl.UStatusDaoImpl;

public class UStatusDaoFactory {
    /**
     * Method 'create'
     * 
     * @return UStatusDao
     */
    public static UStatusDao create() {
	return new UStatusDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return UStatusDao
     */
    public static UStatusDao create(Connection conn) {
	return new UStatusDaoImpl(conn);
    }

}
