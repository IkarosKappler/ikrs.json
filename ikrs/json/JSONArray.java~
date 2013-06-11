package ikrs.json;

/**
 * This is the JSON array subclass.
 *
 * @author Ikaros Kappler
 * @date 2013-05-31
 * @modified 2013-06-04 Ikaros Kappler (added the write method for JSON serialisation).
 * @modified 2013-06-04 Ikaros Kappler (added the constructor with empty param list).
 * @version 1.0.2
 **/

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class JSONArray
    extends AbstractJSONValue {


    /**
     * The array value (as a List) if this JSON value (must not be null).
     **/
    private List<JSONValue> list;


    /**
     * Creates a new empty JSON array backed by an internal ArrayList instance.
     **/
    public JSONArray() {
	super( JSONValue.TYPE_ARRAY );

	this.list = new ArrayList<JSONValue>(1);
    }

    /**
     * Create a new JSON array.
     * 
     * @param array The array value this JSON value should have.
     **/
    public JSONArray( List<JSONValue> array ) 
	throws NullPointerException {

	super( JSONValue.TYPE_ARRAY );

	if( array == null )
	    throw new NullPointerException( "Cannot create a JSON array from null." );
	
	this.list = array;
    }


    /**
     * Get the array value as a List from this JSON value.
     *
     * @return The array from this JSON value. The array is returned as a Mist.
     * @throws JSONException If this value does not represent an array.
     **/
    @Override
    public List<JSONValue> getArray()
	throws JSONException {
	
	return this.list;
    }


    /**
     * This method tries to convert this JSONValue into a JSONArray.
     *
     * If that is not possible (because the contained value does not represent
     * an array in any way) the method will throw an JSONException.
     *
     * @return This JSON value as a JSON array.
     * @throws JSONException If this value is not convertible to an array.
     **/
    @Override
    public JSONArray asJSONArray()
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

	writer.write( '[' );

	Iterator<JSONValue> iter = this.list.iterator();
	int i = 0;
	while( iter.hasNext() ) {

	    JSONValue v = iter.next();

	    if( i > 0 )
		writer.write( "," );
	    
	    writer.write( " " );
	    
	    v.write( writer );

	    i++;
	}
	
	if( i > 0 )
	    writer.write( " " );

	writer.write( ']' );
    }


    public String toString() {
	return this.getClass().getName() + "=" + this.list.toString();
    }

}