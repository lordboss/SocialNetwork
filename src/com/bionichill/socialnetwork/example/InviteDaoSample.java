package com.bionichill.socialnetwork.example;

import java.util.Date;

import com.bionichill.socialnetwork.dao.IInviteDao;
import com.bionichill.socialnetwork.dto.Invite;
import com.bionichill.socialnetwork.factory.InviteDaoFactory;


public class InviteDaoSample {
    /**
     * Method 'main'
     * 
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
	// Uncomment one of the lines below to test the generated code

	// findAll();
	// findByInviter("");
	// findByInvitee("");
	// findByInviteRes("");
	// findWhereIdInviteEquals(null);
	// findWhereInviterEquals("");
	// findWhereInviteeEquals("");
	// findWhereResEquals("");
	// findWhereInviteDateEquals(null);
    }

    /**
     * Method 'findAll'
     * 
     */
    public static void findAll() {
	try {
	    IInviteDao _dao = getInviteDao();
	    Invite _result[] = _dao.findAll();
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByInviter'
     * 
     * @param inviter
     */
    public static void findByInviter(String inviter) {
	try {
	    IInviteDao _dao = getInviteDao();
	    Invite _result[] = _dao.findByInviter(inviter);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByInvitee'
     * 
     * @param invitee
     */
    public static void findByInvitee(String invitee) {
	try {
	    IInviteDao _dao = getInviteDao();
	    Invite _result[] = _dao.findByInvitee(invitee);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findByInviteRes'
     * 
     * @param res
     */
    public static void findByInviteRes(String res) {
	try {
	    IInviteDao _dao = getInviteDao();
	    Invite _result[] = _dao.findByInviteRes(res);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereIdInviteEquals'
     * 
     * @param idInvite
     */
    public static void findWhereIdInviteEquals(Integer idInvite) {
	try {
	    IInviteDao _dao = getInviteDao();
	    Invite _result[] = _dao.findWhereIdInviteEquals(idInvite);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereInviterEquals'
     * 
     * @param inviter
     */
    public static void findWhereInviterEquals(String inviter) {
	try {
	    IInviteDao _dao = getInviteDao();
	    Invite _result[] = _dao.findWhereInviterEquals(inviter);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereInviteeEquals'
     * 
     * @param invitee
     */
    public static void findWhereInviteeEquals(String invitee) {
	try {
	    IInviteDao _dao = getInviteDao();
	    Invite _result[] = _dao.findWhereInviteeEquals(invitee);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereResEquals'
     * 
     * @param res
     */
    public static void findWhereResEquals(String res) {
	try {
	    IInviteDao _dao = getInviteDao();
	    Invite _result[] = _dao.findWhereResEquals(res);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'findWhereInviteDateEquals'
     * 
     * @param inviteDate
     */
    public static void findWhereInviteDateEquals(Date inviteDate) {
	try {
	    IInviteDao _dao = getInviteDao();
	    Invite _result[] = _dao.findWhereInviteDateEquals(inviteDate);
	    for (int i = 0; i < _result.length; i++) {
		display(_result[i]);
	    }

	} catch (Exception _e) {
	    _e.printStackTrace();
	}

    }

    /**
     * Method 'getInviteDao'
     * 
     * @return InviteDao
     */
    public static IInviteDao getInviteDao() {
	return InviteDaoFactory.create();
    }

    /**
     * Method 'display'
     * 
     * @param dto
     */
    public static void display(Invite dto) {
	StringBuffer buf = new StringBuffer();
	buf.append(dto.getIdInvite());
	buf.append(", ");
	buf.append(dto.getInviter());
	buf.append(", ");
	buf.append(dto.getInvitee());
	buf.append(", ");
	buf.append(dto.getRes());
	buf.append(", ");
	buf.append(dto.getInviteDate());
	System.out.println(buf.toString());
    }

}
