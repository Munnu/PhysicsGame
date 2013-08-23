package lasergame.core.presenter.impl;

import static playn.core.PlayN.graphics;

import playn.core.*;
import playn.core.Pointer.Event;

import lasergame.core.view.impl.InstructForwardButton;
import lasergame.core.view.impl.IntroView;
import lasergame.core.view.impl.TitleView;
import lasergame.core.view.impl.startButtonView;

/**
 * Description: This is the presenter for the introduction/splash screen
 * it only displays the start game text and instructions text and then
 * checks to see if the user has clicked either text.
 *
 * @author Monique Blake
 *
 */
public class IntroPresenter {

	private GroupLayer introParent;
	private GroupLayer titleParent;
	private GroupLayer sButtonParent;
	private GroupLayer instructParent;
	private GroupLayer parent;
	private GroupLayer layer;

	private IntroView introView;
	private startButtonView sButtonView;
	private InstructForwardButton instructForwardButton;
	private TitleView titleView;

	private static int SBUTTON_XPOS = 420;
    private static int SBUTTON_YPOS = 300;
	private static int IBUTTON_XPOS = 380;
    private static int IBUTTON_YPOS = 380;
	private static int TITLE_XPOS = 350;
    private static int TITLE_YPOS = 100;
	private static int TEXT_COLOR = 0xFFFFFFFF;
	private static String FONT_NAME = "silkscreen";


	/**
	 * Description: this is the constructor of the presenter,
	 * initializes the views used and puts those views in a layer
	 * then ultimately in the parent layer.
	 *
	 * @param parent the parent layer of the group layer
	 */
	public IntroPresenter(GroupLayer parent){
		this.parent = parent;

		this.introParent = graphics().createGroupLayer();
		this.titleParent =graphics().createGroupLayer();
		this.sButtonParent = graphics().createGroupLayer();
		this.instructParent = graphics().createGroupLayer();

		this.introView = new IntroView(introParent);
		this.titleView = new TitleView(titleParent, FONT_NAME, TEXT_COLOR, TITLE_XPOS, TITLE_YPOS);
		this.sButtonView = new startButtonView(sButtonParent, FONT_NAME, TEXT_COLOR, SBUTTON_XPOS, SBUTTON_YPOS);
		this.instructForwardButton = new InstructForwardButton(instructParent, FONT_NAME, TEXT_COLOR, IBUTTON_XPOS, IBUTTON_YPOS);


		this.layer = graphics().createGroupLayer();

		// now add all the contents into layer
		layer.add(this.introParent);
		layer.add(this.titleParent);
		layer.add(this.sButtonParent);
		layer.add(this.instructParent);


		// add all layers to parent
		parent.add(this.layer);
	}



	/**
	 * Description: this is the method that checks to see if the
	 * instruction button has been clicked and returns the output.
	 *
	 * @param event the mouseclick
	 * @return
	 */
	public boolean instructForwardButtonIsClicked(Event event) {
		// get the layer of InstructBackButton
		if (Layer.Util.hitTest(instructForwardButton.layer, event)) {
			return true;
		}
		return false;
	}


	/**
	 * Description: this is the method that checks to see if the
	 * start button has been clicked and returns the output.
	 *
	 * @param event the mouseclick
	 * @return
	 */
	public boolean startButtonIsClicked(Event event) {
		// get the layer of InstructBackButton
		if (Layer.Util.hitTest(sButtonView.sLayer, event)) {
			return true;
		}
		return false;
	}

}
