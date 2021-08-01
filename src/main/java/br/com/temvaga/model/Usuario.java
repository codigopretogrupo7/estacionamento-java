package br.com.temvaga.model;

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
    @Column(name = "id_usuario")
    private Integer id;
    @Column(name = "nome_usuario")
    private String nome;
    @Column(name = "sobrenome_usuario")
    private String sobreNome;
    @Column(name = "cnh")
    private String CNH;
    @Column(name = "email_usuario")
    private String email;
    @Column(name = "senha_usuario")
    private String sennha;

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
    public String getSobreNome() {
        return sobreNome;
    }
    public String getCNH() {
        return CNH;
    }
    public String getEmail() {
        return email;
    }
    public String getSennha() {
        return sennha;
    }

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
    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
    public void setCNH(String CNH) {
        this.CNH = CNH;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSennha(String sennha) {
        this.sennha = sennha;
    }

    public void setEstacionamentos(List<Estacionamento> estacionamentos) {
        this.estacionamentos = estacionamentos;
    }
    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }

    // CONSTRUCTORS

    public Usuario(
            Integer id,
            String nome,
            String sobreNome,
            String CNH,
            String email,
            String sennha,
            ArrayList<Estacionamento> estacionamentos) {
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

