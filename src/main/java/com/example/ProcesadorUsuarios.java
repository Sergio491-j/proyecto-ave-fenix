package com.example;

import java.util.List;

// Esta clase procesa listas de usuarios, contiene roles e interacciones
/**
 * Esta clase se encarga de procesar listas de usuarios, clasificándolos en admins e invitados representados
 * por diferentes formatos según su rol. Calificandolas como texto
 * 
 * <p>
 * cada formato de la lista debe de tener su nombre y rol separados por coma.
 * según su valor estas se clasifican en:
 * <ul>
 * <li><b>Admins</b>: rol mayor o igual a 5, formato "nombre-rol"
 * <li><b>Invitados</b>: rol entre 2 y 5, formato "nombre*rol"
 * </ul>
 * </p>
 * Los usuarios con rol que no esten en esos rangos no se procesan.
 */
public class ProcesadorUsuarios {

    // Valores que definen límites: jóvenes, adultos, etc.
    /**
     * Metodos que define los roles de los usuarios segun su valor numérico.
     * 
     * 
     * Cada elemento de la lista debe tener el formato "nombre,rol", donde
     * <code>rol</code> es un número entero. Dependiendo de ese valor:
     * 
     * <ul>
     * <li>Si el rol es igual a 2 e considera invitado</li>
     * <li>Si el rol es igual a 1 se considera admin</li>
     * </ul>
     * 
     * @param dataList Lista de cadenas con formato "nombre,rol"
     * @return Una cadena que resume los admins e invitados procesados. 
     *
     */
    private static final int ADMINS = 1;
    private static final int INVITADOS = 2;

    public String procesarLista(List<String> dataList) {
        String admins = "";
        String invitados = "";

        for (String u : dataList) {
            String[] parts = u.split(","); // Formato "nombre,rol"

            if (parts.length >= 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                // Mayor o igual a 5 es Admin
                if (rol >= ADMINS) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(nombre);
                    stringBuilder.append("-");
                    stringBuilder.append(rol);
                    admins = extracted(admins, stringBuilder);
                } else {

                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(nombre.toUpperCase());
                    stringBuilder.append("*");
                    stringBuilder.append(rol);
                    invitados = extracted(invitados, stringBuilder);

                }
            }
        }

        return "Admins: " + admins + " | Invitados: " + invitados;
    }

    private String extracted(String admins, StringBuilder stringBuilder) {
        admins += stringBuilder.toString();
        return admins;
    }
}
