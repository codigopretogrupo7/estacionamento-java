package br.com.temvaga.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import java.util.Date;


@Entity
@Table(name = "gerenciamento")
public class Gerenciamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date hrSaida;
    private  Date hrEntrada;
    private  double VlRecebido;


    @OneToOne
    @JoinColumn(name = "pk_id_estacionamento")
    private  Estacionamento estacionamento;

    @OneToOne
    @JoinColumn(name = "pk_id_vaga")
    private  Vaga vaga;

    @OneToOne
    @JoinColumn(name = "pk_id_veiculo")
    private  Veiculo veiculo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHrSaida() {
        return hrSaida;
    }

    public void setHrSaida(Date hrSaida) {
        this.hrSaida = hrSaida;
    }

    public Date getHrEntrada() {
        return hrEntrada;
    }

    public void setHrEntrada(Date hrEntrada) {
        this.hrEntrada = hrEntrada;
    }

    public double getVlRecebido() {
        return VlRecebido;
    }

    public void setVlRecebido(double vlRecebido) {
        VlRecebido = vlRecebido;
    }

    public int getEstacionamento() {
        return estacionamento.getId();
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    public int getVaga() {
        return vaga.getId();
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public int getVeiculo() {
        return veiculo.getId();
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Gerenciamento(Integer id, Date hrSaida, Date hrEntrada, double vlRecebido, Estacionamento estacionamento, Vaga vaga, Veiculo veiculo) {
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


