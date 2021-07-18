package br.com.temvaga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

private String nome;
private String sobreNome;
private String CNH;
private String email;
private String sennha;


}

