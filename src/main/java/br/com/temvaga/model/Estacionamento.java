package br.com.temvaga.model;



import br.com.temvaga.enuns.DiasSemana;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estacionamento")
@Entity
public class Estacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  nomeEstacionamento;
    private String  descricao;
    private byte[] foto;

    private String CEP;
    private String estado;
    private String bairro;
    private String logadouro;
    private String numero;
    private String lat;
    private String lng;

    private Integer numVagas;
    private Double vlHora;
    private Double vlDiaria;
    private Double vlAdicional;
    private String frame; //?
    private String hrAbertura;
    private String hrFechamento;


    private ArrayList<DiasSemana> diasFuncionamento;

    private String emailEstacionamento;
    private String senhaEstacionamento;

    private Integer idUsuario;
    private  String imgURL;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuario")
    private Usuario usuario;


}
