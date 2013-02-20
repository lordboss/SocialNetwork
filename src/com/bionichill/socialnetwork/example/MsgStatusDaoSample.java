package com.bionichill.socialnetwork.example;

import com.bionichill.socialnetwork.dao.IMsgStatusDao;
import com.bionichill.socialnetwork.dto.MsgStatus;
import com.bionichill.socialnetwork.factory.MsgStatusDaoFactory;


public class MsgStatusDaoSample {
    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
	// Uncomment one of the lines below to test the generated code

	// findAll();
	// findWhereMsgStatusEquals("");
    }

    /**
     * Method 'findAll'
     * 
     */
    public static void findAll() {
	try {
	    IMsgStatusDao _dao = getMsgStatusDao();
	    MsgStatus _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereMsgStatusEquals'
     * 
     * @param msgStatus
     */
    public static void findWhereMsgStatusEquals(String msgStatus) {
	try {
	    IMsgStatusDao _dao = getMsgStatusDao();
	    MsgStatus _result[] = _dao.findWhereMsgStatusEquals(msgStatus);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'getMsgStatusDao'
     * 
     * @return MsgStatusDao
     */
    public static IMsgStatusDao getMsgStatusDao() {
	return MsgStatusDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(MsgStatus dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getMsgStatus());
	System.out.println(buf.toString());
    }

}
