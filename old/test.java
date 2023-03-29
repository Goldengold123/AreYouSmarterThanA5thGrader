import java.io.File;
import java.io.IOException;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class test {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        Clip sound = AudioSystem.getClip();
        sound.open(AudioSystem.getAudioInputStream(new File("sounds/incorrect.wav")));
        sound.start();
        Thread.sleep(250);
        sound.close();

        // Calendar calendar = Calendar.getInstance();
        // long time = calendar.getTime().getTime();
        // System.out.println(time);
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // Calendar c2 = Calendar.getInstance();
        // time = c2.getTime().getTime();
        // System.out.println(time);
    }
}
