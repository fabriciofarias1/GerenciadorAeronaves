/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas.aereas.persistencia;

import empresas.aereas.modelo.Cliente;
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
public class DAOVenda {
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public DAOVenda() throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/empresas.aereas", "AERONAVES", "123");
        
    }
    
    
    public void vender(Aeronave aeronave) throws Exception {
         
        ps = con.prepareStatement("INSERT INTO AERONAVES.CLIENTE VALUES(?,?,?,?,?,?)");
        ps.setString(1, aeronave.getCodigoAeronave());
        ps.setDouble(2, aeronave.getNivelVoo());
        ps.setDouble(3, aeronave.getCapacidadeCarga());
        ps.setDouble(4, aeronave.getAutonomia());
        ps.setString(5, aeronave.getClass().getSimpleName());
        ps.execute();
    }

    public void vender(Aeronave aeronave, Cliente cliente) throws SQLException {
        ps = con.prepareStatement("INSERT INTO AERONAVES.VENDAS VALUES(?,?,?,?,?,?)");
        ps.setString(1, cliente.getCodigoCliente());
        ps.setString(2, cliente.getNomeCliente());
        ps.setString(3, cliente.getCpf());
        ps.setString(4, aeronave.getCodigoAeronave());
        ps.setString(5, aeronave.getTipoAeronave());
        ps.setDouble(6, aeronave.getAutonomia());
        ps.execute();
        
    }
    
    
    
    
}
