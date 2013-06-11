package ikrs.json.rpc;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

//import ikrs.json.JSONArray;
//import ikrs.json.JSONObject;
import ikrs.json.JSONException;
import ikrs.json.JSONValue;
import ikrs.json.parser.*;


/**
 * @author Ikaros Kappler
 * @date 2013-06-03
 * @version 1.0.0
 **/



public class JSONRPC {
    
    
    public JSONRPC() {
	super();
    }


    private void throwJSONRPCException( String msg ) 
	throws JSONRPCException {
	throw createJSONRPCException( msg );
    }
    
    private JSONRPCException createJSONRPCException( String msg ) {
	return new JSONRPCException( "Cannot handle JSON RPC request: " + msg );
    }

    public void doAnything( Integer i, String s, Boolean b ) {
	System.out.println( "DOING ANYTHING" );
	System.out.println( " integer param: " + i );
	System.out.println( " string param:  " + s );
	System.out.println( " boolean param: " + b );
    }
    
    public void doSomething() {
	System.out.println( "DO SOMETHING" );
    }
    
    
    public JSONRPCResponse execute( String jsonString ) 
	throws JSONSyntaxException,
	       JSONException,
	       JSONRPCException {

	try {
	    Reader reader = new StringReader( jsonString );
	    JSONRPCRequest request = this.buildRPCRequest( reader );
	    reader.close();
	    
	    return this.execute( request );
	} catch( IOException e ) {
	    throw new JSONRPCException( "Cannot read from json string: " + e.getMessage() );
	}

    }
    
    public JSONRPCResponse execute( JSONRPCRequest request ) 
	throws JSONRPCException,
	       JSONException {
	
	this.checkVersion(request);
	
	if( request.getMethod() == null || request.getMethod().isNull() )
	    throwJSONRPCException( "method argument is null." );
	if( !request.getMethod().isString() )
	    throwJSONRPCException( "method argument is not a string." );

	

	
	try {
	    // May throw JSONException
	    Class<?>[] paramClasses = this.createParamClassArray( request );
	    Object[] paramObjects   = this.createParamObjectArray( request );

	    /*
	    System.out.println( "Param classes: " );
	    if( paramClasses != null ) {
		for( int i = 0; i < paramClasses.length; i++ )
		    System.out.println( "[" + i + "] " + paramClasses[i].getName() );
	    }
	    */

	    // On which object to invoke the method?
	    // For testing purposes: this
	    Object invocationObject = this;
	    // ...


	    // Resolve method (may throw NoSuchMethodException or SecurityException)
	    Method method = invocationObject.getClass().getMethod( request.getMethod().getString(),
								   paramClasses 
								   );

	    Object result = method.invoke( invocationObject,
					   paramObjects
					   );
	    
	    return null;
	} catch( JSONException e ) {
	    throw new JSONRPCException( "JSONException: " + e.getMessage() );
	} catch( NoSuchMethodException e ) {
	    throw new JSONRPCException( "NoSuchMethodException: " + e.getMessage() );
	} catch( SecurityException e ) {
	    throw new JSONRPCException( "SecurityException: " + e.getMessage() );  
	} catch( IllegalAccessException e ) {
	    throw new JSONRPCException( "IllegalAccessException: " + e.getMessage() );
	} catch( IllegalArgumentException e ) {
	    throw new JSONRPCException( "IllegalArgumentException: " + e.getMessage() );
	} catch( InvocationTargetException e ) {
	    throw new JSONRPCException( "InvocationTargetException: " + e.getMessage() );
	}

    }

    private void checkVersion( JSONRPCRequest request ) 
	throws JSONRPCException,
	       JSONException {
	
	// Check version
	if( request.getVersion() == null )
	    throwJSONRPCException( "version is not present." );
	
	if( request.getVersion().isNull() )
	    throwJSONRPCException( "version is not specified." );
	
	if( !request.getVersion().isString() )
	    throwJSONRPCException( "version seems not to be a string." );
	
	// Due to the specification the version number should be EXACTLY "2.0" (a string!)
	//try {
	    if( !request.getVersion().asJSONString().getString().equals("2.0") ) {
	
		// Catch a regular JSON exception (=type exception)
		throwJSONRPCException( "bad version number: '" + request.getVersion().getNumber().toString() + "'." );

	    }
	    //} catch( JSONException e ) {
	    //throwJSONRPCException( "version is not a number." );
	    //}
	
    }

