package ua.bionichill.socialnetwork.dto;

import java.io.Serializable;

public class FriendshStatus implements Serializable {
    /**
     * This attribute maps to the column friendshstatus in the friendshstatus
     * table.
     */
    protected String friendshStatus;

    /**
     * Method 'FriendshStatus'
     * 
     */
    public FriendshStatus() {
    }

    /**
     * Method 'getFriendshStatus'
     * 
     * @return String
     */
    public String getFriendshStatus() {
	return friendshStatus;
    }

    /**
     * Method 'setFriendshStatus'
     * 
     * @param friendshStatus
     */
    public void setFriendshStatus(String friendshStatus) {
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

	if (!(_other instanceof FriendshStatus)) {
	    return false;
	}

	final FriendshStatus _cast = (FriendshStatus) _other;
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
     * Method 'createPk'
     * 
     * @return FriendshStatusPk
     */
    public FriendshStatusPk createPk() {
	return new FriendshStatusPk(friendshStatus);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.FriendshStatus: ");
	ret.append("friendshStatus=" + friendshStatus);
	return ret.toString();
    }

}
