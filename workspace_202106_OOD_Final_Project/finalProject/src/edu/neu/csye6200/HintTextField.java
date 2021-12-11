package edu.neu.csye6200;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class HintTextField extends JTextField implements FocusListener {

	  private final String hint;
	  private boolean showingHint;
	  
	  public HintTextField(final String hint) {
	    super(hint);
	    this.hint = hint;
	    this.showingHint = true;
	    super.addFocusListener(this);
	    this.setForeground(new Color(255, 255, 255));
	    this.setBackground(new Color(20, 20, 20));
		this.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		this.setColumns(25);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setCaretColor(new Color(255, 255, 255));
	  }

	  @Override
	  public void focusGained(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText("");
	      showingHint = false;
	    }
	  }
	  @Override
	  public void focusLost(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText(hint);
	      showingHint = true;
	    }
	  }

	  @Override
	  public String getText() {
	    return showingHint ? "" : super.getText();
	  }
}
