package mavis.rvs.ac.th.readcode.utility;

/**
 * Created by Teacher on 22/3/2561.
 */

public class MyConstant {

    //    About URL
    private String urlGetAllUserString = "http://androidthai.in.th/mar/getAllUser.php";
    private String urlPostUserString = "http://androidthai.in.th/mar/postUser.php";

    // About Array
    private String[] loginStrings = new String[]{"Id", "Name", "User", "Password"};

    public String[] getLoginStrings() {
        return loginStrings;
    }

    public String getUrlGetAllUserString() {
        return urlGetAllUserString;
    }

    public String getUrlPostUserString() {
        return urlPostUserString;
    }
}   //Main Class

