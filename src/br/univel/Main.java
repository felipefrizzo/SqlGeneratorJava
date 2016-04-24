package br.univel;

import br.univel.database.ConnectionDB;
import br.univel.enums.EstadoCivil;
import br.univel.generics.ClientDaoImplatation;
import br.univel.generics.Execute;
import br.univel.model.Client;

import java.sql.Connection;
import java.util.List;

/**
 * Created by felipefrizzo on 4/21/16.
 */
public class Main {
    public Main() {

    }

    public void createTable() {
        Execute ex = new Execute();
        Connection con = ConnectionDB.getInstance().open();
        ex.getCreateTable(con, new Client());
    }

    public void deleteTable() {
        Execute ex = new Execute();
        Connection con = ConnectionDB.getInstance().open();
        ex.getDropTable(con, new Client());
    }

    public void insert(Client cl) {
        ClientDaoImplatation dao = new ClientDaoImplatation();
        dao.save(cl);
    }

    public void update(Client cl) {
        ClientDaoImplatation dao = new ClientDaoImplatation();
        dao.update(cl);
    }

    public void delete(Integer id) {
        ClientDaoImplatation dao = new ClientDaoImplatation();
        dao.delete(2);
    }

    public void search(Integer id) {
        ClientDaoImplatation dao = new ClientDaoImplatation();
        Client cl = dao.search(id);

        System.out.println("ID: \t\t\t" + cl.getId());
        System.out.println("NOME: \t\t\t" + cl.getName());
        System.out.println("ENDERECO: \t\t" + cl.getEndereco());
        System.out.println("TELEFONE: \t\t" + cl.getTelefone());
        System.out.println("ESTADO CIVIL: \t" + cl.getEstadoCivil());
        System.out.println();
    }

    public void listAll() {
        ClientDaoImplatation dao = new ClientDaoImplatation();
        List<Client> list = dao.listAll();

        System.out.println("LISTAR TODOS\n");
        for (Client l: list) {
            System.out.println("ID: \t\t\t" + l.getId());
            System.out.println("NOME: \t\t\t" + l.getName());
            System.out.println("ENDERECO: \t\t" + l.getEndereco());
            System.out.println("TELEFONE: \t\t" + l.getTelefone());
            System.out.println("ESTADO CIVIL: \t" + l.getEstadoCivil());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Client cl1 = new Client(1, "Felipe", "Rua: Nao Sei", "(45)9970-7070", EstadoCivil.SOLTEIRO);
        Client cl2 = new Client(2, "Frizzo", "Rua: Jaozinho da Silva", "(45)9970-7070", EstadoCivil.CASADO);
        Client cl3 = new Client(3, "Felipe Felipe", "Rua: Brasil", "(45)9970-7070", EstadoCivil.VIUVO);

        Client cl_update = new Client(1, "Felipe Felipe", "Rua: Python <3", "(45)9969-6970", EstadoCivil.CASADO);

        Main main = new Main();
        //Table
        main.deleteTable();
        main.createTable();
        //Obj
        main.insert(cl1);
        main.insert(cl2);
        main.insert(cl3);

        main.listAll();
        main.search(1);

        main.update(cl_update);
        main.delete(2);
        
        main.listAll();
    }
}
