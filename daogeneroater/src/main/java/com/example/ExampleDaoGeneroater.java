package com.example;
import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class ExampleDaoGeneroater {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(2, "com.classliu.greendao.db.bean");
        schema.setDefaultJavaPackageDao("com.classliu.greendao.db.dao");
        addTest(schema);
        addTest2(schema);
        addTest3(schema);
        addTest4(schema);
        addTest5(schema);

        //H:\demo\GreenDao\app\src
        //H:\demo\GreenDao\app\src\main\java-gen
        new DaoGenerator().generateAll(schema, "\\H:\\demo\\GreenDao\\app\\src\\main\\java-gen");
    }

    private static void addTest4( Schema schema) {
        Entity testData = schema.addEntity("TestData4");
        testData.addIdProperty().primaryKey().autoincrement();
        testData.addStringProperty("reader");
        testData.addStringProperty("readerString");
        testData.addIntProperty("testInt");
        testData.addBooleanProperty("testBoolean");
    }


    private static void addTest(Schema schema) {
        Entity testData = schema.addEntity("TestData");
        testData.addIdProperty().primaryKey().autoincrement();
        testData.addStringProperty("reader");
        testData.addLongProperty("testLong");
        testData.addDateProperty("testDate");
        testData.addIntProperty("testInt");
        testData.addBooleanProperty("testBoolean");
        testData.addIntProperty("creatId");
    }
    private static void addTest2(Schema schema) {
        Entity testData = schema.addEntity("TestData2");
        testData.addIdProperty().primaryKey().autoincrement();
        testData.addStringProperty("testString");
        testData.addLongProperty("testLong");
        testData.addDateProperty("testDate");
        testData.addIntProperty("testInt");
        testData.addBooleanProperty("testBoolean");
    }
    private static void addTest3(Schema schema) {
        Entity testData = schema.addEntity("TestData3");
        testData.addIdProperty().primaryKey().autoincrement();
        testData.addStringProperty("testString");
        testData.addLongProperty("testLong");
        testData.addDateProperty("testDate");
        testData.addIntProperty("testInt");
        testData.addBooleanProperty("testBoolean");
    }

    private static void addTest5(Schema schema) {
        Entity testData = schema.addEntity("TestData5");
        testData.addIdProperty().primaryKey().autoincrement();
        testData.addStringProperty("testString");
        testData.addLongProperty("testLong");
        testData.addDateProperty("testDate");
        testData.addIntProperty("testInt");
        testData.addBooleanProperty("testBoolean");
    }
}
