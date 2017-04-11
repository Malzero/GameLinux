import static org.lwjgl.opengl.GL11.*;

public class Enemy extends AbstractEntity2D{
    private float size;
    private Texture tex;
    public Enemy(float size) {
        this.x = 0;
        this.y = 0;
        this.size = size;
        tex = new Texture("");
    }
    public Enemy() {
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

    @Override
    public void followdraw(AbstractEntity2D folowed) {

        setX(getX() + (folowed.getX() - x));
        setY();

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