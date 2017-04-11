import static org.lwjgl.opengl.GL11.*;

public class Box2D extends AbstractEntity2D{
    private float size;
    private Texture tex;
    public Box2D(float x, float y, float size, String filename) {
        this.x = x;
        this.y = y;
        this.size = size;
        tex = new Texture(filename);
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
        tex.bind();
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex2f(x - size/2, y + size/2);
        glTexCoord2f(1,0);
        glVertex2f(x + size/2, y + size/2);
        glTexCoord2f(1,1);
        glVertex2f(x + size/2, y - size/2);
        glTexCoord2f(0,1);
        glVertex2f(x - size/2, y - size/2);
        glEnd();
    }
}