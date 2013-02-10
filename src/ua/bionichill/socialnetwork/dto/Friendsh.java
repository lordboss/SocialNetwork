package ua.bionichill.socialnetwork.dto;

import java.io.Serializable;
import java.util.Date;

public class Friendsh implements Serializable {
    /**
     * This attribute maps to the column idfriendsh in the friendsh table.
     */
    protected Integer idFriendsh;

    /**
     * This attribute maps to the column friendfrom in the friendsh table.
     */
    protected String friendFrom;

    /**
     * This attribute maps to the column friendto in the friendsh table.
     */
    protected String friendTo;

    /**
     * This attribute maps to the column statusfriendsh in the friendsh table.
     */
    protected String statusFriendsh;

    /**
     * This attribute maps to the column inviteid in the friendsh table.
     */
    protected Integer inviteId;

    /**
     * This attribute maps to the column friendshdate in the friendsh table.
     */
    protected Date friendshDate;

    /**
     * Method 'Friendsh'
     * 
     */
    public Friendsh() {
    }

    /**
     * Method 'getIdFriendsh'
     * 
     * @return Integer
     */
    public Integer getIdFriendsh() {
	return idFriendsh;
    }

    /**
     * Method 'setIdFriendsh'
     * 
     * @param idFriendsh
     */
    public void setIdFriendsh(Integer idFriendsh) {
	this.idFriendsh = idFriendsh;
    }

    /**
     * Method 'getFriendFrom'
     * 
     * @return String
     */
    public String getFriendFrom() {
	return friendFrom;
    }

    /**
     * Method 'setFriendFrom'
     * 
     * @param friendFrom
     */
    public void setFriendFrom(String friendFrom) {
	this.friendFrom = friendFrom;
    }

    /**
     * Method 'getFriendTo'
     * 
     * @return String
     */
    public String getFriendTo() {
	return friendTo;
    }

    /**
     * Method 'setFriendTo'
     * 
     * @param friendTo
     */
    public void setFriendTo(String friendTo) {
	this.friendTo = friendTo;
    }

    /**
     * Method 'getStatusFriendsh'
     * 
     * @return String
     */
    public String getStatusFriendsh() {
	return statusFriendsh;
    }

    /**
     * Method 'setStatusFriendsh'
     * 
     * @param statusFriendsh
     */
    public void setStatusFriendsh(String statusFriendsh) {
	this.statusFriendsh = statusFriendsh;
    }

    /**
     * Method 'getInviteId'
     * 
     * @return Integer
     */
    public Integer getInviteId() {
	return inviteId;
    }

    /**
     * Method 'setInviteId'
     * 
     * @param inviteId
     */
    public void setInviteId(Integer inviteId) {
	this.inviteId = inviteId;
    }

    /**
     * Method 'getFriendshDate'
     * 
     * @return Date
     */
    public Date getFriendshDate() {
	return friendshDate;
    }

    /**
     * Method 'setFriendshDate'
     * 
     * @param friendshDate
     */
    public void setFriendshDate(Date friendshDate) {
	this.friendshDate = friendshDate;
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

	if (!(_other instanceof Friendsh)) {
	    return false;
	}

	final Friendsh _cast = (Friendsh) _other;
	if (idFriendsh == null ? _cast.idFriendsh != idFriendsh : !idFriendsh
		.equals(_cast.idFriendsh)) {
	    return false;
	}

	if (friendFrom == null ? _cast.friendFrom != friendFrom : !friendFrom
		.equals(_cast.friendFrom)) {
	    return false;
	}

	if (friendTo == null ? _cast.friendTo != friendTo : !friendTo
		.equals(_cast.friendTo)) {
	    return false;
	}

	if (statusFriendsh == null ? _cast.statusFriendsh != statusFriendsh
		: !statusFriendsh.equals(_cast.statusFriendsh)) {
	    return false;
	}

	if (inviteId == null ? _cast.inviteId != inviteId : !inviteId
		.equals(_cast.inviteId)) {
	    return false;
	}

	if (friendshDate == null ? _cast.friendshDate != friendshDate
		: !friendshDate.equals(_cast.friendshDate)) {
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
	if (idFriendsh != null) {
	    _hashCode = 29 * _hashCode + idFriendsh.hashCode();
	}

	if (friendFrom != null) {
	    _hashCode = 29 * _hashCode + friendFrom.hashCode();
	}

	if (friendTo != null) {
	    _hashCode = 29 * _hashCode + friendTo.hashCode();
	}

	if (statusFriendsh != null) {
	    _hashCode = 29 * _hashCode + statusFriendsh.hashCode();
	}

	if (inviteId != null) {
	    _hashCode = 29 * _hashCode + inviteId.hashCode();
	}

	if (friendshDate != null) {
	    _hashCode = 29 * _hashCode + friendshDate.hashCode();
	}

	return _hashCode;
    }

    /**
     * Method 'createPk'
     * 
     * @return FriendshPk
     */
    public FriendshPk createPk() {
	return new FriendshPk(idFriendsh);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.Friendsh: ");
	ret.append("idFriendsh=" + idFriendsh);
	ret.append(", friendFrom=" + friendFrom);
	ret.append(", friendTo=" + friendTo);
	ret.append(", statusFriendsh=" + statusFriendsh);
	ret.append(", inviteId=" + inviteId);
	ret.append(", friendshDate=" + friendshDate);
	return ret.toString();
    }

}
