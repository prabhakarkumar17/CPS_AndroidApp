package com.example.cps.model;

import android.provider.BaseColumns;

public class StudentContract {
    public static final String DB_NAME = "student_db";
    public static final int VERSION = 1;

    public static final class StudentEntry implements BaseColumns {
        public static final String TABLE_NAME = "students_subject";
        public static final String COLUMN_SUBJECTNAME = "subjectname";
        public static final String COLUMN_MARKS = "marks";
    }
}
