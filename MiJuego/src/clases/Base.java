package clases;

public class Base {
	protected int x;
	protected int y;

	public Base(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	@Override
	public String toString() {
		return "Base [x=" + x + ", y=" + y + "]";
	}
	
	

}
