package com.spectraverse.spectraverse.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class VideosResponseModel extends BaseModel {
    private ArrayList<VideosResponseModel.VideosDataModel> resultData;

    public ArrayList<VideosResponseModel.VideosDataModel> getResultData() {
        return resultData;
    }

    public static class VideosDataModel {
        private VideosResponseModel.ContentDataModel Content;


        public VideosResponseModel.ContentDataModel getContent() {
            return Content;
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

        }

        public final Creator<VideosResponseModel.ContentDataModel> CREATOR = new Creator<VideosResponseModel.ContentDataModel>() {
            @Override
            public VideosResponseModel.ContentDataModel createFromParcel(Parcel in) {
                return new VideosResponseModel.ContentDataModel(in);
            }

            @Override
            public VideosResponseModel.ContentDataModel[] newArray(int size) {
                return new VideosResponseModel.ContentDataModel[size];
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
        }
    }

}
