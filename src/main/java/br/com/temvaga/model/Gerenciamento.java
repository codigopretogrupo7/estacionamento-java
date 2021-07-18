package br.com.temvaga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gerenciamento")
public class Gerenciamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date hrSaida;
    private  Date hrEntrada;
    private  double VlRecebido;


    @OneToOne
    private  Estacionamento estacionamento;

    @OneToOne
    private  Vaga vaga;

    @OneToOne
    private  Veiculo veiculo;

}
