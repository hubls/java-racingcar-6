package controller;

import model.AttemptNumberConverter;
import model.Cars;
import model.Referee;
import view.InputView;
import view.ProgressView;
import view.ResultView;

import javax.xml.transform.Result;
import java.util.List;

public class RacingGameController {
    private Cars cars;
    private CarController carController = new CarController();
    private int attemptNumber;
    private Referee referee;
    private List<String> winner;

    public void start() {
        receiveCarsName();
        receiveAttemptNumber();
        repeatMove();
        printWinner();
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

    private void findWinner() {
        referee = new Referee();
        referee.competeCars(cars);
        winner = referee.getWinner();
    }

    private void printWinner() {
        findWinner();
        ResultView.printResult(winner);
    }
}
