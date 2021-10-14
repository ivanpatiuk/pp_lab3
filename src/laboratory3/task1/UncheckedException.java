package laboratory3.task1;

public class UncheckedException extends RuntimeException {
    private ErrorCode error;

    public UncheckedException(){}
    public UncheckedException(final ErrorCode errorCode){
        error = errorCode;
    }
    @Override
    public String getMessage(){
        return error.toString();
    }
}
