package br.univel.generics;

import br.univel.model.Client;

import java.util.List;

/**
 * Created by felipefrizzo on 4/24/16.
 */
public class ClientDaoImplatation implements Dao<Client,Integer> {
    @Override
    public void save(Client client) {

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
