package com.bionichill.socialnetwork.dto;

import java.io.Serializable;

/**
 * This class represents the primary key of the msgtype table.
 */
public class MsgTypePk implements Serializable {
    private String msgType;

    /**
     * Sets the value of msgType
     */
    public void setMsgType(String msgType) {
	this.msgType = msgType;
    }

    /**
     * Gets the value of msgType
     */
    public String getMsgType() {
	return msgType;
    }

    /**
     * Method 'MsgTypePk'
     * 
     */
    public MsgTypePk() {
    }

    /**
     * Method 'MsgTypePk'
     * 
     * @param msgType
     */
    public MsgTypePk(final String msgType) {
	this.msgType = msgType;
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

	if (!(_other instanceof MsgTypePk)) {
	    return false;
	}

	final MsgTypePk _cast = (MsgTypePk) _other;
	if (msgType == null ? _cast.msgType != msgType : !msgType
		.equals(_cast.msgType)) {
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
	if (msgType != null) {
	    _hashCode = 29 * _hashCode + msgType.hashCode();
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
	ret.append("ua.bionichill.socialnetwork.dto.MsgTypePk: ");
	ret.append("msgType=" + msgType);
	return ret.toString();
    }

}
