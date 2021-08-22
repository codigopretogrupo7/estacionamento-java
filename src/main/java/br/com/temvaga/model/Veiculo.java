package br.com.temvaga.model;


import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cor;
    private String modelo;
    private String placa;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    public Integer getId() {
        return id;
    }
    public String getCor() {
        return cor;
    }
    public String getModelo() {return modelo;}
    public String getPlaca() {
        return placa;
    }
    public Usuario getUsuario() {return usuario;}

    public void setId(Integer id) {
        this.id = id;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Veiculo(Integer id,
                   String cor,
                   String modelo,
                   String placa,
                   Usuario usuario) {
        this.id = id;
        this.cor = cor;
        this.modelo = modelo;
        this.placa = placa;
        this.usuario = usuario;
    }

    public Veiculo(Integer id,
                   String cor,
                   String modelo,
                   String placa,
                   String usuarioTemporario) {
        this.id = id;
        this.cor = cor;
        this.modelo = modelo;
        this.placa = placa;
    }


    public Veiculo() {
    }
}
