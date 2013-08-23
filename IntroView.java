package lasergame.core.view.impl;

import static playn.core.PlayN.graphics;
import playn.core.CanvasLayer;
import playn.core.Color;
import playn.core.GroupLayer;

/**
 * Description: This is the view for the intro/splash screen.
 * It contains a background color and will gather
 * the start button and the read instructions button
 *
 * @author Monique Blake
 *
 */
public class IntroView {
	private GroupLayer parent;
	private CanvasLayer introBgLayer;
	private GroupLayer layer;

	private int WINDOW_WIDTH = 1024;
	private int WINDOW_HEIGHT = 768;


	/**
	 * The IntroView constructor creates a new group layer,
	 * intro background layer, and fill the background layer
	 * with the appropriate color, then create the introduction text layer
	 *
	 * ultimately adding combined layers into the parent layer
	 *
	 * @param parent the base layer where all the layers are added
	 */
	public IntroView(GroupLayer parent){
			this.parent = parent;
			this.layer = graphics().createGroupLayer();

			// Create the background layer.
			graphics().setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			this.introBgLayer = graphics().createCanvasLayer(graphics().width(), graphics().height());
			this.introBgLayer.canvas().setFillColor(Color.rgb(132, 212, 255));
			this.introBgLayer.canvas().fillRect(0, 0, this.introBgLayer.width(), this.introBgLayer.height());


			this.layer.add(this.introBgLayer);
			this.parent.add(introBgLayer);
	}

}
