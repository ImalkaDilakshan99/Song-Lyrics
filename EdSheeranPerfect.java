import java.util.*;
import java.util.concurrent.TimeUnit;

public class EdSheeranPerfect {

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
        lyrics.add(new LyricLine(0.0, "Baby, I'm..."));
        lyrics.add(new LyricLine(5.0, "Dancing in the dark"));
        lyrics.add(new LyricLine(9.0, "With you between my arms"));
        lyrics.add(new LyricLine(13.0, "Barefoot on the grass"));
        lyrics.add(new LyricLine(17.0, "Listening to our favourite song"));
        lyrics.add(new LyricLine(20.0, "I have faith in what I see"));
        lyrics.add(new LyricLine(23.0, "Now I know I have met an angel in person"));
        lyrics.add(new LyricLine(30.0, "And she looks perfect"));
        lyrics.add(new LyricLine(33.0, "I don't deserve this"));
        lyrics.add(new LyricLine(37.0, "You look perfect tonight"));
        
        

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
                    TimeUnit.MILLISECONDS.sleep(80);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted while animating");
                }
            }
            System.out.println(); // Move to next line
        }
    }
}

