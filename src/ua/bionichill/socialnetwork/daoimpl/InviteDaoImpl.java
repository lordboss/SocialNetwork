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

import ua.bionichill.socialnetwork.dao.InviteDao;
import ua.bionichill.socialnetwork.dto.Invite;
import ua.bionichill.socialnetwork.dto.InvitePk;
import ua.bionichill.socialnetwork.exceptions.InviteDaoException;
import ua.bionichill.socialnetwork.exceptions.InviteResDaoException;
import ua.bionichill.socialnetwork.exceptions.UserDaoException;

public class InviteDaoImpl extends AbstractDAO implements InviteDao {
    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    protected java.sql.Connection userConn;

    protected static final Logger logger = Logger
	    .getLogger(InviteDaoImpl.class);

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    protected final String SQL_SELECT = "SELECT idinvite, inviter, invitee, res, invitedate FROM "
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
	    + " ( idinvite, inviter, invitee, res, invitedate ) VALUES ( ?, ?, ?, ?, ? )";

    /**
     * SQL UPDATE statement for this table
     */
    protected final String SQL_UPDATE = "UPDATE "
	    + getTableName()
	    + " SET idinvite = ?, inviter = ?, invitee = ?, res = ?, invitedate = ? WHERE idinvite = ?";

    /**
     * SQL DELETE statement for this table
     */
    protected final String SQL_DELETE = "DELETE FROM " + getTableName()
	    + " WHERE idinvite = ?";

    /**
     * Index of column idinvite
     */
    protected static final int COLUMN_ID_INVITE = 1;

    /**
     * Index of column inviter
     */
    protected static final int COLUMN_INVITER = 2;

    /**
     * Index of column invitee
     */
    protected static final int COLUMN_INVITEE = 3;

    /**
     * Index of column res
     */
    protected static final int COLUMN_RES = 4;

    /**
     * Index of column invitedate
     */
    protected static final int COLUMN_INVITE_DATE = 5;

    /**
     * Number of columns
     */
    protected static final int NUMBER_OF_COLUMNS = 5;

    /**
     * Index of primary-key column idinvite
     */
    protected static final int PK_COLUMN_ID_INVITE = 1;

    /**
     * Inserts a new row in the invite table.
     */
    public InvitePk insert(Invite dto) throws InviteDaoException {
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
	    if (dto.getIdInvite() != null) {
		stmt.setInt(index++, dto.getIdInvite().intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setString(index++, dto.getInviter().getEmail());
	    stmt.setString(index++, dto.getInvitee().getEmail());
	    stmt.setString(index++, dto.getRes().getInviteRes());
	    stmt.setTimestamp(index++, dto.getInviteDate() == null ? null
		    : new java.sql.Timestamp(dto.getInviteDate().getTime()));
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
		dto.setIdInvite(new Integer(rs.getInt(1)));
	    }

	    reset(dto);
	    return dto.createPk();
	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new InviteDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Updates a single row in the invite table.
     */
    public void update(InvitePk pk, Invite dto) throws InviteDaoException {
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
	    if (dto.getIdInvite() != null) {
		stmt.setInt(index++, dto.getIdInvite().intValue());
	    } else {
		stmt.setNull(index++, java.sql.Types.INTEGER);
	    }

	    stmt.setString(index++, dto.getInviter().getEmail());
	    stmt.setString(index++, dto.getInvitee().getEmail());
	    stmt.setString(index++, dto.getRes().getInviteRes());
	    stmt.setTimestamp(index++, dto.getInviteDate() == null ? null
		    : new java.sql.Timestamp(dto.getInviteDate().getTime()));
	    if (pk.getIdInvite() != null) {
		stmt.setInt(6, pk.getIdInvite().intValue());
	    } else {
		stmt.setNull(6, java.sql.Types.INTEGER);
	    }

	    int rows = stmt.executeUpdate();
	    reset(dto);
	    long t2 = System.currentTimeMillis();
	    if (logger.isDebugEnabled()) {
		logger.debug(rows + " rows affected (" + (t2 - t1) + " ms)");
	    }

	} catch (Exception _e) {
	    logger.error("Exception: " + _e.getMessage(), _e);
	    throw new InviteDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Deletes a single row in the invite table.
     */
    public void delete(InvitePk pk) throws InviteDaoException {
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
	    if (pk.getIdInvite() != null) {
		stmt.setInt(1, pk.getIdInvite().intValue());
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
	    throw new InviteDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns the rows from the invite table that matches the specified
     * primary-key value.
     */
    public Invite findByPrimaryKey(InvitePk pk) throws InviteDaoException {
	return findByPrimaryKey(pk.getIdInvite());
    }

    /**
     * Returns all rows from the invite table that match the criteria 'idinvite
     * = :idInvite'.
     */
    public Invite findByPrimaryKey(Integer idInvite) throws InviteDaoException {
	Invite ret[] = findByDynamicSelect(SQL_SELECT + " WHERE idinvite = ?",
		new Object[] { idInvite });
	return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the invite table that match the criteria ''.
     */
    public Invite[] findAll() throws InviteDaoException {
	return findByDynamicSelect(SQL_SELECT + " ORDER BY idinvite", null);
    }

    /**
     * Returns all rows from the invite table that match the criteria 'inviter =
     * :inviter'.
     */
    public Invite[] findByInviter(String inviter) throws InviteDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE inviter = ?",
		new Object[] { inviter });
    }

    /**
     * Returns all rows from the invite table that match the criteria 'invitee =
     * :invitee'.
     */
    public Invite[] findByInvitee(String invitee) throws InviteDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE invitee = ?",
		new Object[] { invitee });
    }

    /**
     * Returns all rows from the invite table that match the criteria 'res =
     * :res'.
     */
    public Invite[] findByInviteRes(String res) throws InviteDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE res = ?",
		new Object[] { res });
    }

