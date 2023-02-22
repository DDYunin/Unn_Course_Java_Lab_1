package com.example.course_java_lab_1;

import com.example.course_java_lab_1.LogicGame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class GameController {
    @FXML
    Circle bigCircleRed, bigCircleGrey, smallCircleRed, smallCircleGrey;

    @FXML
    Label userScore, userShoots;

    LogicGame logicController = new LogicGame();

    boolean gameRun = false;
    Thread moveBigTarget;
    Thread moveSmallTarget;


    @FXML
    protected void startGame() {
        if (moveBigTarget != null) {
            return;
        }
        // Пишем начальный счёт и количество выстрелов игрока = 0
        userScore.setText("0");
        userShoots.setText("0");
        // Устанавливаем мишени в центр экрана
        logicController.putCirclesInCenter(bigCircleGrey, bigCircleRed, smallCircleGrey, smallCircleRed);
        // Создаём поток для движения большой мишени
        gameRun = true;
        moveBigTarget =  new Thread( ()-> {
            while (gameRun) {
                logicController.moveBigTarget(bigCircleGrey, bigCircleRed);
                try {
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    gameRun = false;
                }
            }
        });
        // Создаём поток для движения мальнекой мишени
        moveSmallTarget =  new Thread( ()-> {
            while (gameRun) {
                logicController.moveSmallTarget(smallCircleGrey, smallCircleRed);
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    gameRun = false;
                }
            }
        });
        moveBigTarget.start();
        moveSmallTarget.start();
    }

    @FXML
    protected void makeShoot() {

    }

    @FXML
    protected void stopGame() {
        if (moveBigTarget == null) {
            return;
        }
        moveBigTarget.interrupt();
        moveSmallTarget.interrupt();
        moveBigTarget = null;
        moveSmallTarget = null;
        logicController.clearGameSettings();
    }
}