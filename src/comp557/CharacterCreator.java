package comp557;

// Name: AASHIMA SINGH
// ID: 260782301

import javax.swing.JTextField;
import javax.vecmath.Tuple3d;
import javax.vecmath.Vector3d;

import comp557.a1.DAGNode;
import comp557.a1.Parser;
import mintools.parameters.BooleanParameter;

public class CharacterCreator {

	static public String name = "Rick - Aashima Singh AND 260782301";
	
	// TODO: Objective 6: change default of load from file to true once you start working with xml
	static BooleanParameter loadFromFile = new BooleanParameter( "Load from file (otherwise by procedure)", false );
	static JTextField baseFileName = new JTextField("a1data/character");
	static { baseFileName.setName("what is this?"); }
	
	/**
	 * Creates a character, either procedurally, or by loading from an xml file
	 * @return root node
	 */
	static public DAGNode create() {
		
		if ( loadFromFile.getValue() ) {
			// TODO: Objectives 6: create your character in the character.xml file 
			return Parser.load( baseFileName.getText() + ".xml");
		} else {
			// TODO: Objective 1,2,3,4: test DAG nodes by creating a small DAG in the CharacterCreator.create() method 
			FreeJoint root = new FreeJoint("root");
			
			Tuple3d t = new Vector3d();
			Tuple3d t3 = new Vector3d(-45, -45, -45);
			Tuple3d t4 = new Vector3d(90, 45, 45);
			
			BallJoint spine = new BallJoint("spine");
			t.set(0, 0, 0);
			spine.setPosition(t);
			spine.setLimits(t3, t4);
			root.add(spine);
			
			BodyBox torso = new BodyBox("torso");
			t.set(0.0, 1.0, 0.0);
			torso.setCentre(t);
			t.set(1.5, 2.0, 1.0);
			torso.setScale(t);
			t.set(0.8, 0.9, 1.0);
			torso.setColor(t);
			//root.add(torso);
			spine.add(torso);
			
			BodyRect coat = new BodyRect("coat");
			//root.add(coat);
			spine.add(coat);
			
			BodyBox hip = new BodyBox("hip");
			t.set(0.0, -1.5, 0.0);
			hip.setCentre(t);
			t.set(1.5, 0.5, 1.0);
			hip.setScale(t);
			t.set(0.4, 0.2, 0.0);
			hip.setColor(t);
			root.add(hip);
			
			//////////////////////////////
			
			HingeJoint neck = new HingeJoint("neck");
			t.set(0.0, 3.5, 0.0);
			neck.setPosition(t);
			
			BodyBox neckhinge = new BodyBox("neckhinge");
			t.set(neck.position.x, neck.position.y - neck.position.y, neck.position.z);
			neckhinge.setCentre(t);
			t.set(0.5,0.5,0.5);
			neckhinge.setScale(t);
			t.set(0.9, 0.7, 0.6);
			neckhinge.setColor(t);
			neck.add(neckhinge);
			
			BodySphere head = new BodySphere("head");
			t.set(neck.position.x, neck.position.y - 2, neck.position.z);
			head.setCentre(t);
			//t.set(1.5, 1.0, 1.0);
			t.set(0.8, 1.0, 1.0);
			head.setScale(t);
			t.set(0.9, 0.7, 0.6);
			head.setColor(t);
			neck.add(head);
			
			BodyLine line = new BodyLine("lips");
			neck.add(line);
			
			BodyCone hair1 = new BodyCone("hair");
			BodyCone hair2 = new BodyCone("hair2");
			BodyCone hair3 = new BodyCone("hair3");
			BodyCone hair4 = new BodyCone("hair4");
			BodyCone hair5 = new BodyCone("hair5");
			BodyCone hair6 = new BodyCone("hair6");
			BodyCone hair7 = new BodyCone("hair7");
			BodyCone hair8 = new BodyCone("hair8");
			t.set(-0.4, 3.1, 0.3);
			hair1.setCentre(t);
			hair1.setRotation(30.0);

			t.set(0.4, 3.1, 0.3);
			hair2.setCentre(t);
			hair2.setRotation(-30.0);

			t.set(-1.0, 2.5, 0.3);
			hair3.setCentre(t);
			hair3.setRotation(45.0);
			t.set(0.8, 0.8, 0.8);
			hair3.setScale(t);

			t.set(1.0, 2.5, 0.3);
			hair4.setCentre(t);
			hair4.setRotation(-45.0);
			t.set(0.8, 0.8, 0.8);
			hair4.setScale(t);

			t.set(-1.3, 2.0, 0.3);
			hair5.setCentre(t);
			hair5.setRotation(90.0);
			t.set(0.6, 0.6, 0.6);
			hair5.setScale(t);

			t.set(1.3, 2.0, 0.3);
			hair6.setCentre(t);
			hair6.setRotation(-90.0);
			t.set(0.6, 0.6, 0.6);
			hair6.setScale(t);
			
			t.set(-1.2, 1.0, 0.2);
			hair7.setCentre(t);
			hair7.setRotation(135.0);
			t.set(0.5, 0.5, 0.5);
			hair7.setScale(t);
			
			t.set(1.2, 1.0, 0.2);
			hair8.setCentre(t);
			hair8.setRotation(-135.0);
			t.set(0.5, 0.5, 0.5);
			hair8.setScale(t);
			
			t.set(0.3, 0.8, 1.0);
			hair1.setColor(t); hair2.setColor(t); hair3.setColor(t); hair4.setColor(t); hair5.setColor(t); hair6.setColor(t); hair7.setColor(t); hair8.setColor(t);
			neck.add(hair1);
			neck.add(hair2);
			neck.add(hair3);
			neck.add(hair4);
			neck.add(hair5);
			neck.add(hair6);
			neck.add(hair7);
			neck.add(hair8);
			
			BodySphere eyel = new BodySphere("eyel");
			t.set(-0.4, 1.5, 1.5);
			eyel.setCentre(t);
			t.set(0.3, 0.3, 0.3);
			eyel.setScale(t);
			t.set(1.0, 1.0, 1.0);
			eyel.setColor(t);
			neck.add(eyel);
			
			BodySphere eyer = new BodySphere("eyer");
			t.set(0.4, 1.5, 1.5);
			eyer.setCentre(t);
			t.set(0.3, 0.3, 0.3);
			eyer.setScale(t);
			t.set(1.0, 1.0, 1.0);
			eyer.setColor(t);
			neck.add(eyer);
			
			BodySphere earl = new BodySphere("earl");
			BodySphere earr = new BodySphere("earr");
			t.set(-1.2, 1.3, 0.2);
			earl.setCentre(t);
			t.set(1.2, 1.3, 0.2);
			earr.setCentre(t);
			t.set(0.3, 0.3, 0.2);
			earl.setScale(t);
			earr.setScale(t);
			t.set(0.9, 0.7, 0.6);
			earl.setColor(t);
			earr.setColor(t);
			neck.add(earl);
			neck.add(earr);
			
			BodySphere eyeball1 = new BodySphere("eyeball1");
			BodySphere eyeball2 = new BodySphere("eyeball2");
			t.set(-0.4, 1.5, 2.0);
			eyeball1.setCentre(t);
			t.set(0.4, 1.5, 2.0);
			eyeball2.setCentre(t);
			t.set(0.08, 0.08, 0.08);
			eyeball1.setScale(t);
			eyeball2.setScale(t);
			t.set(0.0, 0.0, 0.0);
			eyeball1.setColor(t);
			eyeball2.setColor(t);
			neck.add(eyeball1);
			neck.add(eyeball2);
			
			BodySphere eyebrow = new BodySphere("eyebrow");
			t.set(0.0, 2.0, 1.8);
			eyebrow.setCentre(t);
			t.set(0.6, 0.08, 0.08);
			eyebrow.setScale(t);
			t.set(0.3, 0.8, 1.0);
			eyebrow.setColor(t);
			neck.add(eyebrow);
			
			BodyCone nose = new BodyCone("nose");
			t.set(0.9, 0.7, 0.6);
			nose.setColor(t);
			t.set(0.0, 0.7, 1.8);
			nose.setCentre(t);
			t.set(0.3, 0.8, 0.5);
			nose.setScale(t);
			neck.add(nose);

			
			///////////////////////////////
			
			BallJoint shoulder1 = new BallJoint("shoulder1");
			t.set(-1.7, 3.0, 0.0);
			shoulder1.setPosition(t);
			
			BodySphere shoulderl = new BodySphere("shoulderl");
			//t.set(0.0, -1.0, 0.0);
			t.set(0.2, -0.5, 0.0);
			shoulderl.setCentre(t);
			//t.set(0.5, 1.0, 0.5);
			t.set(0.3, 0.3, 0.3);
			shoulderl.setScale(t);
			t.set(1.0, 1.0, 1.0);
			shoulderl.setColor(t);
			shoulder1.add(shoulderl);
			
			BodyCylinder arml = new BodyCylinder("arml");
			t.set(0.1, -2.1, 0.0);
			arml.setCentre(t);
			t.set(0.5, 0.8, 0.7);
			arml.setScale(t);
			t.set(1.0, 1.0, 1.0);
			arml.setColor(t);
			shoulder1.add(arml);
			
			BallJoint shoulder2 = new BallJoint("shoulder2");
			//t.set(2.0, 3.0, 0.0);
			t.set(1.7, 3.0, 0.0);
			shoulder2.setPosition(t);
			Tuple3d t1 = new Vector3d( -90, 0, 0 );
			Tuple3d t2 = new Vector3d( 90, 75, 180 );
			shoulder2.setLimits(t1, t2);
			
			BodySphere shoulderr = new BodySphere("shoulderr");
			t.set(-0.2, -0.5, 0.0);
			shoulderr.setCentre(t);
			t.set(0.3, 0.3, 0.3);
			shoulderr.setScale(t);
			t.set(1.0, 1.0, 1.0);
			shoulderr.setColor(t);
			shoulder2.add(shoulderr);
			
			BodyCylinder armr = new BodyCylinder("armr");
			t.set(-0.1, -2.1, 0.0);
			armr.setCentre(t);
			t.set(0.5, 0.8, 0.7);
			armr.setScale(t);
			t.set(1.0, 1.0, 1.0);
			armr.setColor(t);
			shoulder2.add(armr);
			
			HingeJoint elbowleft = new HingeJoint("elbowleft");
			HingeJoint elbowright = new HingeJoint("elbowright");
			BodySphere elbowballl = new BodySphere("elbowballl");
			BodySphere elbowballr = new BodySphere("elbowballr");
			BodyCylinder elbowl = new BodyCylinder("elbowl");
			BodyCylinder elbowr = new BodyCylinder("elbowr");
			t.set(0.0, -2.5, 0.0);
			elbowleft.setPosition(t);
			elbowright.setPosition(t);
			t.set(0.0, 0.0, 0.0);
			elbowballl.setCentre(t);
			elbowballr.setCentre(t);
			t.set(0.3, 0.3, 0.3);
			elbowballl.setScale(t); elbowballr.setScale(t);
			t.set(1.0, 1.0, 1.0);
			elbowballl.setColor(t); elbowballr.setColor(t); elbowl.setColor(t); elbowr.setColor(t);
			t.set(0, 0, 1);
			elbowleft.setAxis(t);
			elbowright.setAxis(t);
			t.set(0.0, -1.8, 0.0);
			elbowl.setCentre(t);
			elbowr.setCentre(t);
			t.set(0.4, 1.0, 0.7);
			elbowl.setScale(t);
			elbowr.setScale(t);
			shoulder1.add(elbowleft);
			shoulder2.add(elbowright);
			elbowleft.add(elbowballl);
			elbowright.add(elbowballr);
			elbowleft.add(elbowl);
			elbowright.add(elbowr);
			
			HingeJoint handleft = new HingeJoint("handleft");
			HingeJoint handright = new HingeJoint("handright");
			t.set(0.0, -2.0, 0.0);
			handleft.setPosition(t);
			handright.setPosition(t);
			t.set(0, 0, 1);
			handleft.setAxis(t);
			handright.setAxis(t);
			
			BodySphere handl = new BodySphere("handl");
			BodySphere handr = new BodySphere("handr");
			t.set(0.0, 0.0, 0.0);
			handl.setCentre(t);
			handr.setCentre(t);
			t.set(0.2, 0.4, 0.3);
			handl.setScale(t);
			handr.setScale(t);
			t.set(0.9, 0.7, 0.6);
			handl.setColor(t);
			handr.setColor(t);
			handleft.add(handl);
			handright.add(handr);
			elbowleft.add(handleft);
			elbowright.add(handright);
			
			/////////////////////////

			BallJoint leg1 = new BallJoint("leg1");
			t.set(-1.0, -1.0, 0.0);
			leg1.setPosition(t);
			t1.set(-90, -45, -45);
			t2.set(90, 0, 0);
			leg1.setLimits(t1, t2);
			
			BallJoint leg2 = new BallJoint("leg2");
			t.set(1.0, -1.0, 0.0);
			leg2.setPosition(t);
			t1.set(-90, 0, 0);
			t2.set(90, 45, 45);
			leg2.setLimits(t1, t2);
			
			BodyBox legl = new BodyBox("legl");
			BodyBox legr = new BodyBox("legr");
			t.set(0.0, -2.0, 0.0);
			legl.setCentre(t);
			legr.setCentre(t);
			t.set(0.5, 1.0, 0.8);
			legl.setScale(t);
			legr.setScale(t);
			t.set(0.4, 0.2, 0.0);
			legl.setColor(t);
			legr.setColor(t);
			leg1.add(legl);
			leg2.add(legr);
			
			BodySphere kneeballl = new BodySphere("kneeballl");
			BodySphere kneeballr = new BodySphere("kneeballr");
			kneeballl.setColor(t);
			kneeballr.setColor(t);
			t.set(0.0, -3.0, 0.0);
			kneeballl.setCentre(t);
			kneeballr.setCentre(t);
			t.set(0.3, 0.4, 0.5);
			kneeballl.setScale(t);
			kneeballr.setScale(t);
			leg1.add(kneeballl);
			leg2.add(kneeballr);
			
			//////////////////
			
			HingeJoint knee1 = new HingeJoint("knee1");
			HingeJoint knee2 = new HingeJoint("knee2");
			t.set(0.0, -3.5, 0.0);
			knee1.setPosition(t);
			knee2.setPosition(t);
			t.set(1, 0, 0);
			knee1.setAxis(t);
			knee2.setAxis(t);
			
			BodyBox kneel = new BodyBox("kneel");
			BodyBox kneer = new BodyBox("kneer");
			t.set(0.0, -0.4, 0.0);
			kneel.setCentre(t);
			kneer.setCentre(t);
			t.set(0.5, 1.0, 0.8);
			kneel.setScale(t);
			kneer.setScale(t);
			t.set(0.4, 0.2, 0.0);
			kneel.setColor(t);
			kneer.setColor(t);
			knee1.add(kneel);
			knee2.add(kneer);
			
			HingeJoint feet1 = new HingeJoint("feet1");
			HingeJoint feet2 = new HingeJoint("feet2");
			t.set(0.0, -1.5, 0.0);
			feet1.setPosition(t);
			feet2.setPosition(t);
			t.set(1, 0, 0);
			feet1.setAxis(t);
			feet2.setAxis(t);
			BodySphere feetl = new BodySphere("feetl");
			BodySphere feetr = new BodySphere("feetr");
			t.set(0.0, 0.0, 0.1);
			feetl.setCentre(t);
			feetr.setCentre(t);
			t.set(0.5, 0.3, 0.6);
			feetl.setScale(t);
			feetr.setScale(t);
			t.set(0.3, 0.0, 0.3);
			feetl.setColor(t);
			feetr.setColor(t);
			feet1.add(feetl);
			feet2.add(feetr);
			knee1.add(feet1);
			knee2.add(feet2);
			
			
			//////////////////
			
			//root.add(neck);
			spine.add(neck);
			spine.add(shoulder1);
			spine.add(shoulder2);
			//root.add(shoulder1);
			//root.add(shoulder2);
			root.add(leg1);
			root.add(leg2);
			leg1.add(knee1);
			leg2.add(knee2);
			// Use this for testing, but ultimately it will be more interesting
			// to create your character with an xml description (see example).
			
			// Here we just return null, which will not be very interesting, so write
			// some code to create a test or partial charcter and return the root node.

			return root;
		}
	}
}
