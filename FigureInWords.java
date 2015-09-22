import java.util.Scanner;

public class FigureInWords{
	public static  String oneTeen(int num) {
		String[] onesArray = {"","one","two","three","four","five", "six","seven","eight","nine","ten",
                "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        int one = (num%100-num%10)/10;
		if (one == 1)return onesArray[num % 20];
        else{return onesArray[num % 10];}
	} 
	public static String tens(int num) {
		String[] tensArray = {"", "","twenty", "thirty", "forty", "fifty", "sixty","seventy", "eighty", "ninety"};
		int ten = ((num % 100) - (num % 10))/10; return tensArray[ten] + oneTeen(num);
	}
    public static String hundreds(int num) {int hundred = ((num % 1000)-(num % 100))/100;
        if (tens(num).isEmpty())  return oneTeen(hundred) +" hundred";
        else return oneTeen(hundred) +" hundred"+ " and " + tens(num);
    }
	public static String multiples(int num) {int hundred = ((num % 1000)-(num % 100))/100;
        if (tens(num).isEmpty())  {return oneTeen(hundred);} else return tens(num);
	} // Main Method
	public static void main(String[] args) {
        String num = "new", prefix;int n;
		do {
            System.out.print("Enter a number to convert to words (or 'done' to quit):");
            Scanner in = new Scanner(System.in);
             num = in.nextLine().trim();
            if (num.equals("done")) {System.out.println("Thank you for using our service."); break;}
            else if (num.equals("-0")) {System.out.println("You entered a wrong value.");break;}
            else if (num.matches("[0-9]+|-[0-9]+")) {int input;
                if (num.matches("-[0-9]+")){input  = Integer.parseInt(num) *-1;prefix = "negative";
                } else {prefix = "";input = Integer.parseInt(num);}
                if (input == 0) System.out.println("zero");
                if (input<20) System.out.println(prefix+" "+oneTeen(input));
                if (input>=20 && input<100) System.out.println(prefix+" " + tens(input));
                if (input>= 100 && input < 1000) System.out.println(prefix + " " + hundreds(input));
                if (input>=1000 && input<100000){n = ((input - input%1000)/1000);
                    System.out.println(prefix+" "+multiples(n)+" "+"thousand"+" "+hundreds(input));
                }
            } else {System.out.println("You entered a wrong value.");break;}
        } while(true);
	}
}

