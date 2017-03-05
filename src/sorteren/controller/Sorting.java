package sorteren.controller;

import javafx.fxml.Initializable;

/**
 * Created by rik on 2/28/17.
 */
interface Sorting extends Initializable {

    void nextAction();

    void autoAction();

    void nextStep();

    Boolean getAuto();
}
