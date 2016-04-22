package br.univel;

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
    protected abstract PreparedStatement getSqlUpdateById(Object obj);
    protected abstract PreparedStatement getSqlDeleteById(Object obj);
}
