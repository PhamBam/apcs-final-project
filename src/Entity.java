import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	protected double x;
	protected double y;
	protected double vx;
	protected double vy;
	protected Sprite sprite;
	private Rectangle player = new Rectangle();
	private Rectangle enemy = new Rectangle();

	public Entity(String ref,int x,int y) {
		this.sprite = SpriteStore.get().getSprite(ref); //Image
		this.x = x;
		this.y = y;
	}
	public Entity(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void move(long ms){
		x += (ms * vy)/1000;
		y += (ms * vx)/1000;
	}
	public void setHorizontalMovement(double dx) {
		this.vx = dx;
	}
	public void setVerticalMovement(double dy) {
		this.vy = dy;
	}
	public double getHorizontalMovement() {
		return vx;
	}
	public double getVerticalMovement() {
		return vy;
	}
	public void draw(Graphics g) {
		sprite.draw(g,(int) x,(int) y);
	}
	public void doLogic() {
	}
	public int getX() {
		return (int) x;
	}
	public int getY() {
		return (int) y;
	}
	
	public boolean collidesWith(Entity other) {
		player.setBounds((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
		enemy.setBounds((int) other.x,(int) other.y,other.sprite.getWidth(),other.sprite.getHeight());

		return player.intersects(enemy);
	}
	public abstract void collidedWith(Entity other);
	
}

