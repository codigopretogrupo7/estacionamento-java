package br.com.temvaga.model;

import java.sql.*;
import java.util.ArrayList;


public class Database {
    private Statement executorQuery;
    private Connection conn;

    public Database() {
        try {

            //String url = "jdbc:mysql://localhost:3306/temvaga"; ## usando o mysql ##
            String url = "jdbc:postgresql://localhost:5432/temvaga";
            String usuario = "postgres";
            String senha = "aloisk";
            conn = DriverManager.getConnection(url, usuario, senha);

            this.executorQuery  = conn.createStatement();
        } catch (SQLException e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }


    public void setEstacionamento(EstacionamentoModel estacionamentoModel){


    }

    public ArrayList<EstacionamentoModel> getEstacionamentos() {
        ArrayList listaEstacionamento= new ArrayList<EstacionamentoModel>();
        ResultSet resultado;
        try {
            resultado = this.executorQuery.executeQuery("SELECT * from estacionamento");

            while(resultado.next()){
                EstacionamentoModel estacionamentoModel = new EstacionamentoModel(
                        resultado.getInt("Id_Estacionamento"),
                        resultado.getString("Nome_estacionamento"),
                        resultado.getString("CEP"),
                        resultado.getString("Estado"),
                        resultado.getString("Bairro"),
                        resultado.getString("Logradouro"),
                        resultado.getString("Numero"),
                        resultado.getInt("Numero_Vagas"),
                        resultado.getDouble("Valor_Hora"),
                        resultado.getInt("FK_Id_Usuario"));
                listaEstacionamento.add(estacionamentoModel);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaEstacionamento;
    }
}
