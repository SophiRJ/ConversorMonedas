package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CambioMoneda {
    private String moneda;
    private int opcion;
    private String destino;
    private double cantidad;
    private String ruta = "monedas.csv";

    public boolean eleccionUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Conversor Monedas");

        do {
            System.out.println("Opciones: \n1-> Ver codigos monedas.\n2-> Realizar Conversion\n3-> Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // ← Limpieza

            switch (opcion) {
                case 1:
                    System.out.println(leerCsv());
                    break;
                case 2:
                    System.out.print("Introduzca el codigo de la moneda de origen: ");
                    moneda = scanner.nextLine().toUpperCase();

                    System.out.print("Introduzca la moneda de destino: ");
                    destino = scanner.nextLine().toUpperCase();

                    System.out.print("Introduzca la cantidad a cambiar: ");
                    cantidad = scanner.nextDouble();
                    scanner.nextLine(); // limpieza

                    return true; // ← señal de que hará la conversión
            }
        } while (opcion != 3);
        return false;
    }

    public String leerCsv(){
        StringBuilder resultado= new StringBuilder();
        try(BufferedReader bf=new BufferedReader(new FileReader(ruta))){
            String linea;
            while((linea=bf.readLine()) != null){
                resultado.append(linea).append("\n");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return resultado.toString();
    }



    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
