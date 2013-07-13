package net.zettadata.simpleparser ;
public class ParserException extends java.lang.Exception 
{

	private String message ;
	
	public ParserException( String message ) 
	{
		super() ;
		this.message = message ;
	}

	public String getMessage()
	{
		return message ;
	}

}
