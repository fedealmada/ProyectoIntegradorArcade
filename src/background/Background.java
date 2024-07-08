package background;

import com.twelvemonkeys.image.ImageUtil;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Background extends JComponent {

      private final Icon image;
      private BufferedImage bufferedImage;
      private int x, y, h, w;
      private int max;

      public Background() {
            image = new ImageIcon(getClass().getResource("/background/background.png"));
      }
      public Background(int x, int y, int w, int h, int max, String location) {
            image = new ImageIcon(getClass().getResource(location));
            this. x = x;
            this. y = y;
            this.h = h;
            this.w = w;
            this.max = max;
      }

      public void createImage() {
            if (image != null) {
                  int width = getWidth();
                  int height = getHeight();
                  if (width > 0 && height > 0) {
                        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                        Graphics2D g2 = bufferedImage.createGraphics();
                        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                        Rectangle rec = getAutoSize(image);
                        g2.drawImage(((ImageIcon) image).getImage(), rec.x, rec.y, rec.width, rec.height, null);
                        createBlurImage(g2);
                        g2.dispose();
                  }
            }
      }

      public void createBlurImage(Graphics2D g) {
//            int x = 280;
//            int y = 0;
//            int w = 1002;
//            int h = 702;
//            int max = 400;
            if (w > 0 && h > 0) {
                  BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                  Graphics2D g2 = img.createGraphics();
                  g2.drawImage(ImageUtil.blur(bufferedImage.getSubimage(this.x, this.y, this.max, this.h), 20f), 0, 0, null);
                  g2.dispose();
                  g.drawImage(img, x, y, null);
            }
      }

      @Override
      protected void paintComponent(Graphics g) {
            g.drawImage(bufferedImage, 0, 0, null);
            super.paintComponent(g);
      }

      @Override
      public void setBounds(int i, int i1, int i2, int i3) {
            super.setBounds(i, i1, i2, i3);
            createImage();
      }

      private Rectangle getAutoSize(Icon image) {
            int w = getWidth();
            int h = getHeight();
            int iw = image.getIconWidth();
            int ih = image.getIconHeight();
            double xScale = (double) w / iw;
            double yScale = (double) h / ih;
            double scale = Math.max(xScale, yScale);
            int width = (int) (scale * iw);
            int height = (int) (scale * ih);
            if (width < 1) {
                  width = 1;
            }
            if (height < 1) {
                  height = 1;
            }
            int x = (w - width) / 2;
            int y = (h - height) / 2;
            return new Rectangle(new Point(x, y), new Dimension(width, height));
      }
}
