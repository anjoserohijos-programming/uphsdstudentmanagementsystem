import java.util.Scanner;

public class test {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String ID = scan.next() + scan.nextLine();

	System.out.println(ID);
	if(ID.equals("0015165772")) {
		System.out.println("Wow");
	}
	else {
		System.out.println("woa");
	}
}
}
