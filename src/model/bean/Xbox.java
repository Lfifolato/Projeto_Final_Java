package model.bean;

public class Xbox extends game {

    private String cor;
    private String processador;
    private String placaVideo;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getPlacaVideo() {
        return placaVideo;
    }

    public void setPlacaVideo(String placaVideo) {
        this.placaVideo = placaVideo;
    }
    
    //Contrutor
    public Xbox(String cor, String processador, String placaVideo) {
        this.cor = cor;
        this.processador = processador;
        this.placaVideo = placaVideo;
    }
    
    
    public Xbox() {

        this.cor = "";
        this.processador = "";
        this.placaVideo = "";
    }
}
