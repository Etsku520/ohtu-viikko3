package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";
        String urlC = "https://studies.cs.helsinki.fi/courses/courseinfo";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String bodyTextC = Request.Get(urlC).execute().returnContent().asString();
        

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );
        System.out.println( bodyTextC );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Submission[] subsC = mapper.fromJson(bodyTextC, Submission[].class);

        for (Submission subc : subsC) {
            boolean found = false;
            int tasks = 0;
            int hours = 0;
            int allex = 0;
            String lause = subc.getFullname() + " " + subc.getTerm() + " " + subc.getYear() + "\n\n";
            
            for (int ex : subc.getExercises()) {
                allex += ex;
            }
            
            
            for (Submission sub : subs) {
                if (sub.getCourse().equals(subc.getName())) {
                    found = true;
                    tasks += sub.getExercises().length;
                    hours += sub.getHours();
                    
                    lause += "viikko " + sub.getWeek() + ":\n";
                    lause += "tehtyhä tehtäviä yhteensä " + sub.getExercises().length + "/" + subc.getExercises()[sub.getWeek()] + " aikaa kului yhteensä " + sub.getHours() + " tehdyt tehtävät ";
        
                    for (int ex : sub.getExercises()) {
                        lause += ex + ", ";
                    }
                    lause += "\n";
                }
            }
            
            lause += "\nyhteensä: " + tasks + "/" + allex + " tehtävää " + hours + " tuntia\n\n";
            
            if (found) {
                System.out.println(lause);
            }
        }

    }
}