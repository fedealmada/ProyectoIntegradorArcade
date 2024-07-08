package pacman;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class FramePacman extends javax.swing.JFrame{

      public FramePacman() {
            TimerTask task = new TimerTask() {
                  @Override
                  public void run() {
                        if(GamePanelPacman.gameStarted) {
                         lblScore.setText("Score: " + GamePanelPacman.score);
                         lblLives.setText("Lives: " + GamePanelPacman.pacman.getLives());
                         lblLevel.setText("Level: " + GamePanelPacman.level);
                        }
                         
                  }
            };
            initComponents();
            jPanel1.setBackground(Color.black);
            jPanel1.setForeground(Color.BLACK);
            lblScore.setForeground(Color.YELLOW);
            lblLives.setForeground(Color.YELLOW);
            lblLevel.setForeground(Color.YELLOW);
           
            Timer timer = new Timer();
            timer.schedule(task, 100, 100);
      }
      
      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            lblScore = new javax.swing.JLabel();
            lblLevel = new javax.swing.JLabel();
            lblLives = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);

            lblScore.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            lblScore.setText("Score: ");

            lblLevel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            lblLevel.setText("Level:");

            lblLives.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            lblLives.setText("Lives:");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                  jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblScore)
                        .addGap(56, 56, 56)
                        .addComponent(lblLevel)
                        .addGap(56, 56, 56)
                        .addComponent(lblLives)
                        .addContainerGap(114, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                  jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
                              .addComponent(lblLives, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                              .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE))
                        .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 280, Short.MAX_VALUE))
            );

            pack();
      }// </editor-fold>//GEN-END:initComponents

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JPanel jPanel1;
      private javax.swing.JLabel lblLevel;
      private javax.swing.JLabel lblLives;
      private javax.swing.JLabel lblScore;
      // End of variables declaration//GEN-END:variables
}
