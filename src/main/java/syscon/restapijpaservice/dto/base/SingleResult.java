package syscon.restapijpaservice.dto.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResult<T> extends CommonResult {
    private T payload;
}
