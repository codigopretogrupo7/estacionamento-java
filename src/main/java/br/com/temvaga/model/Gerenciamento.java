package br.com.temvaga.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gerenciamento")
public class Gerenciamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_gerenciamento")
    private Integer id;

    @Column(name = "hora_entrada")
    private  Date hrEntrada;
    @Column(name = "hora_saida")
    private Date hrSaida;
    @Column(name = "valor_recebido")
    private  double VlRecebido;


    @OneToOne
    @JoinColumn(name = "fk_estacionamento")
    private  Estacionamento estacionamento;

    @OneToOne
    @JoinColumn(name = "fk_vaga")
    private  Vaga vaga;

    @OneToOne
    @JoinColumn(name = "fk_veiculo")
    private  Veiculo veiculo;

}
