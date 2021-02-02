package br.com.moldato.meuaplicativo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String[] CURSOS = new String[]{
                "Dispositivos móveis", "Programção web", "Banco de dados",
                "Lógica de programação", "Testes automatizados", "Engenharia de software",
                "Arquitetura limpa", "Introdução a SEO"
        };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        final String login = getIntent().getStringExtra("login");
        final TextView txtWellcome = (TextView) findViewById(R.id.txt_wellcome);
        final TextView txtDescriptList = (TextView) findViewById(R.id.txt_descript_list);
        final ListView listView = (ListView) findViewById(R.id.lv_cursos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, CURSOS);

        listView.setAdapter(adapter);
        txtWellcome.setText("Olá "+ login +", ");
        txtDescriptList.setText("aqui está usa lista de cursos");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}