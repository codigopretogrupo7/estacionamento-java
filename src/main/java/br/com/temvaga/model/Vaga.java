package br.com.temvaga.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "vaga")
public class Vaga {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
   private Integer id;

   private String situacao;
   @Column(name="hora_entrada")
   private Date dtEntrada;
   @Column(name="num_vaga")
   private String numeroVaga;

   @ManyToOne
   @JoinColumn(name = "fk_estacionamento")
   private Estacionamento estacionamento;

   @OneToOne
   @JoinColumn(name = "fk_veiculo")
   private Veiculo veiculo;

   public Vaga(Integer id, String situacao, Date dtEntrada, Estacionamento estacionamento, Veiculo veiculo) {
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

   public String getSituacao() {
      return situacao;
   }

   public void setSituacao(String situacao) {
      this.situacao = situacao;
   }

   public Date getDtEntrada() {
      return dtEntrada;
   }

   public void setDtEntrada(Date dtEntrada) {
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
