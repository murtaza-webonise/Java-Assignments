
import java.util.Scanner;


 abstract class polygon {

    protected int side;
    protected float length;

	polygon(int side) {

    	this.side=side;

    }
    polygon(float length,int side) {

	    	this.length=length;
	    	this.side=side;

    }

    abstract protected void calculate();
	abstract protected void getResult();



}

class interiorAngle extends polygon {

	final int pie=180;
	protected int sum;

	interiorAngle(int side) {
		super(side);

	}

	protected void calculate() {

	        sum=pie*(side-2);


    }


    protected void getResult() {

        System.out.println("Sum of Interior angles is "+sum);

    }

}

class perimeter extends polygon {

	float pmeter;

	perimeter(float length,int side) {
		super(length,side);

	}

	protected void calculate() {

	        pmeter=length*side;
	        System.out.println(pmeter);

    }



    protected void getResult() {

        System.out.println("Perimeter of Polygon is "+pmeter);

    }

}

public class polygonMaths {

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of sides");
        int side=sc.nextInt();

        if(side>3&&side<10)
        {
			polygon Obj;
            Obj=new interiorAngle(side);
            Obj.calculate();
            Obj.getResult();

            System.out.println("Enter the length of sides");
            float length=sc.nextFloat();
            Obj=new perimeter(length,side);
            Obj.calculate();
            Obj.getResult();
		}

		else
		System.out.println("Please enter the side in between 3 and 10");



    }

}
