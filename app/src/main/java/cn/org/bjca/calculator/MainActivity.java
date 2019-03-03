package cn.org.bjca.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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


    }

    public void calculator(View view) {
        int salarys= Integer.parseInt(salary.getText().toString().trim());
        int subsidys= Integer.parseInt(subsidy.getText().toString().trim());
        int taxBases= Integer.parseInt(taxBase.getText().toString().trim());
        int gjjBases= Integer.parseInt(gjjBase.getText().toString().trim());
        int gongjijins= Integer.parseInt(gongjijin.getText().toString().trim());
        int medicals= Integer.parseInt(medical.getText().toString().trim());
        int yanglaos= Integer.parseInt(yanglao.getText().toString().trim());
        int shiyes= Integer.parseInt(shiye.getText().toString().trim());
        int gongshangs= Integer.parseInt(gongshang.getText().toString().trim());
        int shengyus= Integer.parseInt(shengyu.getText().toString().trim());

        

    }
}
