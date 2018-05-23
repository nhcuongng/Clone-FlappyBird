//Code By CUONG NGUYEN HUU//

package FlappyBird.Bird;

import base.Vector2D;
import constrant.Constrant;
import sound.Sound;

public class BirdMove {

    private Vector2D velocity;
    private Vector2D gravity = Constrant.GRAVITY;
    public boolean isFlying = false;
    private Sound sound;

    public BirdMove(){
        this.velocity = new Vector2D();
        this.sound = new Sound();

    }

    public void run(Bird bird){
        this.velocity.addUp(this.gravity);
        bird.position.addUp(this.velocity);
        if (this.velocity.y < 0) {
            isFlying = true;
        } else {
            isFlying = false;
        }
    }

    public void resetVelocity(){
        this.velocity.set(Constrant.VELOCITY_BIRD_START);
    }

    public void fly(Bird bird) {
        this.velocity.set(Constrant.VECLOCITY_WHEN_BIRD_FLY);
        bird.position.subtractBy(this.velocity);
        sound.flapSound.play();
    }

    public boolean getIsFlying() {
        return isFlying;
    }
}
