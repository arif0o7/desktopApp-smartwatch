import java.text.DecimalFormat;
import java.text.MessageFormat;


public class CountdownHelper {

	
	public int Hours;
    public int Minutes;
    public int Seconds;
    public int hour;
    public int min;


    public void setCountdownHour(String h){
        hour = Integer.parseInt(h);
    }
    public int getCountdownHour(){
        return hour;
    }
    public void setCountdownMin(String m){
        min = Integer.parseInt(m);
    }

    public int getCountdownMin(){
        return min;
    }

    public void values(){

        Hours = getCountdownHour();
        Minutes = getCountdownMin();
        Seconds = 0;

    }


    public void decrease(){

        if (Hours != 0 || Minutes != 0 || Seconds != 0){
            Seconds--;
            if (Seconds < 0){
                Minutes--;
                Seconds=59;
                if(Minutes < 0){
                    Hours--;
                    Minutes = 0;

                }
            }

        }
    }
    
    public String displayTime(){
    	
    	
        MessageFormat mf = new MessageFormat("{0}:{1}:{2}");
        DecimalFormat df = new DecimalFormat("00");
        Object[] objs = {df.format(Hours), df.format(Minutes), df.format(Seconds)};
        return mf.format(objs);
    }
}