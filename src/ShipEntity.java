
public class ShipEntity extends Entity {

	public ShipEntity(Game game, String string, int x, int y) {
		super(x, y);
	}
	public void move(long delta) {
		if ((vx < 0) && (x < 10)) {
			return;
		}
		if ((vx > 0) && (x > 750)) {
			return;
		}
		super.move(delta);
	}

	public void collidedWith(Entity other) {

		
	}
}
