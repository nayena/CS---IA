package Score.pkg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class ChatGPT {
    // The 'promptTemplate' is a template for the prompt used in the AI model.
    // It provides instructions for scoring extracurricular activities.
    private static String promptTemplate = "You are to evaluate how impactful extracurricular activities are for university application. You must provide a score between 0 to 100. Output a single number and nothing else. \n"
            + "\n"
            + "Activity: Culturama Leader: Dance showcase in front 800+ people\n"
            + "Score: 85\n"
            + "\n"
            + "Activity: Founder of indie game studio, dynabox games\n"
            + "Score:  95\n"
            + "\n"
            + "Activity: <<ACTIVITY>>\n"
            + "Score: ";
    
    // The 'answerMe' method takes an activity description as input, and it uses the OpenAI API to generate a score for it.
    public static String answerMe(String text) throws Exception {
        String prompt = promptTemplate.replace("<<ACTIVITY>>", text);

        // Initialize the URL for the OpenAI API.
        String url = "https://api.openai.com/v1/completions";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        // Set the HTTP request method and request headers.
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer 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");

        // Create a JSON object to hold the API request data, including the prompt.
        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", prompt);
        data.put("max_tokens", 4000);
        data.put("temperature", 1.0);

        // Set 'doOutput' to true to allow sending data in the request body.
        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        // Read the response from the API and extract the generated text.
        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();

        // Parse the JSON response to get the generated text (the score).
        return (new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));
    }

    public static void main(String[] args) throws Exception {
        // Example usage of the 'answerMe' method with an activity description.
        System.out.println(answerMe("Swimming with a care center"));
    }
}