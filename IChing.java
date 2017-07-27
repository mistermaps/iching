import java.util.Scanner;
import java.lang.Math;
public class IChing {
static boolean done = false;
	public static void main(String[] args) {
	boolean tao = false; //false being yang, unbroken; true being yin, broken
	boolean changing = false; //whether line is stable or changing, false: no, true: yes
	boolean change = false; //whether there are changing lines
	boolean first = false;
	int num = 0;
	int t = 6;
	int i = 0;
	int a = 0;
	Scanner input = new Scanner(System.in);
	Line[] line = new Line[12];
	System.out.println("Welcome to The Oracle!\nThis is a program to simulate throwing the I Ching.");
	System.out.println("Press y to toss coins.");
	do{
		System.out.print("Toss coins?\t");
		String sel = input.next();
	if(sel.equalsIgnoreCase("y") || sel.equalsIgnoreCase("yes")){//creation of lines from user input
		line[t] = new Line();
		num = line[t].setLine(num);
		tao = line[t].getTao();
		changing = line[t].getChanging();
		line[t].getLine(tao, changing);
		t--;
		}
	}while( t > 0);

	System.out.println("\n\nFirst/Lower Trigram:");
	Trigram trigram1 = new Trigram(line[4].getTao(), line[5].getTao(), line[6].getTao());
	trigram1.getTrigramLine();
	System.out.println("\n\nSecond/Upper Trigram:");
	Trigram trigram2 = new Trigram(line[1].getTao(), line[2].getTao(), line[3].getTao());
	trigram2.getTrigramLine();

	System.out.println("\n\n");//formating

	do{//print hexagram; if changing line received, use methods to change values and print
		if(first != true){
			System.out.println("First Hexagram:");
			Hexagram hexagram1 = new Hexagram(trigram1.getCount(), trigram2.getCount());
			hexagram1.getHexagram();
	}
		if(first == true && change == true){
			System.out.println("Changing Hexagram:");
	}
	for(i = 0; i < 6; i++){
	a++;
	if(changing){
		change = true;
	}
	if(first != true){
		changing = line[a].getChanging();
		line[a].getLine(tao, changing);
	}else if(first == true && change == true){
		num = line[a].getValue();
		num = line[a].change();
		line[a].setLine(num);
		tao = line[a].getTao();
		changing = line[a].getChanging();
		line[a].getLine(tao, changing);
	line[a].getTao();
	}
	}
	System.out.println("\n\n\n");//formatting
		setDone(change, first);//check conditions of changing and first
		a = 0;
		i = 0;//reset values
		first = true;

	}while(done == false);
	if(change){
for(i = 1; i <= 6; i++){
line[i].change();
}
System.out.println("First Trigram after change:");
Trigram trigram3 = new Trigram(line[4].getTao(), line[5].getTao(), line[6].getTao());
trigram3.getTrigramLine();
System.out.println("\n\nSecond Trigram after change:");
Trigram trigram4 = new Trigram(line[1].getTao(), line[2].getTao(), line[3].getTao());
trigram4.getTrigramLine();
Hexagram hexagram2 = new Hexagram(trigram3.getCount(), trigram4.getCount());
hexagram2.getHexagram();

}
	}//main
//methods

static boolean setDone(boolean c, boolean f){
if(c == true && f == false){
	done = false;
} else {
	done = true;
}
	return done;
}
//line class
public static class Line {
int trigram;
boolean tao;
boolean changing;
int value = setValue();

public Line(){
}

private static int setValue(){
int value = (int)(Math.random() * 4 + 6);
return value;
}

int getValue(){//get method
return value;
}

boolean getTao(){//get method
return tao;
}

boolean getChanging(){//get method
return changing;
}

int setLine(int n){//sets boolean values based on random number
n = value;
if(value == 6){
	tao = true;
	changing = true;
} else if(value == 7){
	tao = false;
	changing = false;
} else if(value == 8){
	tao = true;
	changing = false;
} else if(value == 9){
	tao = false;
	changing = true;
}
return value;
}

int change(){//method for changing value of number if changing line
	if(value == 6){ //changing broken
		value = 7; //solid
	}
	if(value == 9){ //changing solid
		value = 8;//broken
	}
	if(value == 7){
		value = 7;
	}
	if(value == 8){
		value = 8;
	}
getValue();
return value;
}

void getLine(boolean t, boolean c)
{
t = tao;
c = changing;
setLine(value);
	if(t == true && c == true){
	System.out.print("---  --- +\n");//6
} else if(t == false && c == false){
	System.out.print("--------\n");//7
} else if(t == true && c == false){
	System.out.print("---  ---\n");//8
} else if(t == false && c == true){
	System.out.print("-------- +\n");//9
}
}//getLine()
}//main
}//eof
