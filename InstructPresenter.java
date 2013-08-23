package lasergame.core.presenter.impl;

import static playn.core.PlayN.*;
import static playn.core.PlayN.graphics;
import lasergame.core.view.impl.InstructBackButton;
import lasergame.core.view.impl.InstructView;
import lasergame.core.view.impl.InstructionsText;
import lasergame.core.view.impl.IntroView;
import playn.core.GroupLayer;
import playn.core.Layer;
import playn.core.Pointer.Event;

/*
 * Description: Instruction presenter waits for the user interaction of clicking
 * the back to the IntroView button on the screen after reading the instructions.
 * It then relays the message to the DemoCore presenter which will then set the
 * screen to invisible and set the IntroView to visible
 *
 * @author Monique Blake
 */
public class InstructPresenter {
	private InstructView instructView;
	private InstructBackButton instructBackButton;
	private InstructionsText instructText;

	private GroupLayer parent;
	private GroupLayer layer;
	private GroupLayer instructParent;
	private GroupLayer backButtonParent;
	private GroupLayer instructTextParent;

	private static int PADDING_CENTER = 200;
	private static int PADDING_BOTTOM = 100;
	private static int TEXT_COLOR = 0xFFFFFFFF;
	private static String FONT_NAME = "silkscreen";

	/*
	 * Description: The two main views that the presenter handles:
	 * instruction view and back button are placed onto the root layer
	 */
	public InstructPresenter(GroupLayer parent) {
		this.parent = parent;
		this.instructParent = graphics().createGroupLayer();
		this.backButtonParent = graphics().createGroupLayer();
		this.instructTextParent = graphics().createGroupLayer();


		this.instructView = new InstructView(instructParent);

		//GroupLayer parent, String fontName, int textColor, float xPosition, float yPosition
		this.instructBackButton = new InstructBackButton(instructParent, FONT_NAME, TEXT_COLOR, 0, 0);
		this.instructText = new InstructionsText(instructTextParent, FONT_NAME, TEXT_COLOR, PADDING_CENTER, PADDING_BOTTOM);


		this.layer = graphics().createGroupLayer();

		layer.add(this.instructParent);
		layer.add(this.backButtonParent);
		layer.add(this.instructTextParent);
		parent.add(this.layer);


	}

	// if user presses back button
	// recognize that the back button has been pressed
	public boolean backButtonIsClicked(Event event) {
		// get the layer of InstructBackButton
		if (Layer.Util.hitTest(instructBackButton.layer, event)) {
			return true;
		}
		return false;
	}


}
