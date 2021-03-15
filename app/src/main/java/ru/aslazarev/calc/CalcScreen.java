package ru.aslazarev.calc;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class CalcScreen implements Parcelable {

    private String screen;


    protected CalcScreen(Parcel in) {
        screen = in.readString();
    }

    public CalcScreen(){
        screen = new String();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(screen);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CalcScreen> CREATOR = new Creator<CalcScreen>() {
        @Override
        public CalcScreen createFromParcel(Parcel in) {
            return new CalcScreen(in);
        }

        @Override
        public CalcScreen[] newArray(int size) {
            return new CalcScreen[size];
        }
    };

    public void setScreen(TextView screen) {
        this.screen = screen.getText().toString();
    }

    public String getScreen() {
        return screen;
    }
}
