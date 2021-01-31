package com.example.recyclerviewrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        TextView mtextHeader = findViewById(R.id.textView_heading);
        TextView mtextContent = findViewById(R.id.textView2);



        mtextHeader.setText("HEADING");
        mtextContent.setText("Ingredients\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Metric\\n\" +\n" +
                "                \"150 g packet miso ramen noodles (or plain noodles)\\n\" +\n" +
                "                \"1 handful frozen peas, or any vegetables you have lurking in the fridge (carrots, sugarsnap peas, corn, bean sprouts, finely shredded cabbage, courgette etc)\\n\" +\n" +
                "                \"1 egg\\n\" +\n" +
                "                \"1 tbsp red or brown miso paste (if using plain noodles)\\n\" +\n" +
                "                \"1 fresh green chilli, sliced\\n\" +\n" +
                "                \"1 spring onion, sliced and placed in a bowl of iced water for a few minutes\\n\" +\n" +
                "                \"1 pinch black or white sesame seeds\\n\" +\n" +
                "                \"1 tsp toasted sesame oil, to taste\\n\" +\n" +
                "                \"1 handful Japanese dried nori seaweed, to serve (optional)\\n\" +\n" +
                "                \"5.3 oz packet miso ramen noodles (or plain noodles)\\n\" +\n" +
                "                \"1 handful frozen peas, or any vegetables you have lurking in the fridge (carrots, sugarsnap peas, corn, bean sprouts, finely shredded cabbage, courgette etc)\\n\" +\n" +
                "                \"1 egg\\n\" +\n" +
                "                \"1 tbsp red or brown miso paste (if using plain noodles)\\n\" +\n" +
                "                \"1 fresh green chilli, sliced\\n\" +\n" +
                "                \"1 spring onion, sliced and placed in a bowl of iced water for a few minutes\\n\" +\n" +
                "                \"1 pinch black or white sesame seeds\\n\" +\n" +
                "                \"1 tsp toasted sesame oil, to taste\\n\" +\n" +
                "                \"1 handful Japanese dried nori seaweed, to serve (optional)\\n\" +\n" +
                "                \"5.3 oz packet miso ramen noodles (or plain noodles)\\n\" +\n" +
                "                \"1 handful frozen peas, or any vegetables you have lurking in the fridge (carrots, sugarsnap peas, corn, bean sprouts, finely shredded cabbage, courgette etc)\\n\" +\n" +
                "                \"1 egg\\n\" +\n" +
                "                \"1 tbsp red or brown miso paste (if using plain noodles)\\n\" +\n" +
                "                \"1 fresh green chilli, sliced\\n\" +\n" +
                "                \"1 spring onion, sliced and placed in a bowl of iced water for a few minutes\\n\" +\n" +
                "                \"1 pinch black or white sesame seeds\\n\" +\n" +
                "                \"1 tsp toasted sesame oil, to taste\\n\" +\n" +
                "                \"1 handful Japanese dried nori seaweed, to serve (optional)\\n\" +\n" +
                "                \" \\n\" +\n" +
                "                \"Details\\n\" +\n" +
                "                \"Cuisine: Japanese\\n\" +\n" +
                "                \"Recipe Type: Ramen\\n\" +\n" +
                "                \"Difficulty: Easy\\n\" +\n" +
                "                \"Preparation Time: 5 mins\\n\" +\n" +
                "                \"Cooking Time: 10 mins\\n\" +\n" +
                "                \"Serves: 1\\n\" +\n" +
                "                \"Step-by-step\\n\" +\n" +
                "                \"Cook the ramen noodles according to the packet instructions, adding the frozen peas (or whichever vegetables you opt for) to the pan so they cook at the same time.\\n\" +\n" +
                "                \"Cook the egg by poaching it in the broth (whisk it in a bowl first then pour it into the broth or crack it in), boiling it whole in a separate pan, or giving it a quick fry.\\n\" +\n" +
                "                \"Add the miso paste to the noodle cooking liquid (if cooking plain noodles) and stir through.\\n\" +\n" +
                "                \"Remove from the heat and garnish with the chilli, drained spring onion, sesame seeds, sesame oil and any other toppings you like.\\n\" +\n" +
                "                \"The egg goes on last if you cooked it separately, along with the seaweed (if using).");

    }
}