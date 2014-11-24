package vsge.ui;

import vsge.core.StateMachine;
import vsge.states.Pause;

public class PauseButton extends Button {

    public PauseButton(int imageDefault, int imageActive, int x, int y) {
        super(imageDefault, imageActive, x, y);
    }

    public void call() {
        StateMachine.push(new Pause());
    }
}
