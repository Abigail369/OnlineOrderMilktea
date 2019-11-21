package cn.selforder.demo.Utils;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class Util {

    public String gettime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String stringdate = dateFormat.format(date);
        return stringdate;
    }

    public String getrandomid(){
        String s = "qwertyuioplkjhgfdsazxcvbnm0987654321";
        Random r = new Random();
        int l = s.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<12;i++){
            int x = r.nextInt(l);
            stringBuilder.append(s.charAt(x));
        }
        return new String(stringBuilder);

    }
}
