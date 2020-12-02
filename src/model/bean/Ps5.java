/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

public class Ps5 extends game {

    private String memoria;
    private String qtdControle;
    private String roda4k;

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getQtdControle() {
        return qtdControle;
    }

    public void setQtdControle(String qtdControle) {
        this.qtdControle = qtdControle;
    }

    public String getRoda4k() {
        return roda4k;
    }

    public void setRoda4k(String roda4k) {
        this.roda4k = roda4k;
    }
    // Construtor
    public Ps5(String memoria, String qtdControle, String roda4k) {
        this.memoria = memoria;
        this.qtdControle = qtdControle;
        this.roda4k = roda4k;
    }
    public Ps5(){
        
    this.memoria = "";
    this.qtdControle = "";
    this.roda4k = "";
    
    }
    


}
