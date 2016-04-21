package br.univel;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by felipefrizzo on 4/19/16.
 */
public abstract class SqlGenerator {
    //DDL
    protected abstract String getCreateTable(Connection com, Object obj);
    protected abstract String getDropTable(Object obj);

    //DML
    protected abstract PreparedStatement getSqlInsert(Object obj);
    protected abstract PreparedStatement getSqlSelectAll(Object obj);
    protected abstract PreparedStatement getSqlSelectById(Object obj);
    protected abstract PreparedStatement getSqlUpdateById(Object obj);
    protected abstract PreparedStatement getSqlDeleteById(Object obj);
}
