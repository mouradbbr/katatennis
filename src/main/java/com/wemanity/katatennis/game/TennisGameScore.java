package com.wemanity.katatennis.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.wemanity.katatennis.model.Player;

/**
 * Tennis game score class that calculate outcome of game based on both player
 * scores.
 *
 */
@Component
public class TennisGameScore {

	private static final String ILLEGAL_SCORE = "-1";
	private static final String FORTY_SCORE = "Forty";
	private static final String THIRTY_SCORE = "Thirty";
	private static final String FIFTEEN_SCORE = "Fifteen";
	private static final String LOVE_SCORE = "Love";
	private static final String DEUCE = "Deuce";
	private static final String ADVANTAGE = "Advantage ";
	private static final String ILLEGAL_SCORE_RESULT = "Illegal score...";

	@Autowired
	@Qualifier("Player1")
	private Player player1;

	@Autowired
	@Qualifier("Player2")
	private Player player2;

	public String getScore() {

		if (hasWinner()) {
			return playerWithHighestScore() + " wins";
		}

		if (hasAdvantage()) {
			return ADVANTAGE + playerWithHighestScore();
		}

		if (isDeuce())
			return DEUCE;

		if (player1.getPlayerScore() == player2.getPlayerScore()) {
			return scoreMapper(player1.getPlayerScore()) + " all";
		}

		String score1 = scoreMapper(player1.getPlayerScore());
		String score2 = scoreMapper(player2.getPlayerScore());

		if (ILLEGAL_SCORE.equals(score1) && ILLEGAL_SCORE.equals(score2)) {
			return ILLEGAL_SCORE_RESULT;
		}

		return score1 + "," + score2;
	}

	private boolean isDeuce() {
		return player1.getPlayerScore() >= 3 && player2.getPlayerScore() == player1.getPlayerScore();
	}

	private String playerWithHighestScore() {
		if (player1.getPlayerScore() > player2.getPlayerScore()) {
			return player1.getPlayerName();
		} else {
			return player2.getPlayerName();
		}
	}

	private boolean hasWinner() {
		if (player2.getPlayerScore() == 4 && player2.getPlayerScore() >= player1.getPlayerScore() + 2)
			return true;
		if (player1.getPlayerScore() == 4 && player1.getPlayerScore() >= player2.getPlayerScore() + 2)
			return true;
		if (player2.getPlayerScore() > 4 && player2.getPlayerScore() == player1.getPlayerScore() + 2)
			return true;
		if (player1.getPlayerScore() > 4 && player1.getPlayerScore() == player2.getPlayerScore() + 2)
			return true;
		return false;
	}

	private boolean hasAdvantage() {
		if (player2.getPlayerScore() >= 4 && player2.getPlayerScore() == player1.getPlayerScore() + 1)
			return true;
		if (player1.getPlayerScore() >= 4 && player1.getPlayerScore() == player2.getPlayerScore() + 1)
			return true;

		return false;
	}

	public void playerOneScores() {
		int score = player1.getPlayerScore() + 1;
		player1.setPlayerScore(score);
	}

	public void playerTwoScores() {
		int score = player2.getPlayerScore() + 1;
		player2.setPlayerScore(score);
	}

	private String scoreMapper(int score) {
		switch (score) {
		case 3:
			return FORTY_SCORE;
		case 2:
			return THIRTY_SCORE;
		case 1:
			return FIFTEEN_SCORE;
		case 0:
			return LOVE_SCORE;
		}
		return ILLEGAL_SCORE;
	}
}