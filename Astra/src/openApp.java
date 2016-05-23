import java.io.*;
public class openApp 
{
	public static void main(String [] args)
	{
		Runtime run = Runtime.getRuntime();
		try
		{
			Process p = run.exec("G:/SVP/Sony/Vegas Pro 13.0/vegas130");
		} catch (Exception E)
		{
			E.printStackTrace();
		}

	}
}
