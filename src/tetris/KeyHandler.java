package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import main.Main;

public class KeyHandler implements KeyListener {// La clase KeyHandler implementa la interfaz KeyListener para manejar eventos de teclado

      public static boolean upPressed, downPressed, leftPressed, rightPressed, pausePressed;

      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();

            if (code == KeyEvent.VK_UP) {
                  upPressed = true;
            }
            if (code == KeyEvent.VK_LEFT) {
                  leftPressed = true;
            }
            if (code == KeyEvent.VK_DOWN) {
                  downPressed = true;
            }
            if (code == KeyEvent.VK_RIGHT) {
                  rightPressed = true;
            }
            if (code == KeyEvent.VK_SPACE) {
                  pausePressed = !pausePressed;
            }

            if (code == KeyEvent.VK_ESCAPE) {
                  int response = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
                  if (response == JOptionPane.YES_OPTION) {
                        Main.gameTetris.stop();
                        Main.vtnMenu.setVisible(true);
                  }

            }

      }

      @Override
      public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();

            if (code == KeyEvent.VK_UP) {
                  upPressed = false;
            }
            if (code == KeyEvent.VK_LEFT) {
                  leftPressed = false;
            }
            if (code == KeyEvent.VK_DOWN) {
                  downPressed = false;
            }
            if (code == KeyEvent.VK_RIGHT) {
                  rightPressed = false;
            }

      }

      // MÃ©todo para resetear el estado de las teclas
      public static void resetKeys() {
            upPressed = false;
            downPressed = false;
            leftPressed = false;
            rightPressed = false;
            pausePressed = false;
      }

}
