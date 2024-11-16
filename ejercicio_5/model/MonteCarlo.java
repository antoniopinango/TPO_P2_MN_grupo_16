package ejercicio_5.model;

import ejercicio_2.model.Set;

public class MonteCarlo {
    private static final double SQUARE_SIZE = 1.0; // Definimos el tamaño del cuadrado (1x1 en el primer cuadrante)
    private Set<Coordinate> coordinates;

    public MonteCarlo() {
        this.coordinates = new Set<>();
    }

    /**
     * Agrega una coordenada si está dentro de la región delimitada por el cuadrado [0,0] a [1,1].
     * @param coord La coordenada a agregar.
     */
    public void addCoordinate(Coordinate coord) {
        if (isInSquare(coord)) {
            coordinates.add(coord);
        }
    }

    /**
     * Verifica si la coordenada está dentro del cuadrado.
     * @param coord La coordenada a verificar.
     * @return true si está dentro, false en caso contrario.
     */
    private boolean isInSquare(Coordinate coord) {
        return coord.getX() >= 0 && coord.getX() <= SQUARE_SIZE &&
                coord.getY() >= 0 && coord.getY() <= SQUARE_SIZE;
    }

    public int getCount() {
        return coordinates.size();
    }

    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    /**
     * Verifica si la coordenada está dentro del círculo de radio 1 en el cuadrante.
     * @param coord La coordenada a verificar.
     * @return true si está dentro del círculo, false en caso contrario.
     */
    public static boolean isInsideCircle(Coordinate coord) {
        double distanceFromOrigin = Math.sqrt(Math.pow(coord.getX(), 2) + Math.pow(coord.getY(), 2));
        return distanceFromOrigin <= 1.0;
    }

}
