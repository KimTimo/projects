package kr.green.calendar.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
{
    "_id": 1,
    "title": "거래처 미팅",
    "description": "Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.",
    "start": "2021-09-07T09:30",
    "end": "2021-09-07T15:00",
    "type": "카테고리1",
    "username": "다현",
    "backgroundColor": "#D25565",
    "textColor": "#ffffff",
    "allDay": false
  }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventVO {
	private int _id;
	private String title;
	private String description;
	private String start;
	private String end;
	private String type;
	private String username;
	private String backgroundColor;
	private String textColor;
	private boolean allDay;
}
