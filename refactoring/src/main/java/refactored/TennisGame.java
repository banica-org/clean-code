package homework;

public final class TennisGame {
    private static final int LOVE_POINTS = 0;
    private static final int FIFTEEN_POINTS = 1;
    private static final int THIRTY_POINTS = 2;
    private static final int FORTY_POINTS = 3;
    private static final int WIN_POINTS = 4;
    private static final int WIN_DIFFERENCE = 2;

    private final String player1Name;
    private final String player2Name;
    private int player1Points;
    private int player2Points;

    public TennisGame(final String player1Name, final String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void winPointForPlayer1() {
        player1Points++;
    }

    public void winPointForPlayer2() {
        player2Points++;
    }

    public String calculateScore() {
        final String score;

        if (player1Points == player2Points) {
            if (hasAnyPlayerAdvantage()) {
                score = "Deuce";
            } else {
                score = getScoreForPoints(player1Points) + "-All";
            }
        } else if (isAnyPlayerWinning()) {
            score = "Win for " + getBetterPlayer();
        } else if (hasAnyPlayerAdvantage()) {
            score = "Advantage " + getBetterPlayer();
        } else {
            score = getScoreForPoints(player1Points) + "-" + getScoreForPoints(player2Points);
        }

        return score;
    }

    private boolean isAnyPlayerWinning() {
        final boolean playerWithWinPoints = player1Points >= WIN_POINTS || player2Points >= WIN_POINTS;
        final boolean sufficientPointsDifference = Math.abs(player1Points - player2Points) >= WIN_DIFFERENCE;
        return playerWithWinPoints && sufficientPointsDifference;
    }

    private boolean hasAnyPlayerAdvantage() {
        return player1Points >= FORTY_POINTS || player2Points >= FORTY_POINTS;
    }

    private String getBetterPlayer() {
        return player1Points > player2Points ? player1Name : player2Name;
    }

    private static String getScoreForPoints(final int points) {
        switch (points) {
            case LOVE_POINTS:
                return "Love";
            case FIFTEEN_POINTS:
                return "Fifteen";
            case THIRTY_POINTS:
                return "Thirty";
            case FORTY_POINTS:
                return "Forty";
            default:
                throw new UnsupportedOperationException("Unexpected points count!");
        }
    }
}
