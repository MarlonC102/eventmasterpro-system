package org.event.master.pro.util;

import java.io.InputStream;
import java.util.*;
import javax.swing.JComboBox;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class FileUtil {

    public static Map<String, List<String>> departamentMap = new HashMap<>();

    public static void uploadCity(JComboBox<String> departamentoComboBox) {
        InputStream jsonCity = FileUtil.class.getResourceAsStream("/json/city_departments.json");
        JSONObject jsonObject = new JSONObject(new JSONTokener(jsonCity));
        for (String key : jsonObject.keySet()) {
            JSONArray city = jsonObject.getJSONArray(key);
            List<String> cityList = new ArrayList<>();
            for (int i = 0; i < city.length(); i++) {
                cityList.add(city.getString(i));
            }
            departamentMap.put(key, cityList);
        }
        for (String departamento : departamentMap.keySet()) {
            departamentoComboBox.addItem(departamento);
        }
    }
}
