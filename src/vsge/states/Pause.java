package vsge.states;

import vsge.core.State;
import vsge.events.Input;
import vsge.graphics.Graphics;
import vsge.ui.PlayButton;

public class Pause extends State {

	private PlayButton playButton;

	@Override
	public void init() {
		System.out.println("GAME PAUSED");
		playButton = new PlayButton(IMAGE_PLAY , IMAGE_PLAY_ACTIVE, Graphics.getWidth()/2, Graphics.getHeight()/2);
	}

	@Override
	public void update(int deltatime) {
		// TODO Auto-generated method stub
	}

	@Override
	public void paint() {
		Graphics.clear(0x777777);
		playButton.paint(0, 0);
	}

	@Override
	public boolean event(int eventType, int px, int py, int eventCode) {
		if (eventType == Input.TYPE_MOUSE_DOWN) {
			playButton.press(px, py);
		} else if (eventType == Input.TYPE_MOUSE_UP) {
			boolean exit = playButton.release(px, py);
			if (exit) {
				return false;
			}
		}
		return true;
	}

}
