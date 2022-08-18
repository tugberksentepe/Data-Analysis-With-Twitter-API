import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import utils.Const;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class TwitterApp {


    public static void main(String[] args) {
        TwitterApp t = new TwitterApp();
        t.calistir();

    }

    public List<Status> getAllTweetsOfUser(Twitter twitter, String user) {
        if (user != null && !user.trim().isEmpty()) {
            List<Status> statuses = new ArrayList();
            int pageno = 1;
            while (true) {
                try {
                    int size = statuses.size();
                    Paging page = new Paging(pageno++, 10000);
                    statuses.addAll(twitter.getUserTimeline(user, page));
                    if (statuses.size() == size) {
                        break;
                    }
                } catch (TwitterException e) {
                }
            }
            return statuses;
        } else {
            return null;
        }
    }

    public List<Status> getAllTweetsOfHashtag(Twitter twitter, Query hashtag) {
        if (hashtag != null) {

            if (hashtag.getQuery().equals("")) {
                throw new IllegalArgumentException("Lütfen Query Değerini Boş Geçmeyin..");
            }

            List<Status> statuses = new ArrayList();
            while (true) {
                try {
                    hashtag.setCount(100);

                    statuses.addAll(twitter.search(hashtag).getTweets());
                    if (statuses.size() == 100) {
                        break;
                    }
                } catch (TwitterException e) {

                }
            }
            return statuses;
        } else {
            return null;
        }
    }

   

    public void calistir() {
        try {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true).setOAuthConsumerKey(Const.CONSUMER_KEY.getKey()).setOAuthConsumerSecret(Const.CONSUMER_SECRET.getKey())
                    .setOAuthAccessToken(Const.ACCESS_TOKEN.getKey()).setOAuthAccessTokenSecret(Const.ACCESS_SECRET.getKey());
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            //Query query = new Query("#iphone13");

            String user = "ykeremcann";
//            String user = "kirikkaleunv";
//            String user = "ostimteknikuniv";
//            String user = "BilkentUniv";
//            String user = "ankarabilimuni";
//            String user = "AnkaraUni";
//            String user = "TOBBiletisim";

            List<Status> tweetList = getAllTweetsOfUser(twitter, user);
           // List<Status> tweetList = getAllTweetsOfHashtag(twitter, query);
            //List<Status> tweetList = getAllTweetsOfHashtag(twitter, hashtag);
            for (int i = 0; i < tweetList.size(); i++) {
                Tweets tweetler = new Tweets();
                String tweetText = "";
                long tweetID = 0;
                String tweetDate = "";
                String userName = "";
                String tweetUrl = "";
                int likeCount = 0;
                int retweetCount = 0;
                try {
                    tweetText = tweetList.get(i).getText().replaceAll("\n", " ").trim();
                    tweetText = StringUtils.normalizeSpace(tweetText);
                    tweetText = EmojiParser.removeAllEmojis(String.valueOf(tweetText));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(tweetList.get(i).getCreatedAt());
                try {
                    tweetDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tweetList.get(i).getCreatedAt());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    tweetUrl = "https://twitter.com/" + tweetList.get(i).getUser().getScreenName() + "/status/" + tweetList.get(i).getId();
                } catch (Exception e) {
                }
                try {
                    tweetID = tweetList.get(i).getId();
                } catch (Exception e) {
                }
                try {
                    userName = "@" + tweetList.get(i).getUser().getScreenName();
                } catch (Exception e) {
                }
                try {
                    likeCount = tweetList.get(i).getFavoriteCount();
                } catch (Exception e) {
                }
                try {
                    retweetCount = tweetList.get(i).getRetweetCount();
                } catch (Exception e) {
                }

                System.out.println(i);


                tweetler.setTweetId(tweetID);
                tweetText = tweetText.replace("'", " ");
                tweetText = tweetText.replace("/", " ");
                tweetText = tweetText.replace("\"", " ");
                tweetler.setTweetText(tweetText);
                tweetler.setTweetDate(tweetDate);
                tweetler.setTweetUrl(tweetUrl);
                tweetler.setUserName(userName);
                tweetler.setLikeCount(likeCount);
                tweetler.setRetweetCount(retweetCount);

                MySQL db = new MySQL();
                db.ekle(String.valueOf(tweetID), tweetText, tweetDate, userName, tweetUrl, likeCount, retweetCount);

                /* boolean connection_status = dbCon.connection_open();
                if (connection_status == true) {
                    if (!database.isSearch(tweetler)) {
                        System.out.println("Var////////////////////////////////////////////////");
                        continue;
                    } else { */
                //EKRANA GET EDİLEN TWEE YAZILIR
                    /* }
                } else {
                    System.out.println("Veritabani ile Baglanti Kurulamadi");
                    break;
                }*/

                System.out.println("*********************************************************************************************************");
            }
        } catch (Exception e) {
            System.out.println("Hata var calistir()=" + e);
        }
        try {

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
