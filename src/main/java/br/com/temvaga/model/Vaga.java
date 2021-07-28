package br.com.temvaga.model;

import br.com.temvaga.enuns.Status;

import javax.persistence.*;

@Entity
@Table(name = "vaga")
public class Vaga {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_Vaga")
   private int id;
   @Column(name = "situacao")
   private Status situacao;
   @Column(name = "hora_entrada")
   private String hrEntrada;
   @Column(name = "num_vaga")
   private String numeroVaga;



   @ManyToOne
   @JoinColumn(name = "fk_estacionamento")
   private Estacionamento estacionamento;

   @OneToOne
   @JoinColumn(name = "fk_veiculo")
   private Veiculo veiculo;


   public String getNumeroVaga() {
      return numeroVaga;
   }

   public void setNumeroVaga(String numeroVaga) {
      this.numeroVaga = numeroVaga;
   }


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Status getSituacao() {
      return situacao;
   }

   public void setSituacao(Status situacao) {
      this.situacao = situacao;
   }

   public String getDtEntrada() {
      return hrEntrada;
   }

   public void setDtEntrada(String dtEntrada) {
      this.hrEntrada = dtEntrada;
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
