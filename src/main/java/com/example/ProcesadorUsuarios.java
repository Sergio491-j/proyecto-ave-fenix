package com.example;

import java.util.List;

// Esta clase procesa listas de usuarios, contiene roles e interacciones
public class ProcesadorUsuarios {

    // Valores que definen límites: jóvenes, adultos, etc.
    private static final int APENAS = 5;
    private static final int MINIMO = 2;

    public String procesarLista(List<String> dataList) {
        String adultos = "";
        String invitados = "";

        for (String u : dataList) {
            String[] parts = u.split(","); // Formato "nombre,rol"

            if (parts.length >= 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                // Mayor o igual a 5 es Adulto
                if (rol >= APENAS) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(nombre);
                    stringBuilder.append("-");
                    stringBuilder.append(rol);
                    adultos = extracted(adultos, stringBuilder);
                } else {

                    // Rol entre 2 y 5 es Invitado
                    if (rol >= MINIMO && rol < APENAS) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(nombre.toUpperCase());
                        stringBuilder.append("*");
                        stringBuilder.append(rol);
                        invitados = extracted(invitados, stringBuilder);
                    } else {
                        // rol desconocido, no se procesa
                    }
                }
            }
        }

        return "Adultos: " + adultos + " | Invitados: " + invitados;
    }

    private String extracted(String adultos, StringBuilder stringBuilder) {
        adultos += stringBuilder.toString();
        return adultos;
    }
}
