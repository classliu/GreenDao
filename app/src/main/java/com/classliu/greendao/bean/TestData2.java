package com.classliu.greendao.bean;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "TEST_DATA2".
 */
@Entity
public class TestData2 {

    @Id(autoincrement = true)
    private Long id;
    private String testString;
    private Long testLong;
    private java.util.Date testDate;
    private Integer testInt;
    private Boolean testBoolean;

    @Generated
    public TestData2() {
    }

    public TestData2(Long id) {
        this.id = id;
    }

    @Generated
    public TestData2(Long id, String testString, Long testLong, java.util.Date testDate, Integer testInt, Boolean testBoolean) {
        this.id = id;
        this.testString = testString;
        this.testLong = testLong;
        this.testDate = testDate;
        this.testInt = testInt;
        this.testBoolean = testBoolean;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public Long getTestLong() {
        return testLong;
    }

    public void setTestLong(Long testLong) {
        this.testLong = testLong;
    }

    public java.util.Date getTestDate() {
        return testDate;
    }

    public void setTestDate(java.util.Date testDate) {
        this.testDate = testDate;
    }

    public Integer getTestInt() {
        return testInt;
    }

    public void setTestInt(Integer testInt) {
        this.testInt = testInt;
    }

    public Boolean getTestBoolean() {
        return testBoolean;
    }

    public void setTestBoolean(Boolean testBoolean) {
        this.testBoolean = testBoolean;
    }

}