    /**
     * 
     **/
    private Class<?>[] createParamClassArray( JSONRPCRequest request ) 
	throws JSONException,
	       JSONRPCException {

	if( request.getParams() == null || request.getParams().isNull() )
	    return null;

	Class<?>[] paramClasses = null;
	if( request.getParams().isArray() ) {
	    // List<JSONValue> paramList = request.getParams().getArray();
	    paramClasses = new Class<?>[ request.getParams().getArray().size() ];
	    for( int i = 0; i < request.getParams().getArray().size(); i++ ) {
		JSONValue param = request.getParams().getArray().get(i);
		if( param.isNull() )
		    paramClasses[i] = Object.class;
		else if( param.isBoolean() )
		    paramClasses[i] = Boolean.class;
		else if( param.isNumber() ) 
		    paramClasses[i] = param.getNumber().getClass(); // Double or Integer
		else if( param.isString() )
		    paramClasses[i] = String.class;
		else 
		    throw new JSONRPCException( "datatype at param " + i +" is not supported in the param list." );
	    }
	    
	    return paramClasses;
	} else if( request.getParams().isObject() ) {
	    throw new JSONRPCException( "Sorry, param type 'object' is not yet implemented." );
	} else {
	    throw createJSONRPCException( "params must be an array or an object." );	    
	}
    }
    
    /**
     * 
     **/
    private Object[] createParamObjectArray( JSONRPCRequest request ) 
	throws JSONException,
	       JSONRPCException {
	
	if( request.getParams() == null || request.getParams().isNull() )
	    return null;

	Object[] paramObjects = null;
	if( request.getParams().isArray() ) {
	    // List<JSONValue> paramList = request.getParams().getArray();
	    paramObjects = new Object[ request.getParams().getArray().size() ];
	    for( int i = 0; i < request.getParams().getArray().size(); i++ ) {
		JSONValue param = request.getParams().getArray().get(i);
		if( param.isNull() )
		    paramObjects[i] = null;
		else if( param.isBoolean() )
		    paramObjects[i] = param.getBoolean();
		else if( param.isNumber() ) 
		    paramObjects[i] = param.getNumber(); // Double or Integer
		else if( param.isString() )
		    paramObjects[i] = param.getString();
		else 
		    throw new JSONRPCException( "datatype at param " + i +" is not supported in the param list." );
	    }
	    
	    return paramObjects;
	} else if( request.getParams().isObject() ) {
	    throw new JSONRPCException( "Sorry, param type 'object' is not yet implemented." );
	} else {
	    throw createJSONRPCException( "params must be an array or an object." );
	}
    }


    public JSONRPCRequest buildRPCRequest( Reader reader ) 
	throws JSONSyntaxException,
	       JSONException,
	       IOException {

	// Create JSONRPCValueFactory 
	JSONValueFactory factory = new JSONRPCValueFactory();	    

	// Initialising parser/builder 
	ConfigurableJSONBuilder b  = new ConfigurableJSONBuilder( reader, false, factory );
	
	// start the pasrer
	b.parse();

	JSONValue json = b.getResult();
	//System.out.println( "JSON object: " + json.toString() );
	
	if( !(json instanceof JSONRPCRequest) )
	    throw new JSONException( "Retrieved value is NOT an instance of JSONRPCRequest. Found: " + json.getClass().getName() );
	
	return (JSONRPCRequest)json;
    }

    /**
     * For testign purposes only.
     **/
    public static void main( String[] argv ) {

	try {
	    System.out.println( "Initializing the JSONRPC request ..." );

	    
	    ikrs.json.JSONArray params = new ikrs.json.JSONArray();
	    params.getArray().add( new ikrs.json.JSONNumber(new Integer(1)) );
	    params.getArray().add( new ikrs.json.JSONString("test_A") );
	    params.getArray().add( new ikrs.json.JSONBoolean(true) );
	    JSONRPCRequest request = new DefaultJSONRPCRequest( "doAnything",
								params,
								new Integer(1234)   // id
								);
	    System.out.println( request.toJSONString() );
	    

	    /*
	    ikrs.json.JSONArray params = new ikrs.json.JSONArray();
	    JSONRPCRequest request = new DefaultJSONRPCRequest( "doSomething",
								params,
								new Integer(5678)   // id
								);
	    System.out.println( request.toString() );
	    */
	    
	    System.out.println( "Creating JSONRPC ..." );
	    JSONRPC rpc = new JSONRPC();

	    System.out.println( "Executing the request ..." );
	    rpc.execute( request );

	    String requestString = "{'jsonrpc' : '2.0', 'method': 'doAnything', 'params' : [ 2, 'test_B', false ], 'id' : 1234 }";
	    rpc.execute( requestString );
	    
	    System.out.println( "Done." );
	
	} catch( Exception e ) {
	    e.printStackTrace();
	}
	
	
    }
}