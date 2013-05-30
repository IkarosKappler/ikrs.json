package ikrs.json;

/**
 * This is the default Exception that will be thrown if the parser detects
 * syntax errors in the JSON code.
 *
 *
 * @author Ikaros Kappler
 * @date 2013-05-29
 * @version 1.0.0
 **/

public class JSONException
    extends Exception {

    /**
     * The absolute read position inside the stream.
     **/
    private int readPosition;
    
    /**
     * The line number where the error was detected.
     **/
    private int lineNumber;

    /**
     * The column number where the error was detected.
     **/
    private int columnNumber;


    /**
     * Create a new JSONException.
     **/
    public JSONException( String message,
			  int readPosition,
			  int lineNumber,
			  int columnNumber
			  ) {
	super( message );
	
	this.readPosition = readPosition;
	this.lineNumber   = lineNumber;
	this.columnNumber = columnNumber;
    }

    /**
     * Get the read position where the error was detected.
     **/
    public int getReadPosition() {
	return this.readPosition;
    }

    /**
     * Get the line number where the error was detected.
     **/
    public int getLineNumber() {
	return this.lineNumber;
    }

    /**
     * Get the column number where the error was detected.
     **/
    public int getColumnNumber() {
	return this.columnNumber;
    }
    
    @Override
    public void printStackTrace() {
	super.printStackTrace();
	
	System.err.println( "Syntax error deteced at readPosition=" + this.readPosition + ", lineNumber=" + this.lineNumber + ", columnNumber=" + this.columnNumber );
    }
}