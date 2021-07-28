package br.com.temvaga.model;

import br.com.temvaga.enuns.DiasSemana;

import javax.persistence.*;
import java.util.ArrayList;



@Table(name = "estacionamento")
@Entity
public class Estacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacionamento")
    private Integer id;
    @Column(name = "nome_estacionamento")
    private String nomeEstacionamento;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "foto")
    private byte[] foto;

    @Column(name = "cep")
    private String cep;
    @Column(name = "estado")
    private String estado;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "logradouro")
    private String logadouro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "latitude")
    private String lat;
    @Column(name = "longitude")
    private String lng;

    @Column(name = "numero_vagas")
    private Integer numVagas;
    @Column(name = "valor_hora")
    private Double vlHora;
    @Column(name = "demais_valor_hora")
    private Double vlAdicional;
    @Column(name = "valor_diaria")
    private Double vlDiaria;
    @Column(name = "frame")
    private String frame; //?
    @Column(name = "horario_abertura")
    private String hrAbertura;
    @Column(name = "horario_fechamento")
    private String hrFechamento;

    private int idUsuario;

    @Column(name = "")
    private ArrayList<DiasSemana> diasFuncionamento;

    @Column(name = "email_estacionamento")
    private String emailEstacionamento;
    @Column(name = "senha_estacionamento")
    private String senhaEstacionamento;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "fk_id_usuario")
    private Usuario usuario ;



    public Estacionamento(Integer id, String nomeEstacionamento,
                          String descricao, byte[] foto,
                          String cep, String estado, String cidade,
                          String bairro, String logadouro,
                          String numero, String lat,
                          String lng, Integer numVagas,
                          Double vlHora, Double vlDiaria,
                          Double vlAdicional, String frame,
                          String hrAbertura, String hrFechamento,
                          ArrayList<DiasSemana> diasFuncionamento,
                          String emailEstacionamento, String senhaEstacionamento,
                          Integer idUsuario, Usuario usuario) {
    this.id = id;
    this.nomeEstacionamento = nomeEstacionamento;
    this.descricao = descricao;
    this.foto = foto;
    this.cep = cep;
    this.estado = estado;
    this.cidade = cidade;
    this.bairro = bairro;
    this.logadouro = logadouro;
    this.numero = numero;
    this.lat = lat;
    this.lng = lng;
    this.numVagas = numVagas;
    this.diasFuncionamento = diasFuncionamento;
    this.vlHora = vlHora;
    this.vlAdicional = vlAdicional;
    this.vlDiaria = vlDiaria;
    this.hrAbertura = hrAbertura;
    this.hrFechamento = hrFechamento;
    this.frame = frame;
    this.emailEstacionamento = emailEstacionamento;
    this.senhaEstacionamento = senhaEstacionamento;
    this.idUsuario = idUsuario;
    this.usuario = usuario;
}


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {return idUsuario;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeEstacionamento() {
        return nomeEstacionamento;
    }

    public void setNomeEstacionamento(String nomeEstacionamento) {
        this.nomeEstacionamento = nomeEstacionamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Integer getNumVagas() {
        return numVagas;
    }

    public void setNumVagas(Integer numVagas) {
        this.numVagas = numVagas;
    }

    public Double getVlHora() {
        return vlHora;
    }

    public void setVlHora(Double vlHora) {
        this.vlHora = vlHora;
    }

    public Double getVlDiaria() {
        return vlDiaria;
    }

    public void setVlDiaria(Double vlDiaria) {
        this.vlDiaria = vlDiaria;
    }

    public Double getVlAdicional() {
        return vlAdicional;
    }

    public void setVlAdicional(Double vlAdicional) {
        this.vlAdicional = vlAdicional;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getHrAbertura() {
        return hrAbertura;
    }

    public void setHrAbertura(String hrAbertura) {
        this.hrAbertura = hrAbertura;
    }

    public String getHrFechamento() {
        return hrFechamento;
    }

    public void setHrFechamento(String hrFechamento) {
        this.hrFechamento = hrFechamento;
    }

    public ArrayList<DiasSemana> getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public void setDiasFuncionamento(ArrayList<DiasSemana> diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }

    public String getEmailEstacionamento() {
        return emailEstacionamento;
    }

    public void setEmailEstacionamento(String emailEstacionamento) {
        this.emailEstacionamento = emailEstacionamento;
    }

    public String getSenhaEstacionamento() {
        return senhaEstacionamento;
    }

    public void setSenhaEstacionamento(String senhaEstacionamento) {
        this.senhaEstacionamento = senhaEstacionamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


public Estacionamento() {
}
}
