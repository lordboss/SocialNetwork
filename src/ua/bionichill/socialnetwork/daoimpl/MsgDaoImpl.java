package ua.bionichill.socialnetwork.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;

import ua.bionichill.socialnetwork.dao.MsgDao;
import ua.bionichill.socialnetwork.dto.Msg;
import ua.bionichill.socialnetwork.dto.MsgPk;
import ua.bionichill.socialnetwork.exceptions.MsgDaoException;

public class MsgDaoImpl extends AbstractDAO implements MsgDao {
    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    protected java.sql.Connection userConn;

    protected static final Logger logger = Logger.getLogger(MsgDaoImpl.class);

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    protected final String SQL_SELECT = "SELECT idmsg, mailer, recipient, headmsg, bodymsg, statusmsg, typemsg, sendoffdate FROM "
	    + getTableName() + "";

    /**
     * Finder methods will pass this value to the JDBC setMaxRows method
     */
    protected int maxRows;

    /**
     * SQL INSERT statement for this table
     */
    protected final String SQL_INSERT = "INSERT INTO "
	    + getTableName()
	    + " ( idmsg, mailer, recipient, headmsg, bodymsg, statusmsg, typemsg, sendoffdate ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";

    /**
     * SQL UPDATE statement for this table
     */
    protected final String SQL_UPDATE = "UPDATE "
	    + getTableName()
	    + " SET idmsg = ?, mailer = ?, recipient = ?, headmsg = ?, bodymsg = ?, statusmsg = ?, typemsg = ?, sendoffdate = ? WHERE idmsg = ?";

    /**
     * SQL DELETE statement for this table
     */
    protected final String SQL_DELETE = "DELETE FROM " + getTableName()
	    + " WHERE idmsg = ?";

    /**
     * Index of column idmsg
     */
    protected static final int COLUMN_ID_MSG = 1;

    /**
     * Index of column mailer
     */
    protected static final int COLUMN_MAILER = 2;

    /**
     * Index of column recipient
     */
    protected static final int COLUMN_RECIPIENT = 3;

    /**
     * Index of column headmsg
     */
    protected static final int COLUMN_HEAD_MSG = 4;

    /**
     * Index of column bodymsg
     */
    protected static final int COLUMN_BODY_MSG = 5;

    /**
     * Index of column statusmsg
     */
    protected static final int COLUMN_STATUS_MSG = 6;

    /**
     * Index of column typemsg
     */
    protected static final int COLUMN_TYPE_MSG = 7;

    /**
     * Index of column sendoffdate
     */
    protected static final int COLUMN_SEND_OFF_DATE = 8;

    /**
     * Number of columns
     */
    protected static final int NUMBER_OF_COLUMNS = 8;

    /**
     * Index of primary-key column idmsg
     */
    protected static final int PK_COLUMN_ID_MSG = 1;

