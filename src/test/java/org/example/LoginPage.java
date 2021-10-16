package org.example;


import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    public void clickAccount() {
        $x("//*[@id=\"top-panel\"]/div[1]/div[1]/a").click();

    }
    public void inputLogin(String login) {
        $x("//*[contains(@name, 'p_login')]").setValue(login);
      }

    public void inputPasswd(String passwd) {
        $x("//*[contains(@name, 'p_pass')]").setValue(passwd);
      }

    public void clickLoginBtn() {
        $x("//*[@id=\"eu_enter\"]/input[3]").click();
       }
}
