package grp5;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;


public class HotelCalifornia extends JPanel{

	
	
	// Work in progress that I did not get to figure out before the deadline.
	// I am hung up on sorting the 2D array by distance, I can't seem to get the 
	// columns to stay lined up during the sorting process.
	// After figuring that out, all that is left is adding a process to assign the
	// people with the shortest distance to a hotel to that hotel, for each hotel
	// until there are no people left. 
	// I'm going to keep working on this, if I get it figured out I will push an update.
	
	public static int[] fillCord(int amount) {
		Random rand = new Random();
		int upperbound = 200;
		int xcord[] = new int[amount];

		
		int random = rand.nextInt(upperbound);
		
		for(int i = 0; i < amount; i++) {
			xcord[i] = random;
			random = rand.nextInt(upperbound);
		}
		
		return xcord;
	}
	
	public static int[][] fillPerson(int amount) {
		Random rand = new Random();
		int upperbound = 200;
		int cord[][] = new int[4][amount];

		
		int random = rand.nextInt(upperbound);
		
		
		for(int j = 0; j < amount; j++) {
			cord[0][j] = j;
			random = rand.nextInt(upperbound);
			cord[1][j] = random;
			random = rand.nextInt(upperbound);
			cord[2][j] = random;
		}
		
		
		
		return cord;
	}
	
	
	
	// This method takes the arrays of X and Y coordinates, runs the distance formula, and determines if there is a cluster.
	public String findHotel(int[] xcord, int[] ycord) {
//		double dist = 0;
		int total = 0;

		for (int i = 0; i < xHotel.length; i++) {
			for (int j = 0; j < xcord.length; j++) {
				double dist = Math.sqrt(Math.pow((xHotel[i]-xcord[j]), 2) + Math.pow((yHotel[i]-ycord[j]), 2));
				person[3][j] = (int) dist;
				
				
		//	System.out.println("Distance between hotel " + i + " and coordinate x= " + xcord[j] + " y= " + ycord[j] + " is: " + dist);
	
					
			}
			
			// NEED METHOD TO SORT ARRAY BY DISTANCE AND KEEP COLUMNS IN ORDER
			

			
			System.out.println(Arrays.deepToString(person).replace("], ", "]\n"));
			System.out.println("\n");
		}
	//	System.out.println(Arrays.deepToString(person).replace("], ", "]\n"));
	//	System.out.println("Total amount of clusters: " + total);
	//	System.out.println(clusterCount);
		String countStr = Integer.toString(total);
		return countStr;

	}
	
	
	static int[][] person = fillPerson(150);
	
	static int[] xcord = fillCord(150);
	static int[] ycord = fillCord(150);
	static int[] xHotel = fillCord(20);
	static int[] yHotel = fillCord(20);
	
	int marg = 80;
	

	// Code of generating the graph and plotting the points
	protected void paintComponent(Graphics grf) {
		super.paintComponent(grf);
		Graphics2D graph = (Graphics2D)grf;
		
		
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		int width = getWidth();
		int height = getHeight();
		
		graph.drawString(findHotel(xcord, ycord), 10, 10);
		
		graph.draw(new Line2D.Double(marg, marg, marg, height-marg));
		graph.draw(new Line2D.Double(marg, height-marg, width-marg, height-marg));
		
		double x = (double)(width-2*marg)/(ycord.length-1);
		double scale = (double)(height-2*marg)/200;
		double xscale = (double)(width-2*marg)/200;
		
		graph.setPaint(Color.RED);
		
		for(int i = 0; i < ycord.length; i++) {
			double x1 = width-marg-xscale*xcord[i];
			double y1 = height-marg-scale*ycord[i];
			graph.fill(new Ellipse2D.Double(x1-2, y1-2, 8, 8));
		}
		
		graph.setPaint(Color.BLUE);
		
		for(int i = 0; i < xHotel.length; i++) {
			double x1 = width-marg-xscale*xHotel[i];
			double y1 = height-marg-scale*yHotel[i];
			graph.fill(new Ellipse2D.Double(x1-2, y1-2, 8, 8));
		}
	
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new HotelCalifornia());
		frame.setSize(1200, 1200);
		frame.setLocation(1500, 540);
		frame.setVisible(true);
		
		
	}

}
