package breakout;

import javax.swing.JFrame;

public class GameBreakout {
      JFrame frame = new JFrame();
      GamePanelBreakout panel = new GamePanelBreakout();

      public GameBreakout() {
            frame.setBounds(10, 10, 700, 600);//tamaño y posicion de la ventana
            frame.setTitle("Breakout");// titulo de la ventana
            frame.setUndecorated(true);
            frame.setResizable(false);// Evita que la ventana se pueda redimensionar
            frame.setLocationRelativeTo(null);
            frame.add(panel); // Agregar el panel a la ventana
      }

      public void play() {
            frame.setVisible(true); // Hace visible la ventana
      }
      
      public void stop() {
            frame.setVisible(false);
            frame.dispose();
      }
}
