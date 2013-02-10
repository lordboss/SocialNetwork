package ua.bionichill.socialnetwork.dto;

import java.io.Serializable;

/**
 * This class represents the primary key of the friendsh table.
 */
public class FriendshPk implements Serializable {
    protected Integer idFriendsh;

    /**
     * Sets the value of idFriendsh
     */
    public void setIdFriendsh(Integer idFriendsh) {
	this.idFriendsh = idFriendsh;
    }

    /**
     * Gets the value of idFriendsh
     */
    public Integer getIdFriendsh() {
	return idFriendsh;
    }

    /**
     * Method 'FriendshPk'
     * 
     */
    public FriendshPk() {
    }

    /**
     * Method 'FriendshPk'
     * 
     * @param idFriendsh
     */
    public FriendshPk(final Integer idFriendsh) {
	this.idFriendsh = idFriendsh;
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

	if (!(_other instanceof FriendshPk)) {
	    return false;
	}

	final FriendshPk _cast = (FriendshPk) _other;
	if (idFriendsh == null ? _cast.idFriendsh != idFriendsh : !idFriendsh
		.equals(_cast.idFriendsh)) {
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

	return _hashCode;
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.FriendshPk: ");
	ret.append("idFriendsh=" + idFriendsh);
	return ret.toString();
    }

}
