package br.com.temvaga.model;



import br.com.temvaga.enuns.DiasSemana;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;



@Table(name = "estacionamento")
@Entity
public class Estacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  nomeEstacionamento;
    private String  descricao;
    private byte[] foto;

    private String CEP;
    private String estado;
    private String bairro;
    private String logadouro;
    private String numero;
    private String lat;
    private String lng;

    private Integer numVagas;
    private Double vlHora;
    private Double vlDiaria;
    private Double vlAdicional;
    private String frame; //?
    private String hrAbertura;
    private String hrFechamento;


    private ArrayList<DiasSemana> diasFuncionamento;

    private String emailEstacionamento;
    private String senhaEstacionamento;

    private Integer idUsuario;
    private  String imgURL;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuario")
    private Usuario usuario;

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

public String getCEP() {
    return CEP;
}

public void setCEP(String CEP) {
    this.CEP = CEP;
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

public Integer getIdUsuario() {
    return idUsuario;
}

public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
}

public String getImgURL() {
    return imgURL;
}

public void setImgURL(String imgURL) {
    this.imgURL = imgURL;
}

public Usuario getUsuario() {
    return usuario;
}

public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
}

public Estacionamento(Integer id, String nomeEstacionamento, String descricao, byte[] foto, String CEP, String estado, String bairro, String logadouro, String numero, String lat, String lng, Integer numVagas, Double vlHora, Double vlDiaria, Double vlAdicional, String frame, String hrAbertura, String hrFechamento, ArrayList<DiasSemana> diasFuncionamento, String emailEstacionamento, String senhaEstacionamento, Integer idUsuario, String imgURL, Usuario usuario) {
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
    this.idUsuario = idUsuario;
    this.imgURL = imgURL;
    this.usuario = usuario;
}

public Estacionamento() {
}
}
