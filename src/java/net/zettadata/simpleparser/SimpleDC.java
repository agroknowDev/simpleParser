package net.zettadata.simpleparser ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SimpleDC extends SimpleMetadata
{
	
	public void load( String pathtodc ) throws ParserException
	{
		File dcFile = new File( pathtodc ) ;
		FileReader fr ;
		try 
		{
			fr = new FileReader( dcFile ) ;
		} 
		catch (FileNotFoundException e) 
		{
			throw new ParserException( e.getMessage() ) ;
		}
		DCParser parser = new DCParser( fr ) ;
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
