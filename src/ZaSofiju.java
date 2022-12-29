import java.util.Scanner;

public class ZaSofiju {

	public static void main(String[] args) {
		
		Scanner loadIn = new Scanner(System.in);
		System.out.println("Please input JMBG for validation");
		String jmbg = loadIn.next();
		if (checkGeneral(jmbg)&&checkLength(jmbg)&&checkDayValidation(jmbg)&&checkK(jmbg)&&checkMonthValidation(jmbg)){
			System.out.println("JMBG is valid");
			outputPoliticalRegion(jmbg);
			gender(jmbg);
		}
		else System.err.println("JMBG is not valid");
		loadIn.close();
	}
	static boolean checkGeneral (String x) {
		boolean s=true;
		try { Long.parseLong(x); }
		catch (Exception e) {
			 s=false; System.err.println("This is not numeric!");
		}
		return s;
	}
	
	static boolean checkLength (String x) {
		boolean s=false;
		if (x.length()==13) s=true;		
		return s;
	}
	
	static int day (String x) {
		return Integer.parseInt(x.substring(0,2));
	}
    
	static int month (String x) {
		return Integer.parseInt(x.substring(2,4));
	}
	static int year (String x) {
		return Integer.parseInt (x.substring(4,7));
	}
	static int bbb (String x) {
		return Integer.parseInt(x.substring(9,12));
	}
	static int k (String x) {
		return Integer.parseInt(x.substring(12));
	}
		
	static boolean checkDayValidation (String x) {
		boolean s=true;
		if (day(x)<1||day(x)>31) s=false;
		return s;
	}
	static boolean checkMonthValidation (String x) {
		boolean s=true;
		if (month(x)==2) {
			if (year(x)%4==0) {
				if (day(x)>29) s=false;
				
			}
			else { if (day(x)>28) s=false; }
		}
		if ((month(x)==4||month(x)==6||month(x)==9||month(x)==11)&& day(x)==31) s=false;
		if (month(x)>12) s=false;
		return s;
	}
	
	static int rr (String x) {
		return Integer.parseInt(x.substring(7,9));
	}
	
	static int politicalRegion(String x) {
		int i = -1;
		if (rr(x)>=0 && rr(x)<=9) i=0;
		else if (rr(x)>=10 && rr(x)<=19) i=1;
		else if (rr(x)>=20 && rr(x)<=29) i=2;
		else if (rr(x)>=30 && rr(x)<=39) i=3;
		else if (rr(x)>=40 && rr(x)<=49) i=4;
		else if (rr(x)>=50 && rr(x)<=59) i=5;
		else if (rr(x)>=60 && rr(x)<=69) i=6;
		else if (rr(x)>=70 && rr(x)<=79) i=7;
		else if (rr(x)>=80 && rr(x)<=89) i=8;
		else i=9;
		return i;
	}
	static void outputPoliticalRegion (String x) {
		switch (politicalRegion(x)) {
		
		case 0: System.out.println("Stranci bez drzavljanstva bivse SFRJ ili njenih naslednica");
		break;
		case 1: System.out.println("Bosna i Hercegovina");
		break;
		case 2: System.out.println("Crna Gora");
		break;
		case 3: System.out.println("Hrvatska");
		break;
		case 4: System.out.println("Makedonija");
		break;
		case 5: System.out.println("Slovenija");
		break;
		case 6: System.out.println("Nije korisceno iz neobjasnjivih razloga");
		break;
		case 7: System.out.println("Centralna Srbija");
		break;
		case 8: System.out.println("Autonomna pokrajina Vojvodina");
		break;
		case 9: System.out.println("Autonomna pokrajina Kosovo i Metohija");
		break;
		default: System.out.println("Something is wrong!");
		
		}
	}
	static void gender (String x) {
		if (bbb(x)<=499) System.out.println("Male");
		else System.out.println("Female");
	}
	static int calculation (String x) {
		int p=0;
		p= 11-((7*(Integer.parseInt(x.substring(0,1))+Integer.parseInt(x.substring(6,7)))+
				6*(Integer.parseInt(x.substring(1,2))+Integer.parseInt(x.substring(7,8)))+
			5*(Integer.parseInt(x.substring(2,3))+Integer.parseInt(x.substring(8,9)))+
			4*(Integer.parseInt(x.substring(3,4))+Integer.parseInt(x.substring(9,10)))+
			3*(Integer.parseInt(x.substring(4,5))+Integer.parseInt(x.substring(10,11)))+
			2*(Integer.parseInt(x.substring(5,6))+Integer.parseInt(x.substring(11,12)))))%11;
		if (p>9) p=0;
		return p;		
						
	}
	static boolean checkK (String x) {
		boolean s=false;
		if (k(x)==calculation(x)) s=true;
		return s;
	}
	
}
