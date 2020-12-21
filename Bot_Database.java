package com.example.personality_matchmaking_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import android.database.Cursor;
//import com.codinginflow.myawesomequiz.QuizContract.*;

public class Bot_Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "UserDatabase";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Bot_Questions";

    public static final String Table_Column_ID = "ID";

    public static final String Table_Column_1_Questions = "Questions";

    public static final String Table_Column_2_Option1 = "Option1";

    public static final String Table_Column_3_Option2 = "Option2";

    public static final String Table_Column_4_Option3 = "Option3";

    public static final String Table_Column_5_Option4 = "Option4";

    public static final String Table_Column_6_Option5 = "Option5";


    private SQLiteDatabase db;

    public Bot_Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + Table_Column_ID + " INTEGER PRIMARY KEY, " + Table_Column_1_Questions + " TEXT, " + Table_Column_2_Option1 + " TEXT, " + Table_Column_3_Option2 + " TEXT," + Table_Column_4_Option3 + " TEXT, " + Table_Column_5_Option4 + " TEXT, " + Table_Column_6_Option5 + " TEXT)";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question(1, "I have a vivid imagination.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q1);
        Question q2 = new Question(2, "I worry about things.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q2);
        Question q3 = new Question(3, "I love large parties.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q3);
        Question q4 = new Question(4, "I get angry easily.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q4);
        Question q5 = new Question(5, "I take charge.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q5);
        Question q6 = new Question(6, "I experience my emotions intensely.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q6);
        Question q7 = new Question(7, "I prefer variety to routine.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q7);
        Question q8 = new Question(8, "I am easily intimidated.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q8);
        Question q9 = new Question(9, "I love excitement.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q9);
        Question q10 = new Question(10, "I like to solve complex problems.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q10);
        Question q11 = new Question(11, "I often eat too much.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q11);
        Question q12 = new Question(12, "I radiate joy.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q12);
        Question q13 = new Question(13, "I tend to vote for liberal political candidates. ", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q13);
        Question q14 = new Question(14, "I panic easily.", "Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree");
        addQuestion(q14);


    }


    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(Table_Column_ID, question.getId());
        cv.put(Table_Column_1_Questions, question.getQuestion());
        cv.put(Table_Column_2_Option1, question.getOption1());
        cv.put(Table_Column_3_Option2, question.getOption2());
        cv.put(Table_Column_4_Option3, question.getOption3());
        cv.put(Table_Column_5_Option4, question.getOption4());
        cv.put(Table_Column_6_Option5, question.getOption5());


        db.insert(TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(Table_Column_ID)));
                question.setQuestion(c.getString(c.getColumnIndex(Table_Column_1_Questions)));
                question.setOption1(c.getString(c.getColumnIndex(Table_Column_2_Option1)));
                question.setOption2(c.getString(c.getColumnIndex(Table_Column_3_Option2)));
                question.setOption3(c.getString(c.getColumnIndex(Table_Column_4_Option3)));
                question.setOption4(c.getString(c.getColumnIndex(Table_Column_5_Option4)));
                question.setOption5(c.getString(c.getColumnIndex(Table_Column_6_Option5)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}



