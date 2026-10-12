/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SAMUEL
 */
public class Competidor extends Atleta {
    private int ranking;
    private double estatura;
    private double peso;

    public Competidor(String nombre, int edad, String pais, int ranking, double estatura, double peso) {
        super(nombre, edad, pais);
        this.ranking = ranking;
        this.estatura = estatura;
        this.peso = peso;
    }

    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }
    public double getEstatura() { return estatura; }
    public double getPeso() { return peso; }

    
    public void actualizarRanking(int puntosObtenidos) {
        this.ranking += puntosObtenidos;
    }

    
    public void actualizarRanking(int puntosObtenidos, boolean ganoMedalla) {
        int bonificacion = 0;
        if (ganoMedalla) {
            if (puntosObtenidos > 100) {
                bonificacion = 50; 
            } else {
                bonificacion = 20; 
            }
        } else {
            if (puntosObtenidos > 100) {
                bonificacion = 10;
            }
        }
        this.ranking += puntosObtenidos + bonificacion;
    }

    @Override
    public String toString() {
        return super.toString() + " | Ranking: " + ranking + " | Estatura: " + estatura + "m | Peso: " + peso + "kg";
    }
}
