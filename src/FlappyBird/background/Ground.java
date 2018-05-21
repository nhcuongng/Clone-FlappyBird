package FlappyBird.background;

import base.Vector2D;
import base.Objects;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ground extends Objects {

    private BufferedImage goundImage;
    public Vector2D positionUpdate;
    private GroundMove groundMove;

    public int getYGround() {
        return (int)this.position.y;
    }

    public Ground() {
       this.goundImage = this.loadImage.load("Assets/ground.png");
       this.groundMove = new GroundMove(this);
    }

    public void update() {
        this.groundMove.update(this);
    }

    public void  paint(Graphics graphics) {
       graphics.drawImage(this.goundImage,(int) this.position.x, (int) this.position.y,null);
       graphics.drawImage(this.goundImage,(int) this.positionUpdate.x, (int) this.positionUpdate.y,null);
    }
}
