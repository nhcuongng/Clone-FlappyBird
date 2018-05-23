//Code By CUONG NGUYEN HUU//

package FlappyBird.chimney;

import base.Vector2D;
import constrant.Constrant;
import pkg2dgamesframework.QueueList;
import renderer.loadImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ChimneyGroup {

    public static QueueList<Chimney> chimneys;
    private ChimneyGroupMove chimneyGroupMove;
    private BufferedImage chimneyImageUp, chimneyImageDown;
    private loadImage loadImage;
    public int bottomChimneyY = -350;
    public int topChimneyY = 180;
    private int randomY;
    private int deltaY;


    public int getRandomY(){
        Random random = new Random();
        randomY = random.nextInt(10);
        return randomY*35;
    }

    public Chimney getChimney(int i){
        return chimneys.get(i);
    }


    public ChimneyGroup () {
        this.loadImage = new loadImage();
        this.createChimney();
        this.chimneyGroupMove = new ChimneyGroupMove();
    }

    public void makeChimneyImage(){
        this.chimneyImageUp = this.loadImage.load("Assets/chimney.png");
        this.chimneyImageDown = this.loadImage.load("Assets/chimney_.png");
    }

    public void createChimney() {
        this.makeChimneyImage();
        this.chimneys = new QueueList<>();
        Chimney chimney;
        // Nhét từng cặp ống khói vào chimneys
        for (int i = 0; i < Constrant.SIZE_CHIMNEY_LIST /2; i++){
            deltaY = this.getRandomY();
            chimney = new Chimney(new Vector2D(830 + i *300, topChimneyY + deltaY),74,400);
            chimneys.push(chimney);
            chimney = new Chimney(new Vector2D(830 + i *300, bottomChimneyY + deltaY),74,400);
            chimneys.push(chimney);
        }

    }

    public void update() {
        this.chimneyGroupMove.run(this);
    }

    public void reset(){
        this.createChimney();
    }

    public void paint(Graphics graphics) {
        for (int i = 0; i < 6; i++){
            if (i % 2 == 0){
                graphics.drawImage(chimneyImageUp,(int)chimneys.get(i).getPositionX(),(int) chimneys.get(i).getPositionY(), null);
            } else {
                graphics.drawImage(chimneyImageDown,(int)chimneys.get(i).getPositionX(),(int) chimneys.get(i).getPositionY(), null);
            }

        }
    }
}
