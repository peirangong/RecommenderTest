import java.util.ListIterator;


public class RecommenderTester {

    public static final int TOTAL_WEEKS = 10;
	/**
	 * @param args
	 */

    public static void trade(FFTeam teamA, FFTeam teamB) {
        // TODO: player index need to be input variables
        int playerAInd = 3;
        int playerBInd = 1;

        FFPlayer playerA = teamA.getRoster().get(playerAInd);
        FFPlayer playerB = teamB.getRoster().get(playerBInd);

        String AResult = "";
        String BResult = "";

        ListIterator<Double> itrA = playerA.getPlayerPoints().listIterator();
        ListIterator<Double> itrB = playerB.getPlayerPoints().listIterator();
        
        double totalDiff = 0;

        while(itrA.hasNext() && itrB.hasNext()) {
            double diff = itrA.next() - itrB.next();
            AResult = AResult + " " + String.format("%.2f",diff);
            BResult = BResult + " " + String.format("%.2f",(-diff));
            totalDiff += diff;
        }
        
        AResult = AResult + " total Diff: " + String.format("%.2f", totalDiff);
        BResult = BResult + " total Diff: "
                + String.format("%.2f", (-totalDiff));

        System.out.println("Trading: " + teamA.getName() + ": "
                + playerA.getName() + " <---> " + teamB.getName() + ": "
                + playerB.getName());
        System.out.println(AResult);
        System.out.println(BResult);
    }

	public static void main(String[] args) {
        FFTeam PeiranTeam = new FFTeam("PeiranTeam", TOTAL_WEEKS);
        FFTeam HarveyTeam = new FFTeam("HarveyTeam", TOTAL_WEEKS);
        
        PeiranTeam.addPlayer(new FFPlayer("PG-A", TOTAL_WEEKS, 1));
        PeiranTeam.addPlayer(new FFPlayer("PG-B", TOTAL_WEEKS, 2));
        PeiranTeam.addPlayer(new FFPlayer("PG-C", TOTAL_WEEKS, 3));
        PeiranTeam.addPlayer(new FFPlayer("PG-D", TOTAL_WEEKS, 4));
        PeiranTeam.addPlayer(new FFPlayer("PG-E", TOTAL_WEEKS, 5));

        HarveyTeam.addPlayer(new FFPlayer("HC-A", TOTAL_WEEKS, 1001));
        HarveyTeam.addPlayer(new FFPlayer("HC-B", TOTAL_WEEKS, 1002));
        HarveyTeam.addPlayer(new FFPlayer("HC-C", TOTAL_WEEKS, 1003));
        HarveyTeam.addPlayer(new FFPlayer("HC-D", TOTAL_WEEKS, 1004));
        HarveyTeam.addPlayer(new FFPlayer("HC-E", TOTAL_WEEKS, 1005));

        System.out.println(PeiranTeam.printTeam());
        System.out.println(HarveyTeam.printTeam());

        trade(PeiranTeam, HarveyTeam);
	}

}
