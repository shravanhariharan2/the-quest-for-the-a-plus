import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;



public class SchoolSimulator {

	JFrame frame;
	JTextArea plot;
	JLabel title;
	JLabel inventory;
	JLabel inv1, inv2;
	JLabel hpDisp;
	JLabel hpNum;
	JPanel titlePanel;
	JPanel startPanel;
	JPanel mainPanel;
	JPanel buttonPanel;
	JPanel hpPanel;
	JPanel invPanel;
	JTextArea mainText;
	Container cont;
	
	JButton start;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	
	double cash;
	String item1, item2;
	String location;

	ChoiceHandler ch = new ChoiceHandler();
	TitleListener tl = new TitleListener();
	CloseListener cl = new CloseListener();
	
	boolean hasSpace = false;
	boolean hasNoMoney = false;
	boolean hasKey = false;
	boolean isDesperate = false;
	boolean unique = false;
	boolean encounteredPizzaKid = false;
	boolean encounteredFred = false;
	boolean fredRunning = false;
	boolean has20 = false;
	boolean knowsPassword = false;
	String[] rps;
	String[] food;
	String ans;
	String winStatus;
	int randomNumber;
	int randomAns;
	int correctNum;
	int correctPos;
	
	public void setUp(){
		frame = new JFrame("The Quest for the Undeserved A+");
		frame.setSize(800,600);
		frame.getContentPane().setBackground(Color.white);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		cont = frame.getContentPane();
		
		titlePanel = new JPanel();
		titlePanel.setBounds(100, 100, 600, 150);
		titlePanel.setBackground(Color.white);
		
		
		title = new JLabel("The Quest for the A+", SwingConstants.CENTER);
		title.setFont(new Font("Verdana", Font.PLAIN, 54));
		title.setForeground(Color.black);
		
		startPanel = new JPanel();
		startPanel.setBounds(300,400,200,100);
		startPanel.setBackground(Color.white);
	
		start = new JButton("START");
		start.setBackground(Color.white);
		start.setForeground(Color.black);
		start.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		start.setFocusPainted(false);
		start.addActionListener(tl);
		
		
		titlePanel.add(title);
		startPanel.add(start);
		
		cont.add(titlePanel);
		cont.add(startPanel);
		
		frame.setVisible(true);
		
	}
	
	public void gameScreen(){
		titlePanel.setVisible(false);
		startPanel.setVisible(false);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(100, 100, 600, 250);
		mainPanel.setBackground(Color.white);
		cont.add(mainPanel);
		
		mainText = new JTextArea();
		mainText.setBounds(100,100,600,250);
		mainText.setBackground(Color.white);
		mainText.setForeground(Color.black);
		mainText.setEditable(false);
		mainText.setFont(new Font("Verdana", Font.PLAIN, 22));
		mainText.setLineWrap(true);
		
		mainPanel.add(mainText);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(350,350,300,150);
		buttonPanel.setBackground(Color.white);
		buttonPanel.setForeground(Color.black);
		buttonPanel.setLayout(new GridLayout(4,1));
		
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b3.setBackground(Color.white);
		b3.setForeground(Color.black);
		b4.setBackground(Color.white);
		b4.setForeground(Color.black);
		
		b1.setFont(new Font("Verdana", Font.PLAIN, 16));
		buttonPanel.add(b1);
		b1.setFocusPainted(false);
		b1.addActionListener(ch);
		b1.setActionCommand("b1");
		b2.setFont(new Font("Verdana", Font.PLAIN, 16));
		buttonPanel.add(b2);
		b2.setFocusPainted(false);
		b2.addActionListener(ch);
		b2.setActionCommand("b2");
		b3.setFont(new Font("Verdana", Font.PLAIN, 16));
		buttonPanel.add(b3);
		b3.setFocusPainted(false);
		b3.addActionListener(ch);
		b3.setActionCommand("b3");
		b4.setFont(new Font("Verdana", Font.PLAIN, 16));
		buttonPanel.add(b4);
		b4.setFocusPainted(false);
		b4.addActionListener(ch);
		b4.setActionCommand("b4");
		
		hpPanel = new JPanel();
		hpPanel.setBounds(100,15,300,50);
		hpPanel.setBackground(Color.white);
		hpPanel.setForeground(Color.black);
		hpPanel.setLayout(new GridLayout(1,2));
		
		hpDisp = new JLabel("Cash:");
		hpDisp.setBackground(Color.white);
		hpDisp.setForeground(Color.black);
		hpDisp.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		hpPanel.add(hpDisp);
		
		hpNum = new JLabel();
		hpNum.setBackground(Color.white);
		hpNum.setForeground(Color.black);
		hpNum.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		hpPanel.add(hpNum);
		
		invPanel = new JPanel();
		invPanel.setBounds(25, 325, 200, 300);
		invPanel.setBackground(Color.white);
		invPanel.setForeground(Color.black);
		invPanel.setLayout(new GridLayout(4,1));
		
		inventory = new JLabel("Pocket Items: ");
		inventory.setBackground(Color.white);
		inventory.setForeground(Color.black);
		inventory.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		invPanel.add(inventory);
		
		inv1 = new JLabel();
		inv1.setBackground(Color.white);
		inv1.setForeground(Color.black);
		inv1.setFont(new Font("Verdana", Font.PLAIN, 20));
		invPanel.add(inv1);
		
		inv2 = new JLabel("2. " + item2);
		inv2.setBackground(Color.white);
		inv2.setForeground(Color.black);
		inv2.setFont(new Font("Verdana", Font.PLAIN, 20));
		invPanel.add(inv2);
	
		statusSetup();
		firstClass();
		
		cont.add(buttonPanel);
		cont.add(mainPanel);
		cont.add(hpPanel);
		cont.add(invPanel);
	}
	
