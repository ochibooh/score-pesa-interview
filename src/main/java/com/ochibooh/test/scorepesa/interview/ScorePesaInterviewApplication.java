/*
 * Copyright (c) 2020.
 *        Phelix Ochieng(ochibooh)
 * Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.ochibooh.test.scorepesa.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ScorePesaInterviewApplication {
    public static List<String> changeDateFormat(List<String> dates) {
        List<String> res = new ArrayList<>();
        if (dates.size() > 0) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            List<String> patterns = Arrays.asList("yyyy/MM/dd", "dd/MM/yyyy", "MM-dd-yyyy");
            for (String date : dates) {
                for (String pattern : patterns) {
                    try {
                        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
                        res.add(formatter.format(localDate));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpringApplication.run(ScorePesaInterviewApplication.class, args);
        List<String> dates = changeDateFormat(Arrays.asList("2010/03/30", "15/12/2016", "11-15-2012", "20130720"));
        for(String date : dates) {
            System.out.println(date);
        }
    }
}
