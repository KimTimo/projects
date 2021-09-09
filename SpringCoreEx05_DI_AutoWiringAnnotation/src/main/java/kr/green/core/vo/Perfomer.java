package kr.green.core.vo;

import javax.sound.midi.Instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Perfomer {
	@Autowired
	private Instrument instrument;

}
