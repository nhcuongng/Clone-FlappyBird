//Code By CUONG NGUYEN HUU//

package constrant;

import base.Vector2D;

public class Constrant {

    // GameWindow
    public static int WINDOW_WIDTH = 830;
    public static int WINDOW_HEIGHT = 600;
    public static Vector2D POSITION_BIRD_START = new Vector2D(350,200);

    // Bird
    public static Vector2D GRAVITY = new Vector2D(0f,0.15f);
    public static int WIDTH_HEIGHT_BIRD = 50;
    public static Vector2D VELOCITY_BIRD_START = new Vector2D(0f ,0f);
    public static Vector2D VECLOCITY_WHEN_BIRD_FLY = new Vector2D(0f, -3f);

    // Chimney
    public static int SIZE_CHIMNEY_LIST = 6;
}
