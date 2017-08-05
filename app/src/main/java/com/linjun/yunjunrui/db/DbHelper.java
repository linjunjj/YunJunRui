package com.linjun.yunjunrui.db;

import android.content.Context;

import com.linjun.yunjunrui.model.Usermodel;
import com.vise.xsnow.database.DBManager;

/**
 * 作者：林俊 on 2017/8/5
 * 作用：
 */
public class DbHelper {
    private static final String DB_NAME="vise.db";
    private  static  DbHelper instance;
    private  static DBManager<Usermodel,Long> user;
    private  DaoMaster.DevOpenHelper mHelpter;
    private  DaoMaster mDaoMaster;
    private  DaoSession mDaoSession;
    private  DbHelper(){
    }
 public  static  DbHelper getInstance(){
     if (instance==null){
         synchronized (DbHelper.class){
             if (instance==null){
                 instance=new DbHelper();
             }
         }
     }
     return  instance;
 }
   public  void init(Context context){
       mHelpter=new DaoMaster.DevOpenHelper(context,DB_NAME,null);
     //  mDaoMaster=new DaoMaster();
   }



}
