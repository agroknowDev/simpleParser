package net.zettadata.simpleparser;

import java.util.ArrayList;

public class SimpleMetadataFactory 
{
	public static final String MODS = "mods" ;
	public static String AKIF = "akif" ;
	public static String LOM = "lom" ;
	public static String NSDL = "nsdl" ;
	public static String DC = "dc" ;
	public static String AGRIF = "agrif" ;

    public static SimpleMetadata getSimpleMetadata(String metadataType)
            throws ParserException
    {
    	SimpleMetadata sm = null ;
        if ( LOM.equals( metadataType ) )
        {
            sm = new SimpleLOM ();
        }
        else
        {
            if ( NSDL.equals( metadataType ) )
            {
                sm = new SimpleNSDL ();
            } 
            else if ( DC.equals( metadataType ) )
			{
				sm = new SimpleDC() ;
			}
			else if ( AKIF.equals( metadataType ) )
			{
				sm = new SimpleAKIF() ;
			}
			else if ( MODS.equals( metadataType ) )
			{
				sm = new SimpleMODS() ;
			}
			else if ( AGRIF.equals( metadataType ) )
			{
				sm = new SimpleAGRIF() ;
			}
			else
			{
				throw new ParserException( "Unsupported Metadata Format : \"" 
				                                                        + metadataType
						                                                + "\" !" ) ;
			}
        }
        return sm ;
    }

    private static ArrayList<String> supportedMetadataTypes;

    public static boolean isValidMetadataType( String metadataType )
    {
        if (supportedMetadataTypes == null)
        {
            supportedMetadataTypes = new ArrayList<String>() ;
            supportedMetadataTypes.add( LOM ) ;
            supportedMetadataTypes.add( NSDL ) ;
            supportedMetadataTypes.add( DC ) ;
            supportedMetadataTypes.add( AKIF ) ;
        }
        return supportedMetadataTypes.contains( metadataType ) ;
    }
}

