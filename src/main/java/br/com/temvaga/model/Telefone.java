package br.com.temvaga.model;


import javax.persistence.*;


@Table(name = "telefone")
@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String Telefone;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getTelefone() {
    return Telefone;
}

public void setTelefone(String telefone) {
    Telefone = telefone;
}

public Telefone(Integer id, String telefone) {
    this.id = id;
    Telefone = telefone;
}

public Telefone(){}
}
