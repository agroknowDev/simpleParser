package net.zettadata.simpleparser;

import java.util.Set;

public abstract class SimpleMetadata 
{
		Set<String> locations;
		Set<String> identifiers;

		
		public abstract void load( String pathtometadata ) throws ParserException ;
		
		public Set<String> getLocations() {
			return locations;
		}

		public void setLocations(Set<String> locations) {
			this.locations = locations;
		}

		public Set<String> getIdentifiers() {
			return identifiers;
		}

		public void setIdentifiers(Set<String> identifiers) {
			this.identifiers = identifiers;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder() ;
			sb.append("Identifiers:\n") ;
			for (String identifier : identifiers)
			{
				sb.append( identifier + "\n") ;
			}
			sb.append("Locations:\n") ;
			for (String location : locations)
			{
				sb.append( location + "\n") ;
			}
			return sb.toString();
			
		}
		
	}
