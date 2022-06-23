package fr.greta91.planeteapp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.greta91.planeteapp2022.adapter.PlaneteAdapter;
import fr.greta91.planeteapp2022.model.Planete;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Planete> planetes = getPlanetes();
        Log.i("planetes", planetes.toString());
        //créeation d'adaptateur
        /*ArrayAdapter<Planete> adapter =
                new ArrayAdapter<>(this,
                                    android.R.layout.simple_list_item_1,
                                    android.R.id.text1,
                                    planetes);*/
        PlaneteAdapter adapter =
                new PlaneteAdapter(this, planetes);
        //récupération de listviwe
        ListView lv = findViewById(android.R.id.list);
        lv.setAdapter(adapter);//modification d'adaptateur
    }

    private List<Planete> getPlanetes() {
        Resources resources = getResources();
        String[] nomPlanetes = resources.getStringArray(R.array.noms);
        int[] distancePlanetes = resources.getIntArray(R.array.distances);
        List<Planete> planetes = new ArrayList<>(9);
        //créer un tableau des ressources images
        int[] idImages = new int[]{
                R.drawable.mercury,
                R.drawable.venus,
                R.drawable.earth,
                R.drawable.mars,
                R.drawable.jupiter,
                R.drawable.saturn,
                R.drawable.uranus,
                R.drawable.neptune,
                R.drawable.pluto
        };
        for (int i=0; i<nomPlanetes.length; i++){
            planetes.add(new Planete(nomPlanetes[i], distancePlanetes[i], idImages[i]));
        }
        return  planetes;
    }

}
