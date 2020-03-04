package comp557;

//AASHIMA SINGH
//260782301

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class BodyLine extends DAGNode{
	
	
	public BodyLine (String name) {
		super(name);

	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glPushMatrix();
		gl.glBegin(GL2.GL_LINES);
		gl.glColor3d(0.0, 0.0, 0.0);
		gl.glVertex3f(-0.3f, 0.3f, 1.7f);
		gl.glColor3d(0.0,  0.0,  0.0);
		gl.glVertex3f(0.3f, 0.3f, 1.7f);

		gl.glEnd();
		super.display(drawable);
		gl.glPopMatrix();
	}
}