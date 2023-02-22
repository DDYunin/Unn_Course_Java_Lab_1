package com.example.course_java_lab_1;

import javafx.scene.shape.Circle;

public class LogicGame {

    boolean upMoveBigTarget = false;
    boolean upMoveSmallTarget = false;
    void putCirclesInCenter(Circle bigGrey, Circle bigRed, Circle smallGrey, Circle smallRed) {
        bigGrey.setLayoutY(331);
        bigRed.setLayoutY(331);
        smallGrey.setLayoutY(331);
        smallRed.setLayoutY(331);
    }

    void moveBigTarget(Circle bigGrey, Circle bigRed) {
        double yGrey = bigGrey.getLayoutY();
        double yRed = bigRed.getLayoutY();
        if (upMoveBigTarget) {
            yGrey -= 5;
            yRed -= 5;
            if (yGrey <= 30) {
                upMoveBigTarget = false;
            }
        } else {
            yGrey += 5;
            yRed += 5;
            if (yGrey >= 632) {
                upMoveBigTarget = true;
            }
        }
        bigGrey.setLayoutY(yGrey);
        bigRed.setLayoutY(yRed);
    }

    void moveSmallTarget(Circle smallGrey, Circle smallRed) {
        double yGrey = smallGrey.getLayoutY();
        double yRed = smallRed.getLayoutY();
        if (upMoveSmallTarget) {
            yGrey -= 5;
            yRed -= 5;
            if (yGrey <= 15) {
                upMoveSmallTarget = false;
            }
        } else {
            yGrey += 5;
            yRed += 5;
            if (yGrey >= 648) {
                upMoveSmallTarget = true;
            }
        }
        smallGrey.setLayoutY(yGrey);
        smallRed.setLayoutY(yRed);
    }

    void clearGameSettings() {
        upMoveBigTarget = false;
        upMoveSmallTarget = false;
    }
}
