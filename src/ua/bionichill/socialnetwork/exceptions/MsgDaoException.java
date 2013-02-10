package ua.bionichill.socialnetwork.exceptions;

public class MsgDaoException extends DaoException {
    /**
     * Method 'MsgDaoException'
     * 
     * @param message
     */
    public MsgDaoException(String message) {
	super(message);
    }

    /**
     * Method 'MsgDaoException'
     * 
     * @param message
     * @param cause
     */
    public MsgDaoException(String message, Throwable cause) {
	super(message, cause);
    }

}
