package main;

import breakout.GameBreakout;
import entities.Usuario;
import leaderboard.Leaderboard;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import login.Login;
import menu.Menu;
import pacman.GamePacman;
import recover.Recover_1;
import recover.Recover_2;
import recover.Recover_3;
import register.Register;
import store.Store;
import tateti.GameTateti;
import tetris.GameTetris;

public class Main {

      // Creamos una instancia estática de Usuario que va a representar a la persona que esté logeada.
      public static Usuario userLogged = new Usuario();

      // Definimos e inicializamos las ventanas.
      public static Login vtnLogin = new Login();
      public static Register vtnRegister = new Register();
      public static Menu vtnMenu = new Menu();
      public static Store vtnStore = new Store();
      public static Leaderboard vtnLeaderboard = new Leaderboard();
      public static Recover_1 vtnRecover1 = new Recover_1();
      public static Recover_2 vtnRecover2 = new Recover_2();
      public static Recover_3 vtnRecover3 = new Recover_3();

      // Definimos los juegos.
      public static GameBreakout gameAtari;
      public static GameTetris gameTetris;
      public static GamePacman gamePacman = new GamePacman();
      public static GameTateti gameTateti = new GameTateti();
      public static AdvancedPlayer menuTheme = null;

      public static void main(String[] args) throws JavaLayerException, FileNotFoundException {
            vtnLogin.setVisible(true);

            try {
                  String filePath = "src\\main\\songs\\battletoads.mp3";

                  if (!filePath.isEmpty()) {
                        FileInputStream fis = new FileInputStream(filePath);
                        menuTheme = new AdvancedPlayer(fis);
                        menuTheme.play();
                  }

            } catch (FileNotFoundException e) {
                  System.out.println("ERROR: No se ha encontrado el sonido.");
            }

      }
}
