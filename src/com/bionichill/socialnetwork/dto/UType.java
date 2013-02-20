package com.bionichill.socialnetwork.dto;

import java.io.Serializable;

public class UType implements Serializable {
    /**
     * This attribute maps to the column utype in the utype table.
     */
    private String uType;

    /**
     * Method 'UType'
     * 
     */
    public UType() {
    }

    /**
     * Method 'getUType'
     * 
     * @return String
     */
    public String getUType() {
	return uType;
    }

    /**
     * Method 'setUType'
     * 
     * @param uType
     */
    public void setUType(String uType) {
	this.uType = uType;
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

	if (!(_other instanceof UType)) {
	    return false;
	}

	final UType _cast = (UType) _other;
	if (uType == null ? _cast.uType != uType : !uType.equals(_cast.uType)) {
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
	if (uType != null) {
	    _hashCode = 29 * _hashCode + uType.hashCode();
	}

	return _hashCode;
    }

    /**
     * Method 'createPk'
     * 
     * @return UTypePk
     */
    public UTypePk createPk() {
	return new UTypePk(uType);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.UType: ");
	ret.append("uType=" + uType);
	return ret.toString();
    }

}
