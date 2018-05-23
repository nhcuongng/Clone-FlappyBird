package FlappyBird.Bird;

import base.Vector2D;
import constrant.Constrant;
import physic.BoxCollider;
import base.Objects;
import pkg2dgamesframework.SoundPlayer;
import java.awt.image.BufferedImage;
import java.io.File;

public class Bird extends Objects {

    public static BufferedImage birdImage;
    public BirdMove birdMove;

    public Bird() {
        this.birdImage = this.loadImage.load("Assets/bird_sprite.png");
        this.position.set(Constrant.POSITION_BIRD_START);
        this.width = this.height = Constrant.WIDTH_HEIGHT_BIRD;
        this.boxCollider = new BoxCollider(this.width-40,this.height-40);
        this.birdMove = new BirdMove();
    }

    public void run(long deltaTime) {
        this.birdMove.run(this);
        // cho boxcllider đi theo flappy bird
        this.boxCollider.position.set(this.position);

    }
}
