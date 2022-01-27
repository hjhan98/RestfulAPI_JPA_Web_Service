package syscon.restapijpaservice.common.exception.custom;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.syscon.sfmb.restful.dto.base.CommonResult;
import kr.syscon.sfmb.restful.service.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class CfileException {

    public final ResponseService responseService;

    public void writeException(HttpServletResponse response, Object obj) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json");
        CommonResult commonResult = new CommonResult();
        responseService.setFailResult(
                commonResult,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                obj.getClass().getName() + "에 에러가 발생했습니다.");
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(commonResult);
            System.out.println(json);
            response.getWriter().write(json);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}