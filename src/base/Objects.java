
package base;


import base.Vector2D;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.loadImage;

public class Objects implements HitObject, PhysicBody {

    public loadImage loadImage;
    public Vector2D position;
    public int width, height;
    public boolean isFlying = false;
    public boolean isLive = true;
    public BoxCollider boxCollider;
    
    public Objects(){
         this.position = new Vector2D();
         this.loadImage = new loadImage();
    }
    public Objects(Vector2D position, int width, int height){
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public void update(){

    }

    public void paint(long delta) {

    }

    public float getPositionX(){
        return this.position.x;
    }
    public float getPositionY(){
        return this.position.y;
    }
    public float getW(){
        return width;
    }
    public float getH(){
        return height;
    }

    @Override
    public void setLive(boolean isLive){
        this.isLive = isLive;
    }

    @Override
    public boolean getLive(){
        return isLive;
    }

    @Override
    public BoxCollider getBoxcollider() {
        return this.boxCollider;
    }
}
