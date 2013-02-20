package com.bionichill.socialnetwork.dto;

import java.io.Serializable;

/**
 * This class represents the primary key of the msgstatus table.
 */
public class MsgStatusPk implements Serializable {
    private String msgStatus;

    /**
     * Sets the value of msgStatus
     */
    public void setMsgStatus(String msgStatus) {
	this.msgStatus = msgStatus;
    }

    /**
     * Gets the value of msgStatus
     */
    public String getMsgStatus() {
	return msgStatus;
    }

    /**
     * Method 'MsgStatusPk'
     * 
     */
    public MsgStatusPk() {
    }

    /**
     * Method 'MsgStatusPk'
     * 
     * @param msgStatus
     */
    public MsgStatusPk(final String msgStatus) {
	this.msgStatus = msgStatus;
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

	if (!(_other instanceof MsgStatusPk)) {
	    return false;
	}

	final MsgStatusPk _cast = (MsgStatusPk) _other;
	if (msgStatus == null ? _cast.msgStatus != msgStatus : !msgStatus
		.equals(_cast.msgStatus)) {
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
	if (msgStatus != null) {
	    _hashCode = 29 * _hashCode + msgStatus.hashCode();
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
	ret.append("ua.bionichill.socialnetwork.dto.MsgStatusPk: ");
	ret.append("msgStatus=" + msgStatus);
	return ret.toString();
    }

}
