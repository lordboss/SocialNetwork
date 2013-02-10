package ua.bionichill.socialnetwork.dao;

import java.util.Date;

import ua.bionichill.socialnetwork.dto.Msg;
import ua.bionichill.socialnetwork.dto.MsgPk;
import ua.bionichill.socialnetwork.exceptions.MsgDaoException;

public interface MsgDao {
    /**
     * Inserts a new row in the msg table.
     */
    public MsgPk insert(Msg dto) throws MsgDaoException;

    /**
     * Updates a single row in the msg table.
     */
    public void update(MsgPk pk, Msg dto) throws MsgDaoException;

    /**
     * Deletes a single row in the msg table.
     */
    public void delete(MsgPk pk) throws MsgDaoException;

    /**
     * Returns the rows from the msg table that matches the specified
     * primary-key value.
     */
    public Msg findByPrimaryKey(MsgPk pk) throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'idmsg =
     * :idMsg'.
     */
    public Msg findByPrimaryKey(Integer idMsg) throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria ''.
     */
    public Msg[] findAll() throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'statusMsg =
     * :statusMsg'.
     */
    public Msg[] findByMsgStatus(String statusMsg) throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'typeMsg =
     * :typeMsg'.
     */
    public Msg[] findByMsgType(String typeMsg) throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'mailer =
     * :mailer'.
     */
    public Msg[] findByMailer(String mailer) throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'recipient =
     * :recipient'.
     */
    public Msg[] findByRecipient(String recipient) throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'idMsg =
     * :idMsg'.
     */
    public Msg[] findWhereIdMsgEquals(Integer idMsg) throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'mailer =
     * :mailer'.
     */
    public Msg[] findWhereMailerEquals(String mailer) throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'recipient =
     * :recipient'.
     */
    public Msg[] findWhereRecipientEquals(String recipient)
	    throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'headMsg =
     * :headMsg'.
     */
    public Msg[] findWhereHeadMsgEquals(String headMsg) throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'bodyMsg =
     * :bodyMsg'.
     */
    public Msg[] findWhereBodyMsgEquals(String bodyMsg) throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'statusMsg =
     * :statusMsg'.
     */
    public Msg[] findWhereStatusMsgEquals(String statusMsg)
	    throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'typeMsg =
     * :typeMsg'.
     */
    public Msg[] findWhereTypeMsgEquals(String typeMsg) throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the criteria 'sendOffDate
     * = :sendOffDate'.
     */
    public Msg[] findWhereSendOffDateEquals(Date sendOffDate)
	    throws MsgDaoException;

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows);

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows();

    /**
     * Returns all rows from the msg table that match the specified arbitrary
     * SQL statement
     */
    public Msg[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws MsgDaoException;

    /**
     * Returns all rows from the msg table that match the specified arbitrary
     * SQL statement
     */
    public Msg[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws MsgDaoException;

}
