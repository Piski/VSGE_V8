package vsge.ui;

import vsge.core.StateMachine;

public class PlayButton extends Button {

    public PlayButton(int imageDefault, int imageActive, int x, int y) {
        super(imageDefault, imageActive, x, y);
    }

    public void call() {
        StateMachine.pop();
    }
}
