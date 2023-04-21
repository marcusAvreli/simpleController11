package simpleController11.core.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleController11.Application;
import simpleController11.builder.SwingBuilder;
import simpleController11.builder.layout.GridBagConstraintsBuilder;
import simpleController11.core.view.DefaultViewContainer;

//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/widget/src/test/java/org/viewaframework/widget/swing/builder/util/SwingBuilderView.java
public class SwingBuilderView extends DefaultViewContainer{
	private static final Logger logger = LoggerFactory.getLogger(SwingBuilderView.class);
	public SwingBuilderView(){
		super("SwingBuilderViewId",
			new SwingBuilder().
			
			component(
					new SwingBuilder().
						layout(new GridBagLayout()).
						 /* (1) label-component */
							label(new GridBagConstraintsBuilder().row(0).col(0).gridWidth(2).build()).
								setName("fromLabel").setText("From").swingBuilder().
							label(new GridBagConstraintsBuilder().row(0).col(2).build()).
								setName("departureDateLabel").setText("Departure Date").swingBuilder().
							text(new GridBagConstraintsBuilder().row(1).col(0).gridWidth(2).weightx(0.8).insets(5,5,5,0).build()).
								setName("from").swingBuilder().
								label(new GridBagConstraintsBuilder().row(2).col(0).gridWidth(2).build()).
								setName("toLabel").setText("To").swingBuilder().
							label(new GridBagConstraintsBuilder().row(2).col(2).build()).
								setName("arrivalDateLabel").setText("Arrival Date").swingBuilder().
							text(new GridBagConstraintsBuilder().row(3).col(0).gridWidth(2).insets(5,5,5,0).build()).
								setName("to").swingBuilder().
								button(new GridBagConstraintsBuilder().
										row(6).col(0).gridWidth(3).anchor(GridBagConstraints.EAST).fill(GridBagConstraints.NONE).insets(20,0,0,0).build()).
									setName("searchButton").setText("Search").setPreferredSize(new Dimension(180,25))
								.swingBuilder()
								.getTarget()
							
							
									
									,JPanel.class,BorderLayout.NORTH).
					swingBuilder().setPreferredSize(new Dimension(400,0)).getTarget());
	}
									
}
