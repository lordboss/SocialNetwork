package com.bionichill.socialnetwork.actionimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.bionichill.socialnetwork.action.IInviteAction;
import com.bionichill.socialnetwork.dao.IInviteDao;
import com.bionichill.socialnetwork.dto.Invite;
import com.bionichill.socialnetwork.exceptions.InviteDaoException;
import com.bionichill.socialnetwork.factory.InviteDaoFactory;


public class InviteActionImpl implements IInviteAction {

    private static final Logger logger = Logger
	    .getLogger(InviteActionImpl.class);

    @Override
    public void createInvite(Invite invite) {
	try {
	    IInviteDao _dao = getInviteDao();
	    _dao.insert(invite);
	    logger.info("User " + invite.getInviter()
		    + " want to friendship with user " + invite.getInvitee());
	} catch (InviteDaoException e) {
	    logger.error("Error occurred during creation of a new invite: ", e);
	}
    }

    @Override
    public void delete(Integer idInvite) {
	// TODO Auto-generated method stub

    }

    @Override
    public void update(Integer idInvite, Invite invite) {
	// TODO Auto-generated method stub

    }

    @Override
    public List<Invite> getAllInvite(List<Integer> idInvite) {
	// TODO Auto-generated method stub
	return null;
    }

    /**
     * Method 'getInviteByPK'
     * 
     * @param idInvite
     */
    @Override
    public Invite getInviteByPK(Integer idInvite) {
	try {
	    IInviteDao _dao = getInviteDao();
	    Invite _result = _dao.findByPrimaryKey(idInvite);
	    return _result;
	} catch (Exception _e) {
	    _e.printStackTrace();
	}
	return null;
    }

    /**
     * Method 'getInviteDao'
     * 
     * @return InviteDao
     */
    public static IInviteDao getInviteDao() {
	return InviteDaoFactory.create();
    }

}
