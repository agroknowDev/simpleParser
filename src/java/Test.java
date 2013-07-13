
import java.io.File;

import net.zettadata.simpleparser.ParserException;
import net.zettadata.simpleparser.SimpleMetadata;
import net.zettadata.simpleparser.SimpleMetadataFactory;

public class Test {

	public static final String ROOT_FOLDER = "/Users/dmssrt/home/projects/agroKnow/agroService" ; 
	public static final String LOM_FOLDER = ROOT_FOLDER + File.separator + "simpleParser" + File.separator + "metadata" + File.separator + "LOMs" + File.separator ;
	public static final String AKIF_FOLDER = ROOT_FOLDER + File.separator + "simpleParser" + File.separator + "metadata" + File.separator + "AKIFs" + File.separator ;
	public static final String NSDL_FOLDER = ROOT_FOLDER + File.separator + "simpleParser" + File.separator + "metadata" + File.separator + "NSDLs" + File.separator ;
	public static final String DC_FOLDER = ROOT_FOLDER + File.separator + "simpleParser" + File.separator + "metadata" + File.separator + "DCs" + File.separator ;
	public static final String MODS_FOLDER = ROOT_FOLDER + File.separator + "simpleParser" + File.separator + "metadata" + File.separator + "MODSs" + File.separator ;
	
	public static void main( String[] args )
	{
		System.out.println( "TO USE THIS PROGRAM, set ROOT_FOLDER to the path of the directory" +
				" in which you unzip this package" ) ;
		SimpleMetadata sm ;
		try 
		{
			sm = SimpleMetadataFactory.getSimpleMetadata( SimpleMetadataFactory.MODS ) ;
			sm.load( MODS_FOLDER + "1.xml" ) ;
			System.out.println( sm.toString() ) ;
		}
		catch (ParserException e) 
		{
				e.printStackTrace() ;
		}
	}
	
}

