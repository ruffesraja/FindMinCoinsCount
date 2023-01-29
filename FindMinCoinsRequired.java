import java.util.*;
public class FindMinCoinsRequired{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter balance amount: ");
		int balance = input.nextInt();
		
		System.out.println("Example Denominations:");
		System.out.println("1. British Pound > 1,2,5,10,20,50");
		System.out.println("2. US Dollar > 1,5,10,25");
		System.out.println("3. Norwegian Krone > 1,5,10,20");
		System.out.println("4. Indian Rupee > 1,2,5,10,20");
		System.out.print("Enter coins denominations with comma separated :");
		
		input.nextLine();
		String deno = input.nextLine();
		//convert String to int array
		String deno1[] = deno.split(",");
		int denominations[]=new int[deno1.length];
		
		for(int ind=0;ind<deno1.length;ind++){
			denominations[ind]=Integer.parseInt(deno1[ind]);
		}
		minCoinsReruired(balance,denominations);
	}
	static void minCoinsReruired(int amount,int deno[]){
		int coinsCount=0;
		Arrays.sort(deno);
		for(int ind=deno.length-1;amount!=0&&ind>=0;ind--){
			if(amount>=deno[ind]){
				int coins=amount/deno[ind];
				coinsCount+=coins;
				System.out.println(deno[ind]+" - "+coins+ifOne(coins));
				amount=amount%deno[ind];
			}
		}
		System.out.println("Minumun No.Of Coins Required : "+coinsCount);
	}
	static String ifOne(int coins){
		if(coins==1){
			return "coin";
		}
		else{
			return "coins";
		}
	}
}
