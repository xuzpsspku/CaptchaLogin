package com.captchalogin.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class ImageUtil {

	
	 public static  void shear(Graphics g, int w1, int h1, Color color) {
	        shearX(g, w1, h1, color);
	        shearY(g, w1, h1, color);
	    }
	     
	    private static void shearX(Graphics g, int w1, int h1, Color color) {
	 
	    	 Random random = new Random();
	        int period = random.nextInt(2);
	 
	        boolean borderGap = true;
	        int frames = 1;
	        int phase = random.nextInt(2);
	 
	        for (int i = 0; i < h1; i++) {
	            double d = (double) (period >> 1)
	                    * Math.sin((double) i / (double) period
	                            + (6.2831853071795862D * (double) phase)
	                            / (double) frames);
	            g.copyArea(0, i, w1, 1, (int) d, 0);
	            if (borderGap) {
	                g.setColor(color);
	                g.drawLine((int) d, i, 0, i);
	                g.drawLine((int) d + w1, i, w1, i);
	            }
	        }
	 
	    }
	 
	    private static void shearY(Graphics g, int w1, int h1, Color color) {
	 
	    	 Random random = new Random();
	        int period = random.nextInt(40) + 10; // 50;
	 
	        boolean borderGap = true;
	        int frames = 20;
	        int phase = 7;
	        for (int i = 0; i < w1; i++) {
	            double d = (double) (period >> 1)
	                    * Math.sin((double) i / (double) period
	                            + (6.2831853071795862D * (double) phase)
	                            / (double) frames);
	            g.copyArea(i, 0, 1, h1, 0, (int) d);
	            if (borderGap) {
	                g.setColor(color);
	                g.drawLine(i, (int) d, i, 0);
	                g.drawLine(i, (int) d + h1, i, h1);
	            }
	 
	        }
	    }
	
	
	
	
}
