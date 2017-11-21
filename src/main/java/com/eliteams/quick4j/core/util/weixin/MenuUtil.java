package com.eliteams.quick4j.core.util.weixin;

import com.eliteams.quick4j.web.model.weixin.muen.*;
import com.eliteams.quick4j.web.model.weixin.pojo.Token;
import net.sf.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by hccl on 2017/11/18.
 */
public class MenuUtil {

    private static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    /**
     * 创建菜单方法
     * @param json
     * @param accessToken
     * @return
     */
    public static boolean createMenu(String json, String accessToken) {

        boolean createMenu = true;

        String resUrl = MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);

        String resultJson = CommonUtil.httpRequest(resUrl, "POST", json);

        MenuResult menuResult = null;

        ObjectMapper mapper = new ObjectMapper();

        try {
            menuResult = mapper.readValue(resultJson, MenuResult.class);
        } catch (IOException e) {
            e.printStackTrace();
            createMenu = false;
        }

        if (menuResult.getErrcode() != 0) {
            createMenu = false;
        }
        return createMenu;
    }

    /**
     * 获取菜单方法
     * @param accessToken
     * @return
     */
    public static String getMenu(String accessToken) {

        String menuJson = null;

        String resUrl = MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);

        menuJson = CommonUtil.httpRequest(resUrl, "GET", null);

        return menuJson;
    }

    /**
     * 删除菜单方法
     * @param accessToken
     * @return
     */
    public static boolean delMenu(String accessToken) {

        boolean delMenu = true;

        String resUrl = MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);

        String resultJson = CommonUtil.httpRequest(resUrl, "GET", null);

        MenuResult menuResult = null;

        ObjectMapper mapper = new ObjectMapper();

        try {
            menuResult = mapper.readValue(resultJson, MenuResult.class);
        } catch (IOException e) {
            e.printStackTrace();
            delMenu = false;
        }

        if (menuResult.getErrcode() != 0) {
            delMenu = false;
        }
        return delMenu;
    }


    public static void main(String[] args) {

        Menu menu = formatMenu("");

        String menuStr = JSONObject.fromObject(menu).toString();

        String ACCESS_TOKEN = "vKX8KHEasRL_O9nhNpWj0RHKLXBJ6j75AEt4dz84KXLSokctMfB4J1a98j8zs4HuoI9mgxSZb6msu8GfoZwvJTDm0Bo7tpjSNiex_TRMFRO75QqObtUPWTnSIMulozcFXHXaAEAHRH";

        System.out.println(createMenu(menuStr, ACCESS_TOKEN));

    }

    public static void createMenus(String appid, String appsectet, String projectPath) {

        Menu menu = formatMenu(projectPath);

        String menuStr = JSONObject.fromObject(menu).toString();

        Token token = UserMessageUtil.getAccessToken(appid, appsectet);

        System.out.println(createMenu(menuStr, token.getAccess_token()));
    }

    private static Menu formatMenu(String project_path) {
        ClickButton clickButton = new ClickButton();
        clickButton.setName("签到");
        clickButton.setKey("QIANDAO_KEY");
        clickButton.setType("click");

        ViewButton viewButton = new ViewButton();
        viewButton.setName("百度一下");
        viewButton.setType("view");
        viewButton.setUrl("http://www.baidu.com");

        ClickButton music = new ClickButton();
        music.setName("听音乐");
        music.setKey("MUSIC_KEY");
        music.setType("click");

        ClickButton weather = new ClickButton();
        weather.setName("天气预报");
        weather.setKey("WEATHER_KEY");
        weather.setType("click");

        ViewButton bmi = new ViewButton();
        bmi.setName("BMI计算器");
        bmi.setType("view");
        bmi.setUrl(project_path + "wx/html/index.html");

        ComplexButton complexButton = new ComplexButton();
        complexButton.setName("生活助手");
        complexButton.setSub_button(new BaseButton[]{bmi, weather, music, viewButton,});

        ClickButton gameMore = new ClickButton();
        gameMore.setName("持续开发中....");
        gameMore.setKey("GAMEmORE_KEY");
        gameMore.setType("click");

        ViewButton square = new ViewButton();
        square.setName("方块跳跃");
        square.setType("view");
        square.setUrl(project_path + "wx/games/Square/index.html");

        ViewButton arixTetris = new ViewButton();
        arixTetris.setName("剁手么");
        arixTetris.setType("view");
        arixTetris.setUrl(project_path + "wx/games/duoshou1108/index.html");

        ViewButton flappyFrog = new ViewButton();
        flappyFrog.setName("飞扬的青蛙");
        flappyFrog.setType("view");
        flappyFrog.setUrl(project_path + "wx/games/flappyFrog/index.html");

        ViewButton game2048 = new ViewButton();
        game2048.setName("2048游戏");
        game2048.setType("view");
        game2048.setUrl(project_path + "wx/games/2048Game/index.html");

        ComplexButton complexButton1 = new ComplexButton();
        complexButton1.setName("休闲娱乐");
        complexButton1.setSub_button(new BaseButton[]{gameMore, square, arixTetris, flappyFrog, game2048});

        Menu menu = new Menu();
        menu.setButton(new BaseButton[]{clickButton, complexButton, complexButton1});
        return menu;
    }
}
