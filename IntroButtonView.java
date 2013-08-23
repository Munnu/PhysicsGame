package lasergame.core.view.impl;

import static playn.core.PlayN.graphics;
import playn.core.CanvasLayer;
import playn.core.Font;
import playn.core.GroupLayer;
import playn.core.Layer;
import playn.core.TextFormat;
import playn.core.TextLayout;
import playn.core.Font.Style;
import playn.core.Pointer.Event;

public class IntroButtonView {
	private static final float FONT_SIZE = 30f;
    private static final Style FONT_STYLE = Style.BOLD;
	private static final String DEFAULT_TEXT = "Introduction";

    private GroupLayer parent;
    private CanvasLayer layer;
	private String fontName;
	private int textColor;
	private float xPosition;
    private float yPosition;
	private TextLayout ButtonLayout;
	private TextFormat ButtonFormat;

	public IntroButtonView(GroupLayer parent, String fontName, int textColor,
			float xPosition, float yPosition) {
		 this.parent = parent;
		 this.fontName = fontName;
		 this.textColor = textColor;

		 this.xPosition = xPosition;
		 this.yPosition = yPosition;

		  // Fill in the initial text.
		 Font ButtonFont = graphics().createFont(this.fontName, FONT_STYLE,
		 FONT_SIZE);
		  this.ButtonFormat = new TextFormat().withFont(ButtonFont).
		 withTextColor(this.textColor);
		 this.ButtonLayout = graphics().layoutText(DEFAULT_TEXT,
		 ButtonFormat);

		  this.layer = graphics().createCanvasLayer((int) (ButtonLayout.width()), (int) (ButtonLayout.height()));
		  this.parent.add(this.layer);
		  this.layer.setTranslation(xPosition, yPosition);
		  this.layer.canvas().drawText(ButtonLayout, 0, 0);

	}
	public boolean eventDidHitView(Event event)
	{

		 // Make sure we are still displaying something, then check if the event
		 // actually hit it.
		 if (this.layer != null && Layer.Util.hitTest(this.layer, event))
		 {
		     return true;
		 }
		 return false;

	}
	public void makeViewVisible() {
		this.layer.setVisible(true);
	}
	public void makeViewInvisible() {
		this.layer.setVisible(false);
	}
}
