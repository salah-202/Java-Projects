import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double xsum = 0,ysum = 0,xyps = 0,xsqr = 0,ysqr = 0;
        double xyarrprod,xsqrt,ysqrt,r;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double [] x = new double[n];
        double [] y = new double[n];



        for(int i = 0;i <n; i++){
            System.out.println("Enter x[" + i+1 + "] value");
            x[i] = sc.nextInt();
            System.out.println("Enter y[" + i+1 + "] value");
            y[i] = sc.nextInt();

            xsum += x[i];
            ysum += y[i];

            xyps += x[i]*y[i];

            xsqr += Math.pow(x[i],2);
            ysqr += Math.pow(y[i],2);

        }

        xyarrprod = xsum * ysum;

        xsqrt = Math.sqrt(n * xsqr * Math.pow(xsum,2));
        ysqrt = Math.sqrt(n * ysqr * Math.pow(ysum,2));

        r = (n * xyps * xyarrprod) / (xsqrt * ysqrt);

        System.out.println(r);
    }
    public static double area(double b,double h){
        double a = b * h;
        return a;
    }


    public static double area(double b,double c, double h){
        double a = ((b+c)/2) * h;
        return a;
    }

}

