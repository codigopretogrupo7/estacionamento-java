package br.com.temvaga.model;

import br.com.temvaga.enuns.DiasSemana;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

import java.util.ArrayList;

@Entity
@Table(name = "estacionamento")
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacionamento")
    private Integer id;
    @Column(name = "nome_estacionamento")
    private String  nomeEstacionamento;
    @Column(name = "descricao")
    private String  descricao;
    @Column(name = "foto")
    private byte[] foto;

    @Column(name = "cep")
    private String CEP;
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
    @Column(name = "valor_diaria")
    private Double vlDiaria;
    @Column(name = "demais_valor_hora")
    private Double vlAdicional;
    @Column(name = "frame")
    private String frame;
    @Column(name = "horario_abertura")
    private String hrAbertura;
    @Column(name = "horario_fechamento")
    private String hrFechamento;

    private ArrayList<DiasSemana> diasFuncionamento;

    @Column(name = "email_estacionamento")
    private String emailEstacionamento;
    @Column(name = "senha_estacionamento")
    private String senhaEstacionamento;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuario")
    private Usuario usuario;

    //gets
    public int getUsuario() {
        return usuario.getId();
    }
    public Integer getId() {
            return id;
        }
    public String getNomeEstacionamento() {
        return nomeEstacionamento;
    }
    public String getDescricao() {
        return descricao;
    }
    public byte[] getFoto() {
        return foto;
    }
    public String getCEP() {
        return CEP;
    }
    public String getEstado() {
        return estado;
    }
    public String getCidade() {return cidade;}
    public String getBairro() {return bairro;}
    public String getLogadouro() {
        return logadouro;
    }
    public String getNumero() {
        return numero;
    }
    public String getLat() {
        return lat;
    }
    public String getLng() {
        return lng;
    }
    public Integer getNumVagas() {
        return numVagas;
    }
    public Double getVlHora() {
        return vlHora;
    }
    public Double getVlDiaria() {
        return vlDiaria;
    }
    public Double getVlAdicional() {
        return vlAdicional;
    }
    public String getFrame() {
        return frame;
    }
    public String getHrAbertura() {
        return hrAbertura;
    }
    public String getHrFechamento() {
        return hrFechamento;
    }
    public ArrayList<DiasSemana> getDiasFuncionamento() {
        return diasFuncionamento;
    }
    public String getEmailEstacionamento() {
        return emailEstacionamento;
    }
    public String getSenhaEstacionamento() {
        return senhaEstacionamento;
    }

    //sets
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNomeEstacionamento(String nomeEstacionamento) {
        this.nomeEstacionamento = nomeEstacionamento;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setCidade(String cidade) {this.cidade = cidade;}
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public void setLng(String lng) {
        this.lng = lng;
    }
    public void setNumVagas(Integer numVagas) {
        this.numVagas = numVagas;
    }
    public void setVlHora(Double vlHora) {
        this.vlHora = vlHora;
    }
    public void setVlDiaria(Double vlDiaria) {
        this.vlDiaria = vlDiaria;
    }
    public void setVlAdicional(Double vlAdicional) {
        this.vlAdicional = vlAdicional;
    }
    public void setFrame(String frame) {
        this.frame = frame;
    }
    public void setHrAbertura(String hrAbertura) {
        this.hrAbertura = hrAbertura;
    }
    public void setHrFechamento(String hrFechamento) {
        this.hrFechamento = hrFechamento;
    }
    public void setDiasFuncionamento(ArrayList<DiasSemana> diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }
    public void setEmailEstacionamento(String emailEstacionamento) {
        this.emailEstacionamento = emailEstacionamento;
    }
    public void setSenhaEstacionamento(String senhaEstacionamento) {
        this.senhaEstacionamento = senhaEstacionamento;
    }

    //constructors
    public Estacionamento(
            Integer id,
            String nomeEstacionamento,
            String descricao,
            byte[] foto,
            String CEP,
            String estado,
            String bairro,
            String logadouro,
            String numero,
            String lat,
            String lng,
            Integer numVagas,
            Double vlHora,
            Double vlDiaria,
            Double vlAdicional,
            String frame,
            String hrAbertura,
            String hrFechamento,
            ArrayList<DiasSemana> diasFuncionamento,
            String emailEstacionamento,
            String senhaEstacionamento,
            String imgURL,
            Usuario usuario) {
        this.id = id;
        this.nomeEstacionamento = nomeEstacionamento;
        this.descricao = descricao;
        this.foto = foto;
        this.CEP = CEP;
        this.estado = estado;
        this.bairro = bairro;
        this.logadouro = logadouro;
        this.numero = numero;
        this.lat = lat;
        this.lng = lng;
        this.numVagas = numVagas;
        this.vlHora = vlHora;
        this.vlDiaria = vlDiaria;
        this.vlAdicional = vlAdicional;
        this.frame = frame;
        this.hrAbertura = hrAbertura;
        this.hrFechamento = hrFechamento;
        this.diasFuncionamento = diasFuncionamento;
        this.emailEstacionamento = emailEstacionamento;
        this.senhaEstacionamento = senhaEstacionamento;
    }

    public Estacionamento(){}
}
