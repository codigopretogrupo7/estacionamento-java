package br.com.temvaga.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
@Table(name = "gerenciamento")
public class Gerenciamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name="data_hora")
    private Date dataHora;
    @Column(name="hora_saida")
    private Time hrSaida;
    @Column(name="hora_entrada")
    private  Time hrEntrada;
    @Column(name="valor_recebido")
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

    public Integer getId() {
        return id;
    }
    public Time getHrSaida() {
        return hrSaida;
    }
    public Time getHrEntrada() {
        return hrEntrada;
    }
    public double getVlRecebido() {
        return VlRecebido;
    }
    public int getEstacionamento() {
        return estacionamento.getId();
    }
    public int getVaga() {
        return vaga.getId();
    }
    public int getVeiculo() {
        return veiculo.getId();
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setHrSaida(Time hrSaida) {
        this.hrSaida = hrSaida;
    }
    public void setHrEntrada(Time hrEntrada) {
        this.hrEntrada = hrEntrada;
    }
    public void setVlRecebido(double vlRecebido) {
        VlRecebido = vlRecebido;
    }
    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }
    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }


    public Gerenciamento(Integer id,
                         Time hrSaida,
                         Time hrEntrada,
                         double vlRecebido,
                         Estacionamento estacionamento,
                         Vaga vaga,
                         Veiculo veiculo) {
        this.id = id;
        this.hrSaida = hrSaida;
        this.hrEntrada = hrEntrada;
        VlRecebido = vlRecebido;
        this.estacionamento = estacionamento;
        this.vaga = vaga;
        this.veiculo = veiculo;
    }

    public Gerenciamento() {}
}


