package Engine;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import javax.swing.JFrame;

import javax.swing.*;

/*
 * The JFrame that holds the GamePanel
 * Just does some setup and exposes the gamePanel's screenManager to allow an external class to setup their own content and attach it to this engine.
 */
public class GameWindow {
	private JFrame gameWindow;
	private GamePanel gamePanel;
	protected KeyLocker keyLock = new KeyLocker();

	public GameWindow() {
		gameWindow = new JFrame("Game");
		gamePanel = new GamePanel();
		gamePanel.setFocusable(true);
		gamePanel.requestFocusInWindow();
		gameWindow.setResizable(false);
		// gameWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//gameWindow.setSize(Config.GAME_WINDOW_WIDTH, Config.GAME_WINDOW_HEIGHT);
		//gameWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gameWindow.setContentPane(gamePanel);
		gameWindow.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		gameWindow.setLocationRelativeTo(null);
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//for ( Window w : Window.getWindows() ) {
			//GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow( w );
		//}
		gamePanel.setupGame();



		/*GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

		JButton btn1 = new JButton("Full-Screen");
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				device.setFullScreenWindow(gameWindow);
			}

			
		});
		JButton btn2 = new JButton("Normal");
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				device.setFullScreenWindow(null);
			}
		});


		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel.add(btn1);
		panel.add(btn2);
		gameWindow.add(panel);
	
		gameWindow.pack();*/


		/*
		 * // Add a key listener to toggle full-screen mode on pressing F
		 * gameWindow.addKeyListener(new KeyListener() {
		 * 
		 * @Override
		 * public void keyTyped(KeyEvent e) {
		 * }
		 * 
		 * @Override
		 * public void keyPressed(KeyEvent e) {
		 * if(Keyboard.isKeyUp(Key.F))
		 * {
		 * keyLock.unlockKey(Key.F);
		 * toggleFullScreen();
		 * }
		 * }
		 * 
		 * @Override
		 * public void keyReleased(KeyEvent e) {
		 * }
		 * });
		 */
	}

	/*
	 * private void toggleFullScreen() {
	 * GraphicsDevice device =
	 * GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	 * if (device.getFullScreenWindow() == null) {
	 * // Enter full-screen mode
	 * gameWindow.dispose();
	 * gameWindow.setUndecorated(true);
	 * device.setFullScreenWindow(gameWindow);
	 * gameWindow.validate();
	 * } else {
	 * // Exit full-screen mode
	 * gameWindow.dispose();
	 * gameWindow.setUndecorated(false);
	 * device.setFullScreenWindow(null);
	 * gameWindow.validate();
	 * gameWindow.setVisible(true);
	 * }
	 * }
	 * 
	 * 
	 * 
	 * // Toggle between fullscreen and windowed modes
	 * public void toggleFullscreen() {
	 * GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	 * GraphicsDevice gd = ge.getDefaultScreenDevice();
	 * if (!gd.isFullScreenSupported()) {
	 * System.out.println("Fullscreen not supported");
	 * return;
	 * }
	 * 
	 * if (gameWindow.isUndecorated()) {
	 * setWindowedMode();
	 * } else {
	 * setFullscreenMode();
	 * }
	 * }
	 * 
	 * // Set the game window to fullscreen mode
	 * private void setFullscreenMode() {
	 * GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	 * GraphicsDevice gd = ge.getDefaultScreenDevice();
	 * if (gd.isFullScreenSupported()) {
	 * gameWindow.dispose();
	 * gameWindow.setUndecorated(true);
	 * gd.setFullScreenWindow(gameWindow);
	 * gameWindow.validate();
	 * }
	 * }
	 * 
	 * // Set the game window to windowed mode
	 * private void setWindowedMode() {
	 * GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	 * GraphicsDevice gd = ge.getDefaultScreenDevice();
	 * if (gd.isFullScreenSupported()) {
	 * gameWindow.dispose();
	 * gameWindow.setUndecorated(false);
	 * gd.setFullScreenWindow(null);
	 * gameWindow.setSize(Config.GAME_WINDOW_WIDTH, Config.GAME_WINDOW_HEIGHT);
	 * gameWindow.setLocationRelativeTo(null);
	 * gameWindow.setVisible(true);
	 * gameWindow.validate();
	 * }
	 * }
	 */

	// triggers the game loop to start as defined in the GamePanel class
	public void startGame() {
		gamePanel.startGame();
	}

	public ScreenManager getScreenManager() {
		return gamePanel.getScreenManager();
	}
}
