import java.util.*;
import java.util.concurrent.TimeUnit;

public class LyricsSync {

    // Inner class to store each lyric line with its time in seconds
    static class LyricLine {
        double timeInSeconds;
        String text;

        LyricLine(double timeInSeconds, String text) {
            this.timeInSeconds = timeInSeconds;
            this.text = text;
        }
    }

    public static void main(String[] args) {

        // Define lyrics with time in seconds (e.g., 1 minute = 60.0 seconds)
        List<LyricLine> lyrics = new ArrayList<>();
        lyrics.add(new LyricLine(0.0, "Intro music..."));
        lyrics.add(new LyricLine(5.0, "This is the first line"));
        lyrics.add(new LyricLine(10.0, "Second line of the song"));
        lyrics.add(new LyricLine(15.0, "Third line of the song"));
        lyrics.add(new LyricLine(20.0, "Chorus begins..."));

        long startTime = System.currentTimeMillis();

        for (LyricLine line : lyrics) {
            long currentTime = System.currentTimeMillis();
            long waitTime = (long) (line.timeInSeconds * 1000) - (currentTime - startTime);

            if (waitTime > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(waitTime);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted while waiting");
                }
            }

            // Typing animation
            for (char c : line.text.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted while animating");
                }
            }
            System.out.println(); // Move to next line
        }
    }
}
