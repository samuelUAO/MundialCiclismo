/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import java.util.Scanner;
import Controlador.ControladorMundial;
import Modelo.Competidor;
/**
 *
 * @author SAMUEL
 */
public class VistaMundial {
    private ControladorMundial controlador;
    private Scanner scanner;

    public VistaMundial(ControladorMundial controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n=== SISTEMA MUNDIAL DE CICLISMO DE PISTA (CALI) ===");
            System.out.println("1. Registrar Competidor");
            System.out.println("2. Listar Competidores");
            System.out.println("3. Actualizar Ranking (Sin Medalla)");
            System.out.println("4. Actualizar Ranking (Con/Sin Medalla - Avanzado)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1: registrar(); break;
                case 2: listar(); break;
                case 3: actualizarSimple(); break;
                case 4: actualizarAvanzado(); break;
                case 5: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void registrar() {
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Edad: "); int edad = Integer.parseInt(scanner.nextLine());
        System.out.print("País: "); String pais = scanner.nextLine();
        System.out.print("Ranking Inicial: "); int ranking = Integer.parseInt(scanner.nextLine());
        System.out.print("Estatura (m): "); double estatura = Double.parseDouble(scanner.nextLine());
        System.out.print("Peso (kg): "); double peso = Double.parseDouble(scanner.nextLine());

        Competidor c = new Competidor(nombre, edad, pais, ranking, estatura, peso);
        controlador.registrarCompetidor(c);
        System.out.println("¡Competidor registrado exitosamente!");
    }

    private void listar() {
        System.out.println("\n--- LISTA DE COMPETIDORES ---");
        for (Competidor c : controlador.getListaCompetidores()) {
            System.out.println(c.toString());
        }
    }

    private void actualizarSimple() {
        System.out.print("Nombre del competidor: ");
        Competidor c = controlador.buscarPorNombre(scanner.nextLine());
        if (c != null) {
            System.out.print("Puntos obtenidos: ");
            int pts = Integer.parseInt(scanner.nextLine());
            c.actualizarRanking(pts);
            System.out.println("Ranking actualizado: " + c.getRanking());
        } else {
            System.out.println("Competidor no encontrado.");
        }
    }

    private void actualizarAvanzado() {
        System.out.print("Nombre del competidor: ");
        Competidor c = controlador.buscarPorNombre(scanner.nextLine());
        if (c != null) {
            System.out.print("Puntos obtenidos: ");
            int pts = Integer.parseInt(scanner.nextLine());
            System.out.print("¿Ganó medalla? (true/false): ");
            boolean medalla = Boolean.parseBoolean(scanner.nextLine());
            c.actualizarRanking(pts, medalla);
            System.out.println("Ranking actualizado: " + c.getRanking());
        } else {
            System.out.println("Competidor no encontrado.");
        }
    }
}