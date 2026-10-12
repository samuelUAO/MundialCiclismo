/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.util.ArrayList;
import java.util.List;
import Modelo.Competidor;
/**
 *
 * @author SAMUEL
 */
public class ControladorMundial {
    private List<Competidor> listaCompetidores;

    public ControladorMundial() {
        this.listaCompetidores = new ArrayList<>();
    }

    public void registrarCompetidor(Competidor competidor) {
        listaCompetidores.add(competidor);
    }

    public List<Competidor> getListaCompetidores() {
        return listaCompetidores;
    }

    public Competidor buscarPorNombre(String nombre) {
        for (Competidor c : listaCompetidores) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }
}