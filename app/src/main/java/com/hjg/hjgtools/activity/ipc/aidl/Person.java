package com.hjg.hjgtools.activity.ipc.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {


    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Person(Parcel in) {

        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);//将name打包
        dest.writeInt(age);//将name打包
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
