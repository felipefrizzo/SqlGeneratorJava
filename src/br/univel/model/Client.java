package br.univel.model;

import br.univel.annotation.Column;
import br.univel.annotation.Table;
import br.univel.enums.EstadoCivil;

/**
 * Created by felipefrizzo on 4/20/16.
 */
@Table("CAD_CLIENT")
public class Client {
    @Column(pk = true)
    private int id;
    @Column(name="NOME", size = 255)
    private String name;
    @Column(name="ENDERECO", size = 255)
    private String endereco;
    @Column(name="TELEFONE", size = 255)
    private String telefone;
    @Column(name="ESTADOCIVIL", size = 255)
    private EstadoCivil estadoCivil;

    public Client(int id, String name, String endereco, String telefone, EstadoCivil estadoCivil) {
        this.id = id;
        this.name = name;
        this.endereco = endereco;
        this.telefone = telefone;
        this.estadoCivil = estadoCivil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
