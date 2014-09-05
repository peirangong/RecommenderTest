import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class FFPlayer {
    /** Player name */
    private String name;

    /** List of player's points for each week */
    private LinkedList<Double> playerPoints = new LinkedList<Double>();

    /** Total points for the player */
    private double totalPoints = 0;

    /** Total number of weeks */
    // TODO: already defined in teams. remove this variable later.
    private int weeks;

    public FFPlayer(String name, int weeks, long seed) {
        this.name = name;
        this.weeks = weeks;
        Random r = new Random(seed);
        double pts = r.nextDouble();
        for (int i = 0; i < weeks; i++) {
            pts = r.nextDouble();
            playerPoints.addLast(pts);
            this.totalPoints += pts;
        }
    }

    public LinkedList<Double> getPlayerPoints() {
        return playerPoints;
    }

    public String getName() {
        return name;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public String printPlayer() {
        String msg = name;
        ListIterator<Double> itr = playerPoints.listIterator();
        while (itr.hasNext()) {
            msg = msg + " " + String.format("%.2f", itr.next());
        }
        return msg;
    }
}