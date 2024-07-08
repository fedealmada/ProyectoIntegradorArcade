package tetris;

import java.awt.Color;
import java.awt.Graphics2D;

public class Particle {

      int x, y;
      int vx, vy;
      Color color;
      int lifespan;
      int initialLifespan;

      public Particle(int x, int y, int vx, int vy, Color color, int lifespan) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            this.color = color;
            this.lifespan = lifespan;
            this.initialLifespan = lifespan;
      }

      public void update() {
            x += vx;
            y += vy;
            lifespan--;
      }

      public void draw(Graphics2D g2) {
            int alpha = (int) (255 * (lifespan / (float) initialLifespan));
            Color fadeColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
            g2.setColor(fadeColor);
            g2.fillRect(x, y, 5, 5);
      }
}
