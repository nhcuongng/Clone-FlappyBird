//Code By CUONG NGUYEN HUU//

package sound;

import pkg2dgamesframework.SoundPlayer;

import java.io.File;

public class Sound {

    public SoundPlayer flapSound,bupSound, getMoneySound;
    public Sound() {
        this.createSound();
    }

    public void createSound() {
        flapSound = new SoundPlayer(new File("sound/flap.wav"));
        bupSound = new SoundPlayer(new File("sound/bup.wav"));
        getMoneySound = new SoundPlayer(new File("sound/getmoney.wav"));
    }


}
