import java.text.DecimalFormat;
import java.text.MessageFormat;

import javax.swing.JFrame;


public class StopWatchHelper extends JFrame{

	private int Hours;
	private int Minutes;
	private int Seconds;
	private int Milliseconds;
	
	public StopWatchHelper() {
		Hours = 0;
		Minutes = 0;
		Seconds = 0;
		Milliseconds = 0;
		increaseMilSeconds();
	}
	public String DisplayStopWatch(){
		
		MessageFormat mf = new MessageFormat("{0}:{1}:{2}:{3} ");
		DecimalFormat df = new DecimalFormat("00");
		
        Object[] objs = {df.format(Hours), df.format(Minutes), df.format(Seconds),df.format(Milliseconds)};
        return mf.format(objs);
	}
	
	public void increaseMilSeconds(){
		
		Milliseconds++;
        if (Milliseconds > 99){
        	Milliseconds = 0;
            increaseSeconds();
        }
    }

    public void increaseSeconds(){
        Seconds++;
        if(Seconds >= 60){
            Seconds = 0;
            increaseMinutes();
        }
    }

    public void increaseMinutes(){
        Minutes++;
        if(Minutes >= 60){
            Minutes = 0;
            increaseHours();
        }
    }

    public void increaseHours(){
        Hours++;
        if(Hours >= 99){
            Hours = 0;
        }
    }

    public void resetClock(){
        Hours = 0;
        Minutes = 0;
        Seconds = 0;
        Milliseconds = 0;
    }
	
}

