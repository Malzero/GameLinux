import static org.lwjgl.opengl.GL11.*;

public class Box2D extends AbstractEntity2D {
    protected float size;
    public Box2D(float x, float y, float size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
    public Box2D() {
        this.x = this.y = this.size = 0;
    }
    @Override
    public void setUp() {
        // We don't need anything here for a box
    }
    @Override
    public void destroy() {
        // We don't need anything here for a box
    }
    @Override
    public void draw() {
        glBegin(GL_TRIANGLES);
        glVertex2f(x + size/2, y + size/2);
        glVertex2f(x + size/2, y - size/2);
        glVertex2f(x - size/2, y - size/2);
        glVertex2f(x - size/2, y - size/2);
        glVertex2f(x - size/2, y + size/2);
        glVertex2f(x + size/2, y + size/2);
        glEnd();
    }
}