package vsge.modules.particlesystem;

import java.util.ArrayList;

public class ParticleList {

	private static ArrayList<Particle> mParticleList;
	
	public static void create(int size) {
		mParticleList = new ArrayList<Particle>(size);
	}
	
	public static void update(int elapsedTime) {
		for (Particle p : mParticleList) {
			p.mTime += elapsedTime;
			if (p.mTime < p.mDuration) {
				p.updatePhysics(elapsedTime);
			}
		}
		int size = mParticleList.size();
		Particle p;
		for (int i=size-1; i>=0; i--) {
			p = mParticleList.get(i);
			if (p.mTime >= p.mDuration) {
				mParticleList.remove(i);
			}
		}
		
	}
	
	public static void createParticle(int imgIndex, int frames, int duration,
			float x, float y, float vx, float vy, float ax, float ay) {
		mParticleList.add(new Particle(imgIndex, frames, duration, x, y, vx, vy, ax, ay));
	}
	
	public static void draw() {
		for (Particle p : mParticleList) {
			p.draw();
		}
	}
}
