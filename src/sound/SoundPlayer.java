package sound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class SoundPlayer {

      private InputStream is;
      private AdvancedPlayer player;
      private boolean looping;
      private boolean ringing;
      Timer timer;

      public SoundPlayer() {
            this.looping = false;
            this.ringing = false;
      }

      public void playSound(String soundFilePath) {
            try {
                  is = new BufferedInputStream(new FileInputStream(soundFilePath));
                  player = new AdvancedPlayer(is);

                  if (looping) {
                        // Reproducir en bucle
                        new Thread(() -> {
                              try {
                                    while (looping) {
                                          player.play();
                                          is = new BufferedInputStream(new FileInputStream(soundFilePath));
                                          player = new AdvancedPlayer(is);
                                    }
                              } catch (JavaLayerException | IOException e) {
                                    e.printStackTrace();
                              }
                        }).start();
                  } else {
                        // Reproducir una sola vez
                        ActionListener reiniciarSonido = new ActionListener() {
                              @Override
                              public void actionPerformed(ActionEvent e) {
                                    ringing = false;
                              }
                        };

                        new Thread(() -> {
                              try {
                                    if (this.ringing == false) {
                                          ringing = true;
                                          player.play();
                                          timer = new Timer(20, reiniciarSonido);
                                          timer.setRepeats(false);
                                          timer.start();
                                    }

                              } catch (JavaLayerException e) {
                                    e.printStackTrace();
                              }
                        }).start();
                  }

            } catch (IOException | JavaLayerException e) {
                  e.printStackTrace();
            }


      }

      public void setLooping(boolean looping) {
            this.looping = looping;
      }

      public void stopSound() {
            if (player != null) {
                  ringing = false;
                  player.close();
            }
      }
}
