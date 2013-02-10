package ua.bionichill.socialnetwork.factory;

import java.sql.Connection;

import ua.bionichill.socialnetwork.dao.MsgStatusDao;
import ua.bionichill.socialnetwork.daoimpl.MsgStatusDaoImpl;

public class MsgStatusDaoFactory {
    /**
     * Method 'create'
     * 
     * @return MsgStatusDao
     */
    public static MsgStatusDao create() {
	return new MsgStatusDaoImpl();
    }

    /**
     * Method 'create'
     * 
     * @param conn
     * @return MsgStatusDao
     */
    public static MsgStatusDao create(Connection conn) {
	return new MsgStatusDaoImpl(conn);
    }

}
