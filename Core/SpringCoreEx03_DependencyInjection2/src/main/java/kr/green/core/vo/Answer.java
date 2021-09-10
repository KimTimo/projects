package kr.green.core.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Answer {
    private int id;
    private String name;
    private Date posetedDate;
}
