package net.zettadata.simpleparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SimpleNSDL extends SimpleMetadata 
{

	@Override
	public void load(String pathtometadata) throws ParserException 
	{	
		File file = new File( pathtometadata ) ;
		FileReader fr ;
		try 
		{
			fr = new FileReader( file ) ;
		} 
		catch (FileNotFoundException e) 
		{
			throw new ParserException( e.getMessage() ) ;
		}
		NSDLParser parser = new NSDLParser( fr ) ;
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
