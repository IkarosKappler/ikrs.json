package ikrs.json;

/**
 * @author Ikaros Kappler
 * @date 2013-05-31
 * @version 1.0.0
 **/

import java.util.List;
import java.util.Map;


public abstract class AbstractJSONValue 
    implements JSONValue {

    /**
     * The type of this value.
     **/
    private int type;

    
    protected AbstractJSONValue( int type ) 
	throws IllegalArgumentException {

	super();

	if( !this.isValidTypeID(type) )
	    throw new IllegalArgumentException( "Invalid JSON type ID (" + type + ")." );
	
	this.type = type;
    }
    
    /**
     * This method indicates if this JSON value is a number.
     *
     * @return true if this value represents a number.
     **/
    public boolean isNumber() {
	return this.type == JSONValue.TYPE_NUMBER;
    }

    /**
     * This method indicates if this JSON value is a boolean.
     *
     * @return true if this value represents a boolean value.
     **/
    public boolean isBoolean() {
	return this.type == JSONValue.TYPE_BOOLEAN;
    }
    
    /**
     * This method indicates if this JSON value is a string.
     *
     * @return true if this value represents a string.
     **/
    public boolean isString() {
	return this.type == JSONValue.TYPE_STRING;
    }
    
    /**
     * This method indicates if this JSON value is an array.
     *
     * @return true if this value represents an array.
     **/
    public boolean isArray() {
	return this.type == JSONValue.TYPE_ARRAY;
    }

    /**
     * This method indicates if this JSON value is an object.
     *
     * @return true if this value represents an array.
     **/
    public boolean isObject() {
	return this.type == JSONValue.TYPE_OBJECT;
    }
    
    //--- BEGIN ------------------- Prepare override methods ---------------------------
    /**
     * This method indicates if this is JSON NULL.
     *
     * @return true if this JSON value is NULL (null).
     **/
    public boolean isNull() {
	return this.type == JSONValue.TYPE_NULL;
    }

    /**
     * Get the number from this JSON value.
     *
     * @return The number from this JSON value.
     * @throws JSONException If this value does not represent a number.
     **/
    public Number getNumber()
	throws JSONException {
	
	throw new JSONException( "JSON value is not a number." );
    }
    
    /**
     * Get the boolean from this JSON value.
     *
     * @return The boolean value from this JSON value.
     * @throws JSONException If this value does not represent a boolean value.
     **/
    public Boolean getBoolean()
	throws JSONException {
	
	throw new JSONException( "JSON value is not a boolean value." );
    }

    /**
     * Get the string from this JSON value.
     *
     * @return The string value from this JSON value.
     * @throws JSONException If this value does not represent a string.
     **/
    public String getString()
	throws JSONException {
	
	throw new JSONException( "JSON value is not a string." );
    }

    /**
     * Get the array value as a List from this JSON value.
     *
     * @return The array from this JSON value. The array is returned as a Mist.
     * @throws JSONException If this value does not represent an array.
     **/
    public List<JSONValue> getArray()
	throws JSONException {
	
	throw new JSONException( "JSON value is not an array." );
    }

    /**
     * Get the object value as a Map from this JSON value.
     *
     * @return The object from this JSON value. The object is returned as a Map.
     * @throws JSONException If this value does not represent an object.
     **/
    public Map<String,JSONValue> getObject()
	throws JSONException {
	
	throw new JSONException( "JSON value is not an object." );
    }
    //--- END --------------------- Prepare override methods ---------------------------
    
    /**
     * This method indicates if the passed type ID is supported by this class.
     *
     * @param type The type ID.
     * @return true If the passed type ID is supported by this class
     **/
    public boolean isValidTypeID( int type ) {
	return (type >= JSONValue.TYPE_NULL && type <= JSONValue.TYPE_OBJECT);
    }
}