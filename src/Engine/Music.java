package Engine;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*; 

public class Music {   

    private Clip clip;

    public Music() {
        clip = null;
    }

    //Call when you want to play audio
    public  void background(String path){
        try
        {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (LineUnavailableException e) {       
            e.printStackTrace();
        } 
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    } 

    //Call when you want to loop music
    public void playLoop(){
        if (clip != null){
            clip.loop(-1);
        }
    }

    //Call when you want music to end
    public void stopLoop(){
        if (clip != null && clip.isRunning()){
            clip.stop();
        }
    }
}


