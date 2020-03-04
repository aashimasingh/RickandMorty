package comp557;

//AASHIMA SINGH
//260782301

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class FreeJoint extends DAGNode {

	DoubleParameter tx;
	DoubleParameter ty;
	DoubleParameter tz;
	DoubleParameter rx;
	DoubleParameter ry;
	DoubleParameter rz;
		
	public FreeJoint( String name ) {
		super(name);
		dofs.add( tx = new DoubleParameter( name+" tx", 0, -4, 4 ) );		
		dofs.add( ty = new DoubleParameter( name+" ty", 0, -4, 4 ) );
		dofs.add( tz = new DoubleParameter( name+" tz", 0, -4, 4 ) );
		dofs.add( rx = new DoubleParameter( name+" rx", 0, -180, 180 ) );		
		dofs.add( ry = new DoubleParameter( name+" ry", 0, -180, 180 ) );
		dofs.add( rz = new DoubleParameter( name+" rz", 0, -180, 180 ) );
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();

		// TODO: Objective 1: implement the FreeJoint display method
		gl.glPushMatrix();
		double transx = tx.getValue();
		double transy = ty.getValue();
		double transz = tz.getValue();
		double roty   = ry.getValue();
		gl.glTranslated(transx, transy, transz);
		gl.glRotated(roty, 0, 1, 0);
		super.display(drawable);
		gl.glPopMatrix();
	}

	
}
