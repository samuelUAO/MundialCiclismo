/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Principal;
import Controlador.ControladorMundial;
import Vista.VistaMundial;
/**
 *
 * @author SAMUEL
 */
public class Main {
    public static void main(String[] args) {
        ControladorMundial controlador = new ControladorMundial();
        VistaMundial vista = new VistaMundial(controlador);
        vista.mostrarMenu();
    }
}