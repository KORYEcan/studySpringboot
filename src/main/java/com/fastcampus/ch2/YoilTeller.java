package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Calendar;

@Controller
public class YoilTeller {

    @RequestMapping("/getYoil")
    public String main(@ModelAttribute MyDate mydate) throws IOException {
        //2. 작업 - 요일을 계산
        char yoil=getYoil(mydate);
        //작업한 결과를 Model에 저장(DS가 Model를 Viwe로 전달)
        return "yoil";   // yoil.html -> 뷰의 이름을 반환
    }

    @ModelAttribute("yoil")
    private char getYoil(MyDate mydate) {
        Calendar cal = Calendar.getInstance();  //현재 날짜와 시간을 갖는 cal
        cal.clear(); //cal의 모든 필드를 초기화
        cal.set(mydate.getYear(), mydate.getMonth() - 1, mydate.getDay());  //월(mm)은 0부터 11이기 떄문에 1을 뺴줘야 함.

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  //1~7을 반환 . 1: 일요일 , 2: 월요일
        char yoil = "일월화수목금토".charAt(dayOfWeek - 1);  //1~7 -> 0 ~6
        return yoil;
    }
}
