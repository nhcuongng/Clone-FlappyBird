//Code By CUONG NGUYEN HUU//

package FlappyBird.Bird;

import pkg2dgamesframework.AFrameOnImage;
import pkg2dgamesframework.Animation;

public class BirdAnimation {
    public static Animation bird_anim;

    public BirdAnimation () {
        this.bird_anim = new Animation(100); // Thời gian một bức hình tồn tại
        AFrameOnImage f;
        // lấy từng khung hình  add vào mảng
        f = new AFrameOnImage(0, 0, 60, 60);
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(60, 0, 60, 60);
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(120, 0, 60, 60);
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(60, 0, 60, 60);
        bird_anim.AddFrame(f);
    }
}
