import com.sun.org.apache.xpath.internal.objects.XObject;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        enableDebugScreen();
        staticFileLocation("/public");
        get("/", (req, res) -> {
//            Hero firstHero = new Hero("superman", 123, "flying", "kryptonite");

            ArrayList myHeroArrayList = Hero.getAll();
            Map<String, ArrayList<Hero>> model = new HashMap<>();
            model.put("myHero", myHeroArrayList);
            return new ModelAndView(model, "/index.hbs");
            }, new HandlebarsTemplateEngine());


        post("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

           String name=req.queryParams("name");
           int age = Integer.parseInt(req.queryParams("age"));
           String superPower=req.queryParams("superPower");
           String weakness=req.queryParams("weakness");

           Hero myHero=new Hero(name,age,superPower,weakness);
           model.put("myHero", myHero);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroSquad", (req, res) -> {
            Map<String, ArrayList<Hero>> model = new HashMap<>();
            return new ModelAndView(model, "/heroSquad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

           String squadName=req.queryParams("squadName");
           String cause=req.queryParams("cause");

           Squad mySquad=new Squad(squadName,cause);
           model.put("heroSquad", mySquad);

            return new ModelAndView(model, "/squadSuccess.hbs");
        }, new HandlebarsTemplateEngine());
    }

}

