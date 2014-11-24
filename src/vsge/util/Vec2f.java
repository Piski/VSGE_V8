package vsge.util;


/**
 * 2-valued float vector.
 */
public class Vec2f {
	public static final Vec2f ZERO = new Vec2f();
	public static final Vec2f ONE = new Vec2f(1.f, 1.f);
	
	public float x;
	public float y;

	/**
	 * Create new object that may be converted into stack allocation.
	 * @return
	 */
	public static Vec2f stackAlloc() {
		return new Vec2f();
	}

	public Vec2f() {
	}
	
	public Vec2f(Vec2f v) {
		x=v.x;
		y=v.y;
	}
	
	public Vec2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vec2f(float[] v) {
		this.x = v[0];
		this.y = v[1];
	}

	/**
	 * Return a copy of this vector.
	 */
	public final Vec2f clone() {
		return new Vec2f(x, y);
	}

	public boolean isZero() {
		return x==0 && y==0;
	}

	public boolean equals(Vec2f v) {
		return x == v.x && y == v.y;
	}
	
	public boolean equals(Vec2f v, float tolerance) {
		return Math.abs(x - v.x) < tolerance && Math.abs(y - v.y) < tolerance;
	}

	public float getAt(int i) {
		return i == 0 ? x : (i == 1 ? y : 0);
	}

	public void setAt(int i, float v) {
		if (i == 0) {
			x = v;
		} else if (i == 1) {
			y = v;
		}
	}

	public void setZero() {
		x = 0;
		y = 0;
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vec2f set_chain(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public void set(Vec2f v) {
		x = v.x;
		y = v.y;
	}

	public Vec2f set_chain(Vec2f v) {
		x = v.x;
		y = v.y;
		return this;
	}

	public void set(float[] v) {
		x = v[0];
		y = v[1];
	}
	
	public void set(float[] v, int index) {
		x = v[index++];
		y = v[index];
	}
	
	public void negate() {
		x = -x;
		y = -y;
	}

	public Vec2f negate_chain() {
		x = -x;
		y = -y;
		return this;
	}

	public void add(Vec2f v) {
		x += v.x;
		y += v.y;
	}

	public void add(float x, float y) {
		this.x += x;
		this.y += y;
	}

	public void add(float v) {
		this.x += v;
		this.y += v;
	}

//	public Vec2f add_new(Vec2f v) {
//		return new Vec2f(x + v.x, y + v.y);
//	}
	
	public Vec2f add_chain(Vec2f v) {
		x += v.x;
		y += v.y;
		return this;
	}
	
	public void add(float[] v) {
		x += v[0];
		y += v[1];
	}

	public void setAdd(Vec2f a, Vec2f b) {
		x = a.x + b.x;
		y = a.y + b.y;
	}
	
	public void addAt(int index, float v) {
		if (index == 0) {
			x += v;
		} else {
			y += v;
		}
	}


	public void sub(Vec2f v) {
		x -= v.x;
		y -= v.y;
	}

	public Vec2f sub_chain(Vec2f v) {
		x -= v.x;
		y -= v.y;
		return this;
	}

	public void sub(float vx, float vy) {
		x -= vx;
		y -= vy;
	}
	
	public void sub(float[] v) {
		x -= v[0];
		y -= v[1];
	}

	public void setSub(Vec2f a, Vec2f b) {
		x = a.x - b.x;
		y = a.y - b.y;
	}

//	public final Vec2f sub_new(Vec2f v) {
//		return new Vec2f(x - v.x, y - v.y);
//	}
	
	public void mul(float s) {
		x *= s;
		y *= s;
	}
	
	public void mul(float sX,float sY) {
		x *= sX;
		y *= sY;
	}
	
	public void mul(Vec2f v) {
		x *= v.x;
		y *= v.y;
	}

	public void setMul(Vec2f v, float s) {
		x = v.x*s;
		y = v.y*s;
	}
	
	public Vec2f mul_chain(float s) {
		x *= s;
		y *= s;
		return this;
	}
	
	// Scale with pivot as center point for scaling
	
	public void scaleAbout(Vec2f pivot, float scale) {
		x += (x-pivot.x)*scale;
		y += (y-pivot.y)*scale;
	}
	
	public void div(float s) {
		x /= s;
		y /= s;
	}

	/**
	 * Add (s * v) to this vector.
	 * @param s
	 * @param v
	 */
	public void addMul(Vec2f v, float s) {
		x += v.x * s;
		y += v.y * s;
	}

	public void setAbs(Vec2f v) {
		x = Math.abs(v.x);
		y = Math.abs(v.y);
	}
	
	public final void abs(){
		x = x > 0 ? x : -x;
		y = y > 0 ? y : -y;
//		x = Math.abs(x);
//		y = Math.abs(y);
	}
	
		
	public float dot(Vec2f v) {
		return x * v.x + y * v.y;
	}
	
	public float dot(float[] v) {
		return x * v[0] + y * v[1];
	}

	public final void setCross(Vec2f a, float s){
		float tempy = -s * a.x;
		x = s * a.y;
		y = tempy;
	}

	public final void setCross(float s, Vec2f a){
		float tempY = s * a.x;
		x = -s * a.y;
		y = tempY;
	}

	public float lengthSq() {
		return x*x+y*y;
	}
	
	/**
	 * Calculate squared distance to vector v.
	 * @param v
	 * @return
	 */
	public float distSq(Vec2f v) {
		final float c0 = x - v.x;
		final float c1 = y - v.y;
		return c0 * c0 + c1 * c1;
	}

	public float distSq(float[] v) {
		final float c0 = x - v[0];
		final float c1 = y - v[1];
		return c0 * c0 + c1 * c1;
	}

	
	public void rotate90() {
		float oy = y;
		y = x;
		x = -oy;
	}
	
	/**
	 * Cross product analog for 2D (rotated dot product).
	 * @param v
	 * @return
	 */
	public float cross(Vec2f v) {
		return x * v.y - y * v.x;
	}


	/**
	 * Componentwise min.
	 * @param a
	 * @param b
	 */
	public void setMin(Vec2f a, Vec2f b) {
		x = Math.min(a.x, b.x);
		y = Math.min(a.y, b.y);
	}

	/**
	 * Componentwise max.
	 * @param a
	 * @param b
	 */
	public void setMax(Vec2f a, Vec2f b) {
		x = Math.max(a.x, b.x);
		y = Math.max(a.y, b.y);
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append('[');
		result.append(x);
		result.append(", ");
		result.append(y);
		result.append(']');
		return result.toString();
		
	}
	// ---- static
	public static float dot(Vec2f v1, Vec2f v2) {
		return v1.x * v2.x + v1.y * v2.y;
	}

	public static float cross(Vec2f v1, Vec2f v2) {
		return v1.x * v2.y - v1.y * v2.x;
	}


}
