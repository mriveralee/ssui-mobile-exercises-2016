package com.mikeriv.ssui_2016.parcelableactivitystate;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mlrivera on 10/15/16.
 */

public class PersonModel implements Parcelable {

    private static final String DEFAULT_PERSON_NAME = "";
    private static final String DEFAULT_PERSON_FAVORITE_FOOD = "";
    private static final int DEFAULT_PERSON_AGE = 18;

    private String mName;
    private int mAge;
    private String mFavoriteFood;

    public PersonModel() {
        setName(DEFAULT_PERSON_NAME);
        setAge(DEFAULT_PERSON_AGE);
        setFavoriteFood(DEFAULT_PERSON_FAVORITE_FOOD);
    }

    public PersonModel(String name, int age, String favoriteFood) {
        setName(name);
        setAge(age);
        setFavoriteFood(favoriteFood);
    }

    protected PersonModel(Parcel in) {
        mName = in.readString();
        mAge = in.readInt();
        mFavoriteFood = in.readString();
    }

    public static final Creator<PersonModel> CREATOR = new Creator<PersonModel>() {
        @Override
        public PersonModel createFromParcel(Parcel in) {
            return new PersonModel(in);
        }

        @Override
        public PersonModel[] newArray(int size) {
            return new PersonModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mAge);
        dest.writeString(mFavoriteFood);
    }

    public int getAge() {
        return mAge;
    }

    public String getName() {
        return mName;
    }

    public String getFavoriteFood() {
        return mFavoriteFood;
    }

    public void setName(String name) {
        if (name == null) {
            name = DEFAULT_PERSON_NAME;
        }
        mName = name;
    }

    public void setAge(int age) {
        if (age <= 0) {
            age = 1;
        }
        mAge = age;
    }

    public void setFavoriteFood(String favoriteFood) {
        if (favoriteFood == null) {
            favoriteFood = DEFAULT_PERSON_FAVORITE_FOOD;
        }
        mFavoriteFood = favoriteFood;
    }
}
