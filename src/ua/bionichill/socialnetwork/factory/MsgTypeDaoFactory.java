package ua.bionichill.socialnetwork.factory;

import java.sql.Connection;

import ua.bionichill.socialnetwork.dao.MsgTypeDao;
import ua.bionichill.socialnetwork.daoimpl.MsgTypeDaoImpl;

public class MsgTypeDaoFactory {
    /**
     * Method 'create'
     * 
     * @return MsgTypeDao
     */
    public static MsgTypeDao create() {
	return new MsgTypeDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return MsgTypeDao
     */
    public static MsgTypeDao create(Connection conn) {
	return new MsgTypeDaoImpl(conn);
    }

}
