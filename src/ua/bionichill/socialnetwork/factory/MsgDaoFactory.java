package ua.bionichill.socialnetwork.factory;

import java.sql.Connection;

import ua.bionichill.socialnetwork.dao.MsgDao;
import ua.bionichill.socialnetwork.daoimpl.MsgDaoImpl;

public class MsgDaoFactory {
    /**
     * Method 'create'
     * 
     * @return MsgDao
     */
    public static MsgDao create() {
	return new MsgDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return MsgDao
     */
    public static MsgDao create(Connection conn) {
	return new MsgDaoImpl(conn);
    }

}
