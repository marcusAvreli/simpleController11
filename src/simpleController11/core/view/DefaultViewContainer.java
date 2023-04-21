package simpleController11.core.view;

import java.awt.Component;
import java.awt.Container;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;
import java.util.Map;

import javax.swing.JLayeredPane;
import javax.swing.JRootPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleController11.api.controller.ViewController;

/**
 * This is a helper class. It helps programmer not to implement certain methods. Also
 * its constructor helps for setting the id directly.
 * 
 * @author Mario García
 *
 */
public class DefaultViewContainer extends AbstractViewContainer{
	private static final Logger logger = LoggerFactory.getLogger(DefaultViewContainer.class);

	/**
	 * 
	 */
	public DefaultViewContainer(){
		super();
	}
	
	/**
	 * @param id
	 * @param component
	 */
	public DefaultViewContainer(String id,Component component){
		this();
		this.setId(id);
		this.setTitle(id);
		this.getContentPane().add(component);
	}
	
	/**
	 * @param id
	 * @param title
	 * @param component
	 */
	public DefaultViewContainer(String id,String title,Component component){
		this();
		this.setId(id);
		this.setTitle(title);
		this.getContentPane().add(component);
	}

}