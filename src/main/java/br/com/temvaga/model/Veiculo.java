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

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getCor() {
    return cor;
}

public void setCor(String cor) {
    this.cor = cor;
}

public String getModelo() {
    return modelo;
}

public void setModelo(String modelo) {
    this.modelo = modelo;
}

public String getPlaca() {
    return placa;
}

public void setPlaca(String placa) {
    this.placa = placa;
}

public Usuario getUsuario() {
    return usuario;
}

public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
}

public Veiculo(Integer id, String cor, String modelo, String placa, Usuario usuario) {
    this.id = id;
    this.cor = cor;
    this.modelo = modelo;
    this.placa = placa;
    this.usuario = usuario;
}

public Veiculo() {
}
}
