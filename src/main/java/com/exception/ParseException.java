package com.exception;


/**
 * The class ParseException is a form of Exception that indicates an issue encountered 
 * while parsing a line of data into an object of {@link com.valueobject.BuildVo} class
 * @author Akshay Singh
 *
 */
public class ParseException extends Exception {
	
	private String line;
	public ParseException(String line) {
		this.line = line;
	}
	
	@Override
	public String getMessage() {
		return "Encountered Parse Exception while processing the line>>> "+line+" <<<";
	}

}
