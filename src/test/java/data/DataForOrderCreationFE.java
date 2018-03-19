package data;

import org.testng.annotations.DataProvider;

public class DataForOrderCreationFE {

    @DataProvider(name = "dataForOrderCreation")
    public static Object[][] dataForOrderCreation(){
        Object userInfoObj = new Object[2][3];

        userInfoObj[0][0] = "ekgothamuser";
        userInfoObj[0][1] = "9841001122";
        userInfoObj[0][2] = "350 Sansome St";

        userInfoObj[1][0] = "ekstarcityuser";
        userInfoObj[1][0] = "9841023252";
        userInfoObj[1][0] = "3 Embarcadero Center";

        return userInfoObj;
    }

}
