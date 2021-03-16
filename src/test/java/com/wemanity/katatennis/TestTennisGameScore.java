package com.wemanity.katatennis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.wemanity.katatennis.game.TennisGameScore;
import com.wemanity.katatennis.model.Player;

public class TestTennisGameScore {
	
	private TennisGameScore tennisGameScore;

	private Player player1;

	private Player player2;

	@BeforeEach
	public void setup() {
		tennisGameScore = new TennisGameScore();
		player1 = new Player();
		player1.setPlayerName("Player1");
		player2 = new Player();
		player2.setPlayerName("Player2");

		ReflectionTestUtils.setField(tennisGameScore, "player1", player1);
		ReflectionTestUtils.setField(tennisGameScore, "player2", player2);
	}

	@Test
	public void testNewGameShouldReturnLoveAll() {
		String score = tennisGameScore.getScore();

		assertEquals("Love all", score);
	}

	@Test
	public void testPlayerOneWinsFirstBall() {
		tennisGameScore.playerOneScores();

		String score = tennisGameScore.getScore();
		assertEquals("Fifteen,Love", score);
	}

	@Test
	public void testFifteenAll() {
		tennisGameScore.playerOneScores();
		tennisGameScore.playerTwoScores();

		String score = tennisGameScore.getScore();
		assertEquals("Fifteen all", score);
	}

	@Test
	public void testPlayerTwoWinsFirstTwoBalls() {
		createScore(0, 2);

		String score = tennisGameScore.getScore();
		assertEquals("Love,Thirty", score);
	}

	@Test
	public void testPlayerOneWinsFirstThreeBalls() {
		createScore(3, 0);
		String score = tennisGameScore.getScore();
		assertEquals("Forty,Love", score);
	}

	@Test
	public void testPlayersAreDeuce() {
		createScore(3, 3);

		String score = tennisGameScore.getScore();
		assertEquals("Deuce", score);
	}

	@Test
	public void testPlayerOneWinsGame() {
		createScore(4, 0);

		String score = tennisGameScore.getScore();
		assertEquals("Player1 wins", score);
	}

	@Test
	public void testPlayerTwoWinsGame() {
		createScore(1, 4);

		String score = tennisGameScore.getScore();
		assertEquals("Player2 wins", score);
	}

	@Test
	public void testPlayersAreDuce4() {
		createScore(4, 4);
		String score = tennisGameScore.getScore();
		assertEquals("Deuce", score);
	}

	@Test
	public void testPlayerTwoAdvantage() {
		createScore(4, 5);

		String score = tennisGameScore.getScore();
		assertEquals("Advantage Player2", score);
	}

	@Test
	public void testPlayerOneAdvantage() {
		createScore(5, 4);

		String score = tennisGameScore.getScore();
		assertEquals("Advantage Player1", score);
	}

	@Test
	public void testPlayerTwoWins() {
		createScore(2, 4);
		String score = tennisGameScore.getScore();
		assertEquals("Player2 wins", score);
	}

	@Test
	public void testPlayerTwoWinsAfterAdvantage() {
		createScore(6, 8);
		String score = tennisGameScore.getScore();
		assertEquals("Player2 wins", score);
	}

	@Test
	public void testPlayerOneWinsAfterAdvantage() {
		createScore(8, 6);
		String score = tennisGameScore.getScore();
		assertEquals("Player1 wins", score);
	}

	@Test
	public void testScoreInputtedInvalid() {
		createScore(9, 6);
		String score = tennisGameScore.getScore();
		assertEquals("Illegal score...", score);
	}

	private void createScore(int playerOneBalls, int playerTwoBalls) {
		for (int i = 0; i < playerOneBalls; i++) {
			tennisGameScore.playerOneScores();
		}
		for (int i = 0; i < playerTwoBalls; i++) {
			tennisGameScore.playerTwoScores();
		}
	}
}