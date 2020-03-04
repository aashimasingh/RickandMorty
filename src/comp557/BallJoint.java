package comp557;

//Name: AASHIMA SINGH
//ID: 260782301

import javax.vecmath.Tuple3d;
import javax.vecmath.Vector3d;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class BallJoint extends DAGNode {
	
	DoubleParameter rposex;
	DoubleParameter rposey;
	DoubleParameter rposez;
	Tuple3d position;
	Tuple3d minlim;
	Tuple3d maxlim;
	
	public BallJoint( String name ) {
		super(name);
		minlim = new Vector3d( -90, -75, -180 );
		maxlim = new Vector3d( 90, 0, 0 );
			dofs.add( rposex = new DoubleParameter(name+" rposex", 0, -90, 90) );
			dofs.add( rposey = new DoubleParameter(name+" rposey", 0, -75, 0) );
			dofs.add( rposez = new DoubleParameter(name+" rposez", 0, -180, 0) );
		position = new Vector3d( 0.0, 0.0, 0.0 );
	} 
	
	public void setPosition ( Tuple3d t ) {
		position.x = t.x;
		position.y = t.y;
		position.z = t.z;
	}
	
	public void setLimits ( Tuple3d t1, Tuple3d t2 ) {
		rposex.setMaximum(t2.x);
		rposex.setMinimum(t1.x);
		rposey.setMaximum(t2.y);
		rposey.setMinimum(t1.y);
		rposez.setMaximum(t2.z);
		rposez.setMinimum(t1.z);
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glPushMatrix();
		gl.glTranslated(position.x, position.y, position.z);
		double rpx = rposex.getValue();
		double rpy = rposey.getValue();
		double rpz = rposez.getValue();
		gl.glRotated(rpy, 0, 1, 0);
		gl.glRotated(rpz, 0, 0, 1);
		gl.glRotated(rpx, 1, 0, 0);
		super.display(drawable);
		gl.glPopMatrix();
	}
}