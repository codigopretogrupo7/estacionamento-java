package br.com.temvaga.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "cnh")
    private String CNH;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name="telefone")
    private String telefone;
    @Column(name="mode")
    private String mode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Estacionamento> estacionamentos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private  List<Veiculo> veiculo;

    // GETS
    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getCNH() {
        return CNH;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public String getTelefone() {return telefone;}
    public String getMode() {return mode;}

    public List<Integer> getEstacionamentos() {
        List<Integer> idsEstacionamentos = new ArrayList<Integer>();
        for( int i = 0 ; i < estacionamentos.toArray().length ; i++ ){
            idsEstacionamentos.add(estacionamentos.get(i).getId());
        }

        return idsEstacionamentos;
    }
    public List<Integer> getVeiculo() {
        List<Integer> idsVeiculos = new ArrayList<Integer>();
        for( int i = 0 ; i < veiculo.toArray().length ; i++ ){
            idsVeiculos.add(veiculo.get(i).getId());
        }

        return idsVeiculos;
    }

    //SETS

    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}
    public void setCNH(String CNH) {
        this.CNH = CNH;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String sennha) {
        this.senha = sennha;
    }
    public void setMode(String mode) {this.mode = mode;}
    public void setEstacionamentos(List<Estacionamento> estacionamentos) {
        this.estacionamentos = estacionamentos;
    }
    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }
    public void setTelefone(String telefone) {this.telefone = telefone;}

    // CONSTRUCTORS

    public Usuario() {}
}

