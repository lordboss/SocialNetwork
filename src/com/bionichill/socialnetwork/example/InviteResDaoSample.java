package com.bionichill.socialnetwork.example;

import com.bionichill.socialnetwork.dao.IInviteResDao;
import com.bionichill.socialnetwork.dto.InviteRes;
import com.bionichill.socialnetwork.factory.InviteResDaoFactory;


public class InviteResDaoSample {
    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
	// Uncomment one of the lines below to test the generated code

	// findAll();
	// findWhereInviteResEquals("");
    }

    /**
     * Method 'findAll'
     * 
     */
    public static void findAll() {
	try {
	    IInviteResDao _dao = getInviteResDao();
	    InviteRes _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereInviteResEquals'
     * 
     * @param inviteRes
     */
    public static void findWhereInviteResEquals(String inviteRes) {
	try {
	    IInviteResDao _dao = getInviteResDao();
	    InviteRes _result[] = _dao.findWhereInviteResEquals(inviteRes);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'getInviteResDao'
     * 
     * @return InviteResDao
     */
    public static IInviteResDao getInviteResDao() {
	return InviteResDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(InviteRes dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getInviteRes());
	System.out.println(buf.toString());
    }

}
