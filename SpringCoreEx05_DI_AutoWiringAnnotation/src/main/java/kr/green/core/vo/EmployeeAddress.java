package kr.green.core.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class EmployeeAddress {
    private String Street = "미금로 21";
    private String city="성남시";
}
