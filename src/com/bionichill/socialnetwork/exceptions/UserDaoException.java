package com.bionichill.socialnetwork.exceptions;

public class UserDaoException extends DaoException {
    /**
     * Method 'UserDaoException'
     * 
     * @param message
     */
    public UserDaoException(String message) {
	super(message);
    }

    /**
     * Method 'UserDaoException'
     * 
     * @param message
     * @param cause
     */
    public UserDaoException(String message, Throwable cause) {
	super(message, cause);
    }

}
