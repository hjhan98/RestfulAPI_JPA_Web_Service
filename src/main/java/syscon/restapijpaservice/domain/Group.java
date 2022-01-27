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
@Table(name = "tb_group")
public class Group {
    /**
     * id : 로봇 그룹 Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    /**
     * group_name : 그룹명
     */
    @Column(name = "group_name", nullable = false)
    private String groupName;

    /**
     * alloc_code : 할당 우선순위 (1020101:우선순위 없음, 1020102:시간순, 1020103:거리순, 1020104:job_priority)
     */
    @Column(name = "alloc_code", nullable = false)
    private Long allocCode;

    /**
     * display_seq : null
     */
    @Column(name = "display_seq", nullable = false)
    private Long displaySeq;

    /**
     * use_yn : 사용여부(0:사용안함, 1:사용)
     */
    @Column(name = "use_yn", nullable = false)
    private Long useYn;

    /**
     * remark : 설명
     */
    @Column(name = "remark")
    private String remark;

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

    /**
     * filler1 : null
     */
    @Column(name = "filler1")
    private String filler1;

    /**
     * filler2 : null
     */
    @Column(name = "filler2")
    private String filler2;

    /**
     * filler3 : null
     */
    @Column(name = "filler3")
    private String filler3;

    /**
     * filler4 : null
     */
    @Column(name = "filler4")
    private String filler4;

    /**
     * filler5 : null
     */
    @Column(name = "filler5")
    private String filler5;
}
