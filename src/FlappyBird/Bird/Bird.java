package FlappyBird.Bird;

import base.Vector2D;
import constrant.Constrant;
import physic.BoxCollider;
import base.Objects;
import pkg2dgamesframework.SoundPlayer;
import java.awt.image.BufferedImage;
import java.io.File;

public class Bird extends Objects {

    private Vector2D velocity;
    private Vector2D gravity = Constrant.GRAVITY;
    public SoundPlayer flapSound,bupSound, getMoneySound;
    public static BufferedImage birdImage;

    public Bird() {
        this.birdImage = this.loadImage.load("Assets/bird_sprite.png");
        this.velocity = new Vector2D();
        this.position.set(Constrant.POSITION_BIRD_START);
        this.width = this.height = Constrant.WIDTH_HEIGHT_BIRD;
        this.boxCollider = new BoxCollider(this.width-10,this.height-10);
//        this.createSound();
    }

    public void createSound() {
        flapSound = new SoundPlayer(new File("sound/flap.wav"));
        bupSound = new SoundPlayer(new File("sound/bup.wav"));
        getMoneySound = new SoundPlayer(new File("sound/getmoney.wav"));
    }


    public void resetVelocity(){
        this.velocity.set(Constrant.VELOCITY_BIRD_START);
    }

    public void update(long deltaTime) {
        this.velocity.addUp(this.gravity);
        this.position.addUp(this.velocity);
        // cho boxcllider đi theo flappy bird
        this.boxCollider.position.set(this.position);
        if (this.velocity.y < 0) {
            isFlying = true;
        } else {
            isFlying = false;
        }
    }

    public void fly() {
        this.velocity.set(Constrant.VECLOCITY_WHEN_BIRD_FLY);
        this.position.subtractBy(this.velocity);
//        flapSound.play();
    }

    public boolean getIsFlying() {
        return isFlying;
    }

}
