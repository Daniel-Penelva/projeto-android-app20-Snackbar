package com.formacaoandroidstudio.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonAbrir, buttonFechar;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAbrir = findViewById(R.id.buttonAbrir);
        buttonFechar = findViewById(R.id.buttonFechar);

        // Evento de click do botão abrir
        buttonAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 Snackbar.make(view, "Visualizando SnackBar", Snackbar.LENGTH_LONG).setAction("Confirmar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonAbrir.setText("Botão abrir Alterado");

                        Toast.makeText(MainActivity.this, "Você clicou no botão Confirmar!", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();
            }
        });

        /*
        // Evento de click do botão fechar
        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //encerra a snackbar
                snackbar.dismiss();

                Toast.makeText(MainActivity.this, "Você clicou no botão Fechar!", Toast.LENGTH_SHORT).show();
            }
        });
       */
    }
}

/* Anotações:
* Antes de poder usar as Snackbar, você precisa adicionar uma dependência à biblioteca Material Components para Android.
* Você pode adicionar uma ação a um Snackbar, permitindo que o usuário responda à sua mensagem. Se você adicionar uma ação a um
* Snackbar, o Snackbar colocará um botão ao lado do texto da mensagem. O usuário pode acionar sua ação pressionando o botão.
* Por exemplo, um app de e-mails pode colocar um botão desfazer na mensagem "e-mail arquivado". Se o usuário clicar no botão desfazer,
* o app removerá o e-mail do arquivo.
*
* Para adicionar uma ação a uma mensagem do Snackbar, você precisa definir um objeto listener que implemente a interface
* View.OnClickListener. O sistema chamará o método onClick() do listener se o usuário clicar na ação da mensagem.
*
* O Snackbar fornece uma estática 'make' que é o método para produzir uma Snackbar configurada da maneira desejada. Esse método leva
* como parametro uma 'View', que será usado para encontrar um ancestral adequado ViewGroup para exibir a barra de Snackbar, uma string
* de texto para exibir a mensagem e uma duração para exibir a barra de snackbar. Um ancestral adequado ViewGroup será o mais próximo
* CoordenadorLayout para o View passado, ou a DecorView se nenhum pudesse ser encontrado.
*
* As predefinições de duração disponíveis são:
*  -> LENGTH_INDEFINITE(Mostrar a barra de Snackbar até que ela seja descartada ou outra barra de Snackbar seja mostrada)
*  -> LENGTH_LONG(Mostrar o snackbar por um longo período de tempo)
* -> LENGTH_SHORT(Mostrar o snackbar por um curto período de tempo)
*
* Snackbars funcionam melhor se forem exibidos dentro de um CoordenadorLayout. CoordenadorLayout permite que a barra de Snackbar
* habilite comportamentos como deslizar para dispensar, bem como mover automaticamente widgets como FloatingActionButton.
*
* Fonte: https://m2.material.io/components/snackbars/android#using-snackbars
* */
