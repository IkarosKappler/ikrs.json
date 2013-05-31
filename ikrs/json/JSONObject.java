package ikrs.json;

/**
 * This is the JSON object subclass.
 *
 * @author Ikaros Kappler
 * @date 2013-05-31
 * @version 1.0.0
 **/

import java.util.Map;


public class JSONObject
    extends AbstractJSONValue {


    /**
     * The array value (as a List) if this JSON value (must not be null).
     **/
    private Map<String,JSONValue> map;



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


    public String toString() {
	return this.map.toString();
    }

}