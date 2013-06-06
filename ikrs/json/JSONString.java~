package ikrs.json;

/**
 * This is the JSON string subclass.
 *
 * @author Ikaros Kappler
 * @date 2013-05-31
 * @version 1.0.0
 **/

public class JSONString
    extends AbstractJSONValue {


    /**
     * The string value if this JSON value (must not be null).
     **/
    private String string;



    /**
     * Create a new JSON string.
     * 
     * @param string The string value this JSON value should have.
     **/
    public JSONString( String string ) 
	throws NullPointerException {

	super( JSONValue.TYPE_STRING );

	if( string == null )
	    throw new NullPointerException( "Cannot create a JSON string from null." );
	
	this.string = string;
    }


    /**
     * Get the string from this JSON value.
     *
     * @return The string value from this JSON value.
     * @throws JSONException If this value does not represent a string.
     **/
    @Override
    public String getString()
	throws JSONException {
	
	return this.string;
    }


    /**
     * Note: this method does not (!) return a valid JSON string value!
     **/
    public String toString() {
	return this.string;
    }
}