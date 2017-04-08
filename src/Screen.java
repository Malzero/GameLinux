import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Screen {

    private Screen()
    {
        if (!glfwInit())
            throw new IllegalStateException("Failed to initialize GLFW");

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        long window = glfwCreateWindow(640, 480,"Ventana QLa", 0,0);
        if (window == 0)
            throw new IllegalStateException("Failed to create window");

        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window, (videoMode.width() + 640)/4, (videoMode.height() + 480)/4);

        glfwShowWindow(window);
 
        glfwMakeContextCurrent(window);

        GL.createCapabilities();

        glEnable(GL_TEXTURE_2D);

        Texture tex = new Texture("/root/Documentos/GameLinux/rsrc/sprites/teoql2.png");
        float x;
        float y;
        Entity2D box = new Box2D(0.2f, 0.2f,0.2f);
        box.setUp();


        while (!glfwWindowShouldClose(window))
        {
            x = 0;
            y = 0;

            glfwPollEvents();
            if (glfwGetKey(window, GLFW_KEY_A) == GL_TRUE)
                x = -0.01f;

            if (glfwGetKey(window, GLFW_KEY_D) == GL_TRUE)
                x = 0.01f;

            if (glfwGetKey(window, GLFW_KEY_W) == GL_TRUE)
                y = 0.01f;

            if (glfwGetKey(window, GLFW_KEY_S) == GL_TRUE)
                y = -0.01f;


            if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GL_TRUE)
                glfwSetWindowShouldClose(window, true);

            glClear(GL_COLOR_BUFFER_BIT);


            if (x <= videoMode.width() && y <= videoMode.height())
            {
                tex.bind();
                    box.setX(box.getX() + x);
                    box.setY(box.getY() + y);
                    box.draw();
                glEnd();
                glfwSwapBuffers(window);
            }

        }
        box.destroy();
        glfwTerminate();

    }

    public static void main(String[] args)
    {
        Screen pantalla = new Screen();


    }




}