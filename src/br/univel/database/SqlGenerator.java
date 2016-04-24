package br.univel.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by felipefrizzo on 4/19/16.
 */
public abstract class SqlGenerator {
    //DDL
    protected abstract String getCreateTable(Connection con, Object obj);
    protected abstract String getDropTable(Connection con, Object obj);

    //DML
    protected abstract PreparedStatement getSqlInsert(Connection con, Object obj);
    protected abstract PreparedStatement getSqlSelectAll(Connection con, Object obj);
    protected abstract PreparedStatement getSqlSelectById(Connection con, Object obj, int id);
    protected abstract PreparedStatement getSqlUpdateById(Connection con, Object obj, int id);
    protected abstract PreparedStatement getSqlDeleteById(Connection con, Object obj, int id);
}
