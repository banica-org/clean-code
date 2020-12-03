package homework;

public final class Main {
    private static final String PLAYER_1_NAME = "player1";
    private static final String PLAYER_2_NAME = "player2";

    public static void main(final String[] args) {
        final TennisGame tennisGame = new TennisGame(PLAYER_1_NAME, PLAYER_2_NAME);
        tennisGame.winPointForPlayer1();
        tennisGame.winPointForPlayer1();
        tennisGame.winPointForPlayer1();
        tennisGame.winPointForPlayer2();
        tennisGame.winPointForPlayer2();
        tennisGame.winPointForPlayer2();
        tennisGame.winPointForPlayer2();
        System.out.println(tennisGame.calculateScore());
    }
}
