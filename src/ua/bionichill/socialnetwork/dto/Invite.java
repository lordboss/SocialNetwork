package ua.bionichill.socialnetwork.dto;

import java.io.Serializable;
import java.util.Date;

public class Invite implements Serializable {
    /**
     * This attribute maps to the column idinvite in the invite table.
     */
    private Integer idInvite;

    /**
     * This attribute maps to the column inviter in the invite table.
     */
    private User inviter;

    /**
     * This attribute maps to the column invitee in the invite table.
     */
    private User invitee;

    /**
     * This attribute maps to the column res in the invite table.
     */
    private InviteRes res;

    /**
     * This attribute maps to the column invitedate in the invite table.
     */
    private Date inviteDate;

    /**
     * Method 'Invite'
     * 
     */
    public Invite() {
    }

    /**
     * Method 'getIdInvite'
     * 
     * @return Integer
     */
    public Integer getIdInvite() {
	return idInvite;
    }

    /**
     * Method 'setIdInvite'
     * 
     * @param idInvite
     */
    public void setIdInvite(Integer idInvite) {
	this.idInvite = idInvite;
    }

    /**
     * Method 'getInviter'
     * 
     * @return User
     */
    public User getInviter() {
	return inviter;
    }

    /**
     * Method 'setInviter'
     * 
     * @param inviter
     */
    public void setInviter(User inviter) {
	this.inviter = inviter;
    }

    /**
     * Method 'getInvitee'
     * 
     * @return User
     */
    public User getInvitee() {
	return invitee;
    }

    /**
     * Method 'setInvitee'
     * 
     * @param invitee
     */
    public void setInvitee(User invitee) {
	this.invitee = invitee;
    }

    /**
     * Method 'getRes'
     * 
     * @return InviteRes
     */
    public InviteRes getRes() {
	return res;
    }

    /**
     * Method 'setRes'
     * 
     * @param res
     */
    public void setRes(InviteRes res) {
	this.res = res;
    }

    /**
     * Method 'getInviteDate'
     * 
     * @return Date
     */
    public Date getInviteDate() {
	return inviteDate;
    }

    /**
     * Method 'setInviteDate'
     * 
     * @param inviteDate
     */
    public void setInviteDate(Date inviteDate) {
	this.inviteDate = inviteDate;
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

	if (!(_other instanceof Invite)) {
	    return false;
	}

	final Invite _cast = (Invite) _other;
	if (idInvite == null ? _cast.idInvite != idInvite : !idInvite
		.equals(_cast.idInvite)) {
	    return false;
	}

	if (inviter == null ? _cast.inviter != inviter : !inviter
		.equals(_cast.inviter)) {
	    return false;
	}

	if (invitee == null ? _cast.invitee != invitee : !invitee
		.equals(_cast.invitee)) {
	    return false;
	}

	if (res == null ? _cast.res != res : !res.equals(_cast.res)) {
	    return false;
	}

	if (inviteDate == null ? _cast.inviteDate != inviteDate : !inviteDate
		.equals(_cast.inviteDate)) {
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
	if (idInvite != null) {
	    _hashCode = 29 * _hashCode + idInvite.hashCode();
	}

	if (inviter != null) {
	    _hashCode = 29 * _hashCode + inviter.hashCode();
	}

	if (invitee != null) {
	    _hashCode = 29 * _hashCode + invitee.hashCode();
	}

	if (res != null) {
	    _hashCode = 29 * _hashCode + res.hashCode();
	}

	if (inviteDate != null) {
	    _hashCode = 29 * _hashCode + inviteDate.hashCode();
	}

	return _hashCode;
    }

    /**
     * Method 'createPk'
     * 
     * @return InvitePk
     */
    public InvitePk createPk() {
	return new InvitePk(idInvite);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.Invite: ");
	ret.append("idInvite=" + idInvite);
	ret.append(", inviter=" + inviter.toString());
	ret.append(", invitee=" + invitee.toString());
	ret.append(", res=" + res.toString());
	ret.append(", inviteDate=" + inviteDate);
	return ret.toString();
    }

}
