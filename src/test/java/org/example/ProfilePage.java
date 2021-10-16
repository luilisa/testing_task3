package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {

    public void uploadPhoto() {
        File file = new File("C:\\Users\\User\\IdeaProjects\\test_task3\\photo_2021-10-14_16-06-39.jpg");
        $x("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[1]/input").uploadFile(file);
        $x("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[2]/input").click();
    }

    public void homeClick() {
        $x("/html/body/div[2]/div[4]/div/a[2]").click();
    }
//    public void perfomanceClick() {
//        $x("//*[@id=\"main-blocks\"]/div[1]/div[6]/a").click();
//        }

    public void userLogout() {
        $x("//*[@id=\"page\"]/header/a[1]").click();
    }

    public String getUserName() {
        String expectedName = "Хайбуллина Луиза Юнировна";
        return $x("//*[@id=\"info\"]/div/div[1]/div[2]/div[2]/span[2]").shouldHave(Condition.exactText(expectedName)).getText();
    }

    public boolean checkFile() {
        $x("//*[@id=\"under-slider-menu\"]/div/a[2]").click();
        $x("//*[@id=\"under-slider-menu\"]/div/a[4]").click();
        $x("//*[@id=\"under-slider-menu\"]/div/a[8]/span").click();
        $x("//*[@id=\"mCSB_1_container\"]/ul/li[1]/a").click();
        String string= "Хайбуллину Луизу Юнировну";
        String file = getDoc();
        return file.contains(string);
    }

    public String getDoc()  {
        File doc= null;
        String strDoc=null;
        try {
         doc = $x("//*[@id=\"tab1\"]/p[2]/a").download();
         strDoc = FileUtils.readFileToString(doc, "Windows-1251");

        } catch (IOException e){
            e.printStackTrace();
        }
        return strDoc;


    }
}
