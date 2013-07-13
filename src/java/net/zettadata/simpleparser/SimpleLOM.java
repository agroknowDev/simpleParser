package net.zettadata.simpleparser ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SimpleLOM extends SimpleMetadata
{
	
	public void load( String pathtolom ) throws ParserException
	{
		File lomFile = new File( pathtolom ) ;
		FileReader fr ;
		try 
		{
			fr = new FileReader( lomFile ) ;
		} 
		catch (FileNotFoundException e) 
		{
			throw new ParserException( e.getMessage() ) ;
		}
		LOMParser parser = new LOMParser( fr ) ;
		try 
		{
			// parse  configuration file
			parser.yylex() ;
		} 
		catch (IOException e) 
		{
			throw new ParserException( e.getMessage() ) ;
		}
		finally
		{
			try 
			{
				fr.close() ;
			} 
			catch (IOException e) 
			{
				throw new ParserException( e.getMessage() ) ;
			}
		}
		locations = parser.getLocations() ;
		identifiers = parser.getIdentifiers() ;
	}
}
