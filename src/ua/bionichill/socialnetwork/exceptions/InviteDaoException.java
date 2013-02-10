package ua.bionichill.socialnetwork.exceptions;

public class InviteDaoException extends DaoException {
    /**
     * Method 'InviteDaoException'
     * 
     * @param message
     */
    public InviteDaoException(String message) {
	super(message);
    }

    /**
     * Method 'InviteDaoException'
     * 
     * @param message
     * @param cause
     */
    public InviteDaoException(String message, Throwable cause) {
	super(message, cause);
    }

}
