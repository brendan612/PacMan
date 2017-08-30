package pacman.entities.edibles;

import java.awt.Point;
import pacman.entities.Entity;
import pacman.graphics.GraphicsLoop;

public abstract class Eatable extends Entity {
	int pointsWorth;

	public Eatable(GraphicsLoop gl, Point p, int pointsWorth){
		super(gl, p);
		this.pointsWorth = pointsWorth;
	}

	public int getPointsWorth() {
		return pointsWorth;
	}

	public void setPointsWorth(int pointsWorth) {
		this.pointsWorth = pointsWorth;
	}
	
	public abstract int getEaten();
}
