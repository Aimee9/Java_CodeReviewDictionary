import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/home.vtl");
      model.put("vocabulary", Word.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/words", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      String title = request.queryParams("title");
      Word newWord = new Word(title);

      model.put("vocabulary", Word.all());
      model.put("title", title);
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word title = Word.find(Integer.parseInt(request.params(":id")));

      model.put("title", title);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words/:id/meaning", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word title = Word.find(Integer.parseInt(request.params(":id")));
      ArrayList<Definition> definition = title.getDefinitions();
      String meaning = request.queryParams("meaning");
      Definition newDefinition = new Definition(meaning);

      model.put("definition", definition);
      model.put("title", title);
      model.put("meaning", meaning);
      model.put("uses", Definition.all());
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
