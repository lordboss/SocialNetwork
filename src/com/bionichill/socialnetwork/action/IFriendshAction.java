package com.bionichill.socialnetwork.action;

import java.util.List;

import com.bionichill.socialnetwork.dto.Friendsh;


public interface IFriendshAction {

    /**
     * Create friendship.
     */
    public Friendsh createFriendsh(Integer idFriendsh, Friendsh friendsh);

    /**
     * Update friendship.
     */
    public void update(Integer idFriendsh, Friendsh friendsh);

    /**
     * Get friendship.
     */
    public Friendsh getFriendsh(Integer idFriendsh);

    /**
     * Delete friendship.
     */
    public void delete(Integer idFriendsh);

    /**
     * Get all friendship.
     */
    public List<Friendsh> getAllFriendship(List<Integer> idFriendsh);

}
