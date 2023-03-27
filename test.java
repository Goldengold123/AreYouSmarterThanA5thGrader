import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class test {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        File audioFile = new File("/correct");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip audioClip = (Clip) AudioSystem.getLine(info);

        audioClip.open(audioStream);
        audioClip.start();

        Thread.sleep(2000);

        audioClip.close();
        audioStream.close();

        // Calendar calendar = Calendar.getInstance();
        // long time = calendar.getTime().getTime();
        // System.out.println(time);
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // Calendar c2 = Calendar.getInstance();
        // time = c2.getTime().getTime();
        // System.out.println(time);
    }
}
