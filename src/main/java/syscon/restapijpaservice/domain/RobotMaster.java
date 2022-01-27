package syscon.restapijpaservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor // 필드의 모든 값을 인자로 하는 생성자 생성
@NoArgsConstructor  // 인자가 없는 생성자 생성
@Entity             // JPA가 관리하는 클래스
@Table(name = "tb_robot_master")
public class RobotMaster {

    /**
     * Robot ID
     */
    @Id // primary key
    @Column(name = "id", nullable = false)
    private String id;

    /**
     * Robot Name
     */
    @Column(name = "robot_name", nullable = false)
    private String robotName;

    /**
     * Ip
     */
    private String ip;

    /**
     * Port
     */
    private Integer port;

    /**
     * PortStream
     */
    @Column(name = "port_stream")
    private Integer portStream;

    /**
     * Robot Type Code
     */
    @Column(name = "robot_type_code", nullable = false)
    private Integer robotTypeCode;

    /**
     * Device Id
     */
    @Column(name = "device_id", nullable = false)
    private Integer deviceId;

    /**
     * map Id
     */
    @Column(name = "map_id", nullable = false)
    private Integer mapId;

    /**
     * 자동 충전 여부
     */
    @Column(name = "auto_charge_yn", nullable = false)
    private Byte autoChargeYn;

    /**
     * 배터리 자동충전 시작 수치(최소 배터리)
     */
    @Column(name = "charge_on_battery", nullable = false)
    private Integer chargeOnBattery;

    /**
     * 배터리 자동충전 종료 수치(최대 배터리)
     */
    @Column(name = "charge_off_battery", nullable = false)
    private Integer chargeOffBattery;

    /**
     * 사용여부
     */
    @Column(name = "use_yn", nullable = false)
    private Byte useYn;

    /**
     * 최초 생성자
     */
    @Column(name = "create_user", nullable = false)
    private Integer createUser;

    /**
     * 최초 생성 날짜
     */
    @Column(name = "create_dt", nullable = false)
    private LocalDateTime createDt;

    /**
     * 최종 수정자
     */
    @Column(name = "mod_user")
    private Integer modUser;

    /**
     * 최종 수정날짜
     */
    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    private String filler1;

    private String filler2;

    private String filler3;

    private String filler4;

    private String filler5;

    @Column(name = "del_yn")
    private Byte delYn;

    private Double battery;


}
