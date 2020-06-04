package cc.bestmsg.core.service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import cc.bestmsg.core.MsgCenter;
import cc.bestmsg.core.constant.Parameter;
import cc.bestmsg.core.model.Message;
import cc.bestmsg.core.util.StringUtils;
import com.alibaba.fastjson.JSON;

/**
 * Created by  songzip on 2020/6/3.
 */
public class ProcessMsgService {

    public final static int               RESULT_CODE_SUCCESS    = 1;
    public final static int               RESULT_CODE_ERROR      = -1;
    
    private final static ProcessMsgService instance = new ProcessMsgService();


    public static ProcessMsgService getInstance() {
        return instance;
    }


    /**
     * 
     * @param url
     * @param parameters
     * @return
     */
    public String service(String url, Map<String,  String[]> parameters) {

//        Map<String, String> getParameters = getParameters(url);

        if (url.equals("/messages.json")) {
            return returnJSONResult(RESULT_CODE_SUCCESS, MsgCenter.getMsgService().getMessage());
        }

        if (url.equals("/users.json")) {
            return returnJSONResult(RESULT_CODE_SUCCESS, MsgCenter.getUserService().getUserList());
        }

        if (url.equals("/send.json")) {
            if(parameters.get(Parameter.MESSAGE) == null && parameters.get(Parameter.TO) == null){
                return returnJSONResult(RESULT_CODE_ERROR, "error");
            }
            Message m = new Message();
            m.setFromUserId(MsgCenter.getUserService().getCurrentUserId());
            m.setNickName(MsgCenter.getUserService().getCurrentUserNickName());
            m.setContent( parameters.get(Parameter.MESSAGE)[0]);
            m.setToUserId((String) parameters.get(Parameter.TO)[0]);
            MsgCenter.getMsgService().send(m);
            return returnJSONResult(RESULT_CODE_SUCCESS, "sent");
        }

//        if (url.equals("/datasource.json")) {
//            return returnJSONResult(RESULT_CODE_SUCCESS, statManagerFacade.getDataSourceStatDataList());
//        }
//
//        if (url.equals("/activeConnectionStackTrace.json")) {
//            return returnJSONResult(RESULT_CODE_SUCCESS, statManagerFacade.getActiveConnStackTraceList());
//        }

//        if (url.startsWith("/datasource-")) {
//            Integer id = StringUtils.subStringToInteger(url, "datasource-", ".");
//            Object result = statManagerFacade.getDataSourceStatData(id);
//            return returnJSONResult(result == null ? RESULT_CODE_ERROR : RESULT_CODE_SUCCESS, result);
//        }
//
//        if (url.startsWith("/connectionInfo-") && url.endsWith(".json")) {
//            Integer id = StringUtils.subStringToInteger(url, "connectionInfo-", ".");
//            List<?> connectionInfoList = statManagerFacade.getPoolingConnectionInfoByDataSourceId(id);
//            return returnJSONResult(connectionInfoList == null ? RESULT_CODE_ERROR : RESULT_CODE_SUCCESS,
//                    connectionInfoList);
//        }
//
//        if (url.startsWith("/activeConnectionStackTrace-") && url.endsWith(".json")) {
//            Integer id = StringUtils.subStringToInteger(url, "activeConnectionStackTrace-", ".");
//            return returnJSONActiveConnectionStackTrace(id);
//        }
//
//        if (url.startsWith("/sql.json")) {
//            return returnJSONResult(RESULT_CODE_SUCCESS, getSqlStatDataList(parameters));
//        }
//
//        if (url.startsWith("/wall.json")) {
//            return returnJSONResult(RESULT_CODE_SUCCESS, getWallStatMap(parameters));
//        }
//
//        if (url.startsWith("/wall-") && url.indexOf(".json") > 0) {
//            Integer dataSourceId = StringUtils.subStringToInteger(url, "wall-", ".json");
//            Object result = statManagerFacade.getWallStatMap(dataSourceId);
//            return returnJSONResult(result == null ? RESULT_CODE_ERROR : RESULT_CODE_SUCCESS, result);
//        }
//
//        if (url.startsWith("/sql-") && url.indexOf(".json") > 0) {
//            Integer id = StringUtils.subStringToInteger(url, "sql-", ".json");
//            return getSqlStat(id);
//        }
//
//        if (url.startsWith("/weburi.json")) {
//            return returnJSONResult(RESULT_CODE_SUCCESS, getWebURIStatDataList(parameters));
//        }
//
//        if (url.startsWith("/weburi-") && url.indexOf(".json") > 0) {
//            String uri = StringUtils.subString(url, "weburi-", ".json");
//            return returnJSONResult(RESULT_CODE_SUCCESS, getWebURIStatData(uri));
//        }
//
//        if (url.startsWith("/webapp.json")) {
//            return returnJSONResult(RESULT_CODE_SUCCESS, getWebAppStatDataList(parameters));
//        }
//
//        if (url.startsWith("/websession.json")) {
//            return returnJSONResult(RESULT_CODE_SUCCESS, getWebSessionStatDataList(parameters));
//        }
//
//        if (url.startsWith("/websession-") && url.indexOf(".json") > 0) {
//            String id = StringUtils.subString(url, "websession-", ".json");
//            return returnJSONResult(RESULT_CODE_SUCCESS, getWebSessionStatData(id));
//        }
//
//        if (url.startsWith("/spring.json")) {
//            return returnJSONResult(RESULT_CODE_SUCCESS, getSpringStatDataList(parameters));
//        }
//
//        if (url.startsWith("/spring-detail.json")) {
//            String clazz = parameters.get("class");
//            String method = parameters.get("method");
//            return returnJSONResult(RESULT_CODE_SUCCESS, getSpringMethodStatData(clazz, method));
//        }

        return returnJSONResult(RESULT_CODE_ERROR, "Do not support this request, please contact with administrator.");
    }



    public static String returnJSONResult(int resultCode, Object content) {
        Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
        dataMap.put("ResultCode", resultCode);
        dataMap.put("Content", content);
        return JSON.toJSONString(dataMap);
    }

    public static Map<String, String> getParameters(String url) {
        if (url == null || (url = url.trim()).length() == 0) {
            return Collections.<String, String> emptyMap();
        }

        String parametersStr = StringUtils.subString(url, "?", null);
        if (parametersStr == null || parametersStr.length() == 0) {
            return Collections.<String, String> emptyMap();
        }

        String[] parametersArray = parametersStr.split("&");
        Map<String, String> parameters = new LinkedHashMap<String, String>();

        for (String parameterStr : parametersArray) {
            int index = parameterStr.indexOf("=");
            if (index <= 0) {
                continue;
            }

            String name = parameterStr.substring(0, index);
            String value = parameterStr.substring(index + 1);
            parameters.put(name, value);
        }
        return parameters;
    }
}
