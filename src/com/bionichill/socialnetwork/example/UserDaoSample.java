package com.bionichill.socialnetwork.example;

import java.util.Date;

import com.bionichill.socialnetwork.dao.IUserDao;
import com.bionichill.socialnetwork.dto.User;
import com.bionichill.socialnetwork.factory.UserDaoFactory;


public class UserDaoSample {
    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
	// Uncomment one of the lines below to test the generated code

	findAll();
	// findByProfile(null);
	findByUStatus("ACTIVE");
	findByUType("REGISTERED");
	// findWhereEmailEquals("");
	// findWherePasswEquals("");
	// findWhereTypeUEquals("");
	// findWhereStatusUEquals("");
	// findWhereProfileIdEquals(null);
	// findWhereRegistrDateEquals(null);
    }

    /**
     * Method 'findAll'
     * 
     */
    public static void findAll() {
	try {
	    IUserDao _dao = getUserDao();
	    User _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByProfile'
     * 
     * @param profileId
     */
    public static void findByProfile(Integer profileId) {
	try {
	    IUserDao _dao = getUserDao();
	    User _result[] = _dao.findByProfile(profileId);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByUStatus'
     * 
     * @param statusU
     */
    public static void findByUStatus(String statusU) {
	try {
	    IUserDao _dao = getUserDao();
	    User _result[] = _dao.findByUStatus(statusU);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByUType'
     * 
     * @param typeU
     */
    public static void findByUType(String typeU) {
	try {
	    IUserDao _dao = getUserDao();
	    User _result[] = _dao.findByUType(typeU);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereEmailEquals'
     * 
     * @param email
     */
    public static void findWhereEmailEquals(String email) {
	try {
	    IUserDao _dao = getUserDao();
	    User _result[] = _dao.findWhereEmailEquals(email);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWherePasswEquals'
     * 
     * @param passw
     */
    public static void findWherePasswEquals(String passw) {
	try {
	    IUserDao _dao = getUserDao();
	    User _result[] = _dao.findWherePasswEquals(passw);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereTypeUEquals'
     * 
     * @param typeU
     */
    public static void findWhereTypeUEquals(String typeU) {
	try {
	    IUserDao _dao = getUserDao();
	    User _result[] = _dao.findWhereTypeUEquals(typeU);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereStatusUEquals'
     * 
     * @param statusU
     */
    public static void findWhereStatusUEquals(String statusU) {
	try {
	    IUserDao _dao = getUserDao();
	    User _result[] = _dao.findWhereStatusUEquals(statusU);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereProfileIdEquals'
     * 
     * @param profileId
     */
    public static void findWhereProfileIdEquals(Integer profileId) {
	try {
	    IUserDao _dao = getUserDao();
	    User _result[] = _dao.findWhereProfileIdEquals(profileId);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereRegistrDateEquals'
     * 
     * @param registrDate
     */
    public static void findWhereRegistrDateEquals(Date registrDate) {
	try {
	    IUserDao _dao = getUserDao();
	    User _result[] = _dao.findWhereRegistrDateEquals(registrDate);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'getUserDao'
     * 
     * @return UserDao
     */
    public static IUserDao getUserDao() {
	return UserDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(User dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getEmail());
	buf.append(", ");
	buf.append(dto.getPassw());
	buf.append(", ");
	buf.append(dto.getTypeU());
	buf.append(", ");
	buf.append(dto.getStatusU());
	buf.append(", ");
	buf.append(dto.getProfile());
	buf.append(", ");
	buf.append(dto.getRegistrDate());
	System.out.println(buf.toString());
    }

}
