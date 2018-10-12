import java.applet.Applet;
import java.applet.AudioClip;


public class Sound {
	
	private AudioClip clip;
	
	public Sound() {
		try{
			clip = Applet.newAudioClip(Sound.class.getResource("/sound.wav"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void play(){
		try{
			new Thread(){
				public void run(){
					clip.play();
				}
			}.start();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
