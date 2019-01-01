package com.xin.activity.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.xin.activity.core.DefaultPageRequestBean;
import com.xin.activity.core.DefaultRequestBean;
import com.xin.activity.core.RequestBean;
import com.xin.activity.handler.requestBeans.FindMasterRequestBean;
import com.xin.activity.handler.requestBeans.NotFoundRequestBean;
import com.xin.activity.handler.requestBeans.StudentListRequestBeanBean;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;

import java.util.stream.Stream;

/**
 * @author three
 * @since 2018/12/26 23:27
 * <p>
 *
 * </p>
 */
@Getter
public enum FunctionEnum {
    schoolList(FunctionCode.schoolList, "学校列表", DefaultPageRequestBean.class),
    findMaster(FunctionCode.findMaster, "查询教练", FindMasterRequestBean.class),
    studentList(FunctionCode.studentList, "学员列表", StudentListRequestBeanBean.class),
    studentApplyList(FunctionCode.studentApplyList, "学员申请列表", DefaultPageRequestBean.class),
    reviewStudent(FunctionCode.reviewStudent, "学员审核", null),
    register(FunctionCode.register, "注册", null),
    createCourse(FunctionCode.createCourse, "创建课程", null),
    editCourse(FunctionCode.editCourse, "编辑课程", null),
    deleteCourse(FunctionCode.deleteCourse, "删除课程", null),
    appointment(FunctionCode.appointment, "学员预约", null),
    notFound(FunctionCode.notFound, "doNothing", NotFoundRequestBean.class);
    private String                       code;
    private String                       desc;
    private Class<? extends RequestBean> requestBeanClass;

    FunctionEnum(String code, String desc, Class<? extends RequestBean> requestBeanClass) {
        this.code = code;
        this.desc = desc;
        this.requestBeanClass = requestBeanClass;
    }

    @JsonCreator
    public static FunctionEnum getByCode(String code) {
        return Stream.of(FunctionEnum.values())
                .filter(function -> StringUtils.equals(code, function.getCode()))
                .findAny()
                .orElse(notFound);
    }


}
