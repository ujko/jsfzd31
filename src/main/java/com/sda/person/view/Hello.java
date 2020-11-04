package com.sda.person.view;

import org.springframework.stereotype.Component;

@Component
public class Hello {
    private String hello = "Hello world from JSF";
    private String przekieruj = "Przekieruj na stronę pierwszą";
    private int strona = 1;
    private String imie;

    private String text;

    public void przek() {
        switch (strona) {
            case 1:
                przekieruj = "Przekieruj na stronę pierwszą";
                break;
            case 2:
                przekieruj = "Przekieruj na stronę drugą";
                break;
            case 3:
                przekieruj = "Przekieruj na stronę trzecią";
                break;
            case 4:
                przekieruj = "Przekieruj na stronę czwartą";
                break;
        }
    }

    public String goToPage() {
        System.out.println(strona);
        switch (strona) {
            case 1:
                hello = "witaj na stronie pierwszej";
                return "strona-pierwsza";
            case 2:
                hello = "witaj na stronie drugiej";
                return "strona-druga";
            case 3:
                hello = "witaj na stronie trzeciej";
                return "strona-trzecia";
            case 4:
                hello = "witaj na stronie czwartej";
                return "strona-czwarta";
            default:
                return "index";
        }
    }

    public String getHello() {
        return hello;
    }

    public void changeImie() {
        if(imie.length()>1) {
            imie = imie.substring(0,1).toUpperCase() + imie.substring(1).toLowerCase();
        }
    }
    public void setHello(String hello) {
        this.hello = hello;
    }

    public String backToIndex() {
        hello = "Hello world from JSF";
        return "index";
    }

    public int getStrona() {
        return strona;
    }

    public void setStrona(int strona) {
        this.strona = strona;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPrzekieruj() {
        return przekieruj;
    }

    public void setPrzekieruj(String przekieruj) {
        this.przekieruj = przekieruj;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
