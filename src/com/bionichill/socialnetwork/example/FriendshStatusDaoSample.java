package com.bionichill.socialnetwork.example;

import com.bionichill.socialnetwork.dao.IFriendshStatusDao;
import com.bionichill.socialnetwork.dto.FriendshStatus;
import com.bionichill.socialnetwork.factory.FriendshStatusDaoFactory;


public class FriendshStatusDaoSample {
    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
	// Uncomment one of the lines below to test the generated code

	findAll();
	// findWhereFriendshStatusEquals("");
    }

    /**
     * Method 'findAll'
     * 
     */
    public static void findAll() {
	try {
	    IFriendshStatusDao _dao = getFriendshStatusDao();
	    FriendshStatus _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereFriendshStatusEquals'
     * 
     * @param friendshStatus
     */
    public static void findWhereFriendshStatusEquals(String friendshStatus) {
	try {
	    IFriendshStatusDao _dao = getFriendshStatusDao();
	    FriendshStatus _result[] = _dao
		    .findWhereFriendshStatusEquals(friendshStatus);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'getFriendshStatusDao'
     * 
     * @return FriendshStatusDao
     */
    public static IFriendshStatusDao getFriendshStatusDao() {
	return FriendshStatusDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(FriendshStatus dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getFriendshStatus());
	System.out.println(buf.toString());
    }

}
