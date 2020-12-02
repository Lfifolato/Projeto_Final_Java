/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;


public class game {

    private int IdVideoGame;
    private String NomeDoVideoGame;
    private String NomeDoJogo;
    private Xbox xbox;
    private Ps5 ps5;

    public Ps5 getPs5() {
        return ps5;
    }

    public void setPs5(Ps5 ps5) {
        this.ps5 = ps5;
    }

    public Xbox getXbox() {
        return xbox;
    }

    public void setXbox(Xbox xbox) {
        this.xbox = xbox;
    }
       

    public int getIdVideoGame() {
        return IdVideoGame;
    }

    public void setIdVideoGame(int IdVideoGame) {
        this.IdVideoGame = IdVideoGame;
    }

    public String getNomeDoVideoGame() {
        return NomeDoVideoGame;
    }

    public void setNomeDoVideoGame(String NomeDoVideoGame) {
        this.NomeDoVideoGame = NomeDoVideoGame;
    }

    public String getNomeDoJogo() {
        return NomeDoJogo;
    }

    public void setNomeDoJogo(String NomeDoJogo) {
        this.NomeDoJogo = NomeDoJogo;
    }

    public game(int IdVideoGame, String NomeDoVideoGame, String NomeDoJogo, Xbox xbox) {
        this.IdVideoGame = IdVideoGame;
        this.NomeDoVideoGame = NomeDoVideoGame;
        this.NomeDoJogo = NomeDoJogo;
        this.xbox = xbox;
    }
    
    public game(){
        this.IdVideoGame = 0;
        this.NomeDoVideoGame = "";
        this.NomeDoJogo = "";
        this.xbox = null;
    }
    

}
