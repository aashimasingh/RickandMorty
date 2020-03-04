package comp557;

import javax.vecmath.Tuple3d;
import javax.vecmath.Vector3d;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

//import mintools.parameters.DoubleParameter;

public class BodyBox extends DAGNode{
	
	int size;
	Tuple3d center;
	Tuple3d scale;
	Tuple3d color;
	
	public BodyBox (String name) {
		super(name);
		size = 2;
		center = new Vector3d(0.0, 0.0, 0.0);
		scale = new Vector3d(1.0, 1.0, 1.0);
		color = new Vector3d(1.0, 0.0, 0.0);
	}
	
	public void setCentre( Tuple3d t ) {
		center.x = t.x;
		center.y = t.y;
		center.z = t.z;
	}
	
	public void setScale( Tuple3d t ) {
		scale.x = t.x;
		scale.y = t.y;
		scale.z = t.z;
	}
	
	public void setColor( Tuple3d t ) {
		color.x = t.x;
		color.y = t.y;
		color.z = t.z;
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glPushMatrix();
		gl.glTranslated(center.x, center.y, center.z);
		gl.glScaled(scale.x, scale.y, scale.z);
		gl.glColor3d(color.x, color.y, color.z);
		DAGNode.glut.glutSolidCube(size);
		super.display(drawable);
		gl.glPopMatrix();
	}
}