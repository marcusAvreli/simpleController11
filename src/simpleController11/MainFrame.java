package simpleController11;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSplitPane;
import javax.swing.RootPaneContainer;

import simpleController11.api.controller.ViewControllerDispatcher;
import simpleController11.core.controller.DefaultViewControllerDispatcher;
import simpleController11.core.controller.SwingBuilderView;
import simpleController11.core.controller.TestView;
import simpleController11.core.view.AbstractViewContainer;
import simpleController11.core.view.DefaultViewManager;

public class MainFrame extends JFrame{
	JSplitPane splitPane;
	JPanel leftRootView;
	JPanel rightRootView;
	private ViewControllerDispatcher 	dispatcher;
	public ViewControllerDispatcher getControllerDispatcher() {
		return this.dispatcher;
	}

	public void setControllerDispatcher(ViewControllerDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
	public MainFrame() {
		this.dispatcher 			= new DefaultViewControllerDispatcher();
		initComponents();
	}
	
	public void initComponents() {
		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        
    	
    	
    	//AbstractViewContainer def = new DefaultView("myPanelId","myTitle",panel);
    	//AbstractViewContainer def = new TestView();
    	AbstractViewContainer def = new SwingBuilderView();
    	def.setContentPane(rootPane);
  //  def.setRootPane(this.getRootPane());
    	//ViewManager
    	//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/view/AbstractViewManager.java
    	ViewManager vm = new DefaultViewManager();
    	
    	vm.setControllerDispatcher(dispatcher);
    	//vm.setFrame(this);
    	//vm.addView(def);

		pack();
		setVisible(true);
	}
	/*
	public void setViews(Map<Object,JPanel> views) {
		rightRootView.add(views.get("view"));
		leftRootView.add(views.get("view2"));
	}
	*/
}
