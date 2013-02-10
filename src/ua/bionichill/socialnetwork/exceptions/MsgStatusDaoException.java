package ua.bionichill.socialnetwork.exceptions;

public class MsgStatusDaoException extends DaoException {
    /**
     * Method 'MsgStatusDaoException'
     * 
     * @param message
     */
    public MsgStatusDaoException(String message) {
	super(message);
    }

    /**
     * Method 'MsgStatusDaoException'
     * 
     * @param message
     * @param cause
     */
    public MsgStatusDaoException(String message, Throwable cause) {
	super(message, cause);
    }

}
