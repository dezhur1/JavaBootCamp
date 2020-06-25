package sef.module6.activity;

public class AbstractionActivity {

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		r.setColor("red");
		r.setLengh(5);
		r.setBreath(6);
		
		Rectangle sq = new Rectangle();
		sq.setColor("black");
		sq.setLengh(5);
		sq.setBreath(sq.getLengh());
		
		System.out.println("Rectangle color is "+ r.getColor());//Rectangle Color
		System.out.println("Rectangle area is "+ r.calculateArea());//Rectangle Are
		System.out.println("Rectangle perimeter is " + r.calculatePerimeter());//Rectangle Perimeter

		System.out.println("Square color is "+ sq.getColor());//Square Color
		System.out.println("Square area is "+ sq.calculateArea());//Square Are
		System.out.println("Square perimeter is " + sq.calculatePerimeter());//Square Perimeter
	}

}
