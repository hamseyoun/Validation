package co.kr.spring.validation.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class JavaBean {

    //@NotNull
    //Bean Validation의 validator인 @NotNull!
    //인자로 들어온 필드값에 대해 Null을 허용하지 않는다.
    //말그대로 Null만 허용하지 않으므로, " " 이나 ""는 허용함.

    //@Max, @Min
    //숫자를 사용하는 필드를 검증하는데 사용하는 validator
    //숫자표시의 String, int, byte의 최대/최소 길이를 제한하는것.
    //value속성에 최대/최소 길이를 정하고,
    //message속성에 validation 실패 시 띄울 문구를 작성한다.

    @NotNull
    @Max(value = 2, message = "숫자는 2 이하여야 합니다.")
    private Integer number;


    //@Future
    //이 어노테이션이 달린 요소는 현재보다 미래의 순간,날짜 또는 시간이어야한다.
    //'현재'는 Validator 또는 ValidatorFactory에 첨부된 ClockProvider에 의해 결정된다.
    @NotNull
    @Future
    @DateTimeFormat(iso = ISO.DATE)
    private Date date;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
