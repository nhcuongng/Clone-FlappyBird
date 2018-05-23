//Code By CUONG NGUYEN HUU//

package FlappyBird.background;

import base.Vector2D;

public class GroundMove {

    public GroundMove(Ground ground) {
        ground.position.set(0,500);
        // position cập nhật khi position phía trước ra khỏi màn hình
        ground.positionUpdate = new Vector2D((int) ground.getPositionX() + 830, (int) ground.position.y);
    }

    public void run(Ground ground) {
        // Caapj nhật tốc độ
        ground.position.addUp(-2f,0f);
        ground.positionUpdate.addUp(-2f,0f);
        this.checkPosition(ground);
    }

    public void checkPosition(Ground ground){
        if (ground.position.x < 0) {
            ground.positionUpdate.x = ground.position.x + 830;
        }
        if (ground.positionUpdate.x < 0) {
            ground.position.x = ground.positionUpdate.x + 830;
        }
    }

}
