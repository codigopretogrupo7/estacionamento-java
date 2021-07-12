package br.com.temvaga.model;

import br.com.temvaga.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vaga")
public class Vaga {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Enumerated(EnumType.STRING)
   private Status situacao;
   private String dtEntrada;


   @ManyToOne
   @JoinColumn(name = "idEstacionamento")
   private Estacionamento estacionamento;

   @OneToOne
   @JoinColumn(name = "id")
   private Veiculo veiculo;

}
