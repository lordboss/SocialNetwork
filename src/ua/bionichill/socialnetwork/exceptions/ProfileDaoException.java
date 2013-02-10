package ua.bionichill.socialnetwork.exceptions;

public class ProfileDaoException extends DaoException {
    /**
     * Method 'ProfileDaoException'
     * 
     * @param message
     */
    public ProfileDaoException(String message) {
	super(message);
    }

    /**
     * Method 'ProfileDaoException'
     * 
     * @param message
     * @param cause
     */
    public ProfileDaoException(String message, Throwable cause) {
	super(message, cause);
    }

}
