/**
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * @author Monique Blake
 */
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

public class startButtonView {
	private static final float FONT_SIZE = 30f;
    private static final Style FONT_STYLE = Style.BOLD;
	private static final String DEFAULT_TEXT = "Start Game";

    private GroupLayer parent;
    public CanvasLayer sLayer;
	private String fontName;
	private int textColor;
	private float xPosition;
    private float yPosition;
    Font startButtonFont;
	private TextLayout startButtonLayout;
	private TextFormat startButtonFormat;

	public startButtonView(GroupLayer parent, String fontName, int textColor, float xPosition, float yPosition) {
		this.parent = parent;
		this.fontName = fontName;
		this.textColor = textColor;

		this.xPosition = xPosition;
		this.yPosition = yPosition;

		// Fill in the initial text.
		Font startButtonFont = graphics().createFont(this.fontName, FONT_STYLE, FONT_SIZE);
		this.startButtonFormat = new TextFormat().withFont(startButtonFont).withTextColor(this.textColor);
		this.startButtonLayout = graphics().layoutText(DEFAULT_TEXT, startButtonFormat);

		this.sLayer = graphics().createCanvasLayer((int) (startButtonLayout.width()), (int) (startButtonLayout.height()));
		this.parent.add(this.sLayer);

		this.sLayer.setTranslation(xPosition, yPosition);
		this.sLayer.canvas().drawText(startButtonLayout, 0, 0);

	}

}
