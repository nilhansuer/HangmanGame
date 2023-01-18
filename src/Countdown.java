

public class Countdown {

	private int hour;
	private int minute;
	private int second;
	
	public Countdown(){}
	
	public Countdown(int h){
		this(h,0,0);
	}
	
	public Countdown(int h,int m){
		this(h,m,0);
	}

	public Countdown(int h,int m,int s){
		
		settime(h,m,s);
	}
	
	
	public void settime(int h,int m,int s){

		sethour(h);
		setminute(m);
		setsecond(s);
		
	}
	
	public void sethour(int h){
		hour=((h>=0 && h<24)?h:0);
	}
	
	
	public void setminute(int m){
		minute=((m>=0 && m<60)?m:0);
	}
	
	public void setsecond(int s){
		second=((s>=0 && s<60)?s:0);
	}
	
	public int gethour(){
		return hour;
	}
	
	public int getminute(){
		return minute;
	}
	
	public int getsecond(){
		return second;
	}


	public void dechour(){
		int h=gethour()-1;
		
		if(h>=0)
			hour=h;
		
		else
			hour=23;
			
	}
	
	public void decminute(){
		
		int m=getminute()-1;

		if(m>=0)
			minute=m;
		
		else
			{minute=59;
			dechour();
			}
		
	}
	
	public void decsecond(){
		
		int s=getsecond()-1;

		if(s>=0)
			second=s;
		
		else
			{second=59;
			decminute();
			}
		
	}
	
	
	
	public String toString(){
		return String.format("%02d:%02d:%02d\n",gethour(),getminute(),getsecond());
	}
	
	public String printminsec(){
		return String.format("%02d:%02d\n",getminute(),getsecond());

	}
	
	public int sec(){
		return (gethour()*3600)+(getminute()*60)+getsecond();
	}
	
	
}
