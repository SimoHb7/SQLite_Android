package com.example.listapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.listapp.service.ProduitService;
import com.example.listapp.classes.Produit;

public class DetailsPizzas extends AppCompatActivity {
    private ProduitService ps;
    private ImageView image;
    private TextView desc;
    private TextView nom;
    private TextView ingrediants;
    private static final String TAG = "DetailsPizzas"; // Pour les logs

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pizzas);

        // Ajout de la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialisation du service Produit
        ps = ProduitService.getInstance();

        // Liaison avec les éléments de l'UI
        image = findViewById(R.id.photo);
        nom = findViewById(R.id.nom);
        desc = findViewById(R.id.description);
        ingrediants = findViewById(R.id.detaisIngrediant);

        // Vérification de l'intent et récupération de l'ID
        Intent intent = getIntent();
        int id = -1; // Valeur par défaut si l'ID est invalide

        if (intent != null && intent.hasExtra("idf")) {
            try {
                id = Integer.parseInt(intent.getStringExtra("idf"));
            } catch (NumberFormatException e) {
                Log.e(TAG, "Erreur de conversion de l'ID : " + e.getMessage());
            }
        } else {
            Log.e(TAG, "L'ID de la pizza est introuvable dans l'intent !");
        }

        // Vérifier si l'ID est valide avant de chercher le produit
        if (id != -1) {
            Produit p = ps.findById(id);
            if (p != null) {
                image.setImageResource(p.getPhoto());
                ingrediants.setText(p.getDetaisIngrediant());
                desc.setText(p.getDescription());
                nom.setText(p.getNom());
            } else {
                Log.e(TAG, "Produit introuvable pour l'ID : " + id);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pizza_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_share) {
            sharePizzaDetails();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sharePizzaDetails() {
        String pizzaName = nom.getText().toString();
        String pizzaDescription = desc.getText().toString();
        String pizzaIngredients = ingrediants.getText().toString();

        String message = "🍕 " + pizzaName + "\n\n" +
                "📖 Description : " + pizzaDescription + "\n\n" +
                "🥒 Ingrédients : " + pizzaIngredients + "\n\n" +
                "Bon appétit ! 😋";

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, message);

        try {
            startActivity(Intent.createChooser(shareIntent, "Partager cette recette via"));
        } catch (Exception e) {
            Toast.makeText(this, "Erreur lors du partage", Toast.LENGTH_SHORT).show();
        }
    }
}
