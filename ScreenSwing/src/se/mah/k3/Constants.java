package se.mah.k3;

import java.awt.Color;

public class Constants {
	public static int screenNbr=145;
	public static String question = "urk";
	public static String alt1 = "Alt1";
	public static String alt2 = "Alt2";
	public static String alt3 = "Alt3";
	public static String alt4 = "";
	
	public static long alt1C = 0;
	public static long alt2C = 0;
	public static long alt3C = 0;
	public static long alt4C;
	
	public static boolean falseValue = false;
		
	public static boolean t1 = false;
	public static int x1 = 0;
	public static int y1 = 0;
	public static boolean t2 = false;
	public static int x2 = 0;
	public static int y2 = 0;
	public static boolean t3 = false;
	public static int x3 = 0;
	public static int y3 = 0;
	public static boolean t4 = false;
	public static int x4 = 0;
	public static int y4 = 0;
	
	public static Color green = new Color(0x99C21D);
	public static Color blue = new Color(0x0099CC);
	public static Color pink = new Color(0xCD1139);



	public static void setAlt1C(long count){
		alt1C = count;
	}
	
	public static void setAlt2C(long count){
		alt2C = count;
	}
	
	public static void setAlt3C(long count){
		alt3C = count;
	}
	
	public static void setAlt4C(long count){
		alt4C = count;
	}
	
	public static void setQuestion(String questionIn){
		question = questionIn;
	}
	
	public static void setAlt1(String altIn){
		alt1 = altIn;
	}
	
	public static void setAlt2(String altIn){
		alt2 = altIn;
	}
	
	public static void setAlt3(String altIn){
		alt3 = altIn;
	}
	
	public static void setAlt4(String altIn){
		alt4 = altIn;
	}
}
