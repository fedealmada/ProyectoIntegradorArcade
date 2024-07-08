package pacman;

public class GamePacman {

      private final FramePacman frame = new FramePacman();
      private final GamePanelPacman panel = new GamePanelPacman();

      public GamePacman() {
            frame.setSize(800, 680);
            panel.setSize(800, 700);
            frame.add(panel);
            panel.setLocation(0, 20);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
      }

      public void play() {
//            GamePanelPacman.iniciarPartida();
            frame.setVisible(true);
      }

      public void stop() {
            GamePanelPacman.iniciarPartida();
            GamePanelPacman.detenerTimer();
            frame.setVisible(false);
      }
}
