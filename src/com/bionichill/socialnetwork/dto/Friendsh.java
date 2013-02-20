package com.bionichill.socialnetwork.dto;

import java.io.Serializable;
import java.util.Date;

public class Friendsh implements Serializable {
    /**
     * This attribute maps to the column idfriendsh in the friendsh table.
     */
    private Integer idFriendsh;

    /**
     * This attribute maps to the column friendfrom in the friendsh table.
     */
    private User friendFrom;

    /**
     * This attribute maps to the column friendto in the friendsh table.
     */
    private User friendTo;

    /**
     * This attribute maps to the column statusfriendsh in the friendsh table.
     */
    private FriendshStatus statusFriendsh;

    /**
     * This attribute maps to the column inviteid in the friendsh table.
     */
    private Invite invite;

    /**
     * This attribute maps to the column friendshdate in the friendsh table.
     */
    private Date friendshDate;

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
     * @return User
     */
    public User getFriendFrom() {
	return friendFrom;
    }

    /**
     * Method 'setFriendFrom'
     * 
     * @param friendFrom
     */
    public void setFriendFrom(User friendFrom) {
	this.friendFrom = friendFrom;
    }

    /**
     * Method 'getFriendTo'
     * 
     * @return User
     */
    public User getFriendTo() {
	return friendTo;
    }

    /**
     * Method 'setFriendTo'
     * 
     * @param friendTo
     */
    public void setFriendTo(User friendTo) {
	this.friendTo = friendTo;
    }

    /**
     * Method 'getStatusFriendsh'
     * 
     * @return FriendshStatus
     */
    public FriendshStatus getStatusFriendsh() {
	return statusFriendsh;
    }

    /**
     * Method 'setStatusFriendsh'
     * 
     * @param statusFriendsh
     */
    public void setStatusFriendsh(FriendshStatus statusFriendsh) {
	this.statusFriendsh = statusFriendsh;
    }

    /**
     * Method 'getInvite'
     * 
     * @return Invite
     */
    public Invite getInvite() {
	return invite;
    }

    /**
     * Method 'setInvite'
     * 
     * @param invite
     */
    public void setInvite(Invite invite) {
	this.invite = invite;
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

	if (invite == null ? _cast.invite != invite : !invite
		.equals(_cast.invite)) {
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

	if (invite != null) {
	    _hashCode = 29 * _hashCode + invite.hashCode();
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
	ret.append(", friendFrom=" + friendFrom.toString());
	ret.append(", friendTo=" + friendTo.toString());
	ret.append(", statusFriendsh=" + statusFriendsh.toString());
	ret.append(", inviteId=" + invite.toString());
	ret.append(", friendshDate=" + friendshDate);
	return ret.toString();
    }

}
