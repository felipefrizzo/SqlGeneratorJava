package br.univel.generics;

import br.univel.database.ConnectionDB;
import br.univel.enums.EstadoCivil;
import br.univel.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try {
            Client cl = new Client();
            ps = ex.getSqlSelectById(con, cl, integer);
            rs = ps.executeQuery();
            rs.next();

            EstadoCivil ec = EstadoCivil.values()[rs.getInt("ESTADOCIVIL")];
            cl = new Client(rs.getInt("id"), rs.getString("nome"),
                    rs.getString("endereco"), rs.getString("telefone"), ec);

            ps.close();
            rs.close();
            return cl;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void update(Client client) {
        try {
            ps = ex.getSqlUpdateById(con, client, client.getId());
            ps.executeUpdate();
            ps.close();

            System.out.println("Cliente atualizado com sucesso!");
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
    public void delete(Integer integer) {
        try {
            Client cl = new Client();
            ps = ex.getSqlDeleteById(con, cl, integer);
            ps.executeUpdate();
            ps.close();
            System.out.println("Cliente excluido com sucesso!");
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
    public List<Client> listAll() {
        try {
            Client cl = new Client();
            list = new ArrayList<Client>();
            ps = ex.getSqlSelectAll(con, cl);
            rs = ps.executeQuery();

            while (rs.next()) {
                EstadoCivil ec = EstadoCivil.values()[rs.getInt("ESTADOCIVIL")];
                list.add(new Client(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("endereco"), rs.getString("telefone"), ec));
            }

            ps.close();
            rs.close();

            if (list != null) {
                return list;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
