package com.wemanity.katatennis;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wemanity.katatennis.game.TennisGameScore;
import com.wemanity.katatennis.model.Player;

/**
 * Class that allows user to input from command line for both player and outcome
 * of game displayed on command line
 * 
 *
 */
@Component
public class KataTennisRunner implements CommandLineRunner {

	@Autowired
	@Qualifier("Player1")
	private Player player1;

	@Autowired
	@Qualifier("Player2")
	private Player player2;

	@Autowired
	private TennisGameScore tennisGame;

	@Override
	public void run(String... args) throws IOException {

		try (Scanner inputReader = new Scanner(System.in)) {
			do {
				System.out.println("Please enter first player name : ");
				String playerName1 = inputReader.next();
				player1.setPlayerName(playerName1);

				System.out.println("Please enter second player name : ");
				String playerName2 = inputReader.next();
				player2.setPlayerName(playerName2);

				if (playerName1.trim().equalsIgnoreCase(playerName2.trim())) {
					System.out.println("Both player names are same, please enter two different players!!!");
				} else {
					break;
				}

			} while (true);

			System.out.println("Please enter first player score : ");
			int score1 = inputReader.nextInt();

			System.out.println("Please enter second player score : ");
			int score2 = inputReader.nextInt();

			createScore(score1, score2);
			System.out.format("Game outcome : %s", tennisGame.getScore());
		} catch (InputMismatchException ex) {
			System.out.format("Required input for score is integer... %s", ex.getMessage());
		}
	}

	/**
	 * Method to create score for both players
	 * @param playerOneBalls
	 * @param playerTwoBalls
	 */
	private void createScore(int playerOneBalls, int playerTwoBalls) {

		for (int i = 0; i < playerOneBalls; i++) {
			tennisGame.playerOneScores();
		}
		for (int i = 0; i < playerTwoBalls; i++) {
			tennisGame.playerTwoScores();
		}
	}
}