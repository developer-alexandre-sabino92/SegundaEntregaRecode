/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class PacoteViagem {

    private int id_Pacote;

    private String Destino;

    public PacoteViagem() {

    }

    public PacoteViagem(int id_Pacote, String Destino) {
        this.id_Pacote = id_Pacote;
        this.Destino = Destino;
    }

    public int getId_Pacote() {
        return id_Pacote;
    }

    public void setId_Pacote(int id_Pacote) {
        this.id_Pacote = id_Pacote;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

}
