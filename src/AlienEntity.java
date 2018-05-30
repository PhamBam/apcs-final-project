
public class AlienEntity extends Entity {

	private double moveSpeed = 75;
	private Game game;
	
	public AlienEntity(Game game,String ref,int x,int y) {
		super(x,y);
		
		this.game = game;
		vx = -moveSpeed;
	}
	public void move(long delta) {
		if ((vx < 0) && (x < 10)) {
			game.updateLogic();
		}
		if ((vx > 0) && (x > 750)) {
			game.updateLogic();
		}
		super.move(delta);
	}
	
	public void doLogic() {
		vx = -vx;
		y += 10;
		
		if (y > 570) {
			game.notifyDeath();
		}
	}
	
	public void collidedWith(Entity other) {
	}
}

