package com.linjun.yunjunrui.utils;

import android.content.Context;
import android.widget.EditText;
import com.throrinstudio.android.common.libs.validator.Form;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validator.EmailValidator;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;
import com.throrinstudio.android.common.libs.validator.validator.PhoneValidator;
import com.throrinstudio.android.common.libs.validator.validator.UrlValidator;
public class ValidationUtil {
    private static Form form;
    public   static  boolean IsEmpty(Context context, EditText text){
        Validate validate=new Validate(text);
        validate.addValidator(new NotEmptyValidator(context));
        form.addValidates(validate);
        return form.validate();
    }
    public   static  boolean IsPhoneMumber(Context cotext,EditText text){
        Validate validate=new Validate(text);
        validate.addValidator(new PhoneValidator(cotext));
        form.addValidates(validate);
        return form.validate();
    }

    public   static  boolean IsEmali(Context context ,EditText text){
        Validate validate=new Validate(text);
        validate.addValidator(new EmailValidator(context));
        form.addValidates(validate);
        return form.validate();
    }
    public   static  boolean IsURl(Context context,EditText text){
        Validate validate=new Validate(text);
        validate.addValidator(new UrlValidator(context));
        form.addValidates(validate);
        return  form.validate();
    }
}
