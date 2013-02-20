package com.bionichill.socialnetwork.dto;

import java.io.Serializable;

/**
 * This class represents the primary key of the friendshstatus table.
 */
public class FriendshStatusPk implements Serializable {
    private String friendshStatus;

    /**
     * Sets the value of friendshStatus
     */
    public void setFriendshStatus(String friendshStatus) {
	this.friendshStatus = friendshStatus;
    }

    /**
     * Gets the value of friendshStatus
     */
    public String getFriendshStatus() {
	return friendshStatus;
    }

    /**
     * Method 'FriendshStatusPk'
     * 
     */
    public FriendshStatusPk() {
    }

    /**
     * Method 'FriendshStatusPk'
     * 
     * @param friendshStatus
     */
    public FriendshStatusPk(final String friendshStatus) {
	this.friendshStatus = friendshStatus;
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

	if (!(_other instanceof FriendshStatusPk)) {
	    return false;
	}

	final FriendshStatusPk _cast = (FriendshStatusPk) _other;
	if (friendshStatus == null ? _cast.friendshStatus != friendshStatus
		: !friendshStatus.equals(_cast.friendshStatus)) {
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
	if (friendshStatus != null) {
	    _hashCode = 29 * _hashCode + friendshStatus.hashCode();
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
	ret.append("ua.bionichill.socialnetwork.dto.FriendshStatusPk: ");
	ret.append("friendshStatus=" + friendshStatus);
	return ret.toString();
    }

}
