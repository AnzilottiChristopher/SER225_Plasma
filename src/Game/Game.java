package Game;

import Engine.GameWindow;
import Engine.Music;
import Engine.ScreenManager;
import Scripts.TestMap.JukeboxScript;

/*
 * The game starts here
 * This class just starts up a GameWindow and attaches the ScreenCoordinator to the ScreenManager instance in the GameWindow
 * From this point on the ScreenCoordinator class will dictate what the game does
 */
public class Game {
    Music music = new Music();

    public static void main(String[] args) {
        new Game();
        // Music music = new Music();
        // music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
        // music.playLoop();
    }

    public Game() {
        GameWindow gameWindow = new GameWindow();
        ScreenManager screenManager = gameWindow.getScreenManager();
        screenManager.setCurrentScreen(new ScreenCoordinator());
        gameWindow.startGame();

        // Music music = new Music();
        // music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
        // music.playLoop();

        // System.out.println("Game has been r");

        // if (music.getCount() == 2){
        //     music.stopLoop();
        // }

        // music.background("Resources/Pokemon FireRedLeafGreen- Pallet Town.wav");
        // music.playLoop();
        // music.setCount(1);
    }
}
