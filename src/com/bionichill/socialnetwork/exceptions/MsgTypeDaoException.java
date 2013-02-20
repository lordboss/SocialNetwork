package com.bionichill.socialnetwork.exceptions;

public class MsgTypeDaoException extends DaoException {
    /**
     * Method 'MsgTypeDaoException'
     * 
     * @param message
     */
    public MsgTypeDaoException(String message) {
	super(message);
    }

    /**
     * Method 'MsgTypeDaoException'
     * 
     * @param message
     * @param cause
     */
    public MsgTypeDaoException(String message, Throwable cause) {
	super(message, cause);
    }

}
