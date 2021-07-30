package br.com.temvaga.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "usuario")
public class Usuario {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

private String nome;
private String sobreNome;
private String CNH;
private String email;
private String sennha;


@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
@JsonIgnore
private List<Estacionamento> estacionamentos;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
@JsonIgnore
private  List<Veiculo> veiculo;



public void setEstacionamentos(List<Estacionamento> estacionamentos) {
    this.estacionamentos = estacionamentos;
}

public List<Veiculo> getVeiculo() {
    return veiculo;
}

public void setVeiculo(List<Veiculo> veiculo) {
    this.veiculo = veiculo;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getSobreNome() {
    return sobreNome;
}

public void setSobreNome(String sobreNome) {
    this.sobreNome = sobreNome;
}

public String getCNH() {
    return CNH;
}

public void setCNH(String CNH) {
    this.CNH = CNH;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getSennha() {
    return sennha;
}

public void setSennha(String sennha) {
    this.sennha = sennha;
}

public List<Estacionamento> getEstacionamentos() {
    return estacionamentos;
}

public void setEstacionamentos(ArrayList<Estacionamento> estacionamentos) {
    this.estacionamentos = estacionamentos;
}

public Usuario(Integer id, String nome, String sobreNome, String CNH, String email, String sennha, ArrayList<Estacionamento> estacionamentos) {
    this.id = id;
    this.nome = nome;
    this.sobreNome = sobreNome;
    this.CNH = CNH;
    this.email = email;
    this.sennha = sennha;
    this.estacionamentos = estacionamentos;
}

public Usuario() {
}
}

