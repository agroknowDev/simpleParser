package net.zettadata.simpleparser;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class SimpleAKIF extends SimpleMetadata {

	@Override
	public void load(String pathtometadata) throws ParserException 
	{
		File akifFile = new File( pathtometadata ) ;
		String akif = null ;
		try 
		{
			akif =  FileUtils.readFileToString( akifFile ) ;
		} 
		catch (IOException e) 
		{
			throw new ParserException( "Cannot read AKIF file: " + e.getMessage() ) ;
		}
		JSONObject akifObject = (JSONObject)JSONValue.parse( akif ) ;
		String identifier = ((Long)akifObject.get( "identifier" )).toString() ;
		identifiers = new HashSet<String>() ;
		identifiers.add( identifier ) ;
		locations = new HashSet<String>() ;
		JSONArray expressions = (JSONArray)akifObject.get( "expressions" ) ;
		for ( Object expression: expressions )
		{
			JSONArray manifestations = (JSONArray)((JSONObject)expression).get( "manifestations" ) ;
			for ( Object manifestation: manifestations )
			{
				JSONArray items = (JSONArray)((JSONObject)manifestation).get( "items" ) ;
				for ( Object item: items )
				{
					locations.add( (String)((JSONObject)item).get( "url" ) ) ;
				}
			}
		}
	}

}
