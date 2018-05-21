package renderer;

import base.Vector2D;

import java.awt.*;

public interface Renderer {
    void paint(Graphics graphics, Vector2D position);
}
