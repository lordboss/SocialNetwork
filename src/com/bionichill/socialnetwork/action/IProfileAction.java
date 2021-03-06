package com.bionichill.socialnetwork.action;

import java.util.List;

import com.bionichill.socialnetwork.dto.Profile;


/**
 * @author Roman Baranov
 * 
 */

public interface IProfileAction {

    /**
     * Update an information in user profile.
     */
    public Profile updateProfile(Integer idProfile, Profile profile);

    /**
     * Delete a user profile.
     */
    public void delete(Integer idProfile);

    /**
     * Get a profile by PK.
     */
    public Profile getProfileByPK(Integer idProfile);

    /**
     * Get a list of all profiles.
     */
    public List<Profile> getProfileList();

    /**
     * Get profiles by hobbies.
     */
    public List<Profile> getProfileListByHobby(List<String> hobby);

    /**
     * Create profile.
     */
    public Profile createProfile();

}
