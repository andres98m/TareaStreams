package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

        List<Pelicula> peliculasSigloXXI = peliculas.stream()
                .filter(p -> p.getEstreno() >= 2000)
                .toList();

        String titulosSpielberg = peliculas.stream()
                .filter(p -> "Steven Spielberg".equals(p.getDirector()))
                .map(Pelicula::getTitulo)
                .collect(Collectors.joining(", "));

        List<String> titulosOrdenados = peliculas.stream()
                .map(Pelicula::getTitulo)
                .sorted()
                .toList();

        System.out.println("\n\nPelículas del siglo XXI: " + peliculasSigloXXI);
        System.out.println("\n\nPelículas de Steven Spielberg: " + titulosSpielberg);
        System.out.println("\n\nTítulos ordenados alfabéticamente: " + titulosOrdenados);
    }
}

class Pelicula {
    private String titulo;
    private String director;
    private int estreno;

    public Pelicula(String titulo, String director, int estreno) {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getEstreno() {
        return estreno;
    }

    @Override
    public String toString() {
        return titulo + " (" + director + ", " + estreno + ")";
    }
}