package kr.green.datetime8;

import java.time.Duration;
import java.time.Instant;

// Java Instants/Durations
public class Ex09_InstantsDurations {
	public static void main(String[] args) {
		Instant instantNow = Instant.now();
	    System.out.println(instantNow);
	    
	    Instant instance9 = Instant.ofEpochSecond(9);
	    System.out.println(instance9);
	    
	    instance9 = Instant.ofEpochSecond(-9);
	    System.out.println(instance9);
	    
	    Instant instanceMilli = Instant.ofEpochMilli(2000);
	    System.out.println(instanceMilli);
	    System.out.println();
	    
	    Duration d1  = Duration.ofDays(2);
	    System.out.println(d1);

	    Duration d2  = Duration.ofMinutes(2);
	    System.out.println(d2);

	    Duration d3 = Duration.ofSeconds(200); 	// 3 minutes and 20 seconds 
	    Duration d4  = d3.multipliedBy(2);   	// 6  minutes and  40  seconds 
	    Duration d5  = d3.negated();            // -3  minutes and  -20  seconds
	    System.out.println(d3);
	    System.out.println(d4);
	    System.out.println(d5);
	    System.out.println();
	    
	    Instant i1 = Instant.now();
	    long seconds = i1.getEpochSecond();
	    System.out.println(seconds);
	    int nanoSeconds = i1.getNano();
	    System.out.println(nanoSeconds);
	    System.out.println();
	    
	    Duration d6 = Duration.ofSeconds(55);
	    Duration d7 = Duration.ofSeconds(-17);
	    Duration d8 = d6.plus(d7);
	    System.out.println(d6);
	    System.out.println(d7);
	    System.out.println(d8);
	    System.out.println();
	    
	    Instant i2 = Instant.now();
	    Instant i3 = i2.plus(d6);
	    Instant i4 = i2.minus(d7);
	    
	    System.out.println(i2);
	    System.out.println(i3);
	    System.out.println(i4);
	}
}
