package br.univel;

import br.univel.annotation.Column;
import br.univel.annotation.Table;

/**
 * Created by felipefrizzo on 4/20/16.
 */
@Table("CAD_CLIENT")
public class Client {
    @Column(pk = true)
    private int id;
    @Column(name="Nome")
    private String name;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
