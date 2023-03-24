import java.util.*;

public class test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTime().getTime();
        System.out.println(time);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Calendar c2 = Calendar.getInstance();
        time = c2.getTime().getTime();
        System.out.println(time);
    }
}
