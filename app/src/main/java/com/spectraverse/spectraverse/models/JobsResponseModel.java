package com.spectraverse.spectraverse.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class JobsResponseModel extends BaseModel {
    private ArrayList<JobsDataModel> resultData;

    public ArrayList<JobsDataModel> getResultData() {
        return resultData;
    }

    public static class JobsDataModel {
        private ContentDataModel Content;
        private UserDataModel User;

        public ContentDataModel getContent() {
            return Content;
        }

        public UserDataModel getUser() {
            return User;
        }
    }

    public class ContentDataModel implements Parcelable {
        private String id;
        private String title;
        private String description;
        private String content_type_id;
        private String ref_type;
        private String recruitment_status;
        private String start_date;
        private String end_date;
        private String content_path;
        private String created_by;
        private String company;

        protected ContentDataModel(Parcel in) {
            id = in.readString();
            title = in.readString();
            description = in.readString();
            content_type_id = in.readString();
            ref_type = in.readString();
            recruitment_status = in.readString();
            start_date = in.readString();
            end_date = in.readString();
            content_path = in.readString();
            created_by = in.readString();
            company = in.readString();
        }

        public final Creator<ContentDataModel> CREATOR = new Creator<ContentDataModel>() {
            @Override
            public ContentDataModel createFromParcel(Parcel in) {
                return new ContentDataModel(in);
            }

            @Override
            public ContentDataModel[] newArray(int size) {
                return new ContentDataModel[size];
            }
        };

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getContent_type_id() {
            return content_type_id;
        }

        public String getRef_type() {
            return ref_type;
        }

        public String getRecruitment_status() {
            return recruitment_status;
        }

        public String getStart_date() {
            return start_date;
        }

        public String getEnd_date() {
            return end_date;
        }

        public String getContent_path() {
            return content_path;
        }

        public String getCreated_by() {
            return created_by;
        }

        public String getCompany() {
            return company;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(title);
            dest.writeString(description);
            dest.writeString(content_type_id);
            dest.writeString(ref_type);
            dest.writeString(recruitment_status);
            dest.writeString(start_date);
            dest.writeString(end_date);
            dest.writeString(content_path);
            dest.writeString(created_by);
            dest.writeString(company);
        }
    }

    private class UserDataModel implements Parcelable {
        private String id;
        private String fname;
        private String lname;
        private String pic;
        private String business_unit_id;
        //private String[] BusinessUnit;

        protected UserDataModel(Parcel in) {
            id = in.readString();
            fname = in.readString();
            lname = in.readString();
            pic = in.readString();
            business_unit_id = in.readString();
            //BusinessUnit = in.createStringArray();
        }

        public final Creator<UserDataModel> CREATOR = new Creator<UserDataModel>() {
            @Override
            public UserDataModel createFromParcel(Parcel in) {
                return new UserDataModel(in);
            }

            @Override
            public UserDataModel[] newArray(int size) {
                return new UserDataModel[size];
            }
        };

        public String getId() {
            return id;
        }

        public String getFname() {
            return fname;
        }

        public String getLname() { return lname; }

        public String getPic() {
            return pic;
        }

        public String getBusiness_unit_id() {
            return business_unit_id;
        }

        //public String[] getBusinessUnit() { return BusinessUnit; }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(fname);
            dest.writeString(lname);
            dest.writeString(pic);
            dest.writeString(business_unit_id);
           // dest.writeStringArray(BusinessUnit);
        }
    }
}
