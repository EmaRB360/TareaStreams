package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)
    {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));



        // Sublistado de películas estrenadas en el siglo XXI
        List<Pelicula> peliculasSigloXXI = peliculas.stream()
                .filter(pelicula -> pelicula.getEstreno() >= 2000)
                .collect(Collectors.toList());

        System.out.println("Películas del siglo XXI:");
        peliculasSigloXXI.forEach(System.out::println);

        //Los títulos de las películas de Steven Spielberg
        String peliculasSpielberg = peliculas.stream()
                .filter(p -> p.getDirector().equals("Steven Spielberg"))
                .map(Pelicula::getTitulo)
                .collect(Collectors.joining(", ", "Películas de Spielberg: ", ""));

        System.out.println(peliculasSpielberg);


        // Sublistado con los nombres de las películas, ordenados alfabéticamente
        List<String> titulosOrdenados = peliculas.stream()
                .map(Pelicula::getTitulo) // Extrae los títulos
                .sorted() // Ordena alfabéticamente
                .collect(Collectors.toList()); // Recoge en una nueva lista

        System.out.println("Títulos de las Películas ordenados alfabéticamente:");
        titulosOrdenados.forEach(System.out::println);
    }


}