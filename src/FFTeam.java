import java.util.LinkedList;
import java.util.ListIterator;

public class FFTeam {
    /** Team name */
    private String name;

    /** List of players on the roster */
    private LinkedList<FFPlayer> roster = new LinkedList<FFPlayer>();

    /** Total number of weeks */
    private int weeks;

    /** Team total points of current players */
    private double teamPts = 0;

    public String getName() {
        return name;
    }

    public LinkedList<FFPlayer> getRoster() {
        return roster;
    }

    public FFTeam(String name, int weeks) {
        super();
        this.name = name;
        this.weeks = weeks;
    }

    public void addPlayer(FFPlayer player) {
        roster.addLast(player);
    }

    public double getTeamPts() {
        teamPts = 0;
        ListIterator<FFPlayer> itr = roster.listIterator();
        while (itr.hasNext()) {
            teamPts += itr.next().getTotalPoints();
        }
        return teamPts;
    }

    public String printTeam() {
        String msg = "";
        msg += name + "\n";
        ListIterator<FFPlayer> itr = roster.listIterator();
        while (itr.hasNext()) {
            msg = msg + itr.next().printPlayer() + "\n";
        }
        msg = msg + getTeamPts() + "\n";
        return msg;
    }
}
