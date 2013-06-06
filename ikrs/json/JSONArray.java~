package ikrs.json;

/**
 * This is the JSON array subclass.
 *
 * @author Ikaros Kappler
 * @date 2013-05-31
 * @version 1.0.0
 **/

import java.util.List;


public class JSONArray
    extends AbstractJSONValue {


    /**
     * The array value (as a List) if this JSON value (must not be null).
     **/
    private List<JSONValue> list;



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


    public String toString() {
	return this.list.toString();
    }

}