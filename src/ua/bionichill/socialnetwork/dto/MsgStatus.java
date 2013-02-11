package ua.bionichill.socialnetwork.dto;

import java.io.Serializable;

public class MsgStatus implements Serializable {
    /**
     * This attribute maps to the column msgstatus in the msgstatus table.
     */
    private String msgStatus;

    /**
     * Method 'MsgStatus'
     * 
     */
    public MsgStatus() {
    }

    /**
     * Method 'getMsgStatus'
     * 
     * @return String
     */
    public String getMsgStatus() {
	return msgStatus;
    }

    /**
     * Method 'setMsgStatus'
     * 
     * @param msgStatus
     */
    public void setMsgStatus(String msgStatus) {
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

	if (!(_other instanceof MsgStatus)) {
	    return false;
	}

	final MsgStatus _cast = (MsgStatus) _other;
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
     * Method 'createPk'
     * 
     * @return MsgStatusPk
     */
    public MsgStatusPk createPk() {
	return new MsgStatusPk(msgStatus);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.MsgStatus: ");
	ret.append("msgStatus=" + msgStatus);
	return ret.toString();
    }

}
