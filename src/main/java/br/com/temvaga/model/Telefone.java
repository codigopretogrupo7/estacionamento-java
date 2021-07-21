package br.com.temvaga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "telefone")
@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
