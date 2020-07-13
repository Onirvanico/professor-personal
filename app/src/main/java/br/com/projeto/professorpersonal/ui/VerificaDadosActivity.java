package br.com.projeto.professorpersonal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.projeto.professorpersonal.R;
import br.com.projeto.professorpersonal.model.Trainer;

import static br.com.projeto.professorpersonal.ui.ChaveIntent.TRAINERKEY;

public class VerificaDadosActivity extends AppCompatActivity {

    public static final String APP_BAR_TITULO = "Verificação dos Dados";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica_dados);

        TextView nome = findViewById(R.id.verifica_nome);
        TextView sobrenome = findViewById(R.id.verifica_sobrenome);
        TextView registro = findViewById(R.id.verifica_registro);
        TextView identidade = findViewById(R.id.verifica_identidade);
        TextView email = findViewById(R.id.verifica_email);

        setTitle(APP_BAR_TITULO);

        if(getIntent().hasExtra(TRAINERKEY)) {
            Trainer trainer = getIntent().getParcelableExtra(TRAINERKEY);
            if(trainer != null) {
                preencheCampos(nome, sobrenome, registro, identidade, email, trainer);
            }
        }
    }

    private void preencheCampos(TextView nome, TextView sobrenome, TextView registro, TextView identidade, TextView email, Trainer trainer) {
        nome.setText("Nome: " + trainer.getNome());
        sobrenome.setText("Sobrenome: " + trainer.getSobreNome());
        registro.setText("Nº CREF: " + trainer.getNumeroCREF());
        identidade.setText("Nº Identidade: " + trainer.getNumeroIdentidade());
        email.setText("Email: " + trainer.getEmail());
    }
}
