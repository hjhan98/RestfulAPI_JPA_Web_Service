package syscon.restapijpaservice.common.exception.custom;

public class CLoginFailException extends RuntimeException{
    public CLoginFailException(){
        super();
    }

    public CLoginFailException(String message){
        super(message);
    }

    public CLoginFailException(String message, Throwable cause){
        super(message, cause);
    }
}
