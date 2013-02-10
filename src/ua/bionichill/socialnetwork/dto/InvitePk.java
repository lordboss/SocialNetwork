package ua.bionichill.socialnetwork.dto;

import java.io.Serializable;

/**
 * This class represents the primary key of the invite table.
 */
public class InvitePk implements Serializable {
    protected Integer idInvite;

    /**
     * Sets the value of idInvite
     */
    public void setIdInvite(Integer idInvite) {
	this.idInvite = idInvite;
    }

    /**
     * Gets the value of idInvite
     */
    public Integer getIdInvite() {
	return idInvite;
    }

    /**
     * Method 'InvitePk'
     * 
     */
    public InvitePk() {
    }

    /**
     * Method 'InvitePk'
     * 
     * @param idInvite
     */
    public InvitePk(final Integer idInvite) {
	this.idInvite = idInvite;
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

	if (!(_other instanceof InvitePk)) {
	    return false;
	}

	final InvitePk _cast = (InvitePk) _other;
	if (idInvite == null ? _cast.idInvite != idInvite : !idInvite
		.equals(_cast.idInvite)) {
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

	return _hashCode;
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.InvitePk: ");
	ret.append("idInvite=" + idInvite);
	return ret.toString();
    }

}
