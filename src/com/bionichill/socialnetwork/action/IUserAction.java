/**
 * 
 */
package com.bionichill.socialnetwork.action;

import java.util.List;

import com.bionichill.socialnetwork.dto.User;


/**
 * @author Roman Baranov
 * 
 */
public interface IUserAction {

    /**
     * Create a new user (registration).
     */
    public void createUser(User user);

    /**
     * Update an information about user.
     */
    public void updateUser(User user);

    /**
     * Delete a user.
     */
    public void delete(String email);

    /**
     * Get a user by PK (login?).
     */
    public User getUserByPK(String email);

    /**
     * Get a list of all users.
     */
    public List<User> getUserList();

    /**
     * Block a user.
     */
    public void blockUser(String email);

    public void askFriendsh(User inviter, User invitee);
}
