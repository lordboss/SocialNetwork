package ua.bionichill.socialnetwork.exceptions;

public class UStatusDaoException extends DaoException {
    /**
     * Method 'UStatusDaoException'
     * 
     * @param message
     */
    public UStatusDaoException(String message) {
	super(message);
    }

    /**
     * Method 'UStatusDaoException'
     * 
     * @param message
     * @param cause
     */
    public UStatusDaoException(String message, Throwable cause) {
	super(message, cause);
    }

}
