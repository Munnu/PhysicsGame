package lasergame.core.view.impl;

import static playn.core.PlayN.*;
import playn.core.CanvasLayer;
import playn.core.Font;
import playn.core.GroupLayer;
import playn.core.Layer;
import playn.core.TextFormat;
import playn.core.TextLayout;
import playn.core.Font.Style;

public class InstructBackButton {

	private static final float FONT_SIZE = 18f;
	private static final Style FONT_STYLE = Style.PLAIN;
	private static final String DEFAULT_TEXT = "Back to Main Menu";

	private GroupLayer parent;
	public CanvasLayer layer;
	private String fontName;
	private int textColor;
	private float xPosition;
	private float yPosition;
	private TextLayout backButtonLayout;
	private TextFormat backButtonFormat;

	public InstructBackButton(GroupLayer parent, String fontName, int textColor, float xPosition, float yPosition) {

		this.parent = parent;
		this.fontName = fontName;
		this.textColor = textColor;
		this.xPosition = xPosition;
		this.yPosition = yPosition;

		Font backButtonFont = graphics().createFont(this.fontName, FONT_STYLE, FONT_SIZE);
		this.backButtonFormat = new TextFormat().withFont(backButtonFont).withTextColor(this.textColor);
		this.backButtonLayout = graphics().layoutText(DEFAULT_TEXT, backButtonFormat);

		this.layer = graphics().createCanvasLayer((int) (backButtonLayout.width()), (int) (backButtonLayout.height()));
		this.parent.add(this.layer);
		this.layer.setTranslation(xPosition, yPosition);
		this.layer.canvas().drawText(backButtonLayout, 0, 0);


	}

}
