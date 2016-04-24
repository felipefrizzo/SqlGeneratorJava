package br.univel.generics;

import br.univel.database.ConnectionDB;
import br.univel.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by felipefrizzo on 4/24/16.
 */
public class ClientDaoImplatation implements Dao<Client,Integer> {
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection con = ConnectionDB.getInstance().open();
    private Execute ex = new Execute();
    private List<Client> list = null;
    
    @Override
    public void save(Client client) {
        try {
            ps = ex.getSqlInsert(con, client);
            ps.executeUpdate();
            ps.close();

            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Client search(Integer integer) {
        return null;
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Client> listAll() {
        return null;
    }
}
