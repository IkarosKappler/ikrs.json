package ikrs.json;

/**
 * This is the JSON boolean subclass.
 *
 * @author Ikaros Kappler
 * @date 2013-05-31
 * @modified 2013-06-04 Ikaros Kappler (added the write method for JSON serialisation).
 * @version 1.0.0
 **/

import java.io.IOException;
import java.io.Writer;


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


    /**
     * This method tries to convert this JSONValue into a JSONBoolean.
     *
     * If that is not possible (because the contained value does not represent
     * a boolean in any way) the method will throw an JSONException.
     *
     * @return This JSON value as a JSON boolean.
     * @throws JSONException If this value is not convertible to a boolean.
     **/
    @Override
    public JSONBoolean asJSONBoolean()
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
	
	if( this.bool.booleanValue() )
	    writer.write( "true" );
	else
	    writer.write( "false" );
    }
    

    public String toString() {
	return this.bool.toString();
    }
}