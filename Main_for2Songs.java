import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main_for2Songs {
    /* public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);

        // First Clip
        File file1 = new File("Sky Full of Stars.wav");
        AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(file1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(audioStream1);

        // Second Clip
        File file2 = new File("កុំមានអ្នកទី៣.wav");
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
        Clip clip2 = AudioSystem.getClip();
        clip2.open(audioStream2);

        String response = "";

        while (!response.equals("Q")) {
            System.out.println("1 = Play Clip 1, 2 = Play Clip 2, S = Stop, R = Restart, RES = Resume, Q = Quit");
            System.out.println("Enter your choice:");

            response = scanner.next();
            response = response.toUpperCase();

            switch (response) {
                case "1" -> clip1.start();
                case "2" -> {
                    clip1.stop();
                    clip1.setMicrosecondPosition(0);
                    clip2.setMicrosecondPosition(0);
                    clip2.start();
                }
                case "S" -> {
                    clip1.stop();
                    clip2.stop();
                }
                case "R" -> {
                    clip1.setMicrosecondPosition(0);
                    clip2.setMicrosecondPosition(0);
                }
                case "RES" -> {
                    if (!clip1.isActive()) {
                        clip1.setMicrosecondPosition(clip1.getMicrosecondPosition());
                        clip1.start();
                    }
                    if (!clip2.isActive()) {
                        clip2.setMicrosecondPosition(clip2.getMicrosecondPosition());
                        clip2.start();
                    }
                }
                case "Q" -> {
                    clip1.close();
                    clip2.close();
                }
                default -> System.out.println("Not a valid response");
            }
        }
        System.out.println("You just exited the music program!!!");
    }*/

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);

        // First Clip
        File file1 = new File("Sky Full of Stars.wav");
        AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(file1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(audioStream1);

        // Second Clip
        File file2 = new File("កុំមានអ្នកទី៣.wav");
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
        Clip clip2 = AudioSystem.getClip();
        clip2.open(audioStream2);

        Clip currentClip = clip1;  // Initialize the current clip to clip 1
        boolean isClip2Playing = false;  // Flag to track if clip 2 is playing

        String response = "";

        while (!response.equals("Q")) {
            System.out.println("1 = Play Clip 1, 2 = Play Clip 2, S = Stop, R = Restart, RES = Resume, Q = Quit");
            System.out.println("Enter your choice:");

            response = scanner.next();
            response = response.toUpperCase();

            switch (response) {
                case "1":
                    if (isClip2Playing) {
                        clip2.stop();
                        clip2.setMicrosecondPosition(0);
                        isClip2Playing = false;
                    }
                    currentClip = clip1;
                    currentClip.start();
                    break;
                case "2":
                    if (!isClip2Playing) {
                        currentClip.stop();
                        currentClip.setMicrosecondPosition(0);
                        isClip2Playing = true;
                    }
                    currentClip = clip2;
                    currentClip.start();
                    break;
                case "S":
                    currentClip.stop();
                    break;
                case "R":
                    currentClip.setMicrosecondPosition(0);
                    break;
                case "RES":
                    if (!currentClip.isActive()) {
                        currentClip.setMicrosecondPosition(currentClip.getMicrosecondPosition());
                        currentClip.start();
                    }
                    break;
                case "Q":
                    clip1.close();
                    clip2.close();
                    break;
                default:
                    System.out.println("Not a valid response");
                    break;
            }
        }
        System.out.println("You just exited the music program!!!");
    }
}
