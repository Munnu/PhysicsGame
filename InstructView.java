package lasergame.core.view.impl;

import static playn.core.PlayN.graphics;
import playn.core.CanvasLayer;
import playn.core.Color;
import playn.core.GroupLayer;

/**
 * Description: This is the view for the instruction.
 * It contains a background color and will gather
 * the instruction text from the InstructText class
 * and put both aspects together in the view
 *
 * @author Monique Blake
 *
 */

public class InstructView {
	// ParentLayer for this view
	private GroupLayer parent;

	// Layer for this view.
	private GroupLayer layer;

	// Layer for the background colour.
	private CanvasLayer instructBgLayer;

	// create a view for the instruction text
	private GroupLayer intructText;
	private GroupLayer backButton;

	private int WINDOW_WIDTH = 1024;
	private int WINDOW_HEIGHT = 768;

	/**
	 * The InstructView constructor creates a new group layer,
	 * instruction background layer, and fill the background layer
	 * with the appropriate color, then create the introduction text layer
	 *
	 * ultimately adding combined layers into the parent layer
	 *
	 * @param parent the base layer where all the layers are added
	 */
	public InstructView(GroupLayer parent) {

		this.parent = parent;
		this.layer = graphics().createGroupLayer();

		// Create the background layer.
		graphics().setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.instructBgLayer = graphics().createCanvasLayer(graphics().width(), graphics().height());
		this.instructBgLayer.canvas().setFillColor(Color.rgb(132, 212, 255));
		this.instructBgLayer.canvas().fillRect(0, 0, this.instructBgLayer.width(), this.instructBgLayer.height());

		this.layer.add(this.instructBgLayer);

		// Add everything to the parent.
		this.parent.add(this.layer);

	}

}
