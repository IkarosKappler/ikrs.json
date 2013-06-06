package ikrs.json;

/**
 * This is the JSON boolean subclass.
 *
 * @author Ikaros Kappler
 * @date 2013-05-31
 * @version 1.0.0
 **/

public class JSONBoolean
    extends AbstractJSONValue {


    /**
     * The boolean value if this JSON value (must not be null).
     **/
    private Boolean bool;



    /**
     * Create a new JSON boolean.
     * 
     * @param bool The boolean value this JSON value should have.
     **/
    public JSONBoolean( Boolean bool ) 
	throws NullPointerException {

	super( JSONValue.TYPE_BOOLEAN );

	if( bool == null )
	    throw new NullPointerException( "Cannot create a JSON boolean from null." );
	
	this.bool = bool;
    }


    /**
     * Get the boolean from this JSON value.
     *
     * @return The boolean value from this JSON value.
     * @throws JSONException If this value does not represent a boolean value.
     **/
    @Override
    public Boolean getBoolean()
	throws JSONException {
	
	return this.bool;
    }


    public String toString() {
	return this.bool.toString();
    }
}