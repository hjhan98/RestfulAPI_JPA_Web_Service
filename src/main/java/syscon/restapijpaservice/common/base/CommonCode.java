package syscon.restapijpaservice.common.base;

import lombok.Getter;

public enum CommonCode {
    /**
     * 최상위 코드
     */
    BasicCode(100L),
    TypeCode(200L),
    DataCode(300L),
    CommandCode(400L),
    AdminCode(900L),

    /**
     * Basic Code
     */


    /**
     * Type Code
     */


    /**
     * Data Code
     */


    /**
     * Command Code
     */


    /**
     * Admin Code
     */
    UserGroup(901L),
    UserRole(902L),

    Admin(9010001L),
    Super(9010002L),
    User(9010003L),
    Viewer(9010004L);
    

    @Getter
    private final Long value;

    CommonCode(Long value) {
        this.value = value;
    }
}
