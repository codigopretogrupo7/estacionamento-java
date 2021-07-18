package br.com.temvaga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cor;
    private String modelo;
    private String placa;


    @ManyToOne
    @JoinColumn(name = "fk_id_usuario")
    private Usuario usuario;

}
