package br.com.temvaga.model;

public class EstacionamentoModel {
    private Integer idEstacionamento;
    private String  NomeEstacionamento;
    private String CEP;
    private String estado;
    private String bairro;
    private String logadouro;
    private String numero;
    private Integer numVagas;
    private Double vlHora;
    private Integer idUsuario;

public Integer getIdEstacionamento() {
    return idEstacionamento;
}

public void setIdEstacionamento(Integer idEstacionamento) {
    this.idEstacionamento = idEstacionamento;
}

public String getNomeEstacionamento() {
    return NomeEstacionamento;
}

public void setNomeEstacionamento(String nomeEstacionamento) {
    NomeEstacionamento = nomeEstacionamento;
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

public Integer getIdUsuario() {
    return idUsuario;
}

public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
}

public EstacionamentoModel(Integer idEstacionamento, String nomeEstacionamento, String CEP, String estado, String bairro, String logadouro, String numero, Integer numVagas, Double vlHora, Integer idUsuario) {
    this.idEstacionamento = idEstacionamento;
    NomeEstacionamento = nomeEstacionamento;
    this.CEP = CEP;
    this.estado = estado;
    this.bairro = bairro;
    this.logadouro = logadouro;
    this.numero = numero;
    this.numVagas = numVagas;
    this.vlHora = vlHora;
    this.idUsuario = idUsuario;
}
}
