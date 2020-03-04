package comp557;

// Name: AASHIMA SINGH
//ID: 260782301

import javax.vecmath.Tuple3d;
import javax.vecmath.Vector3d;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class HingeJoint extends DAGNode {
	
	DoubleParameter rhinge;
	Tuple3d position;
	Tuple3d axis;
	
	public HingeJoint( String name ) {
		super(name);
		dofs.add( rhinge = new DoubleParameter( name+" rhinge", 0, -90, 90 ) );
		
		position = new Vector3d(0.0, 0.0, 0.0);
		axis = new Vector3d(1.0, 0.0, 0.0);
	}
	
	public void setPosition( Tuple3d t ) {
		position.x = t.x;
		position.y = t.y;
		position.z = t.z;
	}
	
	public void setAxis( Tuple3d t ) {
		axis.x = t.x;
		axis.y = t.y;
		axis.z = t.z;
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glPushMatrix();
		gl.glTranslated(position.x, position.y, position.z);
		double rh    = rhinge.getValue();
		gl.glRotated(rh, axis.x, axis.y, axis.z);
		super.display(drawable);
		gl.glPopMatrix();
	}
}