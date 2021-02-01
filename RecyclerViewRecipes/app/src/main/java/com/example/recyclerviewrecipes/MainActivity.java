package com.example.recyclerviewrecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;
    private final LinkedList<Recipe> mRecipeList = new LinkedList<>();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Recipe recipe = new Recipe("Ramen, Japan","A Japanese noodle soup, ramen has grown in popularity in the last decade " +
                "and it's easy to see why. In its simple form, it's a rich meat (or occasionally fish) broth, flavoured with " +
                "soy or miso and served with toppings such as mushrooms, seaweed, sesame seeds, spring onions and soft-boiled egg. " +
                "As with most dishes, there are regional varieties too, including the most popular tonkotsu (pork bone broth) ramen of Kyushu " +
                "and the miso ramen of Hokkaido.",
                "Ingredients\n" +
                "\n" +
                "Metric\n" +
                "150 g packet miso ramen noodles (or plain noodles)\n" +
                "1 handful frozen peas, or any vegetables you have lurking in the fridge (carrots, sugarsnap peas, corn, bean sprouts, finely shredded cabbage, courgette etc)\n" +
                "1 egg\n" +
                "1 tbsp red or brown miso paste (if using plain noodles)\n" +
                "1 fresh green chilli, sliced\n" +
                "1 spring onion, sliced and placed in a bowl of iced water for a few minutes\n" +
                "1 pinch black or white sesame seeds\n" +
                "1 tsp toasted sesame oil, to taste\n" +
                "1 handful Japanese dried nori seaweed, to serve (optional)\n" +
                "5.3 oz packet miso ramen noodles (or plain noodles)\n" +
                "1 handful frozen peas, or any vegetables you have lurking in the fridge (carrots, sugarsnap peas, corn, bean sprouts, finely shredded cabbage, courgette etc)\n" +
                "1 egg\n" +
                "1 tbsp red or brown miso paste (if using plain noodles)\n" +
                "1 fresh green chilli, sliced\n" +
                "1 spring onion, sliced and placed in a bowl of iced water for a few minutes\n" +
                "1 pinch black or white sesame seeds\n" +
                "1 tsp toasted sesame oil, to taste\n" +
                "1 handful Japanese dried nori seaweed, to serve (optional)\n" +
                "5.3 oz packet miso ramen noodles (or plain noodles)\n" +
                "1 handful frozen peas, or any vegetables you have lurking in the fridge (carrots, sugarsnap peas, corn, bean sprouts, finely shredded cabbage, courgette etc)\n" +
                "1 egg\n" +
                "1 tbsp red or brown miso paste (if using plain noodles)\n" +
                "1 fresh green chilli, sliced\n" +
                "1 spring onion, sliced and placed in a bowl of iced water for a few minutes\n" +
                "1 pinch black or white sesame seeds\n" +
                "1 tsp toasted sesame oil, to taste\n" +
                "1 handful Japanese dried nori seaweed, to serve (optional)\n" +
                " \n" +
                "Details\n" +
                "Cuisine: Japanese\n" +
                "Recipe Type: Ramen\n" +
                "Difficulty: Easy\n" +
                "Preparation Time: 5 mins\n" +
                "Cooking Time: 10 mins\n" +
                "Serves: 1\n" +
                "Step-by-step\n" +
                "Cook the ramen noodles according to the packet instructions, adding the frozen peas (or whichever vegetables you opt for) to the pan so they cook at the same time.\n" +
                "Cook the egg by poaching it in the broth (whisk it in a bowl first then pour it into the broth or crack it in), boiling it whole in a separate pan, or giving it a quick fry.\n" +
                "Add the miso paste to the noodle cooking liquid (if cooking plain noodles) and stir through.\n" +
                "Remove from the heat and garnish with the chilli, drained spring onion, sesame seeds, sesame oil and any other toppings you like.\n" +
                "The egg goes on last if you cooked it separately, along with the seaweed (if using).");

        Recipe recipe2 = new Recipe("Cacio e pepe, Italy","There are countless divine Italian pasta recipes, but this one is genius in its simplicity. Translating as \"cheese and pepper\", the dish, as its name suggests, uses a handful of basic ingredients: black pepper, cheese, pasta and butter. You'll find versions made with either spaghetti or pici, which is a short, thick worm-like pasta, and there's also debate about what cheese to use – it's usually either Parmesan or pecorino romano.","Ingredients\\n\" +\n" +
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

        Recipe recipe3 = new Recipe("Boeuf bourguignon, France","This classic French dish might look rustic, but plenty of work and skill goes into making it just right. Consisting of beef slowly braised in red wine, plus beef stock, carrots, onions and sometimes mushrooms, this super-rich dish is packed with layers of flavour. It's also become one of the most famous recipes from Julia Child's groundbreaking cookbook The French Chef.","Ingredients\n" +
                "\n" +
                "Metric\n" +
                "800 g Beef brisket, cut into large cubes\n" +
                "1 l Full-bodied red wine\n" +
                "2 Thyme sprigs\n" +
                "4 Garlic cloves, crushed with the flat edge of a knife or your hand\n" +
                "3 tbsp Cognac\n" +
                "100 ml Sunflower oil\n" +
                "2 tbsp Plain flour\n" +
                "600 ml Veal stock or chicken stock\n" +
                "2 Carrots, peeled, halved lengthways and cut into chunks\n" +
                "12 Silverskin onions\n" +
                "100 g Small button mushrooms\n" +
                "100 g Pancetta, diced\n" +
                "1 handful Flat-leaf parsley, roughly chopped\n" +
                "1 pinch Salt\n" +
                "1 pinch Freshly ground black pepper\n" +
                "1 Bouquet garni (made with 1 parsley sprig, 1 thyme sprig and 1 small bay leaf)\n" +
                "28.2 oz Beef brisket, cut into large cubes\n" +
                "1.8 pints Full-bodied red wine\n" +
                "2 Thyme sprigs\n" +
                "4 Garlic cloves, crushed with the flat edge of a knife or your hand\n" +
                "3 tbsp Cognac\n" +
                "3.5 fl oz Sunflower oil\n" +
                "2 tbsp Plain flour\n" +
                "21.1 fl oz Veal stock or chicken stock\n" +
                "2 Carrots, peeled, halved lengthways and cut into chunks\n" +
                "12 Silverskin onions\n" +
                "3.5 oz Small button mushrooms\n" +
                "3.5 oz Pancetta, diced\n" +
                "1 handful Flat-leaf parsley, roughly chopped\n" +
                "1 pinch Salt\n" +
                "1 pinch Freshly ground black pepper\n" +
                "1 Bouquet garni (made with 1 parsley sprig, 1 thyme sprig and 1 small bay leaf)\n" +
                "28.2 oz Beef brisket, cut into large cubes\n" +
                "4.2 cups Full-bodied red wine\n" +
                "2 Thyme sprigs\n" +
                "4 Garlic cloves, crushed with the flat edge of a knife or your hand\n" +
                "3 tbsp Cognac\n" +
                "0.4 cup Sunflower oil\n" +
                "2 tbsp Plain flour\n" +
                "2.5 cups Veal stock or chicken stock\n" +
                "2 Carrots, peeled, halved lengthways and cut into chunks\n" +
                "12 Silverskin onions\n" +
                "3.5 oz Small button mushrooms\n" +
                "3.5 oz Pancetta, diced\n" +
                "1 handful Flat-leaf parsley, roughly chopped\n" +
                "1 pinch Salt\n" +
                "1 pinch Freshly ground black pepper\n" +
                "1 Bouquet garni (made with 1 parsley sprig, 1 thyme sprig and 1 small bay leaf)\n" +
                " \n" +
                "Details\n" +
                "Cuisine: French\n" +
                "Recipe Type: Main\n" +
                "Difficulty: Medium\n" +
                "Preparation Time: 200 mins\n" +
                "Cooking Time: 135 mins\n" +
                "Serves: 4\n" +
                "Step-by-step\n" +
                "In a deep dish, mix together the beef, wine, thyme, garlic and Cognac. Cover with cling film and leave to marinate in the fridge for at least 3 hours.\n" +
                "Drain the meat into a bowl, using a colander, and reserve the marinade.\n" +
                "Heat 4 tablespoons of the oil in a large saucepan or cast iron pot over a medium hear. Add the meat and cook for 20 minutes until brown, season with salt and pepper, then sprinkle with the flour and cook, stirring, for a further 2-3 minutes.\n" +
                "Add the stock and reserved marinade and bring to the boil. Skim the foam off the surface and add the bouquet garni, then reduce the heat to low and simmer, partially covered, for 1 hour 45 minutes, stirring occasionally, until the meat is tender. By that time you should have a rich, silky sauce.\n" +
                "About 50 minutes before the end of the cooking time, heat another medium saucepan with 1 tablespoon of the oil over a medium-low heat. Add the carrots and onions and cook for 10 minutes or until soft and pale gold in colour, then add to the meat saucepan.\n" +
                "When the beef is almost ready, heat the remaining oil in a frying pan over a medium heat. Add the mushrooms and pancetta and fry 8-10 minutes, stirring occasionally, until golden brown, then add them to the beef. Check the seasoning adjusting the salt and pepper, if necessary, throw in the parsley and stir gently without breaking the delicate pieces of beef.\n" +
                "Serve with hot creamed mash potatoes for a perfect winter warmer.");
        mRecipeList.addLast(recipe);
        mRecipeList.addLast(recipe2);
        mRecipeList.addLast(recipe3);
        mRecipeList.addLast(recipe);
        mRecipeList.addLast(recipe2);
        mRecipeList.addLast(recipe3);
        mRecipeList.addLast(recipe);
        mRecipeList.addLast(recipe2);
        mRecipeList.addLast(recipe3);
        Log.d(LOG_TAG, "onCreate: First "+mRecipeList.getFirst().recipeTitle);
        Log.d(LOG_TAG, "onCreate: LAST "+mRecipeList.getLast().recipeTitle);
        Log.d(LOG_TAG, "onCreate: SIZE!!!!!!!!!!!! "+mRecipeList.size());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       mRecyclerView = findViewById(R.id.recyclerview);
       mAdapter = new RecipeListAdapter(this, mRecipeList);

       mRecyclerView.setAdapter(mAdapter);
       mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}