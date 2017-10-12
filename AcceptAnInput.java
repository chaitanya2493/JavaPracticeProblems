//import java.util.Scanner;

//public class AcceptAnInput{
//	public static void main(String args[]){
//		Scanner scan= new Scanner(System.in);
//		//For string
//		String text= scan.nextLine();
//		System.out.println(text);
//		//for int
//		int num= scan.nextInt();
//		System.out.println(num);
//	}
//}

import java.io.BufferedReader;
import java.io.InputStreamReader; 
class AcceptAnInput {
    public static void main(String args[]){
        float PI = 3.1416f;
        int r=0;
        String rad; //We're going to read all user's text into a String and we try to convert it later
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Here you declare your BufferedReader object and instance it.
        System.out.println("Radius?");
        try{
            rad = br.readLine(); //We read from user's input
            r = Integer.parseInt(rad); //We validate if "rad" is an integer (if so we skip catch call and continue on the next line, otherwise, we go to it (catch call))
            System.out.println("Circle area is: " + PI*r*r + " Perimeter: " +PI*2*r); //If all was right, we print this
        }
        catch(Exception e){
            System.out.println("Write an integer number"); //This is what user will see if he/she write other thing that is not an integer
            AcceptAnInput a = new AcceptAnInput(); //We call this class again, so user can try it again
           //You can also print exception in case you want to see it as follows:
           // e.printStackTrace();
        }
    }
}
