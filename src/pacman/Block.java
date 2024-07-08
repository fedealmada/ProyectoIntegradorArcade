package pacman;

import java.awt.Color;

public class Block {

      protected Color color;

      public Block() {
      }

      public Block(Color color) {
            this.color = color;
      }

      public Color getColor() {
            return color;
      }

      public void setColor(Color color) {
            this.color = color;
      }
}
