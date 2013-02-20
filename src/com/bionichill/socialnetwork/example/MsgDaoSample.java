package com.bionichill.socialnetwork.example;

import java.util.Date;

import com.bionichill.socialnetwork.dao.IMsgDao;
import com.bionichill.socialnetwork.dto.Msg;
import com.bionichill.socialnetwork.factory.MsgDaoFactory;


public class MsgDaoSample {
    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
	// Uncomment one of the lines below to test the generated code

	findAll();
	// findByMsgStatus("");
	// findByMsgType("");
	findByMailer("petr@petr.com");
	// findByRecipient("");
	// findWhereIdMsgEquals(null);
	// findWhereMailerEquals("");
	// findWhereRecipientEquals("");
	// findWhereHeadMsgEquals("");
	// findWhereBodyMsgEquals("");
	// findWhereStatusMsgEquals("");
	// findWhereTypeMsgEquals("");
	// findWhereSendOffDateEquals(null);
    }

    /**
     * Method 'findAll'
     * 
     */
    public static void findAll() {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByMsgStatus'
     * 
     * @param statusMsg
     */
    public static void findByMsgStatus(String statusMsg) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findByMsgStatus(statusMsg);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByMsgType'
     * 
     * @param typeMsg
     */
    public static void findByMsgType(String typeMsg) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findByMsgType(typeMsg);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByMailer'
     * 
     * @param mailer
     */
    public static void findByMailer(String mailer) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findByMailer(mailer);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByRecipient'
     * 
     * @param recipient
     */
    public static void findByRecipient(String recipient) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findByRecipient(recipient);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereIdMsgEquals'
     * 
     * @param idMsg
     */
    public static void findWhereIdMsgEquals(Integer idMsg) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findWhereIdMsgEquals(idMsg);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereMailerEquals'
     * 
     * @param mailer
     */
    public static void findWhereMailerEquals(String mailer) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findWhereMailerEquals(mailer);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereRecipientEquals'
     * 
     * @param recipient
     */
    public static void findWhereRecipientEquals(String recipient) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findWhereRecipientEquals(recipient);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereHeadMsgEquals'
     * 
     * @param headMsg
     */
    public static void findWhereHeadMsgEquals(String headMsg) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findWhereHeadMsgEquals(headMsg);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereBodyMsgEquals'
     * 
     * @param bodyMsg
     */
    public static void findWhereBodyMsgEquals(String bodyMsg) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findWhereBodyMsgEquals(bodyMsg);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereStatusMsgEquals'
     * 
     * @param statusMsg
     */
    public static void findWhereStatusMsgEquals(String statusMsg) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findWhereStatusMsgEquals(statusMsg);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereTypeMsgEquals'
     * 
     * @param typeMsg
     */
    public static void findWhereTypeMsgEquals(String typeMsg) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findWhereTypeMsgEquals(typeMsg);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereSendOffDateEquals'
     * 
     * @param sendOffDate
     */
    public static void findWhereSendOffDateEquals(Date sendOffDate) {
	try {
	    IMsgDao _dao = getMsgDao();
	    Msg _result[] = _dao.findWhereSendOffDateEquals(sendOffDate);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'getMsgDao'
     * 
     * @return MsgDao
     */
    public static IMsgDao getMsgDao() {
	return MsgDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(Msg dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getIdMsg());
	buf.append(", ");
	buf.append(dto.getMailer());
	buf.append(", ");
	buf.append(dto.getRecipient());
	buf.append(", ");
	buf.append(dto.getHeadMsg());
	buf.append(", ");
	buf.append(dto.getBodyMsg());
	buf.append(", ");
	buf.append(dto.getStatusMsg());
	buf.append(", ");
	buf.append(dto.getTypeMsg());
	buf.append(", ");
	buf.append(dto.getSendOffDate());
	System.out.println(buf.toString());
    }

}
