package com.bionichill.socialnetwork.dto;

import java.io.Serializable;

/**
 * This class represents the primary key of the msg table.
 */
public class MsgPk implements Serializable {
    private Integer idMsg;

    /**
     * Sets the value of idMsg
     */
    public void setIdMsg(Integer idMsg) {
	this.idMsg = idMsg;
    }

    /**
     * Gets the value of idMsg
     */
    public Integer getIdMsg() {
	return idMsg;
    }

    /**
     * Method 'MsgPk'
     * 
     */
    public MsgPk() {
    }

    /**
     * Method 'MsgPk'
     * 
     * @param idMsg
     */
    public MsgPk(final Integer idMsg) {
	this.idMsg = idMsg;
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

	if (!(_other instanceof MsgPk)) {
	    return false;
	}

	final MsgPk _cast = (MsgPk) _other;
	if (idMsg == null ? _cast.idMsg != idMsg : !idMsg.equals(_cast.idMsg)) {
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
	if (idMsg != null) {
	    _hashCode = 29 * _hashCode + idMsg.hashCode();
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
	ret.append("ua.bionichill.socialnetwork.dto.MsgPk: ");
	ret.append("idMsg=" + idMsg);
	return ret.toString();
    }

}
