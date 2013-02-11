package ua.bionichill.socialnetwork.dto;

import java.io.Serializable;

/**
 * This class represents the primary key of the inviteres table.
 */
public class InviteResPk implements Serializable {
    private String inviteRes;

    /**
     * Sets the value of inviteRes
     */
    public void setInviteRes(String inviteRes) {
	this.inviteRes = inviteRes;
    }

    /**
     * Gets the value of inviteRes
     */
    public String getInviteRes() {
	return inviteRes;
    }

    /**
     * Method 'InviteResPk'
     * 
     */
    public InviteResPk() {
    }

    /**
     * Method 'InviteResPk'
     * 
     * @param inviteRes
     */
    public InviteResPk(final String inviteRes) {
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

	if (!(_other instanceof InviteResPk)) {
	    return false;
	}

	final InviteResPk _cast = (InviteResPk) _other;
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
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.InviteResPk: ");
	ret.append("inviteRes=" + inviteRes);
	return ret.toString();
    }

}
