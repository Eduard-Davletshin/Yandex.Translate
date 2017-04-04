package com.example.eddy.yandextranslate;

        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitSingleton {

    private static RetrofitSingleton instance = new RetrofitSingleton();
    private RequestInterface requestInterface;

    private RetrofitSingleton() {
        String URL = "https://translate.yandex.net/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        requestInterface = retrofit.create(RequestInterface.class);
    }

    public static RetrofitSingleton getInstance() {
        return instance;
    }

    public RequestInterface getRequestInterface() {
        return requestInterface;
    }
}

