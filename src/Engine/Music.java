package Engine;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Music {   

    private Clip clip;
    private int count = 1;
    public int talked = 0;

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
        if (getCount() == 2){
            stopLoop();
        }
    }

    //Call when you want music to end
    public void stopLoop(){
        if (clip != null && clip.isRunning()){
            clip.stop();
        }
    }

    //Call when you want initial music in PlayLevelScreen to end
    public void stopLoopPlayLevelScreen(){
        if (clip != null && clip.isRunning()){
            clip.stop();
        }
    }

    public void stopClass(){
        Music music = new Music();
        if (music.clip != null){
            music.stopLoop();
        }
    }

    public Clip getClip() {
        return clip;
    }
    
    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }

    
}


