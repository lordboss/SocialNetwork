package ua.bionichill.socialnetwork.factory;

import java.sql.Connection;

import ua.bionichill.socialnetwork.dao.UTypeDao;
import ua.bionichill.socialnetwork.daoimpl.UTypeDaoImpl;

public class UTypeDaoFactory {
    /**
     * Method 'create'
     * 
     * @return UTypeDao
     */
    public static UTypeDao create() {
	return new UTypeDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return UTypeDao
     */
    public static UTypeDao create(Connection conn) {
	return new UTypeDaoImpl(conn);
    }

}
