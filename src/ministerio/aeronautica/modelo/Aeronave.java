/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ministerio.aeronautica.modelo;

import empresas.aereas.modelo.AeronaveTransporte;

/**
 *
 * @author Fabricio
 */
public abstract class Aeronave extends AeronaveTransporte {
    private String codigoAeronave, tipoAeronave;
    private Integer nivelVoo;
    private Double capacidadeCarga;

    /**
     * @return the codigoAeronave
     */
    public String getCodigoAeronave() {
        return codigoAeronave;
    }

    /**
     * @param codigoAeronave the codigoAeronave to set
     */
    public void setCodigoAeronave(String codigoAeronave) {
        this.codigoAeronave = codigoAeronave;
    }

    /**
     * @return the nivelVoo
     */
    public Integer getNivelVoo() {
        return nivelVoo;
    }

    /**
     * @param nivelVoo the nivelVoo to set
     */
    public void setNivelVoo(Integer nivelVoo) {
        this.nivelVoo = nivelVoo;
    }

    /**
     * @return the capacidadeCarga
     */
    public Double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    /**
     * @param capacidadeCarga the capacidadeCarga to set
     */
    public void setCapacidadeCarga(Double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    /**
     * @return the tipoAeronave
     */
    public String getTipoAeronave() {
        return tipoAeronave;
    }

    /**
     * @param tipoAeronave the tipoAeronave to set
     */
    public void setTipoAeronave(String tipoAeronave) {
        this.tipoAeronave = tipoAeronave;
    }
    
    
    
}
