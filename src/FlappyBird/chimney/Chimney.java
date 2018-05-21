//Code By CUONG NGUYEN HUU//

package FlappyBird.chimney;

import base.Vector2D;
import physic.BoxCollider;
import base.Objects;

public class Chimney extends Objects {
    // Kiểm tra xem chim qua ống khói chưa, mặc định chưa qua
    public Chimney(Vector2D position, int width, int height){
        super(position,width,height);
        this.boxCollider = new BoxCollider(this.width,this.height);
        this.isLive = false;
    }

    public void update() {
        this.position.setX(this.getPositionX() - 2);
        this.boxCollider.position.set(this.position);
    }

}
