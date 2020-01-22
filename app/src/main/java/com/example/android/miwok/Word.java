package com.example.android.miwok;

public class Word {
    private String MiwokTranslation,DefaultTranslation;
    private int ImageResourceId=NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED=-1;
    private int AudioResourceID;

    public String getMiwokTranslations() {
        return MiwokTranslation;
    }

    public String getDefaultTranslation() {
        return DefaultTranslation;
    }

    public int getImageResourceId(){
        return ImageResourceId;
    }

    public int getAudioResourceID(){return AudioResourceID; }



    public Word(String defTrans, String miwTrans,int id2) {
        MiwokTranslation = miwTrans;
        DefaultTranslation = defTrans;
        AudioResourceID=id2;
    }

    public Word(String defTrans, String miwTrans, int id,int id2){
        MiwokTranslation=miwTrans;
        DefaultTranslation=defTrans;
        ImageResourceId=id;
        AudioResourceID=id2;
    }

    public boolean hasImage(){
        return ImageResourceId!=NO_IMAGE_PROVIDED;
    }
}
