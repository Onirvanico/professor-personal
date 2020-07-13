package br.com.projeto.professorpersonal.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import br.com.projeto.professorpersonal.R;
import br.com.projeto.professorpersonal.model.Trainer;

import static br.com.projeto.professorpersonal.ui.ChaveIntent.TRAINERKEY;

public class MainActivity extends AppCompatActivity {

    public static final String APP_BAR_FORM = "Formulário";
    public static final String TITULO_CAIXA_ALERTA = "Confirmar cadastro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(APP_BAR_FORM);

        final TextView inputNome = findViewById(R.id.main_input_nome);
        final TextView inputSobrenome = findViewById(R.id.main_input_sobrenome);
        final TextView inputRegistro = findViewById(R.id.main_input_registro);
        final TextView inputIdentidade = findViewById(R.id.main_input_identidade);
        final TextView inputEmail = findViewById(R.id.main_input_email);

        Button btCadastrar = findViewById(R.id.main_bt_cadastrar);
        btCadastrar.setOnClickListener(view -> configuraAlertDialog(inputNome,
                inputSobrenome,
                inputRegistro,
                inputIdentidade,
                inputEmail));

    }


    private void configuraAlertDialog(final TextView inputNome, final TextView inputSobrenome,
                                      final TextView inputRegistro, final TextView inputIdentidade,
                                      final TextView inputEmail) {

        new AlertDialog.Builder(this)
                .setTitle(TITULO_CAIXA_ALERTA)
                .setMessage("Confirmar cadastro?")
                .setPositiveButton("sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Trainer trainer = preencheTrainer(inputNome, inputSobrenome,
                                inputRegistro,
                                inputIdentidade,
                                inputEmail);
                        vaiParaTelaVerificaComDadosTrainer(trainer);
                    }
                }).setNegativeButton("não", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .create()
                .show();
    }

    private void vaiParaTelaVerificaComDadosTrainer(Trainer trainer) {
        Intent intent = new Intent(MainActivity.this,
                VerificaDadosActivity.class);
        intent.putExtra(TRAINERKEY, trainer);
        startActivity(intent);
    }

    private Trainer preencheTrainer(TextView inputNome, TextView inputSobrenome,
                                    TextView inputRegistro, TextView inputIdentidade,
                                    TextView inputEmail) {

        String nome = inputNome.getText().toString();
        String sobrenome = inputSobrenome.getText().toString();
        String numeroRegistro = inputRegistro.getText().toString();
        String numeroIdentidade = inputIdentidade.getText().toString();
        String email = inputEmail.getText().toString();
        return new Trainer(nome,
                sobrenome,
                numeroRegistro,
                numeroIdentidade,
                email);
    }
}
