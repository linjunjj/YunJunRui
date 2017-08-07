package com.linjun.yunjunrui.db;

import android.content.Context;

import com.linjun.yunjunrui.model.Usermodel;
import com.vise.xsnow.database.DBManager;

import org.greenrobot.greendao.AbstractDao;

/**
 * 作者：林俊 on 2017/8/5
 * 作用：数据库操作类
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
     mDaoMaster=new DaoMaster(mHelpter.getWritableDatabase());
       mDaoSession=mDaoMaster.newSession();
   }
  public  void init(Context context,String dbName){
      mHelpter=new DaoMaster.DevOpenHelper(context,dbName,null);
      mDaoMaster=new DaoMaster(mHelpter.getWritableDatabase());
      mDaoSession=mDaoMaster.newSession();

  }
 public  DBManager<Usermodel,Long> user(){
     if (user==null){
         user=new DBManager<Usermodel, Long>() {
             @Override
             public AbstractDao<Usermodel, Long> getAbstractDao() {
                 return mDaoSession.getUsermodelDao();
             }
         };
     }
    return  user;
 }
public  DaoMaster getmDaoMaster(){
    return mDaoMaster;
}
public DaoSession getmDaoSession(){
    return mDaoSession;
}
public  void clear(){
    if (mDaoSession!=null){
        mDaoSession.clear();
        mDaoSession=null;
    }

}
public  void close(){
    clear();
    if (mHelpter!=null){
        mHelpter.close();
        mHelpter=null;
    }
}

}
