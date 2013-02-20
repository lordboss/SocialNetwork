package com.bionichill.socialnetwork.example;

import java.util.Date;

import com.bionichill.socialnetwork.dao.IFriendshDao;
import com.bionichill.socialnetwork.dto.Friendsh;
import com.bionichill.socialnetwork.factory.FriendshDaoFactory;


public class FriendshDaoSample {
    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
	// Uncomment one of the lines below to test the generated code

	// findAll();
	// findByInvite(null);
	// findByFriendshStatus("");
	// findByFriendFrom("");
	// findByFriendTo("");
	// findWhereIdFriendshEquals(null);
	// findWhereFriendFromEquals("");
	// findWhereFriendToEquals("");
	// findWhereStatusFriendshEquals("");
	// findWhereInviteIdEquals(null);
	// findWhereFriendshDateEquals(null);
    }

    /**
     * Method 'findAll'
     * 
     */
    public static void findAll() {
	try {
	    IFriendshDao _dao = getFriendshDao();
	    Friendsh _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByInvite'
     * 
     * @param inviteId
     */
    public static void findByInvite(Integer inviteId) {
	try {
	    IFriendshDao _dao = getFriendshDao();
	    Friendsh _result[] = _dao.findByInvite(inviteId);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByFriendshStatus'
     * 
     * @param statusFriendsh
     */
    public static void findByFriendshStatus(String statusFriendsh) {
	try {
	    IFriendshDao _dao = getFriendshDao();
	    Friendsh _result[] = _dao.findByFriendshStatus(statusFriendsh);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByFriendFrom'
     * 
     * @param friendFrom
     */
    public static void findByFriendFrom(String friendFrom) {
	try {
	    IFriendshDao _dao = getFriendshDao();
	    Friendsh _result[] = _dao.findByFriendFrom(friendFrom);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByFriendTo'
     * 
     * @param friendTo
     */
    public static void findByFriendTo(String friendTo) {
	try {
	    IFriendshDao _dao = getFriendshDao();
	    Friendsh _result[] = _dao.findByFriendTo(friendTo);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereIdFriendshEquals'
     * 
     * @param idFriendsh
     */
    public static void findWhereIdFriendshEquals(Integer idFriendsh) {
	try {
	    IFriendshDao _dao = getFriendshDao();
	    Friendsh _result[] = _dao.findWhereIdFriendshEquals(idFriendsh);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereFriendFromEquals'
     * 
     * @param friendFrom
     */
    public static void findWhereFriendFromEquals(String friendFrom) {
	try {
	    IFriendshDao _dao = getFriendshDao();
	    Friendsh _result[] = _dao.findWhereFriendFromEquals(friendFrom);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereFriendToEquals'
     * 
     * @param friendTo
     */
    public static void findWhereFriendToEquals(String friendTo) {
	try {
	    IFriendshDao _dao = getFriendshDao();
	    Friendsh _result[] = _dao.findWhereFriendToEquals(friendTo);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereStatusFriendshEquals'
     * 
     * @param statusFriendsh
     */
    public static void findWhereStatusFriendshEquals(String statusFriendsh) {
	try {
	    IFriendshDao _dao = getFriendshDao();
	    Friendsh _result[] = _dao
		    .findWhereStatusFriendshEquals(statusFriendsh);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereInviteIdEquals'
     * 
     * @param inviteId
     */
    public static void findWhereInviteIdEquals(Integer inviteId) {
	try {
	    IFriendshDao _dao = getFriendshDao();
	    Friendsh _result[] = _dao.findWhereInviteIdEquals(inviteId);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereFriendshDateEquals'
     * 
     * @param friendshDate
     */
    public static void findWhereFriendshDateEquals(Date friendshDate) {
	try {
	    IFriendshDao _dao = getFriendshDao();
	    Friendsh _result[] = _dao.findWhereFriendshDateEquals(friendshDate);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'getFriendshDao'
     * 
     * @return FriendshDao
     */
    public static IFriendshDao getFriendshDao() {
	return FriendshDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(Friendsh dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getIdFriendsh());
	buf.append(", ");
	buf.append(dto.getFriendFrom());
	buf.append(", ");
	buf.append(dto.getFriendTo());
	buf.append(", ");
	buf.append(dto.getStatusFriendsh());
	buf.append(", ");
	buf.append(dto.getInvite());
	buf.append(", ");
	buf.append(dto.getFriendshDate());
	System.out.println(buf.toString());
    }

}
