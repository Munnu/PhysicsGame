package lasergame.core.view.impl;

import static playn.core.PlayN.graphics;
import playn.core.CanvasLayer;
import playn.core.Font;
import playn.core.GroupLayer;
import playn.core.TextFormat;
import playn.core.TextLayout;
import playn.core.Font.Style;
import playn.core.TextFormat.Alignment;
import playn.core.TextFormat.Effect;

/**
 * Description: This is where the text lies for the instructions.
 * The text is set to an alignment and wrapping width value.
 *
 * @author Monique Blake
 *
 */
public class InstructionsText {
	private static final float FONT_SIZE = 30f;
    private static final Style FONT_STYLE = Style.BOLD;
    private static final float WRAP_WIDTH = 700;
	private static final String DEFAULT_TEXT =
			"Instructions: \n\n" +
			"By using the mouse you can put up to 5 mirrors in the game\n" +
			"You can use key 1 and key 2 (the number pad) to adjust the angle\n" +
			"You can use key number 8 to delete mirrors\n" +
			"When the target is hit, points will be rewarded";

    private GroupLayer parent;
    private CanvasLayer sLayer;
	private String fontName;
	private int textColor;
	private float xPosition;
    private float yPosition;
    Font instructTextFont;
	private TextLayout instructTextLayout;
	private TextFormat instructTextFormat;

	public InstructionsText(GroupLayer parent, String fontName, int textColor, float xPosition, float yPosition) {
		this.parent = parent;
		this.fontName = fontName;
		this.textColor = textColor;

		this.xPosition = xPosition;
		this.yPosition = yPosition;

		// Fill in the initial text.
		//For textformat: font font, float wrapWidth, Alignment align, int textColor, Effect effect -- ignore this
		// for text format: withWrapping(float wrapWidth, Alignment align)
		Font instructTextFont = graphics().createFont(this.fontName, FONT_STYLE, FONT_SIZE);
		//this.fontName, WRAP_WIDTH, Alignment.LEFT, textColor, Effect.NONE
		this.instructTextFormat = new TextFormat().withFont(instructTextFont).withTextColor(this.textColor).withWrapping(WRAP_WIDTH, Alignment.CENTER);

		this.instructTextLayout = graphics().layoutText(DEFAULT_TEXT, instructTextFormat);

		this.sLayer = graphics().createCanvasLayer((int) (instructTextLayout.width()), (int) (instructTextLayout.height()));
		this.parent.add(this.sLayer);

		this.sLayer.setTranslation(xPosition, yPosition);
		this.sLayer.canvas().drawText(instructTextLayout, 0, 0);
	}
}
