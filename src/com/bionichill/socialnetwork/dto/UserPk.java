package com.bionichill.socialnetwork.dto;

import java.io.Serializable;

/**
 * This class represents the primary key of the user table.
 */
public class UserPk implements Serializable {
    private String email;

    /**
     * Sets the value of email
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * Gets the value of email
     */
    public String getEmail() {
	return email;
    }

    /**
     * Method 'UserPk'
     * 
     */
    public UserPk() {
    }

    /**
     * Method 'UserPk'
     * 
     * @param email
     */
    public UserPk(final String email) {
	this.email = email;
    }

    /**
     * Method 'equals'
     * 
     * @param _other
     * @return boolean
     */
    public boolean equals(Object _other) {
	if (_other == null) {
	    return false;
	}

	if (_other == this) {
	    return true;
	}

	if (!(_other instanceof UserPk)) {
	    return false;
	}

	final UserPk _cast = (UserPk) _other;
	if (email == null ? _cast.email != email : !email.equals(_cast.email)) {
	    return false;
	}

	return true;
    }

    /**
     * Method 'hashCode'
     * 
     * @return int
     */
    public int hashCode() {
	int _hashCode = 0;
	if (email != null) {
	    _hashCode = 29 * _hashCode + email.hashCode();
	}

	return _hashCode;
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.UserPk: ");
	ret.append("email=" + email);
	return ret.toString();
    }

}
