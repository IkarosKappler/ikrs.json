package ikrs.json;

/**
 * This is the JSON number subclass.
 *
 * @author Ikaros Kappler
 * @date 2013-05-31
 * @modified 2013-06-04 Ikaros Kappler (added the write method for JSON serialisation).
 * @version 1.0.0
 **/

import java.io.IOException;
import java.io.Writer;

public class JSONNumber
    extends AbstractJSONValue {


    /**
     * The numeric value if this JSON value (must not be null).
     **/
    private Number number;



    /**
     * Create a new JSON number.
     * 
     * @param number The numeric value this JSON value should have.
     * @throws NullPointerException If number is null.
     **/
    public JSONNumber( Number number ) 
	throws NullPointerException {

	super( JSONValue.TYPE_NUMBER );

	if( number == null )
	    throw new NullPointerException( "Cannot create a JSON number from null." );
	
	this.number = number;
    }


    /**
     * Get the number from this JSON value.
     *
     * @return The number from this JSON value.
     * @throws JSONException If this value does not represent a number.
     **/
    @Override
    public Number getNumber()
	throws JSONException {
	
	return this.number;
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
	
	writer.write( this.number.toString() );
    }


    public String toString() {
	return this.number.toString();
    }
}