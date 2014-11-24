package vsge.states;

import vsge.core.State;
import vsge.core.StateMachine;
import vsge.graphics.Graphics;

public class Results extends State {

	private int time;
	
	@Override
	public void init() {
		time = 0;
	}

	@Override
	public void update(int deltatime) {
		time += deltatime;
		if (time >= 1000) StateMachine.pop();
	}
	
	private float lerp(float x0, float x1, float t) {
		return x0 + t*(x1 - x0);
	}

	@Override
	public void paint() {
		Graphics.clear(0xccaacc);
		Graphics.setColor(0xeeddcc);
//		final int rw = time*Graphics.getWidth()/1000;
//		final int rh = time*Graphics.getHeight()/1000;
		final int rw = (int) lerp(0, Graphics.getWidth(), time/1000.f);
		final int rh = (int) lerp(0, Graphics.getHeight(), time/1000.f);
		Graphics.fillRect(Graphics.getWidth() - rw >> 1,
				Graphics.getHeight() - rh >> 1, rw, rh);
	}

	@Override
	public boolean event(int eventType, int px, int py, int eventCode) {
		// TODO Auto-generated method stub
		return false;
	}

}
