package syscon.restapijpaservice.common.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import syscon.restapijpaservice.common.exception.custom.CLoginFailException;
import syscon.restapijpaservice.common.exception.custom.CUserNotFoundException;
import syscon.restapijpaservice.dto.base.CommonResult;
import syscon.restapijpaservice.exception.NotFoundException;
import syscon.restapijpaservice.service.ResponseService;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    @Autowired
    MessageSource messageSource;
    public final ResponseService responseService;

    private String getMessage(String code){
        return getMessage(code, null);
    }

    private String getMessage(String code, Object[] args){
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    // 유저를 찾지 못했을 경우
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)   // 500 에러
    protected CommonResult userNotFoundException(HttpServletRequest request, CUserNotFoundException e){
        return responseService.getFailResult(Integer.parseInt(getMessage("userNotFound.code")), getMessage("userNotFound.msg")); // 실패 시 응답 데이터 반환
    }

    //  로그인 실패 시
    @ExceptionHandler(CLoginFailException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)   // 500 에러
    protected CommonResult loginFailException(HttpServletRequest request, CLoginFailException e){
        return responseService.getFailResult(Integer.parseInt(getMessage("loginFail.code")), getMessage("loginFail.msg")); // 실패 시 응답 데이터 반환
    }
}