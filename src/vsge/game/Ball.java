package vsge.game;

import vsge.graphics.Graphics;
import vsge.graphics.ImageConstants;

public class Ball {

	private static final float START_VELOCITY = 500f;
	private static final float NEG_ACCEL = 500f;
	
	private float x, y, vx, vy, r;
	private int img;
	
	public Ball(float x, float y) {
		this.x = x;
		this.y = y;
		vx = 0;
		vy = 0;
		img = ImageConstants.IMAGE_BALL;
		r = Graphics.getImageWidth(img)/2;
	}
	
	public void paint() {
		Graphics.drawImage(img, x - r, y - r);
	}
	
	public void moveUp() {
		vx = 0;
		vy = -START_VELOCITY;
	}
	
	public void moveDown() {
		vx = 0;
		vy = START_VELOCITY;
	}
	
	public void moveLeft() {
		vy = 0;
		vx = -START_VELOCITY;
	}
	
	public void moveRight() {
		vy = 0;
		vx = START_VELOCITY;
	}
	
	public void update(int elapsed) {
		x += vx*elapsed*0.001f;
		y += vy*elapsed*0.001f;
		if (x - r < 0) {
			float diff = x - r;
			x -= diff;
			vx = -vx;
		} else if (x + r > Graphics.getWidth()) {
			float diff = x + r - Graphics.getWidth();
			x -= diff;
			vx = -vx;
		} else if (y - r < 0) {
			float diff = y - r;
			y -= diff;
			vy = -vy;
		} else if (y + r > Graphics.getHeight()) {
			float diff = y + r - Graphics.getHeight();
			y -= diff;
			vy = -vy;
		}
		float sign = Math.signum(vx);
		vx -= sign*NEG_ACCEL*0.001f;
		if (Math.signum(vx) != sign) vx = 0;
		sign = Math.signum(vy);
		vy -= sign*NEG_ACCEL*0.001f;
		if (Math.signum(vy) != sign) vy = 0;
		
	}
	
}
