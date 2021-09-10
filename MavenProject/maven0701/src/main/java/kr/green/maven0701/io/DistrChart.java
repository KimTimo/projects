package kr.green.maven0701.io;

import java.io.Serializable;
// 희소배열(sparse array)(의미있는 데이터가 희박하게 분포된 배열)을 직렬화 하는 경우
public class DistrChart implements Serializable{
    int arr[][];
    DistrChart(){
          arr = new int [10][10];
    }
}
