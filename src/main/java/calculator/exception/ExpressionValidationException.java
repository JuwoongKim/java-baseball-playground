package calculator.exception;

public class ExpressionValidationException extends RuntimeException{
	public ExpressionValidationException (String message){
		super(message);
	}
}
