package ua.bionichill.socialnetwork.action;

import java.util.List;

import ua.bionichill.socialnetwork.dto.Invite;

public interface InviteAction {

    /**
     * Create invite
     */
    public void createInvite(Invite invite);

    /**
     * Delete invite.
     */
    public void delete(Integer idInvite);

    /**
     * Update invite.
     */
    public void update(Integer idInvite, Invite invite);

    /**
     * Get all invites
     */
    public List<Invite> getAllInvite(List<Integer> idInvite);

    /**
     * Get invite
     */
    public Invite getInviteByPK(Integer idInvite);
}
