package calculator.exception;

public enum ErrorCode {
	INVALID_EXPRESSION("수식의 형식이 맞지 않습니다.");

	String message;

	ErrorCode(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
