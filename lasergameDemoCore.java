/**
* This is a sample of what I did in this file,
* this file is incomplete.
*/

	/* (non-Javadoc)
	 * @see lasergame.core.impl.DemoModel#init()
	 */
	@Override
	public void init() {
		graphics().setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.model = GunModelImpl.getInstance();
		this.persistanceClient.populate(this.model);

		//Add presenter views to the root layer
		graphics().rootLayer().add(this.instructLayer);
		graphics().rootLayer().add(this.introLayer);

				/**
				 * Description: This part of checks to see if the user
				 * has clicked the option to view the instructions or
				 * have opted to start the game, this acts as a check to
				 * see if the user has clicked the instructions view and
				 * if they have clicked the back page view.
				 *
				 * @param event the event listener for the mouse click
				 * @author Monique Blake (the instruction button pressed check and
				 * start button check)
				 * @version May 18, 2012
				 */


				   pointer().setListener(new Pointer.Adapter() {
				      @Override
				      public void onPointerEnd(Event event) {

				    	  // check to see if the start button has been clicked
					        if (introPresenter.startButtonIsClicked(event)) {
					        	 // load and show our background image
					        	startGame();
					        }

					    	// check to see if the user has clicked the "view instructions" button
					    	if(introPresenter.instructForwardButtonIsClicked(event)) {
					    		// set the splash page to invisible
					    		graphics().rootLayer().get(1).setVisible(false);

					    		// set the instructions page to visible
					    		graphics().rootLayer().get(0).setVisible(true);
					    	}


					    	// check to see if the user has clicked "back to main menu" button
					    	if(instructPresenter.backButtonIsClicked(event)) {
					    		// set the splash page to visible
					    		graphics().rootLayer().get(1).setVisible(true);

					    		// set the instructions page to invisible
					    		graphics().rootLayer().get(0).setVisible(false);
					    	}
				     }
				 });
	}
