package Engine;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*; 

public class MusicStop {   

    private Clip clip;

    public void stopClass(String path){
        Music music = new Music();
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            if (clip != null && clip.isRunning()){
                music.stopLoop();
              }
        } catch (UnsupportedAudioFileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}