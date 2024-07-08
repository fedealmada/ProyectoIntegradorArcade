package pacman;

public class GenericMatrix<T> {
      private final int filas;
      private final int columnas;
      private final T[][] matriz;
      
      public GenericMatrix(int filas, int columnas) {
            this.filas = filas;
            this.columnas = columnas;
            matriz =  (T[][]) new Object [filas][columnas];
        }
      
      public void setearObjeto(T objeto, int fila, int columna) {
            this.matriz[fila][columna] = objeto;
      }
      
      public T obtenerObjeto(int fila, int columna) {
            return matriz[fila][columna];
      }
        
      public void mostrarMatriz() {
            for (int i = 0; i < filas; i++) {
                  for (int j = 0; j < columnas; j++) {
                        if(isNull(i, j)) System.out.println("Vacío");
                        else if(isBlock(i, j))  System.out.println("Bloque");
                        else if(isDot(i, j))  System.out.println("Punto");
                        else System.out.println("Poder");
                  }
            }
      }
      
      public boolean hayDots() {
            for (int i = 0; i < filas; i++) {
                  for (int j = 0; j < columnas; j++) {
                        if(!isNull(i, j)) {
                              if(isDot(i, j)) {
                                    return true;
                              }   
                        }
                  }
            } 
            return false;
      }

      public boolean isBlock(int fila, int columna) {
            if(matriz[fila][columna] == null) {
                  return false;
            }
            return matriz[fila][columna].getClass().getName().equalsIgnoreCase("pacman.Block");
      }
      
      public boolean isDot(int fila, int columna) {
            if(matriz[fila][columna] == null) {
                  return false;
            }
            return matriz[fila][columna].getClass().getName().equalsIgnoreCase("pacman.Dot");
      }
      
      public boolean isPower(int fila, int columna) {
            if(matriz[fila][columna] == null) {
                  return false;
            }
            return matriz[fila][columna].getClass().getName().equalsIgnoreCase("pacman.Power");
      }
      
      public boolean isNull(int fila, int columna) {
            return matriz[fila][columna] == null;
      }
      
      public String obtenerClaseObjeto(int fila, int columna) {
            return matriz[fila][columna].getClass().getName();
      }
}
