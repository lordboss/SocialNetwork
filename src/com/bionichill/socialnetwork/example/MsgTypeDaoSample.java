package com.bionichill.socialnetwork.example;

import com.bionichill.socialnetwork.dao.IMsgTypeDao;
import com.bionichill.socialnetwork.dto.MsgType;
import com.bionichill.socialnetwork.factory.MsgTypeDaoFactory;


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
	    IMsgTypeDao _dao = getMsgTypeDao();
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
	    IMsgTypeDao _dao = getMsgTypeDao();
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
    public static IMsgTypeDao getMsgTypeDao() {
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
