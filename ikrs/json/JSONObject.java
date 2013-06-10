package ikrs.json;

/**
 * This is the JSON object subclass.
 *
 * @author Ikaros Kappler
 * @date 2013-05-31
 * @modified 2013-06-04 Ikaros Kappler (added the write method for JSON serialisation).
 * @modified 2013-06-04 Ikaros Kappler (added constructor with empty param list).
 * @version 1.0.2
 **/

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class JSONObject
    extends AbstractJSONValue {


    /**
     * The array value (as a List) if this JSON value (must not be null).
     **/
    private Map<String,JSONValue> map;

    
    /**
     * Create a new JSON object.
     *
     * The constructor creates a new Map (TreeMap).
     **/
    public JSONObject() {
	super( JSONValue.TYPE_OBJECT );
	
	this.map = new TreeMap<String,JSONValue>();
    }

    /**
     * Create a new JSON object.
     * 
     * @param object The object value this JSON value should have.
     **/
    public JSONObject( Map<String,JSONValue> object ) 
	throws NullPointerException {

	super( JSONValue.TYPE_OBJECT );

	if( object == null )
	    throw new NullPointerException( "Cannot create a JSON object from null." );
	
	this.map = object;
    }


    /**
     * Get the object value as a Map from this JSON value.
     *
     * @return The object from this JSON value. The object is returned as a Map.
     * @throws JSONException If this value does not represent an object.
     **/
    @Override
    public Map<String,JSONValue> getObject()
	throws JSONException {
	
	return this.map;
    }


    /**
     * This method tries to convert this JSONValue into a JSONObject.
     *
     * If that is not possible (because the contained value does not represent
     * an object in any way) the method will throw an JSONException.
     *
     * @return This JSON value as a JSON object.
     * @throws JSONException If this value is not convertible to an object.
     **/
    @Override
    public JSONObject asJSONObject()
	throws JSONException {

	return this;
    }


    /**
     * This method MUST write a valid JSON value to the passed writer.
     *
     * @param writer The writer to write to.
     * @throws IOException If any IO errors occur.
     **/
    @Override
    public void write( Writer writer )
	throws IOException {

	writer.write( "{" );

	Iterator<Map.Entry<String,JSONValue>> iter = this.map.entrySet().iterator();
	int i = 0;
	while( iter.hasNext() ) {
	    
	    if( i > 0 )
		writer.write( "," );
	    writer.write( " " );

	    Map.Entry<String,JSONValue> entry = iter.next();	    
	    JSONString.writeJSON( writer, entry.getKey() );

	    writer.write( ": " );

	    entry.getValue().write( writer );

	    i++;
	}

	if( i > 0 )
	    writer.write( " " );

	writer.write( "}" );
	
    }

    /**
     * This method is a copy of getObject(), but with two differences:
     * it is protected (only for subclasses) and does not thrown any exceptions.
     *
     * Note that this method does not create a copy of the internal map, so
     * changes to the map reflect this JSONObject!
     *
     * @return The internal map, which is never null.
     **/
    protected Map<String,JSONValue> getMap() {
	return this.map;
    }

    public String toString() {
	return this.getClass().getName() + "=" + this.map.toString();
    }

}