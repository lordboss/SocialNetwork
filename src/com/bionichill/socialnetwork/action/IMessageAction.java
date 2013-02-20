package com.bionichill.socialnetwork.action;

import java.util.List;

import com.bionichill.socialnetwork.dto.Msg;


public interface IMessageAction {

    /**
     * Update a message. Send or change a status.
     */
    public void updateMsg(Integer idMsg, Msg msg);

    /**
     * Read a message.
     */
    public Msg getMsgByPK(Integer idMsg);

    /**
     * Delete a message.
     */
    public void delete(Integer idMsg);

    /**
     * Delete all messages.
     */
    public void delete(List<Integer> idMsg);

}
