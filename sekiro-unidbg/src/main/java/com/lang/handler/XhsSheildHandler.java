package com.lang.handler;

import com.github.unidbg.Emulator;
import com.github.unidbg.file.FileResult;
import com.lang.platform.xhsShield;
import com.lang.sekiro.api.SekiroRequest;
import com.lang.sekiro.api.SekiroRequestHandler;
import com.lang.sekiro.api.SekiroResponse;

import java.io.IOException;

public class XhsSheildHandler implements SekiroRequestHandler {

    xhsShield test;
    public XhsSheildHandler(){
        try {
            test = new xhsShield() {
                @Override
                public FileResult resolve(Emulator emulator, String pathname, int oflags) {
                    return null;
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleRequest(SekiroRequest sekiroRequest, SekiroResponse sekiroResponse) {
        String result = "";
        try {
//            String phone= sekiroRequest.getString("phone");
//            String encryp= sekiroRequest.getString("encryp");
            String params = "platform=Android&deviceId=7f059e50-d783-37f8-b874-7aa00e1a948c&device_fingerprint=202009211544583c0cb8792eaa3c9824746208406d8aa801adf4337a44c882&device_fingerprint1=202009211544583c0cb8792eaa3c9824746208406d8aa801adf4337a44c882&versionName=5.26.0&channel=YingYongBao&sid=session.1607061211494317772349&lang=zh-Hans&t=1607311357&sign=e17d4f22bc1be36f0a62851d7097ab1a, tag=Request{method=GET, url=https://www.xiaohongshu.com/api/sns/v3/user/me?platform=Android&deviceId=7f059e50-d783-37f8-b874-7aa00e1a948c&device_fingerprint=202009211544583c0cb8792eaa3c9824746208406d8aa801adf4337a44c882&device_fingerprint1=202009211544583c0cb8792eaa3c9824746208406d8aa801adf4337a44c882&versionName=5.26.0&channel=YingYongBao&sid=session.1607061211494317772349&lang=zh-Hans&t=1607311357&sign=e17d4f22bc1be36f0a62851d7097ab1a";
            String sessionId = "session.1608285820762256226298";
            String deviceId = "e45ea788-06f6-3d2f-bf6c-03f68152c851";
            String userAgent = "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 6P Build/MTC20L) Resolution/1440*2392 Version/5.26.2 Build/5260361 Device/(Huawei;Nexus 6P) NetType/WiFi";
            result = test.getShield(params,sessionId,deviceId,userAgent);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                test.destroy();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }finally {
            sekiroResponse.success(result);
        }
    }
}
