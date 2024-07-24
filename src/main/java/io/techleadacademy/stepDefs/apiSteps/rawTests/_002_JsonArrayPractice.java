package io.techleadacademy.stepDefs.apiSteps.rawTests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _002_JsonArrayPractice {
    public static void main(String[] args) {
        String users = "{" +
                "students: " +
                "[{firstName:John, lastName:Smith}, " +
                "{firstName:Adam, lastName:White}]" +
                "}";

        //convert string into arr json object
        JSONObject jsonObject = new JSONObject(users);

        List<String> list = new ArrayList<>();

        JSONArray jsonArray = jsonObject.getJSONArray("students");

        for (int i = 0; i<jsonArray.length(); i++){
            list.add(jsonArray.getJSONObject(i).getString("firstName"));
        }

        list.forEach(each -> System.out.println(each));

    }

    @Test
    public void test01(){
        String s = "{users:[\n" +
                "    {\n" +
                "        \"createTime\": \"02-21-2024 01:07\",\n" +
                "        \"updateTime\": \"02-21-2024 01:07\",\n" +
                "        \"userId\": 13,\n" +
                "        \"firstName\": \"Gulzhana\",\n" +
                "        \"lastName\": \"Malikova\",\n" +
                "        \"email\": \"malikovag02@gmail.com\",\n" +
                "        \"password\": \"$2a$10$vz1qln61ETNM/8mkp32H9eNLAMaSweZEIZ6XBSs1wbNBXOV3MFrr2\",\n" +
                "        \"role\": \"Student\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createTime\": \"02-19-2024 19:31\",\n" +
                "        \"updateTime\": \"02-19-2024 19:31\",\n" +
                "        \"userId\": 6,\n" +
                "        \"firstName\": \"Student\",\n" +
                "        \"lastName\": \"Test\",\n" +
                "        \"email\": \"tla.liveproject.team1@gmail.com\",\n" +
                "        \"password\": \"$2a$10$tDyxB6G6JLZEZnRfKi.2Ze0idajOGLBGUPf1Xjv3E80iS3EUrM.BO\",\n" +
                "        \"role\": \"Student\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createTime\": \"03-04-2024 21:05\",\n" +
                "        \"updateTime\": \"03-04-2024 21:05\",\n" +
                "        \"userId\": 22,\n" +
                "        \"firstName\": \"Aidar\",\n" +
                "        \"lastName\": \"Kadyraliev\",\n" +
                "        \"email\": \"offbeattsunami@gmail.com\",\n" +
                "        \"password\": \"$2a$10$Vqd/NDRNqQEmuozWvWE0cu9C2nHm2/AyLzWQCfbm.YgrvBQVHm.9G\",\n" +
                "        \"role\": \"Instructor\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createTime\": \"02-19-2024 18:31\",\n" +
                "        \"updateTime\": \"02-19-2024 18:31\",\n" +
                "        \"userId\": 5,\n" +
                "        \"firstName\": \"Nuri\",\n" +
                "        \"lastName\": \"Alibekova\",\n" +
                "        \"email\": \"alibekova99n@gmail.com\",\n" +
                "        \"password\": \"$2a$10$3wn.DtWyT1C7c/XJYUPccuAFWPqYNFBN144TrcUoSJ/5KTd6C/T9S\",\n" +
                "        \"role\": \"Student\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createTime\": \"02-21-2024 01:05\",\n" +
                "        \"updateTime\": \"02-21-2024 01:05\",\n" +
                "        \"userId\": 9,\n" +
                "        \"firstName\": \"Aliia\",\n" +
                "        \"lastName\": \"Kadyralieva\",\n" +
                "        \"email\": \"aliiamarcus3@gmail.com\",\n" +
                "        \"password\": \"$2a$10$vmkfImciWcGHEQk.VEvSXel8IZaPo1YZ/71Pvbo.eha61bfP8Grne\",\n" +
                "        \"role\": \"Student\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createTime\": \"02-21-2024 01:05\",\n" +
                "        \"updateTime\": \"02-21-2024 01:05\",\n" +
                "        \"userId\": 8,\n" +
                "        \"firstName\": \"Marianna\",\n" +
                "        \"lastName\": \"Antonian\",\n" +
                "        \"email\": \"marianna.antonian@gmail.com\",\n" +
                "        \"password\": \"$2a$10$pVYOQP/lsdTGIKGfQV9dY.QIKXeNj8kLwcZ175TNt6M5pzlCbgNv2\",\n" +
                "        \"role\": \"Student\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createTime\": \"02-21-2024 01:07\",\n" +
                "        \"updateTime\": \"02-21-2024 01:07\",\n" +
                "        \"userId\": 14,\n" +
                "        \"firstName\": \"Altan\",\n" +
                "        \"lastName\": \"Dabaev\",\n" +
                "        \"email\": \"altdab97@gmail.com\",\n" +
                "        \"password\": \"$2a$10$we.oPebXNfMI2g.NyjsmkOCNCO4s6RZSG9vxCs8Wp3G2iDIcdycia\",\n" +
                "        \"role\": \"Student\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createTime\": \"02-19-2024 18:15\",\n" +
                "        \"updateTime\": \"02-19-2024 18:15\",\n" +
                "        \"userId\": 4,\n" +
                "        \"firstName\": \"Kuba\",\n" +
                "        \"lastName\": \"Zhaanbaev\",\n" +
                "        \"email\": \"kuba_zhaanbaev@techleadacademy.io\",\n" +
                "        \"password\": \"$2a$10$y8/JNkbOPIqzm1niebRiBeit2L3qYjTksbGX6JhhIjxGbIz/CF.f2\",\n" +
                "        \"role\": \"Admin, Instructor\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createTime\": \"02-21-2024 01:06\",\n" +
                "        \"updateTime\": \"02-21-2024 01:06\",\n" +
                "        \"userId\": 12,\n" +
                "        \"firstName\": \"Olha\",\n" +
                "        \"lastName\": \"Polascak\",\n" +
                "        \"email\": \"olhapolascak@gmail.com\",\n" +
                "        \"password\": \"$2a$10$.g8AJIK0RZAKowar0sgU7ey3/J5D4ra6R.jUcXZ9tVpzyUmN225vy\",\n" +
                "        \"role\": \"Student\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createTime\": null,\n" +
                "        \"updateTime\": null,\n" +
                "        \"userId\": 0,\n" +
                "        \"firstName\": \"Khali\",\n" +
                "        \"lastName\": \"Ba\",\n" +
                "        \"email\": \"hakuban@yahoo.com\",\n" +
                "        \"password\": \"$2a$10$24UCtIAcq25dEpldNRs4neCVNZClVV09qLVMxKvi0azmEbh0uMaWG\",\n" +
                "        \"role\": \"Admin, Instructor\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createTime\": \"07-14-2024 13:17\",\n" +
                "        \"updateTime\": \"07-14-2024 13:17\",\n" +
                "        \"userId\": 24,\n" +
                "        \"firstName\": \"Maria\",\n" +
                "        \"lastName\": \"Smith\",\n" +
                "        \"email\": \"test@test.com\",\n" +
                "        \"password\": null,\n" +
                "        \"role\": \"student\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createTime\": null,\n" +
                "        \"updateTime\": null,\n" +
                "        \"userId\": 1234,\n" +
                "        \"firstName\": \"John\",\n" +
                "        \"lastName\": \"Blue\",\n" +
                "        \"email\": \"j.blue@test.com\",\n" +
                "        \"password\": \"123456\",\n" +
                "        \"role\": \"student\"\n" +
                "    }\n" +
                "]}";

        //convert string into arr json object
        JSONObject jsonObject = new JSONObject(s);

        JSONArray jsonArray = jsonObject.getJSONArray("users");

        for (int i = 0; i<jsonArray.length(); i++){
            System.out.println(jsonArray.getJSONObject(i).getString("firstName") + " | "+
                    jsonArray.getJSONObject(i).getInt("userId"));
        }
    }

    @Test
    public void test02(){
        String str = "[\n" +
                "    {\n" +
                "        \"id\": 7117835,\n" +
                "        \"name\": \"Raj Panicker I\",\n" +
                "        \"email\": \"i_panicker_raj@daniel-beatty.test\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7117833,\n" +
                "        \"name\": \"Gitanjali Pandey\",\n" +
                "        \"email\": \"pandey_gitanjali@senger.test\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7117831,\n" +
                "        \"name\": \"Rupinder Prajapat\",\n" +
                "        \"email\": \"prajapat_rupinder@bechtelar-stroman.example\",\n" +
                "        \"gender\": \"female\",\n" +
                "        \"status\": \"active\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7117829,\n" +
                "        \"name\": \"Girja Kaul\",\n" +
                "        \"email\": \"kaul_girja@jast.test\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"inactive\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7117828,\n" +
                "        \"name\": \"Inder Guneta\",\n" +
                "        \"email\": \"inder_guneta@boyer.test\",\n" +
                "        \"gender\": \"female\",\n" +
                "        \"status\": \"inactive\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7117827,\n" +
                "        \"name\": \"Gautama Singh\",\n" +
                "        \"email\": \"gautama_singh@corkery.test\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7117825,\n" +
                "        \"name\": \"Dr. Anang Trivedi\",\n" +
                "        \"email\": \"anang_dr_trivedi@johnson-kreiger.test\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7117823,\n" +
                "        \"name\": \"Bilva Asan DO\",\n" +
                "        \"email\": \"do_asan_bilva@hills.test\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7117822,\n" +
                "        \"name\": \"Bandhu Namboothiri\",\n" +
                "        \"email\": \"bandhu_namboothiri@dickens.example\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"inactive\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7117820,\n" +
                "        \"name\": \"Subhashini Dubashi\",\n" +
                "        \"email\": \"dubashi_subhashini@pollich.example\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"inactive\"\n" +
                "    }\n" +
                "]";
        JSONArray jsonArray = new JSONArray(str);

        for (int i = 0; i < jsonArray.length(); i++) {
            System.out.println(jsonArray.getJSONObject(i).getString("name"));
        }
    }
}
