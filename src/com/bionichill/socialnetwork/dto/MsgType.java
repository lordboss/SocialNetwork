package com.bionichill.socialnetwork.dto;

import java.io.Serializable;

public class MsgType implements Serializable {
    /**
     * This attribute maps to the column msgtype in the msgtype table.
     */
    private String msgType;

    /**
     * Method 'MsgType'
     * 
     */
    public MsgType() {
    }

    /**
     * Method 'getMsgType'
     * 
     * @return String
     */
    public String getMsgType() {
	return msgType;
    }

    /**
     * Method 'setMsgType'
     * 
     * @param msgType
     */
    public void setMsgType(String msgType) {
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

	if (!(_other instanceof MsgType)) {
	    return false;
	}

	final MsgType _cast = (MsgType) _other;
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
     * Method 'createPk'
     * 
     * @return MsgTypePk
     */
    public MsgTypePk createPk() {
	return new MsgTypePk(msgType);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.MsgType: ");
	ret.append("msgType=" + msgType);
	return ret.toString();
    }

}
