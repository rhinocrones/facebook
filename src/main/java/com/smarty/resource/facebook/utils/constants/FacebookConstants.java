package com.smarty.resource.facebook.utils.constants;

public class FacebookConstants
{
    public static final String FACEBOOK = "faceBook";
    public static final String FEED = "/feed";
    public static final String SLASH = "/";
    public static final String COLUMN = "%7C";
    public static final String FB_LIMIT = "?&limit=";
    public static final String PARAMETERS = "&date_format=U&fields=created_time,from,message,parent,comment_count,like_count,attachment";
    public static final String ACCES_TOKEN = "&access_token=";
    public static final String FILTER_STREAM = "&filter=stream";
    public static final String SINCE = "since";
    public static final String FIELDS = "fields";
    public static final String LOCALE = "locale";
    public static final String EN_US = "en_US";
    public static final String LIMIT = "limit";
    public static final String COMMENTS = "comments";
    public static final String LIKES = "likes";
    public static final String SQUARE_BRACES_LEFT = "[";
    public static final String SQUARE_BRACES_RIGHT = "]";
    public static final String EMPTY = "";
    public static final String POINTER_SPACE = ", ";
    public static final String POINTER = ",";
    public static final String ONLY_DIGITS = "[0-9]+";
    public static final String POST_ID = "[0-9]+_[0-9]+";
    public static final int ZERO = 0;
    public static final int THIRTEEN = 13;
    public static final int FIFTEEN = 15;
    public static final int THIRTY_TWO = 32;
    public static final int ONE_HUNDRED = 100;
    public static final int THOUSAND = 1000;
    public static final String LETTERS_AND_DIGITS = "^(?=.*[a-z])(?=.*[0-9])[a-z0-9]+$";
    public static final String PAGE_ID_ERROR_MESSAGE = "Field pageId can't be null or does not contain only digits.";
    public static final String PAGE_ID_FIELD = "pageId";
    public static final String DATE_ERROR_MESSAGE = "Field earliestPostingDate can't be null or long value of date is wrong";
    public static final String DATE_FIELD = "earliestPostingDate";
    public static final String APP_ID_ERROR_MESSAGE = "Field appId can't be null or contain invalid key length or does not contain only digits.";
    public static final String APP_ID_FIELD = "appId";
    public static final String APP_SECRET_ERROR_MESSAGE = "Field appSecret can't be null or contain invalid appSecret length or does not contain only digits and eng lowercased alphabetic characters.";
    public static final String APP_SECRET_FIELD = "appSecret";
    public static final String RETURN_LIMIT_POST_ERROR_MESSAGE = "Field returnLimit contains invalid value (min 1, max 100).";
    public static final String RETURN_LIMIT_ERROR_MESSAGE = "Field returnLimit contains invalid value (min 1, max 1000).";
    public static final String RETURN_LIMIT_FIELD = "returnLimit";
    public static final String NEXT_PAGE_ERROR_MESSAGE = "Field nextPage contains invalid url.";
    public static final String NEXT_PAGE_FIELD = "nextPageURL";
    public static final String POST_ID_ERROR_MESSAGE = "Field postId can't be null or contain invalid postId length or does not contain only digits.";
    public static final String POST_ID_FIELD = "postId";
    public static final String REACTION_TYPE_ERROR_MESSAGE = "Field reactionType can't be null or contain invalid reactionType value (comments, likes).";
    public static final String REACTION_TYPE_FIELD = "reactionType";
    public static final String TOP_LEVEL_ONLY_ERROR_MESSAGE = "Field topLevelOnly can't be true for reaction type likes.";
    public static final String TOP_LEVEL_ONLY_TYPE_FIELD = "topLevelOnly";
    public static final String GRAPH_FB_URL = "https://graph.facebook.com/";

    //swagger
    //post
    public static final String API = "Smarty REST API for facebook posts and post engagements crawling.";
    public static final String API_DESCRIPTION = "API return list of posts or list of post engagements(comments/like)";
    public static final String API_POST_MAPPING = "/fb/posts";
    public static final String API_POST_PRODUCE = "application/json";
    public static final String API_POST_OPERATION = "Return list of posts from specific page";
    //post.model
    public static final String API_POST_MODEL_PAGE_ID = "Facebook page id";
    public static final String API_POST_MODEL_DATE = "From what date start to crawl (value can be -1 if we will crawl with out earliest posting date)";
    public static final String API_POST_MODEL_APP_ID = "App token id";
    public static final String API_POST_MODEL_APP_SECRET = "App token secret";
    public static final String API_POST_MODEL_DETAILED = "Flag for detailed stats";
    public static final String API_POST_MODEL_RETURN = "Count of posts (min 1 - max 100)";

    //general
    public static final String API_OK = "Successfully retrieved list of posts";
    public static final String API_FORBIDEN = "Accessing the resource you were trying to reach is forbidden";
    public static final String API_BAD_REQUEST = "Bad request";
    public static final String API_INTERNAL_SERVER_ERROR = "Internal server error";
}