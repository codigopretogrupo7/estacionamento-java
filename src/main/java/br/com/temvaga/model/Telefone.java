package br.com.temvaga.model;


import javax.persistence.*;

@Table(name = "telefone")
@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private  Integer id;
    @Column(name = "telefone")
    private  String telefone;

    @ManyToOne
    @JoinColumn(name="fk_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="fk_estacionamento")
    private Estacionamento estacionamento;

    public Integer getId() {
        return id;
    }
    public String getTelefone() {
        return this.telefone;
    }
     public int getUsuario() {return usuario.getId();}
     public int getEstacionamento() {return estacionamento.getId();}

    public void setId(Integer id) {
        this.id = id;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
     public void setUsuario(Usuario usuario) {this.usuario = usuario;}
     public void setEstacionamento(Estacionamento estacionamento) {this.estacionamento = estacionamento;}


    public Telefone(String telefone, Usuario usuario) {
        this.telefone = telefone;
        this.usuario = usuario;
    }
    public Telefone(String telefone, Estacionamento estacionamento) {
        this.telefone = telefone;
        this.estacionamento = estacionamento;
    }

    public Telefone(){}
}
