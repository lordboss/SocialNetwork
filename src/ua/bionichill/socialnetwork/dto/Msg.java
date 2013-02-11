package ua.bionichill.socialnetwork.dto;

import java.io.Serializable;
import java.util.Date;

public class Msg implements Serializable {
    /**
     * This attribute maps to the column idmsg in the msg table.
     */
    private Integer idMsg;

    /**
     * This attribute maps to the column mailer in the msg table.
     */
    private User mailer;

    /**
     * This attribute maps to the column recipient in the msg table.
     */
    private User recipient;

    /**
     * This attribute maps to the column headmsg in the msg table.
     */
    private String headMsg;

    /**
     * This attribute maps to the column bodymsg in the msg table.
     */
    private String bodyMsg;

    /**
     * This attribute maps to the column statusmsg in the msg table.
     */
    private MsgStatus statusMsg;

    /**
     * This attribute maps to the column typemsg in the msg table.
     */
    private MsgType typeMsg;

    /**
     * This attribute maps to the column sendoffdate in the msg table.
     */
    private Date sendOffDate;

    /**
     * Method 'Msg'
     * 
     */
    public Msg() {
    }

    /**
     * Method 'getIdMsg'
     * 
     * @return Integer
     */
    public Integer getIdMsg() {
	return idMsg;
    }

    /**
     * Method 'setIdMsg'
     * 
     * @param idMsg
     */
    public void setIdMsg(Integer idMsg) {
	this.idMsg = idMsg;
    }

    /**
     * Method 'getMailer'
     * 
     * @return User
     */
    public User getMailer() {
	return mailer;
    }

    /**
     * Method 'setMailer'
     * 
     * @param mailer
     */
    public void setMailer(User mailer) {
	this.mailer = mailer;
    }

    /**
     * Method 'getRecipient'
     * 
     * @return User
     */
    public User getRecipient() {
	return recipient;
    }

    /**
     * Method 'setRecipient'
     * 
     * @param recipient
     */
    public void setRecipient(User recipient) {
	this.recipient = recipient;
    }

    /**
     * Method 'getHeadMsg'
     * 
     * @return String
     */
    public String getHeadMsg() {
	return headMsg;
    }

    /**
     * Method 'setHeadMsg'
     * 
     * @param headMsg
     */
    public void setHeadMsg(String headMsg) {
	this.headMsg = headMsg;
    }

    /**
     * Method 'getBodyMsg'
     * 
     * @return String
     */
    public String getBodyMsg() {
	return bodyMsg;
    }

    /**
     * Method 'setBodyMsg'
     * 
     * @param bodyMsg
     */
    public void setBodyMsg(String bodyMsg) {
	this.bodyMsg = bodyMsg;
    }

    /**
     * Method 'getStatusMsg'
     * 
     * @return MsgStatus
     */
    public MsgStatus getStatusMsg() {
	return statusMsg;
    }

    /**
     * Method 'setStatusMsg'
     * 
     * @param statusMsg
     */
    public void setStatusMsg(MsgStatus statusMsg) {
	this.statusMsg = statusMsg;
    }

    /**
     * Method 'getTypeMsg'
     * 
     * @return MsgType
     */
    public MsgType getTypeMsg() {
	return typeMsg;
    }

    /**
     * Method 'setTypeMsg'
     * 
     * @param typeMsg
     */
    public void setTypeMsg(MsgType typeMsg) {
	this.typeMsg = typeMsg;
    }

    /**
     * Method 'getSendOffDate'
     * 
     * @return Date
     */
    public Date getSendOffDate() {
	return sendOffDate;
    }

    /**
     * Method 'setSendOffDate'
     * 
     * @param sendOffDate
     */
    public void setSendOffDate(Date sendOffDate) {
	this.sendOffDate = sendOffDate;
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

	if (!(_other instanceof Msg)) {
	    return false;
	}

	final Msg _cast = (Msg) _other;
	if (idMsg == null ? _cast.idMsg != idMsg : !idMsg.equals(_cast.idMsg)) {
	    return false;
	}

	if (mailer == null ? _cast.mailer != mailer : !mailer
		.equals(_cast.mailer)) {
	    return false;
	}

	if (recipient == null ? _cast.recipient != recipient : !recipient
		.equals(_cast.recipient)) {
	    return false;
	}

	if (headMsg == null ? _cast.headMsg != headMsg : !headMsg
		.equals(_cast.headMsg)) {
	    return false;
	}

	if (bodyMsg == null ? _cast.bodyMsg != bodyMsg : !bodyMsg
		.equals(_cast.bodyMsg)) {
	    return false;
	}

	if (statusMsg == null ? _cast.statusMsg != statusMsg : !statusMsg
		.equals(_cast.statusMsg)) {
	    return false;
	}

	if (typeMsg == null ? _cast.typeMsg != typeMsg : !typeMsg
		.equals(_cast.typeMsg)) {
	    return false;
	}

	if (sendOffDate == null ? _cast.sendOffDate != sendOffDate
		: !sendOffDate.equals(_cast.sendOffDate)) {
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

	if (mailer != null) {
	    _hashCode = 29 * _hashCode + mailer.hashCode();
	}

	if (recipient != null) {
	    _hashCode = 29 * _hashCode + recipient.hashCode();
	}

	if (headMsg != null) {
	    _hashCode = 29 * _hashCode + headMsg.hashCode();
	}

	if (bodyMsg != null) {
	    _hashCode = 29 * _hashCode + bodyMsg.hashCode();
	}

	if (statusMsg != null) {
	    _hashCode = 29 * _hashCode + statusMsg.hashCode();
	}

	if (typeMsg != null) {
	    _hashCode = 29 * _hashCode + typeMsg.hashCode();
	}

	if (sendOffDate != null) {
	    _hashCode = 29 * _hashCode + sendOffDate.hashCode();
	}

	return _hashCode;
    }

    /**
     * Method 'createPk'
     * 
     * @return MsgPk
     */
    public MsgPk createPk() {
	return new MsgPk(idMsg);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
	StringBuffer ret = new StringBuffer();
	ret.append("ua.bionichill.socialnetwork.dto.Msg: ");
	ret.append("idMsg=" + idMsg);
	ret.append(", mailer=" + mailer.toString());
	ret.append(", recipient=" + recipient.toString());
	ret.append(", headMsg=" + headMsg);
	ret.append(", bodyMsg=" + bodyMsg);
	ret.append(", statusMsg=" + statusMsg.toString());
	ret.append(", typeMsg=" + typeMsg.toString());
	ret.append(", sendOffDate=" + sendOffDate);
	return ret.toString();
    }

}
