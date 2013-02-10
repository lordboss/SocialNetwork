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

import ua.bionichill.socialnetwork.dao.FriendshDao;
import ua.bionichill.socialnetwork.dto.Friendsh;
import ua.bionichill.socialnetwork.dto.FriendshPk;
import ua.bionichill.socialnetwork.exceptions.FriendshDaoException;

public class FriendshDaoImpl extends AbstractDAO implements FriendshDao {
    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    protected java.sql.Connection userConn;

    protected static final Logger logger = Logger
	    .getLogger(FriendshDaoImpl.class);

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    protected final String SQL_SELECT = "SELECT idfriendsh, friendfrom, friendto, statusfriendsh, inviteid, friendshdate FROM "
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
	    + " ( idfriendsh, friendfrom, friendto, statusfriendsh, inviteid, friendshdate ) VALUES ( ?, ?, ?, ?, ?, ? )";

    /**
     * SQL UPDATE statement for this table
     */
    protected final String SQL_UPDATE = "UPDATE "
	    + getTableName()
	    + " SET idfriendsh = ?, friendfrom = ?, friendto = ?, statusfriendsh = ?, inviteid = ?, friendshdate = ? WHERE idfriendsh = ?";

    /**
     * SQL DELETE statement for this table
     */
    protected final String SQL_DELETE = "DELETE FROM " + getTableName()
	    + " WHERE idfriendsh = ?";

    /**
     * Index of column idfriendsh
     */
    protected static final int COLUMN_ID_FRIENDSH = 1;

    /**
     * Index of column friendfrom
     */
    protected static final int COLUMN_FRIEND_FROM = 2;

    /**
     * Index of column friendto
     */
    protected static final int COLUMN_FRIEND_TO = 3;

    /**
     * Index of column statusfriendsh
     */
    protected static final int COLUMN_STATUS_FRIENDSH = 4;

    /**
     * Index of column inviteid
     */
    protected static final int COLUMN_INVITE_ID = 5;

    /**
     * Index of column friendshdate
     */
    protected static final int COLUMN_FRIENDSH_DATE = 6;

    /**
     * Number of columns
     */
    protected static final int NUMBER_OF_COLUMNS = 6;

    /**
     * Index of primary-key column idfriendsh
     */
    protected static final int PK_COLUMN_ID_FRIENDSH = 1;

