package ua.bionichill.socialnetwork.example;

import ua.bionichill.socialnetwork.dao.MsgTypeDao;
import ua.bionichill.socialnetwork.dto.MsgType;
import ua.bionichill.socialnetwork.factory.MsgTypeDaoFactory;

public class MsgTypeDaoSample {
    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
	// Uncomment one of the lines below to test the generated code

	// findAll();
	// findWhereMsgTypeEquals("");
    }

    /**
     * Method 'findAll'
     * 
     */
    public static void findAll() {
	try {
	    MsgTypeDao _dao = getMsgTypeDao();
	    MsgType _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereMsgTypeEquals'
     * 
     * @param msgType
     */
    public static void findWhereMsgTypeEquals(String msgType) {
	try {
	    MsgTypeDao _dao = getMsgTypeDao();
	    MsgType _result[] = _dao.findWhereMsgTypeEquals(msgType);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'getMsgTypeDao'
     * 
     * @return MsgTypeDao
     */
    public static MsgTypeDao getMsgTypeDao() {
	return MsgTypeDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(MsgType dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getMsgType());
	System.out.println(buf.toString());
    }

}