	public void statusSetup(){
		cash = 10.00;
		item1 = "none";
		item2 = "none";
		hpNum.setText("$" + cash + "0");
		inv1.setText("1. " + item1);
		inv2.setText("2. " + item2);
	}
	
	public void statusRefresh(double cashIn, String i1, String i2) {
		if(cashIn <= 0){
			cashIn = 0;
		}
		cash = cashIn;
		item1 = i1;
		item2 = i2;
		hpNum.setText("$" + cash + "0");
		inv1.setText("1. " + item1);
		inv2.setText("2. " + item2);
	}
	
	//game over
	public void lose(){
		location = "lost";
		mainText.setFont(new Font("Verdana", Font.PLAIN, 40));
		mainText.setText("You lose!\nChoose an option.");
		b1.addActionListener(cl);
		b1.setText("Quit");
		b2.setText("Restart");
	}
	
	
	//first position
	public void firstClass(){
		location = "classroom";
		mainText.setFont(new Font("Verdana", Font.PLAIN, 22));
		statusSetup();
		mainText.setText("Welcome! You are currently in your 4th period class, and you are currently very restless as you have a B- \nin the class."
				+ " The school year is almost over, and"
				+ " you and your parents both know that you won't get away \nwith having a B-. What will you do?");
		b1.removeActionListener(cl);
		b1.setText("Ask to use restroom.");
		b2.setText("Talk to your buddy next to you.");
		b3.setText("Ask how teacher's day was.");
		b4.setText("Sleep");
		
	}
	//1st pos 1st option
	public void askRest() {
		location = "usingRest";
		mainText.setText("Teacher: Yes, you? Ugh, if you really have to. \nHonestly, you shouldn't be missing class time "
				+ "with\nyour current grade. Just leave.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	//1st pos 2nd option
	public void talkBuddy() {
		location = "talkBuddy";
		mainText.setText("You talk to your friend next to you.\n\nTeacher: Hey you! I don't want to have to talk over\nyou! With your grade, I wouldn't be conversing with\nother people...");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	//1st pos 3rd option
	public void askDay() {
		location = "askDay";
		mainText.setText("Teacher: Yes? Why the hell are you asking that \nquestion right now? Can't you see that I'm teaching aclass right now?"
				+ " God, students like you piss me off. \nBy the way, my day is going terribly, thank you for \nasking.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
		
	}
	//1st pos 4th option
	public void sleep(){
		location = "sleep";
		mainText.setText("You: *falls asleep* \n\nTeacher: Hey! What are you doing? Pay attention! \nThis kid thinks they're so smart, huh...");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	//once leaving for the restroom

	//at restroom
	public void goRestroom(){
		location = "restroom";
		mainText.setText("You: Gosh, what is wrong with the teacher today?\nI just wanna stay here and not go back."
				+ "\n\nAs you walk to the restroom, a kid throws a spoon at you."
				+ "\n\nKid: This is my restroom! Get out!");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void obtainSpoon() {
		location = "hasSpoon";
		item1 = "spoon";
		statusRefresh(cash, item1, item2);
		mainText.setText("You pick up the spoon. \n\nYou: Hey, what was that for? Did someone use this \nspoon?"
				+ "\n\nKid: Leave before I beat you to a pulp. Can't you see I'm busy?");
		b1.setText("Leave");
		b2.setText("Stay");
		b3.setText("");
		b4.setText("");
	}
	
	//COME BACK TO THIS WHEN DONE!!!!!!!!!
	
	public void stayKid() {
		location = "stayKid";
		mainText.setText("Kid: Nah, Imma kick you out. You're not worth \nfighting. A kid with a B- like you doesn't deserve a \nfight.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	

	public void leaveKid() {
		location = "leaveKid";
		mainText.setText("Kid: That's what I thought. A scrub like you \nwith a B- can't put up a fight");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	//after spoon
	
	
	public void outsideRest() {
		location = "outsideRest";
		mainText.setText("You to yourself: How the hell "
				+ "does everyone know \nthat I have a B-? Well, I have a spoon now, I need topee, "
				+ "and the teacher will probably roast me when I \ncome back. What am I supposed to do now?");
		b1.setText("Go back to class");
		b2.setText("Go to vending machine");
		b3.setText("Climb and sit on the roof");
		b4.setText("Go to library");
	}
	
	public void backToClass(){
		location = "backToClass";
		mainText.setText("You proceed to go back to class and get verbally \ndestroyed by your teacher.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void goVending() {
		location = "vending";
		mainText.setText("You are now at the vending machine.\n\nWhat are you going to buy? ");
		b1.setText("Chips: $2");
		b2.setText("Water: $1");
		b3.setText("A life: $1,000,000");
		b4.setText("Leave");
	}
	
	public void chips(){
		location = "chips";
		cash -= 2;
		if(cash < 0){
			mainText.setText("You do not have enough money!");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
			cash +=2;
		}
		else {
			item2 = "chips bag";
			statusRefresh(cash, item1, item2);
			mainText.setText("You proceed to buy and eat chips, and decide to \nkeep the bag.\n\nYou now have $" + cash + "0 remaining");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
	}
	
	public void water(){
		location = "water";
		cash -= 1;
		if(cash < 0){
			mainText.setText("You do not have enough money!");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
			cash++;
		}
		else{
			item2 = "empty bottle";
			statusRefresh(cash, item1, item2);
			mainText.setText("You proceed to buy and drink the water.\n\nYou now have $" + cash + "0 remaining");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
	}
	
	public void aLife(){
		location = "aLife";
		mainText.setText("You: Boy do I need one of these.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void sitRoof() {
		location = "roof";
		mainText.setText("You: For some reason, I just feel like sitting on the \nroof. I wonder if I'll get caught."
				+ "\n\n *You proceed to sit on the roof of a classroom \nbuilding without getting caught.* ");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void seeKey() {
		location = "seeKey";
		mainText.setText("You are looking around while on the roof and happen to see a key lying on the ground in the distance."
				+ " It \nlooks like it's near a bunch of garbage cans.");
		b1.setText("Go back down");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	
	public void goLibrary(){
		location = "goLibrary";
		mainText.setText("You proceed to go to the library using the main route,but you see some teachers walking around."
				+ " It does \nnot look like you should go that way. How do you \nwant to go to the library now? ");
		b1.setText("Keep going straight");
		b2.setText("Go through the crossroads");
		b3.setText("Go around the field");
		b4.setText("Go back to restroom");
	}
	
	public void goStraight(){
		location = "goStraight";
		mainText.setText("You proceed forward. \n\nTeacher: Hey you! What are you doing? You're in \ndeep trouble, little kid!!!");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void goCrossroads(){
		location = "crossroads";
		mainText.setText("You are now at the crossroads. \n\nWhere would you like to go?");
		b1.setText("Back to previous location");
		b2.setText("Back to class");
		b3.setText("Forward to library");
		b4.setText("Field");
	}
	
	public void goField(){
		location = "field";
		mainText.setText("You are now at a relatively large field. \n\nWhere would you like to go?");
		b1.setText("Back to previous location");
		b2.setText("Back to class");
		b3.setText("Forward to library");
		b4.setText("Crossroads");
	}
	
	public void goInLibrary(){
		location = "inLibrary";
		mainText.setText("You are now in the library, and there are no \nteachers around. \n\nWhat would you like to do?");
		b1.setText("Go back to field");
		b2.setText("Go back to crossroads");
		b3.setText("Go to computers");
		b4.setText("");
	}
	
	public void goComputers(){
		location = "goComputers";
		mainText.setText("As you approach the computers, a boy sitting \ngets up and asks you something."
				+ "\n\nBoy: Hey, you! Do you have a spare water bottle\nthat I can use? I need it for a project in my next \nclass.");
		b1.setText("Sorry, I don't have one");
		b2.setText("");
		b3.setText("");
		b4.setText("");
		if(item2.equals("empty bottle")){
			b2.setText("Give empty bottle");
			b3.setText("");
			b4.setText("");
		}
	}
	
	public void noBottle(){
		location = "noBottle";
		mainText.setText("You: Hmm... where can I find a water bottle?\nMaybe one is sold somewhere?");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void giveBottle(){
		location = "giveBottle";
		item2 = "none";
		statusRefresh(cash, item1, item2);
		mainText.setText("You give the boy your empty bottle.\n\nBoy: Wow, thanks dude! Here's something in return."
				+ "\n\nThe boy handed you some candy.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
		
	}
	
	public void afterBottleKid(){
		location = "afterBottleKid";
		item2 = "candy";
		statusRefresh(cash, item1, item2);
		mainText.setText("You: I wonder why there's a kid here and it's still 4thperiod.\n\n*Lunch bell rings*"
				+ "\n\nYou: Aw man, there's no point going back to class, \nthe teacher is going to eat me alive. And my grade.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void leavingLibrary(){
		location = "leavingLibrary";
		mainText.setText("You are now outside the library, and it is lunch time. Where would you like to go?");
		b1.setText("Back to class");
		b2.setText("Towards office");
		b3.setText("Towards garbage area");
		b4.setText("Towards cafeteria");
	}
	
	public void towardsOffice(){
		location = "towardsOffice";
		if(fredRunning){
			mainText.setText("Quick! Fred is still running around, you \nshould go into the office!");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
		else{
			mainText.setText("You walk towards the administration office, but stop because there are too many teachers outside."
				+ "\nYou think to yourself: Maybe I can change my grade using the admin computer."	
				+ " But how can I do \nthat?");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
	}
	
	public void towardsGarbage(){
		location = "towardsGarbage";
		if(item1.equals("none") || item2.equals("none")){
			hasSpace = true;
			mainText.setText("You walk towards the garbage area. Something \nis glistening on the ground.\nIt looks like a key."
					+ "\nMaybe it could be used to open some door. \n\nYou pick up the key");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
		else {
			mainText.setText("You walk towards the garbage area.\nSomething is glistening on the ground."
				+ "It looks like a key.\n\nHowever, you don't have any space to hold it, so you walk back to the library entrance.");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
	}
	
	public void pickUpKey(){
		location = "pickUpKey";
		if(item1.equals("none"))
			item1 = "key";
		else
			item2 = "key";
		statusRefresh(cash, item1, item2);
		mainText.setText("You picked up the key and walk back to the library \nentrance.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");	
		
	}
	//stopped here
	public void towardsCafeteria(){
		location = "towardsCafeteria";
		mainText.setText("As you walk to the cafeteria, you see that there's a \nlot of interesting stuff going on.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void cafeteria(){
		location = "cafeteria";
		mainText.setText("You are right outside the cafeteria, and several, \ninteresting activities are going on among your fellow \npeers. What would you like to do?");
		b1.setText("Walk inside cafeteria");
		b2.setText("Go to gambler");
		b3.setText("Go to 'Fat Fred'");
		b4.setText("Go back to library");
	}
	
	public void goInCafeteria(){
		location = "inCafeteria";
		if(encounteredPizzaKid){
			mainText.setText("You walk into the cafeteria. What will you do?");
			b1.setText("Go to pizza kid");
			b2.setText("Go to 'Sketchy Shravan'");
			b3.setText("Go to 'Nice Nancy'");
			b4.setText("Leave");
		}
		else{
			mainText.setText("You walk into the cafeteria, but you are not \ninterested in eat anything due to your anxiety."
				+ "\n\nHowever, you see a person alone crying. What will \nyou do?");
			b1.setText("Walk to him");
			b2.setText("Leave");
			b3.setText("");
			b4.setText("");
		}
	}
	//pizza kid
	public void helpKid(){
		location = "helpKid";
		mainText.setText("You walk towards the kid and ask what's the problem"
				+ "\nKid: I dropped my only spoon, and now I can't eat \nmy soup!!"
				+ "\n\nYou think to yourself: Bruh I thought he had a B in a class or something that devastating, not something \nas dumb as this.");
		b1.setText("Give spoon");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void giveSpoon(){
		location = "giveSpoon";
		item1 = "none";
		statusRefresh(cash, item1, item2);
		encounteredPizzaKid = true;
		mainText.setText("Kid: Oh my, thanks my dude!! I friggin, like, LOVE \nyou bruh. Here, have this.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	//after encounter
	public void talkPizzaKid(){
		location = "pizzaKid";
		mainText.setText("Kid: Oh hey dude what's up?");
		b1.setText("Leave");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void giveYouFood(){
		location = "giveYouFood";
		item1 = "pizza";
		statusRefresh(cash, item1, item2);
		mainText.setText("You recieve a slice of pizza from the kid.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	//sketchy shravy
	public void goSketchy(){
		location = "sketchyShravan";
		mainText.setText("Sketchy Shravan: Whatup dude, you got any sketchystories to tell me?"
				+ "\n\nIf you tell me a good one, I'll tell you mine!");
		b1.setText("I have a B-");
		b2.setText("I gave someone a used spoon");
		b3.setText("I am not cooler than you");
		b4.setText("I gave a kid an empty bottle");
	}
	
	public void tellB(){
		location = "tellB";
		mainText.setText("Sketchy Shravan: Oh thats pretty sketch, but not \nsketchy enough. Try again.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void tellSpoon(){
		location = "tellSpoon";
		knowsPassword = true;
		mainText.setText("Sketchy Shravan: Holy hell dude now that's sketchy. Here's my story: "
				+ "I met this kid who said he had the\nadmin password to all the computers! He said he'll"
				+ "\ntell me it if I ate an entire doorknob. Which I gladly\ndid, of course. Oh, here's the password "
				+ "by the way. \nIt's 'i_never_get_Bs'");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void afterPass(){
		location = "afterPass";
		mainText.setText("You to yourself: God dangit why does everything \nhave to be about grades. Well, at least I know "
				+ "the \nadmin password, for whatever it's worth"
				+ "\n\nYou: Thanks, Sketchy Shravan!"
				+ "\n\nSketchy Shravan: I gotchu fam. Stay sketch.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	public void notCooler(){
		location = "notCooler";
		mainText.setText("Sketchy Shravan: Bruh that's not sketchy. We all \nknow that's hella true. Try again");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void gaveBottle(){
		location = "gaveBottle";
		mainText.setText("Sketchy Shravan: Ehh... I've heard worse. \nNot sketchy enough.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void goNancy(){
		location = "goNancy";
		mainText.setText("Nice Nancy: Hello, dear! I can help you with financial problems, "
				+ "only if you are absolutely in need!");
		b1.setText("Ask for money");
		b2.setText("Leave");
		b3.setText("");
		b4.setText("");
	}
	
	public void askMoney(){
		if(cash == 0)
			isDesperate = true;
		else
			isDesperate = false;
		location = "askMoney";
		if(isDesperate){	
			mainText.setText("Nice Nancy: Here you go dear! I'm rich and white so I have a lot of money on me! "
					+ "Come whenever you absolutely need more!");
			cash+= 10;
			statusRefresh(cash, item1, item2);
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
		else{
			mainText.setText("Nice Nancy: Sorry dear, but it doesn't look like you \nABSOLUTELY need money!");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
	}
	
	public void goGambler(){
		location = "goGambler";
		mainText.setText("You go up to the notorious gambler, 'Gambler Greg'."
				+ "\n\nGambler Greg: What do you want kid? You gonna \nplay or what?"
				+ "\n\n$2 to play, get $5 or $10 if you win depending\non the game.");
		b1.setText("Rock, Paper, Scissors - $5");
		b2.setText("Number between 1 and 20 - $10");
		b3.setText("");
		b4.setText("Leave");
	}
	
	public void rps(){
		location = "rps";
		cash-=2;
		statusRefresh(cash, item1, item2);
		if(cash < 0){
			mainText.setText("You do not have enough money to play!");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
			cash+=2;
			statusRefresh(cash, item1, item2);
		}
		rps = new String[3];
		rps[0] = "rock"; rps[1] = "paper"; rps[2] = "scissors";
		randomAns = (int)(Math.random()*3);
		statusRefresh(cash, item1, item2);
		mainText.setText("Rock, paper, or scissors?");
		b1.setText("Rock");
		b2.setText("Paper");
		b3.setText("Scissors");
		b4.setText("");
	}
	
	public void rpsRematch(){
		location = "rpsRematch";
		rps = new String[3];
		rps[0] = "rock"; rps[1] = "paper"; rps[2] = "scissors";
		randomAns = (int)(Math.random()*3);
		statusRefresh(cash, item1, item2);
		mainText.setText("Rock, paper, or scissors?");
		b1.setText("Rock");
		b2.setText("Paper");
		b3.setText("Scissors");
		b4.setText("");
	}
	
	public void rpsEnd(){
		location = "rpsEnd";
		if((randomNumber == 0 && randomAns == 1) || (randomNumber == 1 && randomAns == 2) || (randomNumber ==2 && randomAns == 0)){
			mainText.setText("Gambler Greg picked " + rps[randomAns] + " and you picked " + rps[randomNumber] + "!"
					+ "\n\nYou lose!");
			winStatus = "lose";
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
		else if((randomNumber == 1 && randomAns == 0) || (randomNumber == 2 && randomAns == 1) || (randomNumber == 0 && randomAns == 2)){
			mainText.setText("Gambler Greg picked " + rps[randomAns] + " and you picked " + rps[randomNumber] + "!"
					+ "\n\nYou win!");
			winStatus = "win";
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
			cash+=5;
			statusRefresh(cash, item1, item2);
		}
		else{
			mainText.setText("Gambler Greg picked " + rps[randomAns] + " and you picked " + rps[randomNumber] + "!"
					+ "\n\nIt's a tie! You get to play again with no cost.");
			winStatus = "tie";
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
	}
	
	public void numberGame(){
		cash-=2;
		statusRefresh(cash, item1, item2);
		if(cash < 0){
			mainText.setText("You do not have enough money to play!");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
			cash+=2;
			statusRefresh(cash, item1, item2);
		}
		location = "numberGame";
		
		
		correctNum = (int) (Math.random() * 20 + 1);
		correctPos = (int) (Math.random() * 4 + 1);
		int othernum1 = (int)(Math.random() * 20 + 1);
		int othernum2 = (int)(Math.random() * 20 + 1);
		int othernum3 = (int)(Math.random() * 20 + 1); 
		mainText.setText("Gambler Greg: I am thinking of a number between 1-20. What number is it?");
		if(correctPos == 1){
			b1.setText("" + correctNum);
			b2.setText("" + othernum1);
			b3.setText("" + othernum2);
			b4.setText("" + othernum3);
		}
		else if(correctPos == 2){
			b2.setText("" + correctNum);
			b1.setText("" + othernum1);
			b3.setText("" + othernum2);
			b4.setText("" + othernum3);
		}
		else if(correctPos == 3){
			b3.setText("" + correctNum);
			b1.setText("" + othernum1);
			b3.setText("" + othernum2);
			b4.setText("" + othernum3);
		}
		else{
			b4.setText("" + correctNum);
			b2.setText("" + othernum1);
			b3.setText("" + othernum2);
			b1.setText("" + othernum3);
		}
	}
	
	public void numberWin(){
		location = "numberWin";
		mainText.setText("You guessed the right number!");
		cash += 10;
		statusRefresh(cash, item1, item2);
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void numberLose(){
		location = "numberWin";
		mainText.setText("You guessed the wrong number!");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void fatFred(){
		location = "fatFred";
		if(encounteredFred){
			mainText.setText("Fat Fred: You already know what you gotta do. Give me food so that I can help you! Oh hey, homie. You \ngot the money?");
			b1.setText("Yes");
			b2.setText("No");
			b3.setText("");
			b4.setText("");
		}
		else if(fredRunning){
			mainText.setText("Fat Fred is not available because he is running around shirtless.");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
		else{
			mainText.setText("Fat Fred: You already know what you gotta do. Give me food so that I can help you!");
			b1.setText("Give food");
			b2.setText("Leave");
			b3.setText("");
			b4.setText("");
		}
	}
	
	public void leaveFred(){
		location = "leaveFred";
		mainText.setText("Fat Fred: Wow man not cool...");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	
	public void giveFood(){
		location = "giveFood";
		item2 = "none";
		statusRefresh(cash,item1,item2);
		mainText.setText("You give him your candy. \n\nFat Fred: Gimme gimme!! Ok kid, what do you need help with?");
		b1.setText("How do I get an A?");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void fredAdvice(){
		location = "fredAdvice";
		mainText.setText("Fat Fred: Homie, there's not much time left in the \nschool year. I think your best bet is"
				+ " to cheat your \nway, like maybe changing the grades in the admin \nsystem. You gotta sneak your way into the office. \n"
				+ "I can help you out, only if you pay me though. $20 \nand I'll make a distraction for the admins so you can \nenter peacefully.");
		b1.setText("Deal");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void dealFred(){
		location = "dealFred";
		encounteredFred = true;
		mainText.setText("Fat Fred: You got yourself a deal. Come back when \nyou got the money, bro. "
				+ "By the way, I saw a key \nlying around near the garbage collection area. Maybe it could be of use to you.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void give20(){
		location = "give20";
		if(cash < 20){
			has20 = false;
			mainText.setText("Fat Fred: Homie I know you don't got the money. \nStop lying man.");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
		else{
			cash-=20;
			has20 = true;
			fredRunning = true;
			statusRefresh(cash,item1,item2);
			mainText.setText("Fat Fred: I knew you could pull through homie. You \nneed a distraction, right? I'll help you out."
					+ "\n\nFat Fred takes off his shirt, showing the world his \nglorious upper body and proceeds to run towards the \noffice."
					+ " You see all the admins leave the office and runtowards Fat Fred to stop him.");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
	}
	public void no20(){
		location = "no20";
		mainText.setText("Fat Fred: Ok homie, but come back once you do.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	public void breachOffice(){
		location = "office";
		mainText.setText("You proceed to run into the office. However, the \nmain admin's door seems to be locked!");
		if(item1.equals("key") || item2.equals("key")){
			hasKey = true;
			b1.setText("Use key");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
		else{
			hasKey = false;
			b1.setText("Go back");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
	}
	
	public void useKey(){
		location = "adminOffice";
		if(knowsPassword){
			mainText.setText("You are now in the admin office! You run up to the \ncomputer, and type in the password"
					+ " that Sketchy \nShravan told you. Man, is he a savior.");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
		else{	
			mainText.setText("You are now in the admin office! You run up to the computer,\nbut it is locked! You don't know the password,"
					+ "and the admins\nare coming back! It's too late!");
			b1.setText(">");
			b2.setText("");
			b3.setText("");
			b4.setText("");
		}
	}
	
	public void changeGrade(){
		location = "changeGrade";
		mainText.setText("You now have full access to everyone's grades. You \ngo to your gradebook and look at the B-."
				+ "You think to\nyourself: Wow, am I going to get in trouble if anyone finds this out. \n\nLuckily, no one does, and your"
				+ "grade in the class is \nnow an A+. Both you and your parents are incredibly \nhappy. Mission accomplished.");
		b1.setText(">");
		b2.setText("");
		b3.setText("");
		b4.setText("");
	}
	
	public void gameEnd(){
		location = "gameEnd";
		mainText.setFont(new Font("Verdana", Font.PLAIN, 50));
		mainText.setText("You win! Thanks for \nplaying!");
		frame.remove(buttonPanel);
		frame.remove(hpPanel);
		frame.remove(invPanel);
		frame.repaint();
		
	}
	class TitleListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			gameScreen();
		}
		
	}
	
	class CloseListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}
		
	}
	class ChoiceHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
	
			String c = e.getActionCommand();
			
			switch(location){
			
			case "lost":
				switch(c){
				case "b1": break;
				case "b2": firstClass(); break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			//classroom branch
			
			case "classroom":
				switch(c){
				case "b1": askRest(); break;
				case "b2": talkBuddy(); break;
				case "b3": askDay(); break;
				case "b4": sleep(); break;
				}
				break;
			case "usingRest":
				switch(c){
				case "b1": goRestroom(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}	
				break;
			case "talkBuddy":
				switch(c){
				case "b1": firstClass(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			case "askDay":
				switch(c){
				case "b1": firstClass(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			case "sleep":
				switch(c){
				case "b1": firstClass(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
				//restroom branch
			case "restroom":
				switch(c){
				case "b1": obtainSpoon(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
				//spoon and bully branch
			case "hasSpoon":
				switch(c){
				case "b1": leaveKid(); break;
				case "b2": stayKid(); break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "stayKid":
				switch(c){
				case "b1": outsideRest(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;	
			
			case "leaveKid":
				switch(c){
				case "b1": outsideRest(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "outsideRest":
				switch(c){
				case "b1": backToClass(); break;
				case "b2": goVending(); break;
				case "b3": sitRoof(); break;
				case "b4": goLibrary(); break;
				}
				break;
				
			case "backToClass":
				switch(c){
				case "b1": lose(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			case "vending":
				switch(c){
				case "b1": chips(); break;
				case "b2": water(); break;
				case "b3": aLife(); break;
				case "b4": outsideRest(); break;
				}
				break;
			
			case "chips":
				switch(c){
				case "b1": goVending(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "water":
				switch(c){
				case "b1": goVending(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "aLife":
				switch(c){
				case "b1": goVending(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;	
			
			case "roof":
				switch(c){
				case "b1": seeKey(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "seeKey":
				switch(c){
				case "b1": outsideRest(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "goLibrary":
				switch(c){
				case "b1": goStraight(); break;
				case "b2": goCrossroads(); break;
				case "b3": goField(); break;
				case "b4": outsideRest(); break;
				}
				break;	
				
			case "goStraight":
				switch(c){
				case "b1": lose(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;	
			
			case "crossroads":
				switch(c){
				case "b1": goLibrary(); break;
				case "b2": backToClass(); break;
				case "b3": goInLibrary(); break;
				case "b4": goField(); break;
				}
				break;
				
			case "field":
				switch(c){
				case "b1": goLibrary(); break;
				case "b2": backToClass(); break;
				case "b3": goInLibrary(); break;
				case "b4": goCrossroads(); break;
				}
				break;
			
			case "inLibrary":
				switch(c){
				case "b1": goField(); break;
				case "b2": goCrossroads(); break;
				case "b3": goComputers(); break;
				case "b4": break;
				}
				break;
				
			case "goComputers":
				switch(c){
				case "b1": noBottle(); break;
				case "b2": 
					if(b2.getText().equals("Give empty bottle")){
						giveBottle(); break;
					}
					break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "noBottle":
				switch(c){
				case "b1": goInLibrary(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "giveBottle":
				switch(c){
				case "b1": afterBottleKid(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;	
				
			case "afterBottleKid":
				switch(c){
				case "b1": leavingLibrary(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "leavingLibrary":
				switch(c){
				case "b1": backToClass(); break;
				case "b2": towardsOffice(); break;
				case "b3": towardsGarbage(); break;
				case "b4": towardsCafeteria(); break;
				}
				break;
				
			case "towardsOffice":
				switch(c){
				case "b1": 
					if(fredRunning)
						breachOffice();
					else
						leavingLibrary(); 
					break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;	
			
			case "towardsGarbage":
				switch(c){
				case "b1": 
					if(hasSpace)
						pickUpKey();
					else
						leavingLibrary();
					break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "pickUpKey":
				switch(c){
				case "b1": leavingLibrary(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "towardsCafeteria":
				switch(c){
				case "b1": cafeteria(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "cafeteria":
				switch(c){
				case "b1": goInCafeteria(); break;
				case "b2": goGambler(); break;
				case "b3": fatFred(); break;
				case "b4": leavingLibrary(); break;
				}
				break;
				
			case "inCafeteria":
				switch(c){
				case "b1": 
					if(encounteredPizzaKid)
						talkPizzaKid();
					else
						helpKid();
					break;
				case "b2": 
					if(encounteredPizzaKid)
						goSketchy();
					else
						cafeteria();
					break;
				case "b3": 
					if(encounteredPizzaKid)
						goNancy();
					break;
				case "b4": 
					if(encounteredPizzaKid)
						cafeteria();
					break;
				}
				break;
			
			case "pizzaKid":
				switch(c){
				case "b1": goInCafeteria(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "helpKid":
				switch(c){
				case "b1": giveSpoon(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "giveSpoon":
				switch(c){
				case "b1": giveYouFood(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "giveYouFood":
				switch(c){
				case "b1": goInCafeteria(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "sketchyShravan":
				switch(c){
				case "b1": tellB(); break;
				case "b2": tellSpoon(); break;
				case "b3": notCooler(); break;
				case "b4": gaveBottle(); break;
				}
				break;
			
			case "tellB":
				switch(c){
				case "b1": goSketchy(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "tellSpoon":
				switch(c){
				case "b1": afterPass(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "afterPass":
				switch(c){
				case "b1": goInCafeteria(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "notCooler":
				switch(c){
				case "b1": goSketchy(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "gaveBottle":
				switch(c){
				case "b1": goSketchy(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "goNancy":
				switch(c){
				case "b1": askMoney(); break;
				case "b2": goInCafeteria(); break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "askMoney":
				switch(c){
				case "b1": goNancy(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "goGambler":
				switch(c){
				case "b1": rps(); break;
				case "b2": numberGame(); break;
				case "b3": break;
				case "b4": cafeteria(); break;
				}
				break;	
				
			case "rps":
				switch(c){
				case "b1": randomNumber = 0; rpsEnd(); break;
				case "b2": randomNumber = 1; rpsEnd(); break;
				case "b3": randomNumber = 2; rpsEnd(); break;
				case "b4": break;
				}
				break;
			
			case "rpsRematch":
				switch(c){
				case "b1": randomNumber = 0; rpsEnd(); break;
				case "b2": randomNumber = 1; rpsEnd(); break;
				case "b3": randomNumber = 2; rpsEnd(); break;
				case "b4": break;
				}
				break;
				
			case "rpsEnd":
				switch(c){
				case "b1": 
					if(winStatus.equals("tie"))
						rpsRematch();
					else
						goGambler();
					break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "numberGame":
				switch(c){
				case "b1": 
					if(correctPos == 1)
						numberWin();
					else
						numberLose();
					break;
				case "b2": 
					if(correctPos == 2)
						numberWin();
					else
						numberLose();
					break;
				case "b3": 
					if(correctPos == 3)
						numberWin();
					else
						numberLose();
					break;
				case "b4": 
					if(correctPos == 4)
						numberWin();
					else
						numberLose();
					break;
				}
				break;
			
			case "numberWin":
				switch(c){
				case "b1": goGambler(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
					
			case "numberLose":
				switch(c){
				case "b1": goGambler(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "fatFred":
				switch(c){
				case "b1": 
					if(encounteredFred)
						give20();
					else if(fredRunning)
						cafeteria();
					else
						giveFood();
					break;
				case "b2": 
					if(encounteredFred)
						no20();
					else
						leaveFred();
					break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "giveFood":
				switch(c){
				case "b1": fredAdvice(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "fredAdvice":
				switch(c){
				case "b1": dealFred(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "dealFred":
				switch(c){
				case "b1": cafeteria(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "leaveFred":
				switch(c){
				case "b1": cafeteria(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			case "give20":
				switch(c){
				case "b1": 
					if(has20)
						breachOffice();
					else
						cafeteria();
					break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			
			case "no20":
				switch(c){
				case "b1": cafeteria(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "office":
				switch(c){
				case "b1": 
					if(hasKey)
						useKey();
					else
						leavingLibrary();
					break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "adminOffice":
				switch(c){
				case "b1": 
					if(knowsPassword)
						changeGrade(); 
					else
						lose(); 
					break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
				
			case "changeGrade":
				switch(c){
				case "b1": gameEnd(); break;
				case "b2": break;
				case "b3": break;
				case "b4": break;
				}
				break;
			}
			}

			}
	
}