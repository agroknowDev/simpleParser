package net.zettadata.simpleparser;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class SimpleAGRIF extends SimpleMetadata {

	@Override
	public void load(String pathtometadata) throws ParserException 
	{
		File agrifFile = new File( pathtometadata ) ;
		String agrif = null ;
		try 
		{
			agrif =  FileUtils.readFileToString( agrifFile ) ;
		} 
		catch (IOException e) 
		{
			throw new ParserException( "Cannot read AGRIF file: " + e.getMessage() ) ;
		}
		JSONObject agrifObject = (JSONObject)JSONValue.parse( agrif ) ;
		identifiers = new HashSet<String>() ;
		if ( agrifObject.containsKey( "agrifIdentifier" ) )
		{
			String identifier = ((Long)agrifObject.get( "agrifIdentifier" )).toString() ;
			identifiers.add( identifier ) ;			
		}
		locations = new HashSet<String>() ;
		JSONArray expressions = (JSONArray)agrifObject.get( "expressions" ) ;
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
