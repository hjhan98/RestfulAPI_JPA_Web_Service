package syscon.restapijpaservice.service;

import syscon.restapijpaservice.common.base.CommonResponse;
import syscon.restapijpaservice.dto.base.CommonResult;
import syscon.restapijpaservice.dto.base.ListResult;
import syscon.restapijpaservice.dto.base.SingleResult;

import java.util.List;

public class ResponseService {
    // 단일건 결과 처리
    public <T> SingleResult<T> getSingleResult(T data){
        SingleResult<T> result = new SingleResult<>();
        result.setPayload(data);
        setSuccessResult(result);
        return result;
    }

    // 복수건 결과 처리
    public <T> ListResult<T> getListResult(List<T> list){
        ListResult<T> result = new ListResult<>();
        result.setPayload(list);
        setSuccessResult(result);
        return result;
    }

    // 성공 결과 처리
    public CommonResult getSuccessResult(){
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    // 실패 결과 처리
    public CommonResult getFailResult(int code, String message){
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        setFailResult(result,code,message);
        return result;
    }

    // 성공 시, 성공 데이터 셋팅
    public void setSuccessResult(CommonResult result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    // 실패 시, 실패 데이터 셋팅
    public void setFailResult(CommonResult result, int code, String msg){
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
    }
}
