package Game;

import Engine.GameWindow;
import Engine.Music;
import Engine.ScreenManager;

/*
 * The game starts here
 * This class just starts up a GameWindow and attaches the ScreenCoordinator to the ScreenManager instance in the GameWindow
 * From this point on the ScreenCoordinator class will dictate what the game does
 */
public class Game {

    public static void main(String[] args) {
        new Game();
        Music music = new Music();
        music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
        music.playLoop();
    }

    public Game() {
        GameWindow gameWindow = new GameWindow();
        ScreenManager screenManager = gameWindow.getScreenManager();
        screenManager.setCurrentScreen(new ScreenCoordinator());
        gameWindow.startGame();
    }
}
