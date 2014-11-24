package vsge.modules.particlesystem;

import vsge.graphics.Graphics;

public class Particle {

	int mImgIndex;
	int mFrames;
	int mDuration;
	float mX;
	float mY;
	float mVx; // pix/s
	float mVy; // pix/s
	float mAx; // pix/s²
	float mAy; // pix/s²
	int mTime;
	
	public Particle(int imgIndex, int frames,
			int duration, float x, float y, float vx, float vy,
			float ax, float ay) {
		mImgIndex = imgIndex;
		mFrames = frames;
		mDuration = duration;
		mX = x;
		mY = y;
		mVx = vx;
		mVy = vy;
		mAx = ax;
		mAy = ay;
		mTime = 0;
	}

	public void updatePhysics(int elapsed) {
		mX += mVx*elapsed/1000;
		mY += mVy*elapsed/1000;
		mVx += mAx*elapsed/1000;
		mVy += mAy*elapsed/1000;
	}
	
	public void draw() {
		final int frame = mTime*mFrames/mDuration;
		final int img = mImgIndex + frame;
		Graphics.drawImage(img, mX, mY);
	}

}
