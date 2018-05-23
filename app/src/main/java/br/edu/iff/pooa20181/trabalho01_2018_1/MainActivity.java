package br.edu.iff.pooa20181.trabalho01_2018_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText edtTamanho;
    private Button  btCalcular;
    private TextView tMensagem;
    private TextView tMensagem2;
    private TextView tMensagem3;

    private float metros;
    private float litros;
    private int lata;
    private int galao;
    private float vLata;
    private float vGalao;
    private int mrLata = 0;
    private int mrGalao = 0;
    private float mvLata = 0;
    private float mvGalao = 0;
    private float resto;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTamanho = (EditText) findViewById(R.id.edtTamanho);
        btCalcular = (Button) findViewById(R.id.btCalcular);
        tMensagem = (TextView) findViewById(R.id.tMensagem);
        tMensagem2 = (TextView) findViewById(R.id.tMensagem2);
        tMensagem3 = (TextView) findViewById(R.id.tMensagem3);



        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcular();

                tMensagem.setText("Quantiade de latas: " + lata +"\nPreço: " + vLata );
                tMensagem2.setText("Quantiade de galões: " + galao +"\nPreço: " + vGalao );
                tMensagem3.setText("Melhor resultado: " + "\nQuantidade lata: " + mrLata +" Melhor preco: " +mvLata +
                        "\nQuantidade galao: "+ mrGalao  + " Melhor preco: " +mvGalao);

            }
        });

    }

    private void calcular() {


        metros = Float.parseFloat(edtTamanho.getText().toString());
        litros = metros / 6;

        lata = (int) (litros / 18);
        galao = (int) (litros / 3.6);





        if((litros % 18) !=  0)
        {
            lata = lata + 1;
        }
        vLata =  lata * 80;


        if((litros % 3.6) != 0)
        {
            galao = galao + 1;
        }
        vGalao =  lata * 25;

//Numero 4

        if(litros > 18)
        {
           mrLata = (int) litros / 18;

            resto = litros % 18;

            if((resto) > 10.8)
            {
                mrLata = mrLata + 1;
            }
            else{

                mrGalao = (int)((resto) / 3.6);
                if(resto != 0)
                {
                    mrGalao = mrGalao + 1;
                }
            }


        }

        mvLata = mrLata * 80;
        mvGalao = mrGalao * 25;






    }


}
