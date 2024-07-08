package utilities;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

      public ScrollBarCustom() {
            setUI(new ModernScrollBarUI());
            setPreferredSize(new Dimension(8, 8));
            setForeground(new Color(153, 102, 255));
            setBackground(Color.WHITE);
      }
}
