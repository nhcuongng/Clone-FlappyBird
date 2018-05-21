//Code By CUONG NGUYEN HUU//

package FlappyBird.chimney;

import constrant.Constrant;

public class ChimneyGroupMove {


    public ChimneyGroupMove() {

    }

    public void update(ChimneyGroup chimneyGroup) {
        this.runChimney();
        this.repeatChimney(chimneyGroup);
    }

    public void runChimney() {
        for (int i = 0; i < Constrant.SIZE_CHIMNEY_LIST; i++){
            // Cho ống khói di chuyển
            ChimneyGroup.chimneys.get(i).update();
        }
    }

    public void repeatChimney(ChimneyGroup chimneyGroup) {
        if (ChimneyGroup.chimneys.get(0).position.x < -74){ // Nếu ống khói đầu tiên ra khỏi màn hình thì tạo ra cái mới

            int deltaY = chimneyGroup.getRandomY();
            // lấy cái đầu ra và set vị trí +300 so với ống khói cuối cùng
            Chimney chimney;
            chimney = ChimneyGroup.chimneys.pop();
            chimney.position.setX(ChimneyGroup.chimneys.get(4).getPositionX() + 300);
            chimney.position.setY(chimneyGroup.topChimneyY + deltaY);
            chimney.setLive(false);
            ChimneyGroup.chimneys.push(chimney);

            chimney = ChimneyGroup.chimneys.pop();
            chimney.position.setX(ChimneyGroup.chimneys.get(4).getPositionX());
            chimney.position.setY(chimneyGroup.bottomChimneyY + deltaY);
            chimney.setLive(false);
            ChimneyGroup.chimneys.push(chimney);
        }
    }
}
