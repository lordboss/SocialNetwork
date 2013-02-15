package ua.bionichill.socialnetwork.action;

import java.util.List;

import ua.bionichill.socialnetwork.dto.Msg;

public interface MessageAction {

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
