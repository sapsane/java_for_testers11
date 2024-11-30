package ru.stqa.mantis.manager;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.UserApi;
import io.swagger.client.auth.ApiKeyAuth;
import io.swagger.client.model.AccessLevel;
import io.swagger.client.model.User;
import io.swagger.client.model.UserAddResponse;
import ru.stqa.mantis.model.CreateUserData;

public class RestApiHelper extends HelperBase {
    public RestApiHelper(ApplicationManager manager) {
        super(manager);
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
        Authorization.setApiKey(manager.property("apiKey"));
    }

    public void createUser(CreateUserData createUserData) {
        UserApi apiInstance = new UserApi();
        User body = new User(); // User | The user to add.
        body.setUsername(createUserData.username());
        body.setPassword(createUserData.password());
        body.setRealName(createUserData.realName());
        body.setEmail(createUserData.email());
       // body.setAccessLevel(createUserData.withAccessLevel());
       // var accessLevel="developer";
        body.setAccessLevel(new AccessLevel().name("developer"));
        body.setEnabled(true);
        body._protected(false);
          // setAccessLevel(new AccessLevel("developer"));
        try {
            UserAddResponse result = apiInstance.userAdd(body);
            System.out.println(result);
        } catch (ApiException e) {
            new RuntimeException(e);
           // System.err.println("Exception when calling UserApi#userAdd");
            //e.printStackTrace();
        }
    }
}
