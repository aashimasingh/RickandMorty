package comp557;

//AASHIMA SINGH
//260782301

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

//import mintools.parameters.DoubleParameter;

public class BodyRect extends DAGNode{
	
	public BodyRect (String name) {
		super(name);
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glPushMatrix();
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3d(0.0, 1.0, 0.0);
		gl.glVertex3f(-0.7f, 3.0f, 1.0f);
		gl.glColor3d(0.0, 0.0, 1.0);
		gl.glVertex3f(0.7f, 3.0f, 1.0f);
		gl.glColor3d(0.0, 1.0, 0.0);
		gl.glVertex3f(0.7f, -1.0f, 1.0f);
		gl.glColor3d(1.0, 0.0, 0.0);
		gl.glVertex3f(-0.7f, -1.0f, 1.0f);
		gl.glEnd();
		super.display(drawable);
		gl.glPopMatrix();
	}
}