    /**
     * Inserts a new row in the msg table.
     */
    public MsgPk insert(Msg dto) throws MsgDaoException {
	long t1 = System.currentTimeMillis();
	// declare variables
	final boolean isConnSupplied = (userConn != null);
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
	    // get the user-specified connection or get a connection from the
	    // ResourceManager
	    conn = isConnSupplied ? userConn : ResourceManager.getConnection();

	    stmt = conn.prepareStatement(SQL_INSERT,
		    Statement.RETURN_GENERATED_KEYS);
	    int index = 1;
	    if (dto.getIdMsg() != null) {
		stmt.setInt(index++, dto.getIdMsg().intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setString(index++, dto.getMailer());
	    stmt.setString(index++, dto.getRecipient());
	    stmt.setString(index++, dto.getHeadMsg());
	    stmt.setString(index++, dto.getBodyMsg());
	    stmt.setString(index++, dto.getStatusMsg());
	    stmt.setString(index++, dto.getTypeMsg());
	    stmt.setTimestamp(index++, dto.getSendOffDate() == null ? null
		    : new java.sql.Timestamp(dto.getSendOffDate().getTime()));
	    if (logger.isDebugEnabled()) {
		logger.debug("Executing " + SQL_INSERT + " with DTO: " + dto);
	    }

	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	    // retrieve values from auto-increment columns
	    rs = stmt.getGeneratedKeys();
	    if (rs != null && rs.next()) {
		dto.setIdMsg(new Integer(rs.getInt(1)));
	    }

	    reset(dto);
	    return dto.createPk();
	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new MsgDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Updates a single row in the msg table.
     */
    public void update(MsgPk pk, Msg dto) throws MsgDaoException {
	long t1 = System.currentTimeMillis();
	// declare variables
	final boolean isConnSupplied = (userConn != null);
	Connection conn = null;
	PreparedStatement stmt = null;

	try {
	    // get the user-specified connection or get a connection from the
	    // ResourceManager
	    conn = isConnSupplied ? userConn : ResourceManager.getConnection();

	    if (logger.isDebugEnabled()) {
		logger.debug("Executing " + SQL_UPDATE + " with DTO: " + dto);
	    }

	    stmt = conn.prepareStatement(SQL_UPDATE);
	    int index = 1;
	    if (dto.getIdMsg() != null) {
		stmt.setInt(index++, dto.getIdMsg().intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setString(index++, dto.getMailer());
	    stmt.setString(index++, dto.getRecipient());
	    stmt.setString(index++, dto.getHeadMsg());
	    stmt.setString(index++, dto.getBodyMsg());
	    stmt.setString(index++, dto.getStatusMsg());
	    stmt.setString(index++, dto.getTypeMsg());
	    stmt.setTimestamp(index++, dto.getSendOffDate() == null ? null
		    : new java.sql.Timestamp(dto.getSendOffDate().getTime()));
	    if (pk.getIdMsg() != null) {
		stmt.setInt(9, pk.getIdMsg().intValue());
	    } else {
		stmt.setNull(9, java.sql.Types.INTEGER);
	    }

	    int rows = stmt.executeUpdate();
	    reset(dto);
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new MsgDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Deletes a single row in the msg table.
     */
    public void delete(MsgPk pk) throws MsgDaoException {
	long t1 = System.currentTimeMillis();
	// declare variables
	final boolean isConnSupplied = (userConn != null);
	Connection conn = null;
	PreparedStatement stmt = null;

	try {
	    // get the user-specified connection or get a connection from the
	    // ResourceManager
	    conn = isConnSupplied ? userConn : ResourceManager.getConnection();

	    if (logger.isDebugEnabled()) {
		logger.debug("Executing " + SQL_DELETE + " with PK: " + pk);
	    }

	    stmt = conn.prepareStatement(SQL_DELETE);
	    if (pk.getIdMsg() != null) {
		stmt.setInt(1, pk.getIdMsg().intValue());
	    } else {
		stmt.setNull(1, java.sql.Types.INTEGER);
	    }

	    int rows = stmt.executeUpdate();
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new MsgDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns the rows from the msg table that matches the specified
     * primary-key value.
     */
    public Msg findByPrimaryKey(MsgPk pk) throws MsgDaoException {
	return findByPrimaryKey(pk.getIdMsg());
    }

    /**
     * Returns all rows from the msg table that match the criteria 'idmsg =
     * :idMsg'.
     */
    public Msg findByPrimaryKey(Integer idMsg) throws MsgDaoException {
	Msg ret[] = findByDynamicSelect(SQL_SELECT + " WHERE idmsg = ?",
		new Object[] { idMsg });
	return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the msg table that match the criteria ''.
     */
    public Msg[] findAll() throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT + " ORDER BY idmsg", null);
    }

    /**
     * Returns all rows from the msg table that match the criteria 'statusMsg =
     * :statusMsg'.
     */
    public Msg[] findByMsgStatus(String statusMsg) throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE statusMsg = ?",
		new Object[] { statusMsg });
    }

    /**
     * Returns all rows from the msg table that match the criteria 'typeMsg =
     * :typeMsg'.
     */
    public Msg[] findByMsgType(String typeMsg) throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE typeMsg = ?",
		new Object[] { typeMsg });
    }

    /**
     * Returns all rows from the msg table that match the criteria 'mailer =
     * :mailer'.
     */
    public Msg[] findByMailer(String mailer) throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE mailer = ?",
		new Object[] { mailer });
    }

    /**
     * Returns all rows from the msg table that match the criteria 'recipient =
     * :recipient'.
     */
    public Msg[] findByRecipient(String recipient) throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE recipient = ?",
		new Object[] { recipient });
    }

