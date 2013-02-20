package com.bionichill.socialnetwork.dto;

import java.io.Serializable;

public class UStatus implements Serializable {
    /**
     * This attribute maps to the column ustatus in the ustatus table.
     */
    private String uStatus;

    /**
     * Method 'UStatus'
     * 
     */
    public UStatus() {
    }

    /**
     * Method 'getUStatus'
     * 
     * @return String
     */
    public String getUStatus() {
	return uStatus;
    }

    /**
     * Method 'setUStatus'
     * 
     * @param uStatus
     */
    public void setUStatus(String uStatus) {
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

	if (!(_other instanceof UStatus)) {
	    return false;
	}

	final UStatus _cast = (UStatus) _other;
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
     * Method 'createPk'
     * 
     * @return UStatusPk
     */
    public UStatusPk createPk() {
	return new UStatusPk(uStatus);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.UStatus: ");
	ret.append("uStatus=" + uStatus);
	return ret.toString();
    }

}
