package com.example.dummy_tutionapp.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dummy_tutionapp.Modal.CourseList;
import com.example.dummy_tutionapp.R;

import java.util.List;

public class CourseListAdaptor extends RecyclerView.Adapter<CourseListAdaptor.CourseListHolder> {

    List<CourseList> courseLists;

    public CourseListAdaptor(List<CourseList> courseLists){
        this.courseLists = courseLists;
    }

    @NonNull
    @Override
    public CourseListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list, parent, false);

        return new CourseListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseListHolder holder, int position) {

        CourseList courseList = courseLists.get(position);
        holder.courseName.setText(courseList.getCourseName());
        holder.studentCnt.setText(courseList.getStudentCount());
        holder.img.setImageResource(courseList.getImgLanguageLogo());


    }

    @Override
    public int getItemCount() {

        if( courseLists != null){
            return courseLists.size();
        }
        return 0;
    }

    public static class CourseListHolder extends RecyclerView.ViewHolder{

        TextView courseName;
        TextView studentCnt;
        ImageView img;
        public CourseListHolder(@NonNull View itemView) {
            super(itemView);

            courseName = itemView.findViewById(R.id.courseName);
            studentCnt = itemView.findViewById(R.id.studentCnt);
            img = itemView.findViewById(R.id.courseImg);

        }

    }

}
