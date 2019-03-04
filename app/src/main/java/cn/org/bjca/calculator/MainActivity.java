package cn.org.bjca.calculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText salary;
    private EditText subsidy;
    private EditText taxBase;
    private EditText gjjBase;
    private EditText gongjijin;
    private EditText medical;
    private EditText yanglao;
    private EditText shiye;
    private EditText gongshang;
    private EditText shengyu;
    double personTax;
    private EditText kouchu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salary = (EditText) findViewById(R.id.salary);
        subsidy = (EditText) findViewById(R.id.subsidy);
        taxBase = (EditText) findViewById(R.id.taxBase);
        gjjBase = (EditText) findViewById(R.id.gjjBase);
        gongjijin = (EditText) findViewById(R.id.gongjijin);
        medical = (EditText) findViewById(R.id.medical);
        yanglao = (EditText) findViewById(R.id.yanglao);
        shiye = (EditText) findViewById(R.id.shiye);
        gongshang = (EditText) findViewById(R.id.gongshang);
        shengyu = (EditText) findViewById(R.id.shengyu);
        kouchu = (EditText) findViewById(R.id.kouchu);


    }

    public void calculator(View view) {
        double salarys = Double.parseDouble(salary.getText().toString().trim().equals("")
                ? "0" : salary.getText().toString().trim());
        double subsidys = Double.parseDouble(subsidy.getText().toString().trim().equals("")
                ? "0" : subsidy.getText().toString().trim());
        double taxBases = Double.parseDouble(taxBase.getText().toString().trim().equals("")
                ? "0" : taxBase.getText().toString().trim());
        double gjjBases = Double.parseDouble(gjjBase.getText().toString().trim().equals("")
                ? "0" : gjjBase.getText().toString().trim());
        double gongjijins = Double.parseDouble(gongjijin.getText().toString().trim().equals("")
                ? "0" : gongjijin.getText().toString().trim());
        double medicals = Double.parseDouble(medical.getText().toString().trim().equals("")
                ? "0" : medical.getText().toString().trim());
        double yanglaos = Double.parseDouble(yanglao.getText().toString().trim().equals("")
                ? "0" : yanglao.getText().toString().trim());
        double shiyes = Double.parseDouble(shiye.getText().toString().trim().equals("")
                ? "0" : shiye.getText().toString().trim());
        double gongshangs = Double.parseDouble(gongshang.getText().toString().trim().equals("")
                ? "0" : gongshang.getText().toString().trim());
        double shengyus = Double.parseDouble(shengyu.getText().toString().trim().equals("")
                ? "0" : shengyu.getText().toString().trim());
        double kouchus = Double.parseDouble(kouchu.getText().toString().trim().equals("")
                ? "0" : kouchu.getText().toString().trim());

        DecimalFormat df = new DecimalFormat("0.00");

        double gongjijint = Double.parseDouble(df.format(gjjBases * gongjijins / 100));//应缴纳公积金
        double medicalt = Double.parseDouble(df.format(taxBases * medicals / 100));
        double yanglaot = Double.parseDouble(df.format(taxBases * yanglaos / 100));
        double shiyet = Double.parseDouble(df.format(taxBases * shiyes / 100));
        double gongshangt = Double.parseDouble(df.format(taxBases * gongshangs / 100));
        double shengyut = Double.parseDouble(df.format(taxBases * shengyus / 100));


        double afterSecurity = salarys + subsidys - gongjijint - medicalt - yanglaot
                - shiyet - gongshangt - shengyut-kouchus;//扣除社保、公积金和专项扣除项后所剩额

        if (afterSecurity <= 5000) {
            personTax = 0;
        } else if (afterSecurity > 5000 && afterSecurity <= 8000) {
            personTax = (afterSecurity - 5000) * 0.03;
        } else if (afterSecurity > 8000 && afterSecurity <= 17000) {
            personTax = (afterSecurity - 5000) * 0.10 - 210;
        } else if (afterSecurity > 17000 && afterSecurity <= 30000) {
            personTax = (afterSecurity - 5000) * 0.20 - 1410;
        } else if (afterSecurity > 30000 && afterSecurity <= 40000) {
            personTax = (afterSecurity - 5000) * 0.25 - 2660;
        } else if (afterSecurity > 40000 && afterSecurity <= 60000) {
            personTax = (afterSecurity - 5000) * 0.30 - 4410;
        } else if (afterSecurity > 60000 && afterSecurity <= 85000) {
            personTax = (afterSecurity - 5000) * 0.35 - 7160;
        } else if (afterSecurity > 85000) {
            personTax = (afterSecurity - 5000) * 0.45 - 15160;
        }

        double security = gongjijint + medicalt + yanglaot + shiyet + gongshangt + shengyut;
        double left = afterSecurity +kouchus- personTax;
        AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
        builder.setMessage(
                "税后所得：" + Double.parseDouble(df.format(left)) + "\n" +
                        "个税：" + Double.parseDouble(df.format(personTax)) + "\n" +
                        "五险一金总计："+Double.parseDouble(df.format(security))+ "\n" +
                        "公积金：" + gongjijint + "\n" +
                        "医疗：" + medicalt + "\n" +
                        "养老：" + yanglaot + "\n" +
                        "失业：" + shiyet + "\n" +
                        "工伤：" + gongshangt + "\n" +
                        "生育：" + shengyut + "\n"
        );
        builder.show();

    }
}
