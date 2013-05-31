package ikrs.json;

/**
 * @author Ikaros Kappler
 * @date 2013-05-31
 * @version 1.0.0
 **/

import java.util.List;
import java.util.Map;


public interface JSONValue {

    /**
     * This is a public shared instance that should be used for JSON null.
     **/
    public static final JSONNull NULL     = new JSONNull();
    
    /**
     * This is a public shared instance that should be used for JSON true.
     **/
    public static final JSONBoolean TRUE  = new JSONBoolean(true);
    
    /**
     * This is a public shared instance that should be used for JSON false.
     **/
    public static final JSONBoolean FALSE = new JSONBoolean(false);


    /**
     * The constant indicating null.
     **/
    public static final int TYPE_NULL     = 0;

    /**
     * The type constant for numbers.
     **/
    public static final int TYPE_NUMBER   = 1;
    
    /**
     * The type constant for boolean values.
     **/
    public static final int TYPE_BOOLEAN  = 2;
    
    /**
     * The type constant for strings.
     **/
    public static final int TYPE_STRING   = 3;

    /**
     * The type constant for arrays.
     **/
    public static final int TYPE_ARRAY    = 4;

    /**
     * The type constant for objects.
     **/
    public static final int TYPE_OBJECT   = 5;

    
    /**
     * This method indicates if this is JSON NULL.
     *
     * @return true if this JSON value is NULL (null).
     **/
    public boolean isNull();
    
    /**
     * This method indicates if this JSON value is a number.
     *
     * @return true if this value represents a number.
     **/
    public boolean isNumber();

    /**
     * This method indicates if this JSON value is a boolean.
     *
     * @return true if this value represents a boolean value.
     **/
    public boolean isBoolean();
    
    /**
     * This method indicates if this JSON value is a string.
     *
     * @return true if this value represents a string.
     **/
    public boolean isString();
    
    /**
     * This method indicates if this JSON value is an array.
     *
     * @return true if this value represents an array.
     **/
    public boolean isArray();

    /**
     * This method indicates if this JSON value is an object.
     *
     * @return true if this value represents an array.
     **/
    public boolean isObject();
    
    /**
     * Get the number from this JSON value.
     *
     * @return The number from this JSON value.
     * @throws JSONException If this value does not represent a number.
     **/
    public Number getNumber()
	throws JSONException;
    
    /**
     * Get the boolean from this JSON value.
     *
     * @return The boolean value from this JSON value.
     * @throws JSONException If this value does not represent a boolean value.
     **/
    public Boolean getBoolean()
	throws JSONException;

    /**
     * Get the string from this JSON value.
     *
     * @return The string value from this JSON value.
     * @throws JSONException If this value does not represent a string.
     **/
    public String getString()
	throws JSONException;

    /**
     * Get the array value as a List from this JSON value.
     *
     * @return The array from this JSON value. The array is returned as a Mist.
     * @throws JSONException If this value does not represent an array.
     **/
    public List<JSONValue> getArray()
	throws JSONException;

    /**
     * Get the object value as a Map from this JSON value.
     *
     * @return The object from this JSON value. The object is returned as a Map.
     * @throws JSONException If this value does not represent an object.
     **/
    public Map<String,JSONValue> getObject()
	throws JSONException;

    
}