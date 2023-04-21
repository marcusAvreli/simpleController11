package simpleController11.core.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import simpleController11.DefaultViewContainerEventController;
import simpleController11.ViewContainerEvent;
import simpleController11.api.controller.ViewController;
import simpleController11.core.view.delegator.NamedComponentsDelegator;
import simpleController11.core.view.delegator.ViewContainerControllerDelegator;
import simpleController11.Application;
import simpleController11.ViewContainer;
import simpleController11.api.view.delegator.Delegator;
import simpleController11.api.view.event.ViewContainerEventController;


//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/view/AbstractViewContainer.java

public abstract class AbstractViewContainer  implements ViewContainer {
		private static final Logger logger = LoggerFactory.getLogger(AbstractViewContainer.class);
		private JRootPane 								rootPane;
		Container contentPane;
		String id;
		String title;
		private List<ViewContainerEventController> viewContainerEventControllers;
		private Map<String,List<ViewController<? extends EventListener, ? extends EventObject>>> 	viewControllerMap;
		private List<Delegator>							delegators;
		private Map<String,List<Component>> 			namedComponents;
		public AbstractViewContainer(){
			super();
			this.getContentPane().setLayout(new BorderLayout());
			this.viewContainerEventControllers = new ArrayList<ViewContainerEventController>();
			viewControllerMap = new HashMap<String, List<ViewController<? extends EventListener, ? extends EventObject>>>();
		}
		public AbstractViewContainer(String id,String title,Component component){
			//super();
			this.setId(id);
			this.setTitle(title);
			this.getContentPane().add(component);
			this.viewContainerEventControllers = new ArrayList<ViewContainerEventController>();
			addViewContainerListener(new DefaultViewContainerEventController());
			viewControllerMap = new HashMap<String, List<ViewController<? extends EventListener, ? extends EventObject>>>();
		}
		@Override
		public void setContentPane(Container contentPane) {
			// TODO Auto-generated method stub
			System.out.println("set_content_pane_is_called");
			if(null != contentPane) {
			
				System.out.println("set_content_pane_is_not_null:"+contentPane.getName());
			}else {
				System.out.println("set_content_pane_is_null");
			}
			this.getRootPane().setContentPane(contentPane);
		}

		@Override
		public Container getContentPane() {
			// TODO Auto-generated method stub
			
			return this.getRootPane().getContentPane(); 
		
		}

		@Override
		public void setLayeredPane(JLayeredPane layeredPane) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public JLayeredPane getLayeredPane() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setGlassPane(Component glassPane) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Component getGlassPane() {
			// TODO Auto-generated method stub
			return null;
		}
public void setRootPane(JRootPane rootPane) {
	this.rootPane = rootPane;
}
		@Override
		public JRootPane getRootPane() {
			logger.info("get_root_pane");
			if (this.rootPane == null){
				logger.info("root_pane_is_null");
				this.rootPane = new JRootPane();
				this.rootPane.setName("ROOTPANE");
			}else {
				logger.info("root_pane_is_not_null");
			}
			return this.rootPane;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		@Override
		public void viewInit() {
			System.out.println("view_init");
			if (this.getContentPane()!=null) { 
				System.out.println("content_pane_is_not_null. setting_name");
					this.getContentPane().setName("contentPane");
				}else {
					System.out.println("content_pane_is_null");
				}
			this.fireViewInit(new ViewContainerEvent(this));
			
			final ViewContainer thisContainer = this; 
			logger.info("Initializing_view "+this.getClass().getName());
			if (SwingUtilities.isEventDispatchThread()){
				System.out.println("view_init_event_dispatch_thread");
				for (Delegator delegator : this.getDelegators()){
					delegator.inject(thisContainer);
				}
				//thisContainer.viewInitUIState(); 
			} else {
				System.out.println("view_init_not_event_dispatch_thread");
				SwingUtilities.invokeLater(new Runnable(){
					public void run(){
									
							for (Delegator delegator : getDelegators()){
								delegator.inject(thisContainer);
							}	
							//thisContainer.viewInitUIState(); 
									
					}
				});
			}
			
		}
		
		/* (non-Javadoc)
		 * @see org.viewaframework.view.delegator.DelegatorAware#getDelegators()
		 */
		public List<Delegator> getDelegators() {
			if (delegators == null){
				this.delegators = new ArrayList<Delegator>(Arrays.asList(
				 /* ActionDescriptor must always be the first delegator because once it has been injected
				  * all initial java.awt.Component are available, like the JToolBar and the JMenuBar */
						new ViewContainerControllerDelegator(),
						new NamedComponentsDelegator()
					
				));
			}
			return delegators;
		}
		
		/* (non-Javadoc)
		 * @see org.viewaframework.view.ViewContainerEventAware#fireViewInit(org.viewaframework.view.ViewContainerEvent)
		 */
		public void fireViewInit(ViewContainerEvent event) {
			System.out.println("fire_view_init");
			for (ViewContainerEventController listener: this.viewContainerEventControllers){
				//listener.onViewInit(event);
			}
		}
		public void addViewContainerListener(ViewContainerEventController listener){
			this.viewContainerEventControllers.add(listener);
		}
		/* (non-Javadoc)
		 * @see org.viewaframework.controller.ViewControllerAware#setViewControllerMap(java.util.Map)
		 */
		public void setViewControllerMap(Map<String, List<ViewController<? extends EventListener, ? extends EventObject>>> viewControllerMap) {
			this.viewControllerMap = viewControllerMap;
		}
		/* (non-Javadoc)
		 * @see org.viewaframework.controller.ViewControllerAware#getViewControllerMap()
		 */
		public Map<String, List<ViewController<? extends EventListener, ? extends EventObject>>> getViewControllerMap() {
			return this.viewControllerMap;
		}
		public void setNamedComponents(Map<String, List<Component>> namedComponents) {
			this.namedComponents = namedComponents;
		}
		/* (non-Javadoc)
		 * @see org.viewaframework.view.ComponentAware#getNamedComponents()
		 */
		public Map<String, List<Component>> getNamedComponents() {
			return this.namedComponents;
		}
	}

