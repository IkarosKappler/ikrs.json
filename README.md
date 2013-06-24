


Welcome to ikrs.json!
=====================

This software and all its components comes under the General Public 
License version 2.0 (GPL 2.0).
Feel free to copy and modify.

Author:   Ikaros Kappler
Date:     2013-06-11
Modified: 2013-06-24 Ikaros Kappler (Added some security checks to the 
	  	     	    	     JSONRPCHandler).
Version:  1.0.0



What is this?
-------------

ikrs.json is a Java package containing basic JSON classes (datatypes) 
referring to the JSON specification as described in RFC 4627.



What is JSON?
-------------

JSON is the acronym for JavaScript Object Notation. All JSON strings 
are fully valid Javascript codes and represent values such as boolean 
values, numbers, undefined (null), strings, arrays and objects. By
this JSON covers mostly all simple types most programming languages
use.
JSON strings cannot contain executable code; they store just constant
values.


Due to the specification JSON values are defined as follows:
    JSONValue := true | false | null | number | string | array | object
    true      := "true" (ASCII)
    false     := "false"
    null      := "null"
    number    := [ minus ] integer [ frac ] [ exponent ]
    minus     := "-"
    integer   := zero | DIGIT+
    frac      := "." DIGIT+
    DIGIT     := { zero , "1", "2", "3", "4", "5", "6", "7", "8", "9" }
    zero      := "0"
    exponent  := ( "e" | "E" ) [ minus | plus ] DIGIT+
    string    := [...]       (see specs)
    array     := [...]
    object    := [...]

See http://www.ietf.org/rfc/rfc4627.txt for details.


Example
-------

{ "type"          : "person",
  "fist_name"     : "Christopher",
  "last_name"     : "Lloyd",
  "year_of_birth" : 1938,
  "is_alive"	  : true,
  "movie_ids"  	  : [ 13, 17, 19, 23, 2 ],
  "address"	  : { "street"  : "Imaginary Rd. 31415",
  		      "city"    : "St. Olaf",
		      "zipcode" : 27182,
		      "country" : null
		    },
  "id"		  : 12345
}




Package ikrs.json
-----------------

It contains the basic datatype classes:
  - JSONValue (interface)
  - AbstractJSONValue (abstract super class of all JSON types)
  - JSONBoolean
  - JSONNumber
  - JSONString
  - JSONArray
  - JSONObject
  - JSONNull



Package ikrs.json.parser
------------------------

This package contains a simple but fully functional JSON parser and some
builder classes/examples. The parser is a recursive LALR(1) parser and
has linear runtime O(n).

The main classes are:
  - JSONParser
  - JSONBuilder (an example builder class that demontrates how to build
                 up the JSON data structure on-the-fly. It's very 
		 simple, so just take a look at the source ^^).
  - JSONBuilderExample (this is a more enhanced builder example that
    		       	keeps track of all object member names and
			array indices).
  - JSONValueFactory (a factory class to create anonymous JSON values).
  - ConfigurableJSONBuilder (this is the class of your choice: a
    			     configurable JSON builder that uses a 
			     customizable factory class).



A short example how to use the configurable JSON builder
--------------------------------------------------------

    System.out.println( "Creating JSONValueFactory ... ");
    JSONValueFactory factory = new DefaultJSONValueFactory();	    
    System.out.println( "Initialising reader ... " );
    Reader reader = new java.io.FileReader( "test.json.txt" );
    System.out.println( "Initialising parser/builder ... " );
    ConfigurableJSONBuilder b  = new ConfigurableJSONBuilder( reader, false, factory );
    System.out.println( "Starting the parser ..." );
    long time_start = System.currentTimeMillis();
    b.parse();
    long time_end   = System.currentTimeMillis();
    System.out.println( "Closing the reader ..." );
    reader.close();
    System.out.println( "Done." );
    System.out.println( "Parsing and building took " + (time_end - time_start) + " ms." );
    JSONValue json = b.lastPoppedValue;
    System.out.println( "JSON object: " + json.toString() );



The program's output is:
------------------------
    Creating JSONValueFactory ... 
    Initialising reader ... 
    Initialising parser/builder ... 
    Starting the parser ...
    Closing the reader ...
    Done.
    Parsing and building took 42 ms.
    JSON object: ikrs.json.JSONObject={age=2630, answer_is_correct=false, error=this might be an error message., floating_value_0=0.0, floating_value_1=1.0, floating_value_2=1.3E23, mixed_array_and_object=ikrs.json.JSONArray=[A, B, ikrs.json.JSONObject={X=ikrs.json.JSONArray=[d, e]}, F], my_array=ikrs.json.JSONArray=[], my_array_2=ikrs.json.JSONArray=[1, 2, 3], my_array_3=ikrs.json.JSONArray=[1, false, ikrs.json.JSONObject={name=null}, true], my_parser_also_ignores_the_case=true, name=test, negative_float=-3.14159265359, negative_number=-23, nested_array_0=ikrs.json.JSONArray=[1, ikrs.json.JSONArray=[2, ikrs.json.JSONArray=[3, 4, 5], 6]], nested_object_0=ikrs.json.JSONObject={a=1, b=ikrs.json.JSONObject={c=2, d=ikrs.json.JSONObject={e=4, f=5}}, f=6}, object_0=ikrs.json.JSONObject={a=1, b=2, c=3, d=4}, question_expired=true, status=111, test_A=A line- 
n -break, test_C=An unicode Å character (should be the danish Ao), test_x=false, test_y=testing, user_exists=true}




Package ikrs.json.rpc
---------------------

This package contains a set of JSON-RPC classes that provide server 
side support for Remote Procedure Calls (RPCs).

Usually RPC requests are sent to a server over the network. Once the
request was processed (a method/function on the server was called with
some passed parameters) it generates a response which is sent back
to the caller.

JSON-RPC just uses JSON as an interchange language (protocol): a client
sends a JSON string to the server (the string describes the desired 
method call) and the server sends its response as a JSON string too.



The most important classes are:
    - JSONRPCHandler (a configurable JSON-RPC handler).
    - JSONRPCRequest (the request class, a subclass of JSONValue).
    - JSONRPCResponse (the response class, a subclass of JSONValue).
    - RPCInvocationTarget (interface all RPC classes must implement if
      			   the JSONRPCHandler should have access to
			   its methods).



Example
-------

    System.out.println( "Creating JSONRPC ..." );
    JSONRPCHandler rpc = new JSONRPCHandler();
    rpc.addInvocationTarget( "x", new TestInvocationTarget(), true );

    String requestString = "{'jsonrpc' : '2.0', 'method': 'doAnything', 'params' : [ 2, 'test_B', false ], 'id' : 1234 }";
    System.out.println( "Executing the request ..." );
    response = rpc.call( requestString );
    System.out.println( "Response: " + response.toJSONString() );
	   

Note that 'TestInvocationTarget' is an example class that implements the
RPCInvocationTarget interface and has only one method:

    public void doAnything( int i, String s, boolean b )

That method simply prints the passed params on stdout.
The programs output would be:

    Creating JSONRPC ...
    Executing the request ...
    DOING ANYTHING
     integer param: 1
     string param:  test_A
     boolean param: true
    Response: { "error": null, "id": 1234, "jsonrpc": "2.0", "result": null }
    Done.




Have fun!

