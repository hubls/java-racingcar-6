package controller;

import model.AttemptNumberConverter;
import model.Cars;
import view.InputView;
import view.ProgressView;

public class RacingGameController {
    private Cars cars;
    private CarController carController = new CarController();
    private int attemptNumber;

    public void start() {
        receiveCarsName();
        receiveAttemptNumber();
        repeatMove();
    }

    private void receiveCarsName() {
        cars = new Cars(carController.makeCars());
    }

    private void receiveAttemptNumber() {
        String attemptNumberAsString = InputView.inputAttemptNumber();
        attemptNumber = AttemptNumberConverter.convertStringToInteger(attemptNumberAsString);
    }

    private void repeatMove() {
        ProgressView.printProgressResultMessage();
        for (int i = 0; i < attemptNumber; i++) {
            cars.moveAll();
            ProgressView.printProgress(cars);
        }
    }
}
