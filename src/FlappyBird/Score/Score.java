//Code By CUONG NGUYEN HUU//

package FlappyBird.Score;

import FlappyBird.Bird.Bird;
import FlappyBird.chimney.ChimneyGroup;
import constrant.Constrant;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private int point = 0;
    private List<Integer> points;

    public Score() {
        this.points = new ArrayList<>();
    }

    public int getPoint() {
        return this.point;
    }

    public void increasePoint(Bird bird, ChimneyGroup chimneyGroup) {
        // Tính điểm
        for (int i = 0; i < Constrant.SIZE_CHIMNEY_LIST; i++){
            if (bird.getPositionX() > chimneyGroup.getChimney(i).getPositionX() && !chimneyGroup.getChimney(i).getLive() && i%2 == 0){
                this.point ++;
//                    this.bird.getMoneySound.play();
                chimneyGroup.getChimney(i).setLive(true);
            }
        }
        this.points.add(this.point);
    }

    public int checkHightScore(){
        if (this.points.isEmpty()){
            return this.point = 0;
        }else{
            int max = 0;
            for (int i = 0; i < this.points.size(); i++){
                if (max < this.points.get(i)){
                    max = this.point;
                }
            }
            return max;
        }
    }

    public void reset(){
        this.point = 0;
    }
}
