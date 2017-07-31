package co.edu.uninorte.calculadoraprom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class Promediador extends AppCompatActivity {

    EditText n1;
    EditText n2;
    EditText n3;
    EditText n4;
    EditText nf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promediador);
        n1= (EditText) findViewById(R.id.nota1);
        n2= (EditText) findViewById(R.id.nota2);
        n3= (EditText) findViewById(R.id.nota3);
        n4= (EditText) findViewById(R.id.nota4);
        nf= (EditText) findViewById(R.id.notaf);
    }

    public void Decide(View view) {
        //Float entrada= Float.valueOf(n1.getText().toString());
        //n2.setText(entrada.toString());
        float x1,x2,x3,x4,xf;
        int cont = 0;
        int[] pos={1,1,1,1};
        float acum=0;
        if(TextUtils.isEmpty(n1.getText())){
            cont++;
            pos[0]=0;
        }else{
            acum=acum + Float.valueOf(n1.getText().toString());
        }

        if (TextUtils.isEmpty(n2.getText())){
            cont++;
            pos[1]=0;
        }else {
            acum=acum + Float.valueOf(n2.getText().toString());
        }

        if (TextUtils.isEmpty(n3.getText())){
            cont++;
            pos[2]=0;
        }else {
            acum=acum + Float.valueOf(n3.getText().toString());
        }

        if (TextUtils.isEmpty(n4.getText())){
            cont++;
            pos[3]=0;
        }else {
            acum=acum + Float.valueOf(n4.getText().toString());
        }

        if(cont>0){
            Double req;

            if (TextUtils.isEmpty(nf.getText())){
                req = ((3.8*4)-acum)/(cont);
            }else{
                Double x= Double.valueOf(nf.getText().toString());
                req = ((x*4)-acum)/(cont);
            }
            String out = String.valueOf(req);
            if (pos[0]==0){
                n1.setText(out);
            }
            if (pos[1]==0){
                n2.setText(out);
            }
            if (pos[2]==0){
                n3.setText(out);
            }
            if (pos[3]==0){
                n4.setText(out);
            }
        }
        else {
            x1= Float.valueOf(n1.getText().toString());
            x2= Float.valueOf(n2.getText().toString());
            x3= Float.valueOf(n3.getText().toString());
            x4= Float.valueOf(n4.getText().toString());
            xf=(x1+x2+x3+x4)/4;
            String out = String.valueOf(xf);
            nf.setText(out);
        }
    }
}
