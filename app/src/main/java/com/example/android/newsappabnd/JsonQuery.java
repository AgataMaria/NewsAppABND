package com.example.android.newsappabnd;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class JsonQuery {
    Context context;
    private final static String jsonSource = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":28808,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":2881,\"edition\":{\"id\":\"uk/culture\",\"webTitle\":\"Culture\",\"webUrl\":\"https://www.theguardian.com/uk/culture\",\"apiUrl\":\"https://content.guardianapis.com/uk/culture\",\"code\":\"uk\"},\"section\":{\"id\":\"uk/culture\",\"webTitle\":\"Culture\",\"webUrl\":\"https://www.theguardian.com/uk/culture\",\"apiUrl\":\"https://content.guardianapis.com/uk/culture\",\"editions\":[{\"id\":\"culture\",\"webTitle\":\"Culture\",\"webUrl\":\"https://www.theguardian.com/culture\",\"apiUrl\":\"https://content.guardianapis.com/culture\",\"code\":\"default\"},{\"id\":\"au/culture\",\"webTitle\":\"Culture\",\"webUrl\":\"https://www.theguardian.com/au/culture\",\"apiUrl\":\"https://content.guardianapis.com/au/culture\",\"code\":\"au\"},{\"id\":\"uk/culture\",\"webTitle\":\"Culture\",\"webUrl\":\"https://www.theguardian.com/uk/culture\",\"apiUrl\":\"https://content.guardianapis.com/uk/culture\",\"code\":\"uk\"},{\"id\":\"us/culture\",\"webTitle\":\"Culture\",\"webUrl\":\"https://www.theguardian.com/us/culture\",\"apiUrl\":\"https://content.guardianapis.com/us/culture\",\"code\":\"us\"}]},\"results\":[{\"id\":\"culture/2018/jun/14/samantha-bee-north-korea-kim-jong-un-late-night-round-up\",\"type\":\"article\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-06-14T14:43:38Z\",\"webTitle\":\"Samantha Bee: Kim 'left the summit glowing brighter than enriched uranium'\",\"webUrl\":\"https://www.theguardian.com/culture/2018/jun/14/samantha-bee-north-korea-kim-jong-un-late-night-round-up\",\"apiUrl\":\"https://content.guardianapis.com/culture/2018/jun/14/samantha-bee-north-korea-kim-jong-un-late-night-round-up\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"culture/2018/jun/14/david-byrne-every-one-of-his-albums-ranked\",\"type\":\"article\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-06-14T12:04:24Z\",\"webTitle\":\"David Byrne – every one of his albums ranked!\",\"webUrl\":\"https://www.theguardian.com/culture/2018/jun/14/david-byrne-every-one-of-his-albums-ranked\",\"apiUrl\":\"https://content.guardianapis.com/culture/2018/jun/14/david-byrne-every-one-of-his-albums-ranked\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"culture/2018/jun/13/trevor-noah-kim-trump-summit-freddy-kruger-stephen-colbert-jimmy-kimmel\",\"type\":\"article\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-06-13T13:27:07Z\",\"webTitle\":\"Trevor Noah: Trump endorsed 'the Freddy Krueger of human rights'\",\"webUrl\":\"https://www.theguardian.com/culture/2018/jun/13/trevor-noah-kim-trump-summit-freddy-kruger-stephen-colbert-jimmy-kimmel\",\"apiUrl\":\"https://content.guardianapis.com/culture/2018/jun/13/trevor-noah-kim-trump-summit-freddy-kruger-stephen-colbert-jimmy-kimmel\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"culture/2018/jun/12/colbert-on-trump-at-the-g7-like-a-toddler-who-put-a-lego-in-his-mouth\",\"type\":\"article\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-06-12T13:54:37Z\",\"webTitle\":\"Colbert on Trump at the G7: 'Like a toddler who put a Lego in his mouth'\",\"webUrl\":\"https://www.theguardian.com/culture/2018/jun/12/colbert-on-trump-at-the-g7-like-a-toddler-who-put-a-lego-in-his-mouth\",\"apiUrl\":\"https://content.guardianapis.com/culture/2018/jun/12/colbert-on-trump-at-the-g7-like-a-toddler-who-put-a-lego-in-his-mouth\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"culture/live/2018/jun/11/e3-2018-day-two-ubisoft-and-sony\",\"type\":\"liveblog\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-06-12T02:35:54Z\",\"webTitle\":\"E3 2018: all the news from Sony's bizarre Playstation press conference – as it happened\",\"webUrl\":\"https://www.theguardian.com/culture/live/2018/jun/11/e3-2018-day-two-ubisoft-and-sony\",\"apiUrl\":\"https://content.guardianapis.com/culture/live/2018/jun/11/e3-2018-day-two-ubisoft-and-sony\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"culture/2018/jun/12/historic-england-top-10-coventry-cathedral-angel-of-the-north-sutton-hoo\",\"type\":\"article\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-06-11T23:01:34Z\",\"webTitle\":\"New top 10 of heritage sites maps out the history of England\",\"webUrl\":\"https://www.theguardian.com/culture/2018/jun/12/historic-england-top-10-coventry-cathedral-angel-of-the-north-sutton-hoo\",\"apiUrl\":\"https://content.guardianapis.com/culture/2018/jun/12/historic-england-top-10-coventry-cathedral-angel-of-the-north-sutton-hoo\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"uk-news/2018/jun/11/gary-barlow-cancels-confetti-eden-project-litter-environment-plastic\",\"type\":\"article\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-06-11T18:39:45Z\",\"webTitle\":\"Gary Barlow to stop using confetti after 'littering' Eden Project\",\"webUrl\":\"https://www.theguardian.com/uk-news/2018/jun/11/gary-barlow-cancels-confetti-eden-project-litter-environment-plastic\",\"apiUrl\":\"https://content.guardianapis.com/uk-news/2018/jun/11/gary-barlow-cancels-confetti-eden-project-litter-environment-plastic\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"culture/2018/jun/12/dark-mofos-ideas-festival-brings-out-the-pitchforks-as-speakers-rage-against-machine\",\"type\":\"article\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-06-11T18:00:27Z\",\"webTitle\":\"Dark Mofo's ideas festival brings out the pitchforks as speakers rage against machine | Stephanie Convery\",\"webUrl\":\"https://www.theguardian.com/culture/2018/jun/12/dark-mofos-ideas-festival-brings-out-the-pitchforks-as-speakers-rage-against-machine\",\"apiUrl\":\"https://content.guardianapis.com/culture/2018/jun/12/dark-mofos-ideas-festival-brings-out-the-pitchforks-as-speakers-rage-against-machine\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"culture/2018/jun/11/how-we-made-spare-rib-magazine\",\"type\":\"article\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-06-11T15:32:36Z\",\"webTitle\":\"How we made: Spare Rib magazine\",\"webUrl\":\"https://www.theguardian.com/culture/2018/jun/11/how-we-made-spare-rib-magazine\",\"apiUrl\":\"https://content.guardianapis.com/culture/2018/jun/11/how-we-made-spare-rib-magazine\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"culture/2018/jun/10/on-my-radar-craig-brown-cultural-highlights-kieran-hodgson-jimmy-page-robbie-williams-rodin\",\"type\":\"article\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-06-10T09:00:47Z\",\"webTitle\":\"On my radar: Craig Brown’s cultural highlights\",\"webUrl\":\"https://www.theguardian.com/culture/2018/jun/10/on-my-radar-craig-brown-cultural-highlights-kieran-hodgson-jimmy-page-robbie-williams-rodin\",\"apiUrl\":\"https://content.guardianapis.com/culture/2018/jun/10/on-my-radar-craig-brown-cultural-highlights-kieran-hodgson-jimmy-page-robbie-williams-rodin\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"}]}}";
    private JsonQuery() {
    }
    public static List<News> extractFeatureFromJson() {
        List<News> articles = new ArrayList<>();
        try {
            JSONObject rootJsonResponse = new JSONObject(jsonSource);
            JSONObject responseJSONObject = rootJsonResponse.getJSONObject("response");
            JSONArray resultsJSONArray = responseJSONObject.getJSONArray("results");

            for (int i = 0; i < resultsJSONArray.length(); i++) {

                JSONObject currentArticle = resultsJSONArray.getJSONObject(i);

                String webPublDate = currentArticle.getString("webPublicationDate");

                String title = currentArticle.getString("webTitle");

                String section = currentArticle.getString("sectionName");
                //TODO: dodaj autora i url
                //String author = currentArticle.getString("tutaj pobaw sie w rozbijanie webTitle");

                News article = new News(webPublDate, title, section);

                articles.add(article);
            }

        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return articles;
    }
}