    /**
     * Returns all rows from the msg table that match the criteria 'idMsg =
     * :idMsg'.
     */
    public Msg[] findWhereIdMsgEquals(Integer idMsg) throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE idMsg = ? ORDER BY idmsg", new Object[] { idMsg });
    }

    /**
     * Returns all rows from the msg table that match the criteria 'mailer =
     * :mailer'.
     */
    public Msg[] findWhereMailerEquals(String mailer) throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE mailer = ? ORDER BY mailer", new Object[] { mailer });
    }

    /**
     * Returns all rows from the msg table that match the criteria 'recipient =
     * :recipient'.
     */
    public Msg[] findWhereRecipientEquals(String recipient)
	    throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE recipient = ? ORDER BY recipient",
		new Object[] { recipient });
    }

    /**
     * Returns all rows from the msg table that match the criteria 'headMsg =
     * :headMsg'.
     */
    public Msg[] findWhereHeadMsgEquals(String headMsg) throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE headMsg = ? ORDER BY headMsg",
		new Object[] { headMsg });
    }

    /**
     * Returns all rows from the msg table that match the criteria 'bodyMsg =
     * :bodyMsg'.
     */
    public Msg[] findWhereBodyMsgEquals(String bodyMsg) throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE bodyMsg = ? ORDER BY bodyMsg",
		new Object[] { bodyMsg });
    }

    /**
     * Returns all rows from the msg table that match the criteria 'statusMsg =
     * :statusMsg'.
     */
    public Msg[] findWhereStatusMsgEquals(String statusMsg)
	    throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE statusMsg = ? ORDER BY statusMsg",
		new Object[] { statusMsg });
    }

    /**
     * Returns all rows from the msg table that match the criteria 'typeMsg =
     * :typeMsg'.
     */
    public Msg[] findWhereTypeMsgEquals(String typeMsg) throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE typeMsg = ? ORDER BY typeMsg",
		new Object[] { typeMsg });
    }

    /**
     * Returns all rows from the msg table that match the criteria 'sendOffDate
     * = :sendOffDate'.
     */
    public Msg[] findWhereSendOffDateEquals(Date sendOffDate)
	    throws MsgDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE sendOffDate = ? ORDER BY sendOffDate",
		new Object[] { sendOffDate == null ? null
			: new java.sql.Timestamp(sendOffDate.getTime()) });
    }

    /**
     * Method 'MsgDaoImpl'
     * 
     */
    public MsgDaoImpl() {
    }

    /**
     * Method 'MsgDaoImpl'
     * 
     * @param userConn
     */
    public MsgDaoImpl(final java.sql.Connection userConn) {
	this.userConn = userConn;
    }

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows) {
	this.maxRows = maxRows;
    }

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows() {
	return maxRows;
    }

    /**
     * Method 'getTableName'
     * 
     * @return String
     */
    public String getTableName() {
	return "socialnetwork.msg";
    }

    /**
     * Fetches a single row from the result set
     */
    protected Msg fetchSingleResult(ResultSet rs) throws SQLException {
	if (rs.next()) {
	    Msg dto = new Msg();
	    populateDto(dto, rs);
	    return dto;
	} else {
	    return null;
	}

    }

    /**
     * Fetches multiple rows from the result set
     */
    protected Msg[] fetchMultiResults(ResultSet rs) throws SQLException {
	Collection resultList = new ArrayList();
	while (rs.next()) {
	    Msg dto = new Msg();
	    populateDto(dto, rs);
	    resultList.add(dto);
	}

	Msg ret[] = new Msg[resultList.size()];
	resultList.toArray(ret);
	return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    protected void populateDto(Msg dto, ResultSet rs) throws SQLException {
	dto.setIdMsg(new Integer(rs.getInt(COLUMN_ID_MSG)));
	dto.setMailer(rs.getString(COLUMN_MAILER));
	dto.setRecipient(rs.getString(COLUMN_RECIPIENT));
	dto.setHeadMsg(rs.getString(COLUMN_HEAD_MSG));
	dto.setBodyMsg(rs.getString(COLUMN_BODY_MSG));
	dto.setStatusMsg(rs.getString(COLUMN_STATUS_MSG));
	dto.setTypeMsg(rs.getString(COLUMN_TYPE_MSG));
	dto.setSendOffDate(rs.getTimestamp(COLUMN_SEND_OFF_DATE));
    }

    /**
     * Resets the modified attributes in the DTO
     */
    protected void reset(Msg dto) {
    }

    /**
     * Returns all rows from the msg table that match the specified arbitrary
     * SQL statement
     */
    public Msg[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws MsgDaoException {
	// declare variables
	final boolean isConnSupplied = (userConn != null);
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
	    // get the user-specified connection or get a connection from the
	    // ResourceManager
	    conn = isConnSupplied ? userConn : ResourceManager.getConnection();

	    // construct the SQL statement
	    final String SQL = sql;

	    if (logger.isDebugEnabled()) {
		logger.debug("Executing " + SQL);
	    }

	    // prepare statement
	    stmt = conn.prepareStatement(SQL);
	    stmt.setMaxRows(maxRows);

	    // bind parameters
	    for (int i = 0; sqlParams != null && i < sqlParams.length; i++) {
		stmt.setObject(i + 1, sqlParams[i]);
	    }

	    rs = stmt.executeQuery();

	    // fetch the results
	    return fetchMultiResults(rs);
	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new MsgDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns all rows from the msg table that match the specified arbitrary
     * SQL statement
     */
    public Msg[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws MsgDaoException {
	// declare variables
	final boolean isConnSupplied = (userConn != null);
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
	    // get the user-specified connection or get a connection from the
	    // ResourceManager
	    conn = isConnSupplied ? userConn : ResourceManager.getConnection();

	    // construct the SQL statement
	    final String SQL = SQL_SELECT + " WHERE " + sql;

	    if (logger.isDebugEnabled()) {
		logger.debug("Executing " + SQL);
	    }

	    // prepare statement
	    stmt = conn.prepareStatement(SQL);
	    stmt.setMaxRows(maxRows);

	    // bind parameters
	    for (int i = 0; sqlParams != null && i < sqlParams.length; i++) {
		stmt.setObject(i + 1, sqlParams[i]);
	    }

	    rs = stmt.executeQuery();

	    // fetch the results
	    return fetchMultiResults(rs);
	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new MsgDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

}
