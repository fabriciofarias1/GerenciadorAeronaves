/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas.aereas.modelo;

/**
 *
 * @author Fabricio
 */
public abstract class  AeronaveTransporte {
    
    private Double autonomia;
  

    /**
     * @return the autonomia
     */
    public Double getAutonomia() {
        return autonomia;
    }

    /**
     * @param autonomia the autonomia to set
     */
    public void setAutonomia(Double autonomia) {
        this.autonomia = autonomia;
    }
    
    public abstract Double obterValorVenda(); 
       
}

    
    
    

