package syscon.restapijpaservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_group_dtl")
public class GroupDtl {
    /**
     * id : 그룹 설정 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    /**
     * group_id : 그룹 id
     */
    @Column(name = "group_id", nullable = false)
    private Long groupId;

    /**
     * target_code : 타겟 코드 (201:robot, 203:outer_device)
     */
    @Column(name = "target_code", nullable = false)
    private Long targetCode;

    /**
     * target_id : Robot_id 또는 device_id (외래키 불가)
     */
    @Column(name = "target_id")
    private String targetId;

    /**
     * use_yn : 사용여부(0:사용안함, 1:사용)
     */
    @Column(name = "use_yn", nullable = false)
    private Long useYn;

    /**
     * create_user : 최초 생성자 (1:시스템)
     */
    @Column(name = "create_user", nullable = false)
    private Long createUser;

    /**
     * create_dt : 최초 생성일
     */
    @Column(name = "create_dt", nullable = false)
    private LocalDateTime createDt;

    /**
     * mod_user : 최종 수정자 (1:시스템)
     */
    @Column(name = "mod_user")
    private Long modUser;

    /**
     * mod_dt : 최종 수정일
     */
    @Column(name = "mod_dt")
    private LocalDateTime modDt;

}
