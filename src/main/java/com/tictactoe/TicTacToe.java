package com.tictactoe;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TicTacToe extends Application {

    // =====================================================
    // VARIABLES
    // =====================================================

    private Stage mainStage;

    private char currentPlayer = 'X';

    private char[][] boardArray = new char[3][3];

    private Button[][] buttons = new Button[3][3];

    private boolean gameOver = false;

    // Scores
    private int xWins = 0;
    private int oWins = 0;
    private int draws = 0;

    // Player names
    private String playerXName = "Player X";
    private String playerOName = "Player O";


    // =====================================================
    // START APPLICATION
    // =====================================================

    @Override
    public void start(Stage stage) {

        mainStage = stage;

        showStartScreen();
    }


    // =====================================================
    // START SCREEN
    // =====================================================

    private void showStartScreen() {

        Label title = new Label("TIC-TAC-TOE");

        title.setStyle(
                "-fx-text-fill: #00FFFF;" +
                        "-fx-font-family: 'Arial';" +
                        "-fx-font-size: 42px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, #00FFFF, 10, 0.8, 0, 0);"
        );


        Label subtitle = new Label("NEON EDITION");

        subtitle.setStyle(
                "-fx-text-fill: #FF00FF;" +
                        "-fx-font-family: 'Arial';" +
                        "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, #FF00FF, 8, 0.6, 0, 0);"
        );


        // =================================================
        // PLAYER X
        // =================================================

        Label playerXLabel = new Label("PLAYER X NAME");

        playerXLabel.setStyle(
                "-fx-text-fill: #00FFFF;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;"
        );


        TextField playerXField = new TextField();

        playerXField.setPromptText("Enter Player X name");

        playerXField.setPrefWidth(280);

        playerXField.setMaxWidth(280);

        playerXField.setStyle(
                "-fx-background-color: #111111;" +
                        "-fx-border-color: #00FFFF;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 8px;" +
                        "-fx-background-radius: 8px;" +
                        "-fx-text-fill: #00FFFF;" +
                        "-fx-prompt-text-fill: #777777;" +
                        "-fx-font-size: 16px;"
        );


        // =================================================
        // PLAYER O
        // =================================================

        Label playerOLabel = new Label("PLAYER O NAME");

        playerOLabel.setStyle(
                "-fx-text-fill: #FF00FF;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;"
        );


        TextField playerOField = new TextField();

        playerOField.setPromptText("Enter Player O name");

        playerOField.setPrefWidth(280);

        playerOField.setMaxWidth(280);

        playerOField.setStyle(
                "-fx-background-color: #111111;" +
                        "-fx-border-color: #FF00FF;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 8px;" +
                        "-fx-background-radius: 8px;" +
                        "-fx-text-fill: #FF00FF;" +
                        "-fx-prompt-text-fill: #777777;" +
                        "-fx-font-size: 16px;"
        );


        // =================================================
        // START BUTTON
        // =================================================

        Button startButton = new Button("START GAME");

        startButton.setPrefWidth(220);

        startButton.setPrefHeight(55);

        setStartButtonStyle(startButton);


        startButton.setOnMouseEntered(event -> {

            startButton.setStyle(
                    "-fx-background-color: #39FF14;" +
                            "-fx-border-color: #39FF14;" +
                            "-fx-border-width: 3px;" +
                            "-fx-border-radius: 10px;" +
                            "-fx-background-radius: 10px;" +
                            "-fx-text-fill: #050505;" +
                            "-fx-font-size: 20px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-effect: dropshadow(gaussian, #39FF14, 20, 0.9, 0, 0);"
            );
        });


        startButton.setOnMouseExited(event -> {

            setStartButtonStyle(startButton);
        });


        startButton.setOnAction(event -> {

            String xName = playerXField.getText().trim();

            String oName = playerOField.getText().trim();


            if (xName.isEmpty()) {

                playerXName = "Player X";

            } else {

                playerXName = xName;
            }


            if (oName.isEmpty()) {

                playerOName = "Player O";

            } else {

                playerOName = oName;
            }


            showGameScreen();
        });


        // =================================================
        // EXIT BUTTON
        // =================================================

        Button exitButton = new Button("EXIT GAME");

        exitButton.setPrefWidth(220);

        exitButton.setPrefHeight(50);

        setExitButtonStyle(exitButton);


        exitButton.setOnMouseEntered(event -> {

            exitButton.setStyle(
                    "-fx-background-color: #FF4444;" +
                            "-fx-border-color: #FF4444;" +
                            "-fx-border-width: 2px;" +
                            "-fx-border-radius: 10px;" +
                            "-fx-background-radius: 10px;" +
                            "-fx-text-fill: #050505;" +
                            "-fx-font-size: 18px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-effect: dropshadow(gaussian, #FF4444, 18, 0.8, 0, 0);"
            );
        });


        exitButton.setOnMouseExited(event -> {

            setExitButtonStyle(exitButton);
        });


        exitButton.setOnAction(event -> {

            mainStage.close();
        });


        // =================================================
        // START SCREEN LAYOUT
        // =================================================

        VBox root = new VBox(14);

        root.setAlignment(Pos.CENTER);

        root.setStyle(
                "-fx-background-color: #050505;" +
                        "-fx-padding: 30px;"
        );


        root.getChildren().addAll(
                title,
                subtitle,
                playerXLabel,
                playerXField,
                playerOLabel,
                playerOField,
                startButton,
                exitButton
        );


        Scene scene = new Scene(root, 500, 750);

        mainStage.setTitle("Neon Tic-Tac-Toe");

        mainStage.setScene(scene);

        mainStage.setResizable(false);

        mainStage.show();
    }


    // =====================================================
    // GAME SCREEN
    // =====================================================

    private void showGameScreen() {

        currentPlayer = 'X';

        gameOver = false;

        clearBoardArray();


        // =================================================
        // TITLE
        // =================================================

        Label title = new Label("TIC-TAC-TOE");

        title.setStyle(
                "-fx-text-fill: #00FFFF;" +
                        "-fx-font-family: 'Arial';" +
                        "-fx-font-size: 32px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, #00FFFF, 8, 0.6, 0, 0);"
        );


        // =================================================
        // STATUS
        // =================================================

        Label status = new Label(
                playerXName + " (X) TURN"
        );

        status.setStyle(
                "-fx-text-fill: #39FF14;" +
                        "-fx-font-family: 'Arial';" +
                        "-fx-font-size: 21px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, #39FF14, 7, 0.5, 0, 0);"
        );


        // =================================================
        // SCORE
        // =================================================

        Label scoreLabel = new Label();

        updateScore(scoreLabel);


        // =================================================
        // BOARD
        // =================================================

        GridPane board = new GridPane();

        board.setAlignment(Pos.CENTER);

        board.setHgap(8);

        board.setVgap(8);


        // =================================================
        // CREATE 3 x 3 BOARD
        // =================================================

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                Button button = new Button();

                buttons[row][col] = button;

                final int buttonRow = row;

                final int buttonCol = col;

                button.setPrefSize(105, 105);

                setEmptyStyle(button);


                // =================================================
                // MOUSE ENTER
                // =================================================

                button.setOnMouseEntered(event -> {

                    if (button.getText().isEmpty() && !gameOver) {

                        button.setStyle(
                                "-fx-background-color: #1A1A1A;" +
                                        "-fx-border-color: #39FF14;" +
                                        "-fx-border-width: 3px;" +
                                        "-fx-border-radius: 10px;" +
                                        "-fx-background-radius: 10px;" +
                                        "-fx-effect: dropshadow(gaussian, #39FF14, 15, 0.7, 0, 0);"
                        );
                    }
                });


                // =================================================
                // MOUSE EXIT
                // =================================================

                button.setOnMouseExited(event -> {

                    if (button.getText().isEmpty()) {

                        setEmptyStyle(button);
                    }
                });


                // =================================================
                // CLICK EVENT
                // =================================================

                button.setOnAction(event -> {

                    // Game already finished
                    if (gameOver) {
                        return;
                    }


                    // Cell already occupied
                    if (!button.getText().isEmpty()) {
                        return;
                    }


                    // Place symbol
                    button.setText(
                            String.valueOf(currentPlayer)
                    );


                    // Save in array
                    boardArray[buttonRow][buttonCol] =
                            currentPlayer;


                    // Apply style
                    if (currentPlayer == 'X') {

                        setXStyle(button);

                    } else {

                        setOStyle(button);
                    }


                    // =================================================
                    // CHECK WINNER
                    // =================================================

                    if (checkWinner()) {

                        if (currentPlayer == 'X') {

                            xWins++;

                            status.setText(
                                    playerXName +
                                            " (X) WINS!"
                            );

                        } else {

                            oWins++;

                            status.setText(
                                    playerOName +
                                            " (O) WINS!"
                            );
                        }


                        updateScore(scoreLabel);

                        gameOver = true;

                        return;
                    }


                    // =================================================
                    // CHECK DRAW
                    // =================================================

                    if (checkDraw()) {

                        draws++;

                        updateScore(scoreLabel);

                        status.setText("GAME DRAW!");

                        gameOver = true;

                        return;
                    }


                    // =================================================
                    // CHANGE PLAYER
                    // =================================================

                    if (currentPlayer == 'X') {

                        currentPlayer = 'O';

                        status.setText(
                                playerOName +
                                        " (O) TURN"
                        );

                    } else {

                        currentPlayer = 'X';

                        status.setText(
                                playerXName +
                                        " (X) TURN"
                        );
                    }
                });


                board.add(button, col, row);
            }
        }


        // =================================================
        // RESTART BUTTON
        // =================================================

        Button restartButton =
                new Button("RESTART GAME");

        setRestartStyle(restartButton);


        restartButton.setOnMouseEntered(event -> {

            restartButton.setStyle(
                    "-fx-background-color: #39FF14;" +
                            "-fx-border-color: #39FF14;" +
                            "-fx-border-width: 2px;" +
                            "-fx-border-radius: 8px;" +
                            "-fx-background-radius: 8px;" +
                            "-fx-text-fill: #050505;" +
                            "-fx-font-size: 16px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 10px 20px;" +
                            "-fx-effect: dropshadow(gaussian, #39FF14, 15, 0.8, 0, 0);"
            );
        });


        restartButton.setOnMouseExited(event -> {

            setRestartStyle(restartButton);
        });


        restartButton.setOnAction(event -> {

            restartGame(status);
        });


        // =================================================
        // RESET SCORE
        // =================================================

        Button resetScoreButton =
                new Button("RESET SCORE");

        setResetScoreStyle(resetScoreButton);


        resetScoreButton.setOnMouseEntered(event -> {

            resetScoreButton.setStyle(
                    "-fx-background-color: #FF4444;" +
                            "-fx-border-color: #FF4444;" +
                            "-fx-border-width: 2px;" +
                            "-fx-border-radius: 8px;" +
                            "-fx-background-radius: 8px;" +
                            "-fx-text-fill: #050505;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 8px 18px;" +
                            "-fx-effect: dropshadow(gaussian, #FF4444, 15, 0.8, 0, 0);"
            );
        });


        resetScoreButton.setOnMouseExited(event -> {

            setResetScoreStyle(resetScoreButton);
        });


        resetScoreButton.setOnAction(event -> {

            xWins = 0;

            oWins = 0;

            draws = 0;

            updateScore(scoreLabel);

            restartGame(status);
        });


        // =================================================
        // MAIN MENU
        // =================================================

        Button menuButton =
                new Button("MAIN MENU");

        setMenuStyle(menuButton);


        menuButton.setOnMouseEntered(event -> {

            menuButton.setStyle(
                    "-fx-background-color: #00FFFF;" +
                            "-fx-border-color: #00FFFF;" +
                            "-fx-border-width: 2px;" +
                            "-fx-border-radius: 8px;" +
                            "-fx-background-radius: 8px;" +
                            "-fx-text-fill: #050505;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 8px 18px;" +
                            "-fx-effect: dropshadow(gaussian, #00FFFF, 15, 0.8, 0, 0);"
            );
        });


        menuButton.setOnMouseExited(event -> {

            setMenuStyle(menuButton);
        });


        menuButton.setOnAction(event -> {

            showStartScreen();
        });


        // =================================================
        // LAYOUT
        // =================================================

        VBox root = new VBox(20);

        root.setAlignment(Pos.TOP_CENTER);

        root.setStyle(
                "-fx-background-color: #050505;" +
                        "-fx-padding: 35px 20px 30px 20px;"
        );


        root.getChildren().addAll(
                title,
                status,
                scoreLabel,
                board,
                restartButton,
                resetScoreButton,
                menuButton
        );


        // =================================================
        // SCENE
        // =================================================

        Scene scene = new Scene(root, 500, 820);

        mainStage.setTitle("Neon Tic-Tac-Toe");

        mainStage.setScene(scene);

        mainStage.setResizable(false);

        mainStage.show();
    }


    // =====================================================
    // WINNER CHECK
    // =====================================================

    private boolean checkWinner() {

        // ROWS
        for (int row = 0; row < 3; row++) {

            if (boardArray[row][0] == currentPlayer &&
                    boardArray[row][1] == currentPlayer &&
                    boardArray[row][2] == currentPlayer) {

                highlightWinner(
                        buttons[row][0],
                        buttons[row][1],
                        buttons[row][2]
                );

                return true;
            }
        }


        // COLUMNS
        for (int col = 0; col < 3; col++) {

            if (boardArray[0][col] == currentPlayer &&
                    boardArray[1][col] == currentPlayer &&
                    boardArray[2][col] == currentPlayer) {

                highlightWinner(
                        buttons[0][col],
                        buttons[1][col],
                        buttons[2][col]
                );

                return true;
            }
        }


        // MAIN DIAGONAL
        if (boardArray[0][0] == currentPlayer &&
                boardArray[1][1] == currentPlayer &&
                boardArray[2][2] == currentPlayer) {

            highlightWinner(
                    buttons[0][0],
                    buttons[1][1],
                    buttons[2][2]
            );

            return true;
        }


        // SECOND DIAGONAL
        if (boardArray[0][2] == currentPlayer &&
                boardArray[1][1] == currentPlayer &&
                boardArray[2][0] == currentPlayer) {

            highlightWinner(
                    buttons[0][2],
                    buttons[1][1],
                    buttons[2][0]
            );

            return true;
        }


        return false;
    }


    // =====================================================
    // WINNING CELL EFFECT
    // =====================================================

    private void highlightWinner(
            Button button1,
            Button button2,
            Button button3) {

        String winnerStyle =
                "-fx-background-color: #101010;" +
                        "-fx-border-color: #39FF14;" +
                        "-fx-border-width: 5px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-text-fill: #39FF14;" +
                        "-fx-font-family: 'Arial';" +
                        "-fx-font-size: 42px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, #39FF14, 25, 0.9, 0, 0);";


        button1.setStyle(winnerStyle);

        button2.setStyle(winnerStyle);

        button3.setStyle(winnerStyle);


        animateWinner(button1);

        animateWinner(button2);

        animateWinner(button3);
    }


    // =====================================================
    // WINNER ANIMATION
    // =====================================================

    private void animateWinner(Button button) {

        ScaleTransition animation =
                new ScaleTransition(
                        Duration.millis(500),
                        button
                );

        animation.setFromX(1.0);

        animation.setFromY(1.0);

        animation.setToX(1.08);

        animation.setToY(1.08);

        animation.setAutoReverse(true);

        animation.setCycleCount(Animation.INDEFINITE);

        animation.play();
    }


    // =====================================================
    // DRAW CHECK
    // =====================================================

    private boolean checkDraw() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (boardArray[row][col] == '\0') {

                    return false;
                }
            }
        }

        return true;
    }


    // =====================================================
    // SCORE UPDATE
    // =====================================================

    private void updateScore(Label scoreLabel) {

        scoreLabel.setText(
                "X WINS: " + xWins +
                        "    DRAW: " + draws +
                        "    O WINS: " + oWins
        );

        scoreLabel.setStyle(
                "-fx-text-fill: #FFFF00;" +
                        "-fx-font-family: 'Arial';" +
                        "-fx-font-size: 17px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, #FFFF00, 6, 0.5, 0, 0);"
        );
    }


    // =====================================================
    // RESTART GAME
    // =====================================================

    private void restartGame(Label status) {

        currentPlayer = 'X';

        gameOver = false;

        clearBoardArray();

        status.setText(
                playerXName + " (X) TURN"
        );


        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                buttons[row][col].setText("");

                buttons[row][col].setScaleX(1.0);

                buttons[row][col].setScaleY(1.0);

                setEmptyStyle(buttons[row][col]);
            }
        }
    }


    // =====================================================
    // CLEAR ARRAY
    // =====================================================

    private void clearBoardArray() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                boardArray[row][col] = '\0';
            }
        }
    }


    // =====================================================
    // EMPTY STYLE
    // =====================================================

    private void setEmptyStyle(Button button) {

        button.setStyle(
                "-fx-background-color: #111111;" +
                        "-fx-border-color: #00FFFF;" +
                        "-fx-border-width: 3px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-text-fill: #00FFFF;" +
                        "-fx-font-family: 'Arial';" +
                        "-fx-font-size: 40px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, #00FFFF, 8, 0.5, 0, 0);"
        );
    }


    // =====================================================
    // X STYLE
    // =====================================================

    private void setXStyle(Button button) {

        button.setStyle(
                "-fx-background-color: #111111;" +
                        "-fx-border-color: #00FFFF;" +
                        "-fx-border-width: 3px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-text-fill: #00FFFF;" +
                        "-fx-font-family: 'Arial';" +
                        "-fx-font-size: 42px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, #00FFFF, 12, 0.7, 0, 0);"
        );
    }


    // =====================================================
    // O STYLE
    // =====================================================

    private void setOStyle(Button button) {

        button.setStyle(
                "-fx-background-color: #111111;" +
                        "-fx-border-color: #FF00FF;" +
                        "-fx-border-width: 3px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-text-fill: #FF00FF;" +
                        "-fx-font-family: 'Arial';" +
                        "-fx-font-size: 42px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, #FF00FF, 12, 0.7, 0, 0);"
        );
    }


    // =====================================================
    // START BUTTON STYLE
    // =====================================================

    private void setStartButtonStyle(Button button) {

        button.setStyle(
                "-fx-background-color: #111111;" +
                        "-fx-border-color: #39FF14;" +
                        "-fx-border-width: 3px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-text-fill: #39FF14;" +
                        "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, #39FF14, 12, 0.7, 0, 0);"
        );
    }


    // =====================================================
    // EXIT BUTTON STYLE
    // =====================================================

    private void setExitButtonStyle(Button button) {

        button.setStyle(
                "-fx-background-color: #111111;" +
                        "-fx-border-color: #FF4444;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-text-fill: #FF4444;" +
                        "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-effect: dropshadow(gaussian, #FF4444, 8, 0.6, 0, 0);"
        );
    }


    // =====================================================
    // RESTART STYLE
    // =====================================================

    private void setRestartStyle(Button button) {

        button.setStyle(
                "-fx-background-color: #111111;" +
                        "-fx-border-color: #39FF14;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 8px;" +
                        "-fx-background-radius: 8px;" +
                        "-fx-text-fill: #39FF14;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10px 20px;" +
                        "-fx-effect: dropshadow(gaussian, #39FF14, 8, 0.5, 0, 0);"
        );
    }


    // =====================================================
    // RESET SCORE STYLE
    // =====================================================

    private void setResetScoreStyle(Button button) {

        button.setStyle(
                "-fx-background-color: #111111;" +
                        "-fx-border-color: #FF4444;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 8px;" +
                        "-fx-background-radius: 8px;" +
                        "-fx-text-fill: #FF4444;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8px 18px;" +
                        "-fx-effect: dropshadow(gaussian, #FF4444, 8, 0.5, 0, 0);"
        );
    }


    // =====================================================
    // MAIN MENU STYLE
    // =====================================================

    private void setMenuStyle(Button button) {

        button.setStyle(
                "-fx-background-color: #111111;" +
                        "-fx-border-color: #00FFFF;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 8px;" +
                        "-fx-background-radius: 8px;" +
                        "-fx-text-fill: #00FFFF;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8px 18px;" +
                        "-fx-effect: dropshadow(gaussian, #00FFFF, 8, 0.5, 0, 0);"
        );
    }


    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        launch(args);
    }
}