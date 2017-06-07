

import java.util.*;

public class Blackjack {
	
int[] cardValue = {1,2,3,4,5,6,7,8,9,10,10,10,10};
static String[] faceValue = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Queen",
		"Jack","King"};
	
static boolean cont = true;
	
static ArrayList <String> PlayerHand = new ArrayList <String>();
static ArrayList <String> DealerHand = new ArrayList <String>();

static ArrayList <Integer> PlayerHandValueArr = new ArrayList <Integer>();
static ArrayList <Integer> DealerHandValueArr = new ArrayList <Integer>();
//Draw Card function for Player	
private void PlayerDrawCard(){
	int random = 0 + (int)(Math.random() * ((12 - 0) + 1));
	String temp = faceValue[random];
	int PlayerHandValue = cardValue[random];
	PlayerHand.add(temp);
	PlayerHandValueArr.add(PlayerHandValue);	
}

//Draw Card function for Dealer	
private void DealerDrawCard(){
	int random = 0 + (int)(Math.random() * ((12 - 0) + 1));
	String temp2 = faceValue[random];
	int DealerHandValue = cardValue[random];
	DealerHand.add(temp2);
	DealerHandValueArr.add(DealerHandValue);
		
}
//Calculates total of player's hand
private int PlayerHandTotal(){
	int j;
	int sum = 0;
	for(j = 0; j < PlayerHandValueArr.size(); j++)
	    sum += PlayerHandValueArr.get(j);
	return sum;
}
//Calculates total of dealer's hand
private int DealerHandTotal(){
	int k;
	int sum = 0;
	for(k = 0; k < DealerHandValueArr.size(); k++)
	    sum += DealerHandValueArr.get(k);
	return sum;
}


public static void main(String[] args){
boolean run = true;
while(run == true){		
//initial draw of two cards each
Blackjack obj = new Blackjack();
obj.PlayerDrawCard();
obj.PlayerDrawCard();
obj.DealerDrawCard();
obj.DealerDrawCard();
int PlayerTotal = obj.PlayerHandTotal();
int DealerTotal = obj.DealerHandTotal();
//shows only first card of dealer's hand
System.out.println("Dealer's Hand: " +DealerHand.get(0));
	
//shows both cards of player's hand	
System.out.println("Player's Hand: "+PlayerHand.get(0)+" "+ PlayerHand.get(1));
	System.out.println("Player Total is "+ PlayerTotal);
//winner determination 
if(DealerTotal == 21 && PlayerTotal != 21){
	System.out.println("Dealer Wins!");
	System.exit(0);
}

if(PlayerTotal == 21 && DealerTotal != 21){
	System.out.println("Player Wins!");
	System.exit(0);
}

if(PlayerTotal == 21 && DealerTotal == 21){
	System.out.println("Tie!");
	System.exit(0);
}

Scanner scan = new Scanner(System.in);

//PLAYER
//hit or stay choice		
while(cont == true){	
System.out.println("Hit or Stay?");
String PlayerReq = scan.nextLine();
	
if(PlayerReq.equalsIgnoreCase("Stay")){
		cont = false;
		
	}
		
if(PlayerReq.equalsIgnoreCase("Hit")){
	obj.PlayerDrawCard();
	PlayerTotal = obj.PlayerHandTotal();
	System.out.print("Player's Hand:");
	for(int z = 0; z < PlayerHand.size(); z++){
		
		System.out.print(" "+ PlayerHand.get(z)+" ");}
	System.out.println("");
	System.out.println("Player Total is "+PlayerTotal);
}
//Players busts	
if(PlayerTotal > 21){
	System.out.println("Player Loses");
	cont = false;
	System.exit(0);
}
	if(PlayerTotal < 21){
		
}
							
}	
		
//DEALER
//both card are revealed
System.out.println("Dealer's Hand: "+ DealerHand.get(0) +" "+ DealerHand.get(1));
DealerTotal = obj.DealerHandTotal();
System.out.println("Dealers Hand Total "+ DealerTotal);
//dealer keeps hitting until hand total is atleast 17 
while(DealerTotal < 17){
	obj.DealerDrawCard();
	DealerTotal = obj.DealerHandTotal();
	}
//current dealer's hand
System.out.print("Dealer's Hand:");
for(int s = 0; s < DealerHand.size(); s++){
	
	System.out.print(" "+ DealerHand.get(s)+" ");}
System.out.println("");
System.out.println("Dealer's Hand Total " + DealerTotal);
//winner determination 
if(DealerTotal > 21){
	System.out.println("Player Wins");
	System.exit(0);
}

if(DealerTotal < PlayerTotal){
	System.out.println("Player Wins");
	System.exit(0);
}

if(DealerTotal > PlayerTotal){
	System.out.println("Dealer Wins");
	System.exit(0);
}

if (DealerTotal == PlayerTotal){
	System.out.println("Tie!");
	System.exit(0);
}
	}
}}

