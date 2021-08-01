package br.com.temvaga.model;

import br.com.temvaga.enuns.Status;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
@Table(name = "vaga")
public class Vaga {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;


   private Status situacao;
   private String dtEntrada;
   private String numeroVaga;

   @ManyToOne
   @JoinColumn(name = "pk_id_estacionamento")
   private Estacionamento estacionamento;

   @OneToOne
   @JoinColumn(name = "pk_id_veiculo")
   private Veiculo veiculo;

   public Vaga(Integer id, Status situacao, String dtEntrada, Estacionamento estacionamento, Veiculo veiculo) {
      this.id = id;
      this.situacao = situacao;
      this.dtEntrada = dtEntrada;
      this.estacionamento = estacionamento;
      this.veiculo = veiculo;
   }


   public String getNumeroVaga() {
      return numeroVaga;
   }

   public void setNumeroVaga(String numeroVaga) {
      this.numeroVaga = numeroVaga;
   }

   public Vaga() {
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
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

   public int getEstacionamento() {
         return estacionamento.getId();
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
