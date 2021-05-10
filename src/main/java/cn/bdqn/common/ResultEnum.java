package cn.bdqn.common;

/**
 * 出参错误码列表
 * 尽管是后台信息，文案受制于中前台要求，暴露给用户
 * 接手者请推动前端的后台包装，目前谨慎修改
 *
 * @author ct.team
 */
public enum ResultEnum {
    // 成功
    SUCCESS("200", "成功"),
    FAIL("0","失败"),
    COMMON_EXCEPTION("500", "系统异常"),

    // 用户相关
    FAIL_USER_ACCOUNT_EMPTY("10001", "用户账号为空"),
    FAIL_USER_ACCOUNT_EXIST("10002","用户账户已存在"),
    FAIL_USER_GET("10003","查询用户信息失败"),
    FAIL_USER_ADD_ERROR("10004","添加用户失败"),
    FAIL_USER_LOGIN_ERROR("10005","账号或者密码错误"),
    FAIL_USER_ACCOUNT_ISNULL("10006","账号不存在"),



    // 文件相关
    FAIL_FILE_EMPTY("40001","文件为空"),
    FAIL_FILE_SIZE_ERROR("40002","文件大小超过50k"),
    FAIL_FILE_SUFFIX_ERROR("40003","文件格式不符合要求"),

    // 就诊卡相关(挂号)
    PATIENT_ID_CARD_EMPTY("20001","身份证号为空"),
    PATIENT_NULL("20002","就诊卡信息为空"),
    PATIENT_ID_MEDICARE_EMPTY("20008","就诊卡号为空"),
    // 排期相关(挂号)
    SCHEDULE_PARAM_EMPTY("20003","查询医生排期参数为空"),
    SCHEDULE_DOCTOR_EMPTY("20004","无可用就诊医生，请重新选择时间段"),
    // 挂号信息管理相关(挂号)
    REGISTER_DEPARTMENT_ID_EMPTY("20005","就诊科室ID为空"),
    // 就诊相关
    REGISTRY_ID_EMPTY("20006","挂号单ID为空"),
    FAIL_ADD_MEDICAL_ADVICE("20007","添加医嘱失败");

    String code;
    String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    public static ResultEnum getByCode(String code) {
        if (code == null) {
            return COMMON_EXCEPTION;
        }
        for (ResultEnum outputEnum : ResultEnum.values()) {
            if (code.equals(outputEnum.code)) {
                return outputEnum;
            }
        }
        return COMMON_EXCEPTION;
    }
}
