package simpleController11.core.view;

import java.awt.Component;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleController11.Application;
import simpleController11.ViewContainer;
import simpleController11.ViewManager;
import simpleController11.api.controller.ViewController;
import simpleController11.api.controller.ViewControllerDispatcher;
import simpleController11.core.controller.TestController;

/**
 * A default implementation of View Manager. It manages the views added to the application
 * and those which are removed from the application. It also is resposible of launching
 * the views lifecycle and add them to the current perspective. 
 * 
 * It's also responsible for keeping the visual part of the application stable.
 * 
 * @author Mario Garcia
 * @since 1.0
 *
 */
public abstract class AbstractViewManager implements ViewManager
{
	private static final Logger logger = LoggerFactory.getLogger(AbstractViewManager.class);
	private JFrame frame;
	private ViewControllerDispatcher 	dispatcher;
	/**
	 * Default constructor. It creates a new List where the views are
	 * added.
	 */
	public AbstractViewManager(){
			
	}


	/* (non-Javadoc)
	 * @see org.viewaframework.view.ViewManager#addView(org.viewaframework.view.ViewContainer, org.viewaframework.view.perspective.PerspectiveConstraint)
	 */
	public void addView(ViewContainer view)
	{	 
		System.out.println("add_view_called");
		Map<String,List<ViewController<? extends EventListener, ? extends EventObject>>>	controllers 			= null;

		ViewControllerDispatcher				controllerDispatcher	= this.getControllerDispatcher();
		controllers = controllerDispatcher.getViewControllers(view);
		
		if(null != view) {
			System.out.println("view_is_not_null");

		}
		List<ViewController<? extends EventListener, ? extends EventObject>> viewControllers = new ArrayList<ViewController<? extends EventListener, ? extends EventObject>>();
		viewControllers.add(new TestController());
		//view.getViewControllerMap().put("ControllerTestViewId.testButton",viewControllers);
		if(null != view) {
			logger.info("view_is_not_null");
		}else {
			logger.info("view_is_null");
		}
		if(null != view.getViewControllerMap()) {
			logger.info("map_is_not_null");
		}else {
			logger.info("map_is_null");
		}
		view.getViewControllerMap().put("SwingBuilderViewId.searchButton",viewControllers);
		view.viewInit();
		Component component = view.getRootPane();
		if(null !=component) {
			System.out.println("component_is_not_null");
		}else {
			System.out.println("component_is_null");
		}
		JFrame frame = this.getFrame();
		frame.add(component);
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public ViewControllerDispatcher getControllerDispatcher() {
		return this.dispatcher;
	}

	public void setControllerDispatcher(ViewControllerDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
		
}