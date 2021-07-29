package br.com.temvaga.model;

import br.com.temvaga.enuns.Status;


import javax.persistence.*;


@Entity
@Table(name = "vaga")
public class Vaga {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   private Status situacao;
   private String dtEntrada;

   @ManyToOne
   @JoinColumn(name = "pk_id_estacionamento")
   private Estacionamento estacionamento;

   @OneToOne
   @JoinColumn(name = "pk_id_veiculo")
   private Veiculo veiculo;


public Vaga(Long id, Status situacao, String dtEntrada, Estacionamento estacionamento, Veiculo veiculo) {
   this.id = id;
   this.situacao = situacao;
   this.dtEntrada = dtEntrada;
   this.estacionamento = estacionamento;
   this.veiculo = veiculo;
}

public Vaga() {
}

public Long getId() {
   return id;
}

public void setId(Long id) {
   this.id = id;
}

public Status getSituacao() {
   return situacao;
}

public void setSituacao(Status situacao) {
   this.situacao = situacao;
}

public String getDtEntrada() {
   return dtEntrada;
}

public void setDtEntrada(String dtEntrada) {
   this.dtEntrada = dtEntrada;
}

public Estacionamento getEstacionamento() {
   return estacionamento;
}

public void setEstacionamento(Estacionamento estacionamento) {
   this.estacionamento = estacionamento;
}

public Veiculo getVeiculo() {
   return veiculo;
}

public void setVeiculo(Veiculo veiculo) {
   this.veiculo = veiculo;
}


}
