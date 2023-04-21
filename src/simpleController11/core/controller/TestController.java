package simpleController11.core.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import simpleController11.ViewContainer;
import simpleController11.ViewManager;

/**
 * @author Mario Garcia
 * @since 1.0.2
 * 
 */
public class TestController extends  AbstractViewController<ActionListener, ActionEvent> {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.viewaframework.controller.ViewController#getSupportedClass()
	 */
	public Class<ActionListener> getSupportedClass() {
		return ActionListener.class;
	}
	@Override
	public ViewManager getViewManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractViewController getTargetController() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void executeHandler(ViewContainer view, ActionEvent eventObject) {
		// TODO Auto-generated method stub
		logger.info("executeHandler");
	}
	@Override
	public void handleView(ViewContainer view, ActionEvent eventObject) {
		// TODO Auto-generated method stub
		logger.info("handleView");
	}
	@Override
	public void postHandlingView(ViewContainer view, ActionEvent eventObject) {
		// TODO Auto-generated method stub
		logger.info("post_handle");
	}
	@Override
	public void preHandlingView(ViewContainer view, ActionEvent eventObject) {
		// TODO Auto-generated method stub
		logger.info("preHandlingView");
	}


	
}