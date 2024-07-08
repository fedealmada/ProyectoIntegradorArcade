package tetris;

import javax.swing.JFrame;

public class GameTetris {

      JFrame frame = new JFrame();
      GamePanelTetris panel = new GamePanelTetris();

      public GameTetris() {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            //agregamos el panel a la ventana
            frame.add(panel);
            frame.pack();//la medida del panel se convierte a la medida de la ventana

            frame.setLocationRelativeTo(null);
      }

      public void play() {
            frame.setVisible(true);
            panel.launchGame();
      }

      public void stop() {
            panel.stopGame();
            frame.setVisible(false);
            frame.dispose();
      }
}
