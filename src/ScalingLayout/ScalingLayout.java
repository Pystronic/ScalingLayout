package ScalingLayout;

import java.awt.*;
import java.util.ArrayList;

public class ScalingLayout implements LayoutManager {
	
	private int lFWidth, lFHeight;
	private ArrayList<Square> percent;
	private int lastCount;
	private boolean fTime;
	
	public ScalingLayout() {
		super();
		this.lFWidth=0;
		this.lFHeight=0;
		
		this.percent = new ArrayList<Square>();
		
		this.lastCount=0;
		this.fTime=true;
	}
	
	
	@Override
	public void layoutContainer(Container parent) {
		
		if (this.fTime) {
			this.fTime=!this.fTime;
			
			this.lFWidth=parent.getWidth();
			this.lFHeight=parent.getHeight();
		}
		
		
		if (lastCount!=parent.getComponentCount()) {
			
			int i=0;
			
			for (i=0;i<percent.size();i++) {
				percent.remove(i);
			}
			
			for (i=0;i<parent.getComponentCount();i++) {
				
				Component c = parent.getComponent(i);
				
				Square h = new Square();
				h.x = (c.getX()/((float)this.lFWidth/100))/100;
				h.y = (c.getY()/((float)this.lFHeight/100))/100;
				h.w = (c.getWidth()/((float)this.lFWidth/100))/100;
				h.h = (c.getHeight()/((float)this.lFHeight/100))/100;
				
				percent.add(h);
				
			}
			
			this.lastCount = parent.getComponentCount();
			
		}
		
		for  (int i =0;i<parent.getComponentCount();i++) {
			Component c = parent.getComponent(i);
			
			c.setBounds((int)(percent.get(i).x*this.lFWidth),(int)(percent.get(i).y*this.lFHeight),(int)(percent.get(i).w*this.lFWidth),(int)(percent.get(i).h*this.lFHeight));
			
		}
		
		this.lFHeight = parent.getHeight();
		this.lFWidth = parent.getWidth();
		
		
	}

	
	
	
	
	
	
	@Override
	public void addLayoutComponent(String arg0, Component arg1) {
		// ignore
		
	}

	@Override
	public void removeLayoutComponent(Component parent) {
		// ignore
		
	}
	
	@Override
	public Dimension minimumLayoutSize(Container parent) {
		return null;
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		return null;
	}


}
