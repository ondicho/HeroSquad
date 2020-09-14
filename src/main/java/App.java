import com.sun.org.apache.xpath.internal.objects.XObject;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.debug.DebugScreen.enableDebugScreen;

public class App {
    public static void main(String[] args) {
        enableDebugScreen();
        get("/", (req, res) -> {
//            Hero firstHero = new Hero("superman", 123, "flying", "kryptonite");

            ArrayList myHeroArrayList = Hero.getAll();
            Map<String, ArrayList<Hero>> model = new HashMap<>();
            model.put("myHero", myHeroArrayList);
            return new ModelAndView(model, "/index.hbs");
            }, new HandlebarsTemplateEngine());


        post("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String heroName= request.queryParams("name");
            request.session().attribute("name", heroName);
            model.put("username", heroName);

            String heroAge= request.queryParams("age");
            request.session().attribute("age", heroAge);
            model.put("age", heroAge);

            String heroSuperPower= request.queryParams("superPower");
            request.session().attribute("superPower", heroSuperPower);
            model.put("superPower",heroSuperPower);

            String heroWeakness= request.queryParams("weakness");
            request.session().attribute("weakness", heroWeakness);
            model.put("weakness",heroWeakness);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad/new", (req, res) -> {
            Map<String, ArrayList<Squad>> model = new HashMap<>();
//            ArrayList myHeroArrayList = Hero.getAll();
//            Map<String, ArrayList<Hero>> model = new HashMap<>();
//            model.put("heroSquad", myHeroArrayList);
            return new ModelAndView(model, "/heroSquad.hbs");
        }, new HandlebarsTemplateEngine());
    }

}

