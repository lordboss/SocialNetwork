package com.bionichill.socialnetwork.dto;

import java.io.Serializable;

/**
 * This class represents the primary key of the ustatus table.
 */
public class UStatusPk implements Serializable {
    private String uStatus;

    /**
     * Sets the value of uStatus
     */
    public void setUStatus(String uStatus) {
	this.uStatus = uStatus;
    }

    /**
     * Gets the value of uStatus
     */
    public String getUStatus() {
	return uStatus;
    }

    /**
     * Method 'UStatusPk'
     * 
     */
    public UStatusPk() {
    }

    /**
     * Method 'UStatusPk'
     * 
     * @param uStatus
     */
    public UStatusPk(final String uStatus) {
	this.uStatus = uStatus;
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

	if (!(_other instanceof UStatusPk)) {
	    return false;
	}

	final UStatusPk _cast = (UStatusPk) _other;
	if (uStatus == null ? _cast.uStatus != uStatus : !uStatus
		.equals(_cast.uStatus)) {
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
	if (uStatus != null) {
	    _hashCode = 29 * _hashCode + uStatus.hashCode();
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
	ret.append("ua.bionichill.socialnetwork.dto.UStatusPk: ");
	ret.append("uStatus=" + uStatus);
	return ret.toString();
    }

}
