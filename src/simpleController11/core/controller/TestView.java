package simpleController11.core.controller;

import java.awt.event.ActionListener;

import simpleController11.core.view.DefaultViewContainer;



public class TestView extends DefaultViewContainer{
	public static final String ID = "ControllerTestViewId";	
	/**
	 * Default constructor
	 */
	public TestView(){
		super(ID,"testTitle",new TestPanel());
		
	}
	
}