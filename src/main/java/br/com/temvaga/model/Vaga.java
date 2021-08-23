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
   private String hora_entrada;
   @Column(name="dia_entrada")
   private String dia_entrada;
   @Column(name="mes_entrada")
   private String mes_entrada;

   @Column(name="num_vaga")
   private String numeroVaga;

   @ManyToOne
   @JoinColumn(name = "fk_estacionamento")
   private Estacionamento estacionamento;

   @OneToOne
   @JoinColumn(name = "fk_veiculo")
   private Veiculo veiculo;

   public Vaga(Integer id, String situacao, String dtEntrada, Estacionamento estacionamento, Veiculo veiculo) {
      this.id = id;
      this.situacao = situacao;
      this.hora_entrada = dtEntrada;
      this.estacionamento = estacionamento;
      this.veiculo = veiculo;
   }

   public Vaga(Integer id, String situacao, String hora_entrada, String dia_entrada, String mes_entrada, String numeroVaga, Estacionamento estacionamento, Veiculo veiculo) {
      this.id = id;
      this.situacao = situacao;
      this.hora_entrada = hora_entrada;
      this.dia_entrada = dia_entrada;
      this.mes_entrada = mes_entrada;
      this.numeroVaga = numeroVaga;
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

   public String getHora_entrada() {
      return hora_entrada;
   }

   public void setHora_entrada(String hora_entrada) {
      this.hora_entrada = hora_entrada;
   }

   public String getDia_entrada() {
      return dia_entrada;
   }

   public void setDia_entrada(String dia_entrada) {
      this.dia_entrada = dia_entrada;
   }


   public String getMes_entrada() {
      return mes_entrada;
   }

   public void setMes_entrada(String mes_entrada) {
      this.mes_entrada = mes_entrada;
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
