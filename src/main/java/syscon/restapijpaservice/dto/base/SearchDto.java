package syscon.restapijpaservice.dto.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {

    @Builder.Default
    private String outf = "json";

    private String search;
    private Integer type;
    private String startDt;
    private String endDt;
}