    /**
     * Returns all rows from the invite table that match the criteria 'idInvite
     * = :idInvite'.
     */
    public Invite[] findWhereIdInviteEquals(Integer idInvite)
	    throws InviteDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE idInvite = ? ORDER BY idInvite",
		new Object[] { idInvite });
    }

    /**
     * Returns all rows from the invite table that match the criteria 'inviter =
     * :inviter'.
     */
    public Invite[] findWhereInviterEquals(String inviter)
	    throws InviteDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE inviter = ? ORDER BY inviter",
		new Object[] { inviter });
    }

    /**
     * Returns all rows from the invite table that match the criteria 'invitee =
     * :invitee'.
     */
    public Invite[] findWhereInviteeEquals(String invitee)
	    throws InviteDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE invitee = ? ORDER BY invitee",
		new Object[] { invitee });
    }

    /**
     * Returns all rows from the invite table that match the criteria 'res =
     * :res'.
     */
    public Invite[] findWhereResEquals(String res) throws InviteDaoException {
	return findByDynamicSelect(SQL_SELECT + " WHERE res = ? ORDER BY res",
		new Object[] { res });
    }

    /**
     * Returns all rows from the invite table that match the criteria
     * 'inviteDate = :inviteDate'.
     */
    public Invite[] findWhereInviteDateEquals(Date inviteDate)
	    throws InviteDaoException {
	return findByDynamicSelect(SQL_SELECT
		+ " WHERE inviteDate = ? ORDER BY inviteDate",
		new Object[] { inviteDate == null ? null
			: new java.sql.Timestamp(inviteDate.getTime()) });
    }

    /**
     * Method 'InviteDaoImpl'
     * 
     */
    public InviteDaoImpl() {
    }

    /**
     * Method 'InviteDaoImpl'
     * 
     * @param userConn
     */
    public InviteDaoImpl(final java.sql.Connection userConn) {
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
	return "socialnetwork.invite";
    }

    /**
     * Fetches a single row from the result set
     */
    protected Invite fetchSingleResult(ResultSet rs) throws SQLException {
	if (rs.next()) {
	    Invite dto = new Invite();
	    populateDto(dto, rs);
	    return dto;
	} else {
	    return null;
	}

    }

    /**
     * Fetches multiple rows from the result set
     */
    protected Invite[] fetchMultiResults(ResultSet rs) throws SQLException {
	Collection resultList = new ArrayList();
	while (rs.next()) {
	    Invite dto = new Invite();
	    populateDto(dto, rs);
	    resultList.add(dto);
	}

	Invite ret[] = new Invite[resultList.size()];
	resultList.toArray(ret);
	return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    protected void populateDto(Invite dto, ResultSet rs) throws SQLException {
	dto.setIdInvite(new Integer(rs.getInt(COLUMN_ID_INVITE)));
	try {
	    dto.setInviter(new UserDaoImpl().findByPrimaryKey(rs
		    .getString(COLUMN_INVITER)));
	} catch (UserDaoException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}
	try {
	    dto.setInvitee(new UserDaoImpl().findByPrimaryKey(rs
		    .getString(COLUMN_INVITEE)));
	} catch (UserDaoException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
	try {
	    dto.setRes(new InviteResDaoImpl().findByPrimaryKey(rs
		    .getString(COLUMN_RES)));
	} catch (InviteResDaoException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	dto.setInviteDate(rs.getTimestamp(COLUMN_INVITE_DATE));
    }

    /**
     * Resets the modified attributes in the DTO
     */
    protected void reset(Invite dto) {
    }

    /**
     * Returns all rows from the invite table that match the specified arbitrary
     * SQL statement
     */
    public Invite[] findByDynamicSelect(String sql, Object[] sqlParams)
	    throws InviteDaoException {
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
	    throw new InviteDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

    /**
     * Returns all rows from the invite table that match the specified arbitrary
     * SQL statement
     */
    public Invite[] findByDynamicWhere(String sql, Object[] sqlParams)
	    throws InviteDaoException {
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
	    throw new InviteDaoException("Exception: " + _e.getMessage(), _e);
	} finally {
	    ResourceManager.close(rs);
	    ResourceManager.close(stmt);
	    if (!isConnSupplied) {
		ResourceManager.close(conn);
	    }

	}

    }

}
