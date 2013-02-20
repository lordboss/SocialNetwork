package com.bionichill.socialnetwork.dto;

import java.io.Serializable;

public class InviteRes implements Serializable {
    /**
     * This attribute maps to the column inviteres in the inviteres table.
     */
    private String inviteRes;

    /**
     * Method 'InviteRes'
     * 
     */
    public InviteRes() {
    }

    /**
     * Method 'getInviteRes'
     * 
     * @return String
     */
    public String getInviteRes() {
	return inviteRes;
    }

    /**
     * Method 'setInviteRes'
     * 
     * @param inviteRes
     */
    public void setInviteRes(String inviteRes) {
	this.inviteRes = inviteRes;
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

	if (!(_other instanceof InviteRes)) {
	    return false;
	}

	final InviteRes _cast = (InviteRes) _other;
	if (inviteRes == null ? _cast.inviteRes != inviteRes : !inviteRes
		.equals(_cast.inviteRes)) {
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
	if (inviteRes != null) {
	    _hashCode = 29 * _hashCode + inviteRes.hashCode();
	}

	return _hashCode;
    }

    /**
     * Method 'createPk'
     * 
     * @return InviteResPk
     */
    public InviteResPk createPk() {
	return new InviteResPk(inviteRes);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.InviteRes: ");
	ret.append("inviteRes=" + inviteRes);
	return ret.toString();
    }

}
