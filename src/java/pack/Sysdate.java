/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Sysdate
{
	Calendar calendar = new GregorianCalendar();
	public String getCurrDate()
	{
		String currDate="";
		//currDate="Current Date :";
		currDate+=calendar.get(Calendar.YEAR);
		if((calendar.get(Calendar.MONTH)+1)<10)
			currDate+="0"+(calendar.get(Calendar.MONTH)+1);
		else
			currDate+=(calendar.get(Calendar.MONTH)+1);	
		if((calendar.get(Calendar.DATE))<10)	
			currDate+="0"+calendar.get(Calendar.DATE);
		else
			currDate+=calendar.get(Calendar.DATE);
		if((calendar.get(Calendar.HOUR))<10)
			currDate+="0"+calendar.get(Calendar.HOUR);
		else
			currDate+=calendar.get(Calendar.HOUR);
		
		if((calendar.get(Calendar.MINUTE))<10)
			currDate+="0"+calendar.get(Calendar.MINUTE);
		else
			currDate+=calendar.get(Calendar.MINUTE);
		
		if((calendar.get(Calendar.SECOND))<10)
			currDate+="0"+calendar.get(Calendar.SECOND);
		else
			currDate+=calendar.get(Calendar.SECOND);
		currDate+=calendar.get(Calendar.AM_PM);
		return currDate;
	}
}