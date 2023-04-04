package Game;

public class Game
{
   private UserInterface aGui;
   private GameEngine aEngine;
/**
 * Construit le jeu en créant un moteur de jeu et l'interface du jeu
 */   
   public Game()
   {
       this.aEngine = new GameEngine();
       this.aGui = new UserInterface(this.aEngine);
       this.aEngine.setGUI(this.aGui);
       
   }
}