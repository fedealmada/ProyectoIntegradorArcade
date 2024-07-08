package pacman;

import java.awt.Color;
import java.awt.Graphics;

public final class Map {

      public static boolean blocksCreated = false;

      public static int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 3, 0, 1, 1},
            {1, 1, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 1, 1},
            {1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1},
            {1, 1, 2, 0, 1, 0, 0, 0, 1, 2, 0, 1, 0, 0, 0, 0, 1, 2, 0, 1, 1, 2, 0, 1, 0, 0, 0, 0, 1, 2, 0, 1, 0, 0, 0, 1, 2, 0, 1, 1},
            {1, 1, 2, 0, 1, 0, 0, 0, 1, 2, 0, 1, 0, 0, 0, 0, 1, 2, 0, 1, 1, 2, 0, 1, 0, 0, 0, 0, 1, 2, 0, 1, 0, 0, 0, 1, 2, 0, 1, 1},
            {1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1},
            {1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1},
            {1, 1, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 1, 1},
            {1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1},
            {1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1},
            {1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2, 2, 2, 2, 2, 0, 1, 1, 2, 2, 2, 2, 2, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 1, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 3, 0, 1, 1},
            {1, 1, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 1, 1},
            {1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1},
            {1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 2, 0, 1, 1},
            {1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
      };

      public int filas = map.length;
      public int columnas = map[0].length;
      public final int ultimaColumna = map[0].length - 1;

      public GenericMatrix<Object> matrizObjetos = new GenericMatrix<>(filas, columnas);

      public static final int BLOCKSIZE = 20;

      public Map() {

            this.filas = map.length;
            this.columnas = map[0].length;
            initMapObjects(map, Color.BLUE);
      }

      public void initMapObjects(int[][] map, Color color) {
            for (int fila = 0; fila < filas; fila++) {
                  for (int columna = 0; columna < columnas; columna++) {
                        switch (map[fila][columna]) {
                              case 0 ->
                                    matrizObjetos.setearObjeto(null, fila, columna);
                              case 1 ->
                                    matrizObjetos.setearObjeto(new Block(color.brighter()), fila, columna);
                              case 2 ->
                                    matrizObjetos.setearObjeto(new Dot(Color.WHITE), fila, columna);
                              case 3 ->
                                    matrizObjetos.setearObjeto(new Power(Color.RED), fila, columna);
                        }
                  }
            }

      }

      public void draw(Graphics g) {

            for (int i = 0; i < filas; i++) {
                  for (int j = 0; j < columnas; j++) {
                        int x = j * BLOCKSIZE;
                        int y = i * BLOCKSIZE;

                        if (!matrizObjetos.isNull(i, j)) {

                              if (matrizObjetos.isDot(i, j)) {

                                    g.setColor(Color.BLACK);
                                    g.fillRect(x, y, BLOCKSIZE, BLOCKSIZE);

                                    Dot dot = (Dot) matrizObjetos.obtenerObjeto(i, j);

                                    g.setColor(dot.getColor());
                                    g.fill3DRect(x + 15, y + 15, 5, 5, false);

                              } else if (matrizObjetos.isPower(i, j)) {
                                    g.setColor(Color.BLACK);
                                    g.fillRect(x, y, BLOCKSIZE, BLOCKSIZE);

                                    g.setColor(Color.ORANGE);
                                    g.fillOval(x + 2, y + 5, 15, 15);
                              } else if (matrizObjetos.isBlock(i, j)) {
                                    Block bloque = (Block) matrizObjetos.obtenerObjeto(i, j);
                                    g.setColor(bloque.getColor());

                                    g.fill3DRect(x, y, BLOCKSIZE, BLOCKSIZE, true);
                                    g.setColor(bloque.getColor().darker().darker().darker());
                                    g.drawRect(x, y, BLOCKSIZE, BLOCKSIZE);

                                    g.setColor(bloque.getColor().darker());
                                    g.fill3DRect(x, y + 15, BLOCKSIZE, BLOCKSIZE, false);

                                    g.setColor(bloque.getColor().darker());
                                    g.fill3DRect(x + 15, y, BLOCKSIZE, BLOCKSIZE, false);

                                    g.setColor(bloque.getColor().darker().brighter());
                                    g.drawRect(x, y, BLOCKSIZE, BLOCKSIZE);
                              }
                        } else {
                              g.setColor(Color.BLACK);
                              g.fillRect(x, y, BLOCKSIZE, BLOCKSIZE);
                        }
                  }
            }
      }

}
