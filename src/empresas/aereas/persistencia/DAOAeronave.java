/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas.aereas.persistencia;

import empresas.aereas.modelo.Cliente;
import empresas.aereas.modelo.Jato;
import empresas.aereas.modelo.TurboHelice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ministerio.aeronautica.modelo.Aeronave;

/**
 *
 * @author Fabricio
 */
public class DAOAeronave {
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
   
    public DAOAeronave() throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/empresas.aereas", "AERONAVES", "123");       
    }
    
    public void incluir(Aeronave aeronave) throws Exception {
         
        ps = con.prepareStatement("INSERT INTO AERONAVES.AERONAVES VALUES(?,?,?,?,?)");
        ps.setString(1, aeronave.getCodigoAeronave());
        ps.setDouble(2, aeronave.getNivelVoo());
        ps.setDouble(3, aeronave.getCapacidadeCarga());
        ps.setDouble(4, aeronave.getAutonomia());
        ps.setString(5, aeronave.getClass().getSimpleName());
        ps.execute();
    }
    
    
    public void excluir (Aeronave aeronave) throws Exception {
        ps = con.prepareStatement("DELETE FROM AERONAVES.AERONAVES WHERE CODIGO_AERONAVE = ?");
        ps.setString(1, aeronave.getCodigoAeronave());
        ps.execute();
    } 
    
    public void alterar (Aeronave aeronave) throws Exception { 
        ps = con.prepareStatement("UPDATE AERONAVES.AERONAVES SET CODIGO_AERONAVE = ?, NIVELVOO = ?, CAPACIDADECARGA = ?, AUTONOMIA = ?, TIPO = ? WHERE CODIGO_AERONAVE = ?");
        ps.setString(1, aeronave.getCodigoAeronave());
        ps.setDouble(2, aeronave.getNivelVoo());
        ps.setDouble(3, aeronave.getCapacidadeCarga());
        ps.setDouble(4, aeronave.getAutonomia());
        ps.setString(5, aeronave.getClass().getSimpleName());
        ps.setString(6, aeronave.getCodigoAeronave());
        ps.execute();
    }

    public Aeronave consultar(Aeronave aeronave) throws SQLException {
        Aeronave aux = null;
        ps = con.prepareStatement("SELECT * FROM AERONAVES.AERONAVES WHERE CODIGO_AERONAVE = ?");
        ps.setString(1, aeronave.getCodigoAeronave());
        rs = ps.executeQuery();
        if (rs.next()) {
            if (rs.getString(5).equals("Jato")) {
                aux = new Jato();
            } else {
                aux = new TurboHelice();
            }
            aux.setCodigoAeronave(rs.getString(1));
            aux.setNivelVoo(rs.getInt(2));
            aux.setCapacidadeCarga(rs.getDouble(3));
            aux.setAutonomia(rs.getDouble(4));
            aux.setTipoAeronave(rs.getString(5));
        }
        return aux;

    }

    public void vender(Aeronave aeronave) throws SQLException {
        
        ps = con.prepareStatement("INSERT INTO AERONAVES.CLIENTE VALUES(?,?,?,?,?,?)");
       
        ps.setDouble(2, aeronave.getNivelVoo());
        ps.setDouble(3, aeronave.getCapacidadeCarga());
        ps.setDouble(4, aeronave.getAutonomia());
        ps.setString(5, aeronave.getClass().getSimpleName());
        ps.execute();
    }

   
}
