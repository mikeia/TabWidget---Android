package com.example.unipar.myapplication;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends TabActivity {
    private EditText edItem;
    private List<String> dados = new ArrayList<String>();
    private ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        montarTabs();
        ListView lstDados = (ListView)findViewById(R.id.tabList);
        lstDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //removerItem(position);

            }
        });
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
        lstDados.setAdapter(aa);
        edItem = (EditText)findViewById(R.id.edItem);
        findViewById(R.id.btConfirmar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarItem();
            }
        });

    }
    private void montarTabs(){
        getTabHost().addTab(getTabHost()
                .newTabSpec("tag2")
                .setContent(R.id.tabAdd)
                .setIndicator("Adicionar item")
        );
        getTabHost().addTab(getTabHost().newTabSpec("tag1")
                .setContent(R.id.tabList)
                .setIndicator("Minha lista"));
        getTabHost().setCurrentTab(0);
    }
    public void adicionarItem(){
        dados.add(edItem.getText().toString());
        edItem.setText("");
        aa.notifyDataSetChanged();
    }

    public void removerItem(int posicao ){
        dados.remove(posicao);
        aa.notifyDataSetChanged();
    }
}