    /**
     * Inserts a new row in the friendsh table.
     */
    public FriendshPk insert(Friendsh dto) throws FriendshDaoException {
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
	    if (dto.getIdFriendsh() != null) {
		stmt.setInt(index++, dto.getIdFriendsh().intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setString(index++, dto.getFriendFrom());
	    stmt.setString(index++, dto.getFriendTo());
	    stmt.setString(index++, dto.getStatusFriendsh());
	    if (dto.getInviteId() != null) {
		stmt.setInt(index++, dto.getInviteId().intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setTimestamp(index++, dto.getFriendshDate() == null ? null
		    : new java.sql.Timestamp(dto.getFriendshDate().getTime()));
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
		dto.setIdFriendsh(new Integer(rs.getInt(1)));
	    }

	    reset(dto);
	    return dto.createPk();
	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new FriendshDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Updates a single row in the friendsh table.
     */
    public void update(FriendshPk pk, Friendsh dto) throws FriendshDaoException {
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
	    if (dto.getIdFriendsh() != null) {
		stmt.setInt(index++, dto.getIdFriendsh().intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setString(index++, dto.getFriendFrom());
	    stmt.setString(index++, dto.getFriendTo());
	    stmt.setString(index++, dto.getStatusFriendsh());
	    if (dto.getInviteId() != null) {
		stmt.setInt(index++, dto.getInviteId().intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setTimestamp(index++, dto.getFriendshDate() == null ? null
		    : new java.sql.Timestamp(dto.getFriendshDate().getTime()));
	    if (pk.getIdFriendsh() != null) {
		stmt.setInt(7, pk.getIdFriendsh().intValue());
	    } else {
		stmt.setNull(7, java.sql.Types.INTEGER);
	    }

	    int rows = stmt.executeUpdate();
	    reset(dto);
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new FriendshDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Deletes a single row in the friendsh table.
     */
    public void delete(FriendshPk pk) throws FriendshDaoException {
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
	    if (pk.getIdFriendsh() != null) {
		stmt.setInt(1, pk.getIdFriendsh().intValue());
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
	    throw new FriendshDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns the rows from the friendsh table that matches the specified
     * primary-key value.
     */
    public Friendsh findByPrimaryKey(FriendshPk pk) throws FriendshDaoException {
	return findByPrimaryKey(pk.getIdFriendsh());
    }

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'idfriendsh = :idFriendsh'.
     */
    public Friendsh findByPrimaryKey(Integer idFriendsh)
	    throws FriendshDaoException {
	Friendsh ret[] = findByDynamicSelect(SQL_SELECT
		+ " WHERE idfriendsh = ?", new Object[] { idFriendsh });
	return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the friendsh table that match the criteria ''.
     */
    public Friendsh[] findAll() throws FriendshDaoException {
	return findByDynamicSelect(SQL_SELECT + " ORDER BY idfriendsh", null);
    }

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'inviteId = :inviteId'.
     */
    public Friendsh[] findByInvite(Integer inviteId)
	    throws FriendshDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE inviteId = ?",
		new Object[] { inviteId });
    }

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'statusFriendsh = :statusFriendsh'.
     */
    public Friendsh[] findByFriendshStatus(String statusFriendsh)
	    throws FriendshDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE statusFriendsh = ?",
		new Object[] { statusFriendsh });
    }

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'friendFrom = :friendFrom'.
     */
    public Friendsh[] findByFriendFrom(String friendFrom)
	    throws FriendshDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE friendFrom = ?",
		new Object[] { friendFrom });
    }

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'friendTo = :friendTo'.
     */
    public Friendsh[] findByFriendTo(String friendTo)
	    throws FriendshDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE friendTo = ?",
		new Object[] { friendTo });
    }

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'idFriendsh = :idFriendsh'.
     */
    public Friendsh[] findWhereIdFriendshEquals(Integer idFriendsh)
	    throws FriendshDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE idFriendsh = ? ORDER BY idFriendsh",
		new Object[] { idFriendsh });
    }

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'friendFrom = :friendFrom'.
     */
    public Friendsh[] findWhereFriendFromEquals(String friendFrom)
	    throws FriendshDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE friendFrom = ? ORDER BY friendFrom",
		new Object[] { friendFrom });
    }

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'friendTo = :friendTo'.
     */
    public Friendsh[] findWhereFriendToEquals(String friendTo)
	    throws FriendshDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE friendTo = ? ORDER BY friendTo",
		new Object[] { friendTo });
    }

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'statusFriendsh = :statusFriendsh'.
     */
    public Friendsh[] findWhereStatusFriendshEquals(String statusFriendsh)
	    throws FriendshDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE statusFriendsh = ? ORDER BY statusFriendsh",
		new Object[] { statusFriendsh });
    }

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'inviteId = :inviteId'.
     */
    public Friendsh[] findWhereInviteIdEquals(Integer inviteId)
	    throws FriendshDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE inviteId = ? ORDER BY inviteId",
		new Object[] { inviteId });
    }

    /**
     * Returns all rows from the friendsh table that match the criteria
     * 'friendshDate = :friendshDate'.
     */
    public Friendsh[] findWhereFriendshDateEquals(Date friendshDate)
	    throws FriendshDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE friendshDate = ? ORDER BY friendshDate",
		new Object[] { friendshDate == null ? null
			: new java.sql.Timestamp(friendshDate.getTime()) });
    }

    /**
     * Method 'FriendshDaoImpl'
     * 
     */
    public FriendshDaoImpl() {
    }

    /**
     * Method 'FriendshDaoImpl'
     * 
     * @param userConn
     */
    public FriendshDaoImpl(final java.sql.Connection userConn) {
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
	return "socialnetwork.friendsh";
    }

    /**
     * Fetches a single row from the result set
     */
    protected Friendsh fetchSingleResult(ResultSet rs) throws SQLException {
	if (rs.next()) {
	    Friendsh dto = new Friendsh();
	    populateDto(dto, rs);
	    return dto;
	} else {
	    return null;
	}

    }

    /**
     * Fetches multiple rows from the result set
     */
    protected Friendsh[] fetchMultiResults(ResultSet rs) throws SQLException {
	Collection resultList = new ArrayList();
	while (rs.next()) {
	    Friendsh dto = new Friendsh();
	    populateDto(dto, rs);
	    resultList.add(dto);
	}

	Friendsh ret[] = new Friendsh[resultList.size()];
	resultList.toArray(ret);
	return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    protected void populateDto(Friendsh dto, ResultSet rs) throws SQLException {
	dto.setIdFriendsh(new Integer(rs.getInt(COLUMN_ID_FRIENDSH)));
	dto.setFriendFrom(rs.getString(COLUMN_FRIEND_FROM));
	dto.setFriendTo(rs.getString(COLUMN_FRIEND_TO));
	dto.setStatusFriendsh(rs.getString(COLUMN_STATUS_FRIENDSH));
	dto.setInviteId(new Integer(rs.getInt(COLUMN_INVITE_ID)));
	dto.setFriendshDate(rs.getTimestamp(COLUMN_FRIENDSH_DATE));
    }

    /**
     * Resets the modified attributes in the DTO
     */
    protected void reset(Friendsh dto) {
    }

    /**
     * Returns all rows from the friendsh table that match the specified
     * arbitrary SQL statement
     */
    public Friendsh[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws FriendshDaoException {
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
	    throw new FriendshDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns all rows from the friendsh table that match the specified
     * arbitrary SQL statement
     */
    public Friendsh[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws FriendshDaoException {
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
	    throw new FriendshDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

}
