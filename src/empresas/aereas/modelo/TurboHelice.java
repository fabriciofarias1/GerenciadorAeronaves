/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas.aereas.modelo;

import ministerio.aeronautica.modelo.Aeronave;

/**
 *
 * @author Fabricio
 */
public class TurboHelice extends Aeronave {

    @Override
    public Double obterValorVenda() {
       
            return (getNivelVoo() * getCapacidadeCarga()) / 2 * getAutonomia();
        
    }
    
}
