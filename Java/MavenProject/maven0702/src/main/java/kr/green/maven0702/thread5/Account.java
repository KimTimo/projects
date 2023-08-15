package kr.green.maven0702.thread5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private String accountNo;
    private String ownerName;
    private int balance;
    // 입금
    public void deposit(int amount){
          balance += amount;
    }
    // 출금
    public int widthdraw(int amount){
          if(balance<amount)
                 return 0;
          balance -= amount;
          return amount;
    }
}
