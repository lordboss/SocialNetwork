package ua.bionichill.socialnetwork.actionimpl;

import java.util.List;

import org.apache.log4j.Logger;

import ua.bionichill.socialnetwork.action.InviteAction;
import ua.bionichill.socialnetwork.dao.InviteDao;
import ua.bionichill.socialnetwork.dto.Invite;
import ua.bionichill.socialnetwork.exceptions.InviteDaoException;
import ua.bionichill.socialnetwork.factory.InviteDaoFactory;

public class InviteActionImpl implements InviteAction {

    private static final Logger logger = Logger
	    .getLogger(InviteActionImpl.class);

    @Override
    public void createInvite(Invite invite) {
	try {
	    InviteDao _dao = getInviteDao();
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
	    InviteDao _dao = getInviteDao();
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
    public static InviteDao getInviteDao() {
	return InviteDaoFactory.create();
    }

}
