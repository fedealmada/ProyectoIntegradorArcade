package entities;

public class Usuario {

      private String nombre;
      private String password;
      private String answer;
      private int questionIndex;
      private int coins;
      private int scorePacman;
      private int scoreTetris;
      private int scoreTateti;
      private int scoreBreakout;
      private String registerDate;
      private String lastLoginDate;
      private boolean logged;

      public Usuario() {
      }

      public String getNombre() {
            return nombre;
      }

      public void setNombre(String nombre) {
            this.nombre = nombre;
      }

      public int getCoins() {
            return coins;
      }

      public void setCoins(int coins) {
            this.coins = coins;
      }

      public int getScorePacman() {
            return scorePacman;
      }

      public void setScorePacman(int scorePacman) {
            this.scorePacman = scorePacman;
      }

      public int getScoreTateti() {
            return scoreTateti;
      }

      public void setScoreTateti(int scoreTateti) {
            this.scoreTateti = scoreTateti;
      }

      public int getScoreBreakout() {
            return scoreBreakout;
      }

      public void setScoreBreakout(int scoreBreakout) {
            this.scoreBreakout = scoreBreakout;
      }

      public String getPassword() {
            return password;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public String getAnswer() {
            return answer;
      }

      public void setAnswer(String answer) {
            this.answer = answer;
      }

      public int getQuestionIndex() {
            return questionIndex;
      }

      public void setQuestionIndex(int questionIndex) {
            this.questionIndex = questionIndex;
      }

      public String getRegisterDate() {
            return registerDate;
      }

      public void setRegisterDate(String registerDate) {
            this.registerDate = registerDate;
      }

      public String getLastLoginDate() {
            return lastLoginDate;
      }

      public void setLastLoginDate(String lastLoginDate) {
            this.lastLoginDate = lastLoginDate;
      }

      public int getScoreTetris() {
            return scoreTetris;
      }

      public void setScoreTetris(int scoreTetris) {
            this.scoreTetris = scoreTetris;
      }

      public boolean isLogged() {
            return logged;
      }

      public void setLogged(boolean logged) {
            this.logged = logged;
      }
}
