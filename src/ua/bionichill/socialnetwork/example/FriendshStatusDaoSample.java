package ua.bionichill.socialnetwork.example;

import ua.bionichill.socialnetwork.dao.FriendshStatusDao;
import ua.bionichill.socialnetwork.dto.FriendshStatus;
import ua.bionichill.socialnetwork.factory.FriendshStatusDaoFactory;

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
	    FriendshStatusDao _dao = getFriendshStatusDao();
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
	    FriendshStatusDao _dao = getFriendshStatusDao();
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
    public static FriendshStatusDao getFriendshStatusDao() {
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
