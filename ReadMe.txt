Name: Aashima Singh
Character: Rick (from Rick and Morty)

1. BallJoint.java and HingeJoint.java create joints
2. Body<shapename>.java are geometrical node classes
3. a1data folder has character.xml and character-keyposes.javabin. In the Controls window, the base filename for both character and keyframes is: a1data/character
4. Singh-Rick.avi and Singh-Rick.png are video and sample pose image files respectively. Please open the video on VLC player. 
5. The Free-Joint is present at (0,0,0) to which the spine, hip and legs are attached
6. Spine is a hinge joint with childs:
	1. Neck (hinge joint) has:
		a. Head, hair, nose, mouth, ears, eyes geometry nodes
	2. Shoulder (ball joints) have:
		a. Upper arm sphere geometry node
		b. Upper arm cylinder geometry node
		c. Elbow (hinge joints) have:
			i) elbow sphere geometry node
			ii)forearm cylinder geometry node
			iii) hand (hinge joints) which have hand geometry node children
7. Hip is a geometry node attached to root
8. Legs (ball joints) have:
	1. Geometry node for thighs
	2. Knee (hinge joints) have:
		a. Geometry node for lower legs
		b. Feet (hinge joints) have feet children geometry nodes
9. Stills folder has recoder dump image files for video generation
10. The video and animation show Rick waving and then walking
	 
I have included mintools and vecmath jar files in this folder. Please remove it if you already have them! Thank you.