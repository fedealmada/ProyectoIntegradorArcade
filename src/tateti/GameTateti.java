package tateti;

public class GameTateti {
      FrameTateti frame;
      public GameTateti() {
            frame = new FrameTateti();
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
      }
      
      public void play() {
            frame.reiniciarPartida();
            frame.reiniciarPuntuacion();
            frame.setVisible(true);
      }
      
      public void stop() {
            frame.setVisible(false);
            frame.dispose();
      }
}
