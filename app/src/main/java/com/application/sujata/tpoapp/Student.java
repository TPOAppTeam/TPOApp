package com.application.sujata.tpoapp;

import java.util.HashMap;

/**
 * Created by sujata on 13/4/16.
 */
public class Student {


    HashMap<String, String> personolInfo, acadInfo,allInfo;

    public static Student getStd() {
        return std;
    }

    public static void setStd(Student std) {
        Student.std = std;
    }

    private static Student std ;

    static{
        std=new Student();
    }

    Student() {
        allInfo = new HashMap<>();
    }

    Student(HashMap<String, String> personolInfo, HashMap<String, String> acadInfo) {
        this.personolInfo = personolInfo;
        this.acadInfo = acadInfo;
        setAllInfo();

    }

    public void setAllInfo(){
        allInfo = new HashMap<>(personolInfo);
        for(String key:acadInfo.keySet()){
            allInfo.put(key,acadInfo.get(key));
        }
    }
    public HashMap<String,String> getAllInfo(){
        return allInfo;
    }

    public void savePersonalInfo(String PRN, String name, String contact, String email, String branch, String DOB) {

        personolInfo = new HashMap<>();
        personolInfo.put(Config.KEY_PRN, PRN);
        personolInfo.put(Config.KEY_NAME, name);
        personolInfo.put(Config.KEY_Branch, branch);
        personolInfo.put(Config.KEY_Contact, contact);
        personolInfo.put(Config.KEY_Email, email);
        personolInfo.put(Config.KEY_DOB, DOB);


    }

    public void saveAcadInfo(String SSC, String HSC, String entr, String FY, String SY, String TY, String CPI) {

        acadInfo = new HashMap<>();

        acadInfo.put(Config.KEY_SSC, SSC);
        acadInfo.put(Config.KEY_HSC, HSC);
        acadInfo.put(Config.KEY_ENTR, entr);
        acadInfo.put(Config.KEY_FY, FY);
        acadInfo.put(Config.KEY_SY, SY);
        acadInfo.put(Config.KEY_TY, TY);
        acadInfo.put(Config.KEY_CPI, CPI);

    }

    public HashMap<String, String> getPersonolInfo() {
        return personolInfo;
    }

    public void setPersonolInfo(HashMap<String, String> personolInfo) {
        this.personolInfo = personolInfo;
    }

    public HashMap<String, String> getAcadInfo() {
        return acadInfo;
    }

    public void setAcadInfo(HashMap<String, String> acadInfo) {
        this.acadInfo = acadInfo;
    }

    public static void setPersonalInfo(String PRN, String name, String contact, String email, String branch, String DOB) {
        std.savePersonalInfo(PRN, name, contact, email, branch, DOB);
    }

    public static void setAcadInfo(String SSC, String HSC, String entr, String FY, String SY, String TY, String CPI) {
        std.saveAcadInfo(SSC,HSC,entr,FY,SY,TY,CPI);
    }
}