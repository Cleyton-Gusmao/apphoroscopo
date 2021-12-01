package com.pitagoras.apphoroscopo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity2 extends AppCompatActivity {

    EditText dia, mes;
    int numeroDia = 0, numeroMes = 0;
    Button btn_Resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dia = findViewById(R.id.dia);
        mes = findViewById(R.id.mes);

        btn_Resultado = (Button) findViewById(R.id.btn_Resultado);
        btn_Resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarData()) {
                    Intent tela3 = new Intent(MainActivity2.this, MainActivity3.class);
                    // Mandar os dados para a intent chamada tela3 e nao para getIntent() que a própria intent dessa tela
                    String signoEscolhido = signos();
                    tela3.putExtra("referencia", signoEscolhido);
                    tela3.putExtra("texto", textoPorSigno(signoEscolhido));
                    startActivity(tela3);
                    finish();
                }
            }
        });
    }

    private String textoPorSigno(String signo) {
        switch (signo) {
            case "Aquário":
                return "São amantes dos desafios e da liberdade!";

            case "Peixes":
                return "Emocinais espiritualizados!";

            case "Áries":
                return "Costuman ser individualistas e espontâneos!";

            case "Touro":
                return "São esforçados e práticos!";

            case "Gêmeos":
                return "Extrovertidos e amigões!";

            case "Câncer":
                return "Sensível e carinhoso!";

            case "Leão":
                return "São vaidosos e confiantes!";

            case "Virgem":
                return "Organizados e analíticos!";

            case "Libra":
                return "Equilibrado e justo!";

            case "Escorpião":
                return "Atraente e intenso";

            case "Sagitário":
                return "Independente e liberto";

            case "Capricórnio":
                return "A responsabilidade é seu ponto forte";

            default:
                return "Inválido!";
        }
    }


    public String signos() {
        String Signo = "";

        switch (numeroMes) {
            case 1:
                if (numeroDia > 21) {
                    Signo = "Aquário";
                } else {

                    Signo = "Capricórnio";

                }
                break;
            case 2:
                if (numeroDia > 19) {
                    Signo = "Peixes";
                } else {

                    Signo = "Aquário";

                }
                break;
            case 3:
                if (numeroDia > 20) {
                    Signo = "Áries";
                } else {

                    Signo = "Peixes";

                }
                break;
            case 4:
                if (numeroDia > 20) {
                    Signo = "Touro";
                } else {

                    Signo = "Áries";

                }
                break;
            case 5:
                if (numeroDia > 21) {
                    Signo = "Gêmeos";
                } else {

                    Signo = "Touro";

                }
                break;
            case 6:
                if (numeroDia > 20) {
                    Signo = "Câncer";
                } else {

                    Signo = "Gêmeos";

                }
                break;
            case 7:
                if (numeroDia > 22) {
                    Signo = "Leão";
                } else {

                    Signo = "Câncer";

                }
                break;
            case 8:
                if (numeroDia > 21) {
                    Signo = "Virgem";
                } else {

                    Signo = "Leão";

                }
                break;
            case 9:
                if (numeroDia > 22) {
                    Signo = "Libra";
                } else {

                    Signo = "Virgem";

                }
                break;
            case 10:
                if (numeroDia > 22) {
                    Signo = "Escorpião";
                } else {

                    Signo = "Libra";

                }
                break;
            case 11:
                if (numeroDia > 21) {
                    Signo = "Sagitário";
                } else {

                    Signo = "Escorpião";

                }
                break;
            case 12:
                if (numeroDia > 21) {
                    Signo = "Capricórnio";
                } else {

                    Signo = "Sagitário";

                }
                break;

        }

        return Signo;
    }

    private boolean validarData() {
        int mDia = Integer.parseInt(dia.getText().toString());
        int mMes = Integer.parseInt(mes.getText().toString());

        numeroDia = mDia;
        numeroMes = mMes;

        if (mMes == 1 || mMes == 3 || mMes == 5 || mMes == 7 || mMes == 8 || mMes == 10 || mMes == 12) {
            if (mDia > 31) {
                Toast.makeText(getApplicationContext(), "Insira um dia válido",
                        Toast.LENGTH_SHORT).show();
                return false;
            } else {
                return true;
            }
        }

        if (mMes == 4 || mMes == 6 || mMes == 9 || mMes == 11) {
            if (mDia > 30) {
                Toast.makeText(getApplicationContext(), "Insira um dia válido",
                        Toast.LENGTH_SHORT).show();
                return false;
            } else {
                return true;
            }
        }

        if (mMes == 2) {

            if (mDia > 29) {
                Toast.makeText(getApplicationContext(), "Insira um dia válido",
                        Toast.LENGTH_SHORT).show();
                return false;
            } else {
                return true;
            }
        }

        if (mMes > 12) {
            Toast.makeText(getApplicationContext(), "Insira uma mês válido",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}

