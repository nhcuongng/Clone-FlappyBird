
import FlappyBird.Bird.Bird;
import FlappyBird.Bird.BirdAnimation;
import FlappyBird.Score.Score;
import FlappyBird.background.Ground;
import FlappyBird.chimney.ChimneyGroup;
import constrant.Constrant;
import pkg2dgamesframework.GameScreen;
import sound.Sound;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static FlappyBird.Bird.BirdAnimation.bird_anim;


public class GameWindow extends GameScreen {

    private Bird bird; // Chim
    private Ground ground; // nền Đất
    private ChimneyGroup chimneyGroup; // ống khói
    private int beginScene = 0; // Biến quản lý màn hình
    private int gamePlayScene = 1;
    private int gameoverScene = 2;
    private int currentScene = this.beginScene;
    private BirdAnimation birdAnimation;
    private Score score;
    private Sound sound;


    public GameWindow() {
        super(Constrant.WINDOW_WIDTH, Constrant.WINDOW_HEIGHT);
        // khởi tạo chim
        this.birdAnimation = new BirdAnimation();
        this.bird = new Bird();
        this.ground = new Ground();
        this.chimneyGroup = new ChimneyGroup();
        this.score = new Score();
        this.sound = new Sound();
        this.windowEvent();
        BeginGame();
    }

    // reset game khi game kết thúc, đặt chim về vị trí và vận tốc ban đầu
    private void reset() {
        this.bird.position.set(Constrant.POSITION_BIRD_START);
        this.bird.birdMove.resetVelocity();
        this.bird.setLive(true);
        this.score.reset();
        this.chimneyGroup.reset();
    }

    @Override
    public void GAME_UPDATE(long deltaTime) {

        if (this.currentScene == beginScene) {
            this.reset();
        }else if(this.currentScene == this.gamePlayScene) {
            if (bird.getLive()) { bird_anim.Update_Me(deltaTime);}
            this.bird.run(deltaTime);
            this.ground.run();
            this.chimneyGroup.update();
            for (int i = 0; i < Constrant.SIZE_CHIMNEY_LIST; i++){
                if (this.bird.getBoxcollider().checkCollider(this.chimneyGroup.getChimney(i).getBoxcollider())){
                    if (bird.getLive() == true){
                        sound.bupSound.play();
                    }
                    this.bird.setLive(false);
                }
            }
//                 kiểm tra va chạm với đất
            if (this.bird.position.y + this.bird.getH() > this.ground.getYGround()) {
                this.currentScene = this.gameoverScene;
            }
            this.score.increasePoint(this.bird, this.chimneyGroup);
        }
    }


    @Override
    public void GAME_PAINT(Graphics2D g2) {
        g2.setColor(Color.decode("#b8daef"));
        g2.fillRect(0,0,MASTER_WIDTH,MASTER_HEIGHT);
        this.chimneyGroup.paint(g2);
        this.ground.render(g2);
        if (bird.birdMove.getIsFlying())
            bird_anim.PaintAnims((int) bird.getPositionX(), (int) bird.getPositionY(), Bird.birdImage, g2, 0, -1);
        else {
            bird_anim.PaintAnims((int) bird.getPositionX(), (int) bird.getPositionY(), Bird.birdImage, g2, 0, 0);
        }
        if (this.currentScene == this.beginScene) {
            g2.setColor(Color.red);
            g2.drawString("Press space to play game", 200, 300);
        }
        if (this.currentScene == this.gameoverScene) {
            g2.setColor(Color.red);
            g2.drawString("Press space to turn back begin scene \n Hight Score: " + this.score.checkHightScore(), 200, 300);
        }
        g2.setColor(Color.red);
        g2.drawString("Points: " + this.score.getPoint(),20,50);
    }

    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {
        if (Event == KEY_PRESSED) {
            if (this.currentScene == this.beginScene){
                this.currentScene = this.gamePlayScene;
            }else if (this.currentScene == this.gamePlayScene) {
               if (this.bird.getLive()) bird.birdMove.fly(this.bird);
            }else if (this.currentScene == this.gameoverScene){
                this.currentScene = this.beginScene;
            }

        }
    }

    public void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

}
