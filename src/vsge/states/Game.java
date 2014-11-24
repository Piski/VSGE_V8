package vsge.states;

import vsge.core.State;
import vsge.events.Input;
import vsge.game.Ball;
import vsge.graphics.Graphics;
import vsge.ui.ExitButton;
import vsge.ui.PauseButton;
import vsge.ui.PlayButton;

public class Game extends State {

	private ExitButton exitButton;
	private Ball ball;
	private PauseButton pauseButton;
	private int startX;
	private int startY;

	
	public void init() {
		System.out.println("init game");
		exitButton = new ExitButton(IMAGE_EXIT, IMAGE_EXIT_ACTIVE, 0, 0);
		ball = new Ball(Graphics.getWidth()/2, Graphics.getHeight()/2);
		pauseButton = new PauseButton(IMAGE_PAUSE, IMAGE_PAUSE_ACTIVE, 0, Graphics.getHeight()-50);
	}
	
	public void update(int deltatime) {
		ball.update(deltatime);
	}
	
	public boolean event(int eventType, int px, int py, int eventCode) {
		if (eventType == Input.TYPE_MOUSE_DOWN) {
			startX = px;
			startY = py;
			exitButton.press(px, py);
			pauseButton.press(px, py);
		} else if (eventType == Input.TYPE_MOUSE_UP) {
			boolean exit = exitButton.release(px, py);
			boolean pause = pauseButton.release(px, py);
			if (exit) {
				return false;
			} else if (pause) {
				return false;
			}
		}

		if (eventType == Input.TYPE_MOUSE_DRAG) {
			if(startX > px && Math.abs(startX-px) > (Math.abs(startY-py))) {
				ball.moveLeft();
			} else if (startX < px && Math.abs(startX-px) > (Math.abs(startY-py))) {
				ball.moveRight();
			} else if (startY > py && Math.abs(startY-py) > (Math.abs(startX-px))) {
				ball.moveUp();
			} else if (startY < py && Math.abs(startY-py) > (Math.abs(startX-px))) {
				ball.moveDown();
			}
		}

		return true;
	}


	
	public void paint() {
		Graphics.clear(0x666666);
		ball.paint();
		exitButton.paint(0, 0);
		pauseButton.paint(0, 0);
	}

}
