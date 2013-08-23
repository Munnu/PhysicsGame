package lasergame.core.view.impl;

import static playn.core.PlayN.graphics;
import playn.core.CanvasLayer;
import playn.core.Font;
import playn.core.GroupLayer;
import playn.core.TextFormat;
import playn.core.TextLayout;
import playn.core.Font.Style;

public class InstructForwardButton {
	private static final float FONT_SIZE = 30f;
	private static final Style FONT_STYLE = Style.BOLD;
	private static final String DEFAULT_TEXT = "Read Instructions";

	private GroupLayer parent;
	public CanvasLayer layer;
	private String fontName;
	private int textColor;
	private float xPosition;
	private float yPosition;
	private TextLayout forwardButtonLayout;
	private TextFormat forwardButtonFormat;

	public InstructForwardButton(GroupLayer parent, String fontName, int textColor, float xPosition, float yPosition) {

		this.parent = parent;
		this.fontName = fontName;
		this.textColor = textColor;

		this.xPosition = xPosition;
		this.yPosition = yPosition;

		Font forwardButtonFont = graphics().createFont(this.fontName, FONT_STYLE, FONT_SIZE);
		this.forwardButtonFormat = new TextFormat().withFont(forwardButtonFont).withTextColor(this.textColor);
		this.forwardButtonLayout = graphics().layoutText(DEFAULT_TEXT, forwardButtonFormat);

		this.layer = graphics().createCanvasLayer((int) (forwardButtonLayout.width()), (int) (forwardButtonLayout.height()));
		this.parent.add(this.layer);

		this.layer.setTranslation(xPosition, yPosition);
		this.layer.canvas().drawText(forwardButtonLayout, 0, 0);

	}

}
